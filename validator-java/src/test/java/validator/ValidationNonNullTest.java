package validator;

import static org.assertj.core.api.Assertions.assertThat;
import static validator.validations.ValidationNonNull.nonNullString;

import org.junit.Test;

import validator.interfaces.Validator;

public class ValidationNonNullTest {

	@Test
	public void ShouldDetectNullStringTest() {

		String parameter = null;

		Validator validator = ValidatorBuilder.build() //
				.verify(parameter, nonNullString()) //
				.validate();

		assertThat(validator).isNotNull();

		assertThat(validator.hasErrors()) //
				.isEqualTo(true);

		assertThat(validator.getErrorList()) //
				.hasSize(1);
		
		assertThat(validator.getErrorList().get(0).getErrorMessage()) //
				.isEqualTo("String is null");

		assertThat(validator.getErrorList()) //
				.flatExtracting(Erro::getErrorMessage) //
				.hasSize(1) //
				.contains("String is null");
	}

	@Test
	public void ShouldDetectNullStringWithAlternativeErrorMessageTest() {

		String parameter = null;

		Validator validator = ValidatorBuilder.build() //
				.verify(parameter, nonNullString()).errorMessage("Objeto não pode ser nulo") //
				.validate();

		assertThat(validator).isNotNull();

		assertThat(validator.hasErrors()) //
				.isEqualTo(true);

		assertThat(validator.getErrorList()) //
				.hasSize(1);

		assertThat(validator.getErrorList()) //
				.extracting(Erro::getErrorMessage) //
				.contains("Objeto não pode ser nulo");

	}

	@Test
	public void ShouldValidateNonNullStringWithAlternativeErrorMessageTest() {

		String parameter = "Teste";

		Validator validator = ValidatorBuilder.build() //
				.verify(parameter, nonNullString()).errorMessage("Objeto não pode ser nulo") //
				.validate();

		assertThat(validator).isNotNull();

		assertThat(validator.hasErrors()) //
				.isEqualTo(false);

		assertThat(validator.getErrorList()) //
				.hasSize(0);

	}

}
