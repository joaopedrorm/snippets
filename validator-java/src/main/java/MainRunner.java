

import static validator.validations.ValidationNonNull.nonNullString;

import models.Aluno;
import validator.ValidatorBuilder;
import validator.interfaces.Validator;
import validator.validations.AlunoCustomValidation;

public class MainRunner {

	public static void main(String[] args) {

		System.out.println("Iniciando Validador");

		System.out.println("Validando null");
		
		String parameter = null;

		Validator validator1 = ValidatorBuilder.build() //
				.verify(parameter, nonNullString()).errorMessage("Objeto não pode ser nulo") //
				.validate();

		System.out.println("Quantidade de erros: " + validator1.getErrorList().size());

		validator1.getErrorList() //
				.stream() //
				.map(e -> e.getErrorMessage()) //
				.forEach(m -> System.out.println(m));
		
		
		System.out.println("Validando aluno");
		
		//Aluno aluno = null;
		Aluno aluno = new Aluno();
		aluno.setNome("Aluno1");

		Validator validator2 = ValidatorBuilder.build() //
				.verify(aluno, AlunoCustomValidation.class) //
				.validate();

//		ValidationResult result = Validator.validate(aluno, AlunoValidator.class);

		System.out.println("Quantidade de erros: " + validator2.getErrorList().size());

		validator2.getErrorList() //
				.stream() //
				.map(e -> e.getErrorMessage()) //
				.forEach(m -> System.out.println(m));
		
		System.out.println("Finalizando");

	}
}
