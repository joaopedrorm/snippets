package validator.validations;

import java.util.ArrayList;
import java.util.List;

import models.Aluno;
import validator.interfaces.Validation;
import validator.interfaces.CustomValidation;

public class AlunoCustomValidation implements CustomValidation<Aluno> {

	@Override
	public List<Validation<?>> verify(Aluno aluno) {

		List<Validation<?>> validationList = new ArrayList<>();

		Validation<Aluno> nullAlunoValidation = getAlunoNonNullValidation(aluno);
		validationList.add(nullAlunoValidation);

		// Wont continue to validate a null object
		if (!nullAlunoValidation.getErrorOptional().isPresent()) {

			validationList.add(getNomeNonNullValidation(aluno));
			validationList.add(getIdadeNonNullValidation(aluno));

		}

		return validationList;
	}

	private Validation<Aluno> getAlunoNonNullValidation(Aluno aluno) {
		return ValidationNonNull.nonNull(Aluno.class) //
				.validate(aluno) //
				.setErrorMessage("Aluno não pode ser nulo");
	}

	private Validation<String> getNomeNonNullValidation(Aluno aluno) {
		return ValidationNonNull.nonNullString() //
				.validate(aluno.getNome()) //
				.setErrorMessage("Aluno.nome não pode ser nulo");
	}

	private Validation<Long> getIdadeNonNullValidation(Aluno aluno) {
		return ValidationNonNull.nonNullLong() //
				.validate(aluno.getIdade()) //
				.setErrorMessage("Aluno.idade não pode ser nulo");
	}

}
