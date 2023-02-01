package validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import validator.interfaces.CustomValidation;
import validator.interfaces.Validation;
import validator.interfaces.Validator;
import validator.interfaces.ValidatorErrorMessageInterface;
import validator.interfaces.ValidatorVerifyInterface;

public class ValidatorBuilder implements Validator, ValidatorVerifyInterface, ValidatorErrorMessageInterface {

	private List<Validation<?>> validations;
	private List<Erro> errors;

	private ValidatorBuilder() {
		this.validations = new ArrayList<>();
		this.errors = new ArrayList<>();
	}

	public Boolean hasErrors() {
		if (errors.isEmpty()) {
			return false;
		}

		return true;
	}

	public List<Erro> getErrorList() {
		return this.errors;
	}

	public static ValidatorVerifyInterface build() {
		return new ValidatorBuilder();
	}

	public <R> ValidatorVerifyInterface verify(R Obj, Class<? extends CustomValidation<R>> clazz) {

		this.validations.addAll(getNewInstance(clazz).verify(Obj));

		return this;
	}

	public <R> ValidatorErrorMessageInterface verify(R obj, Validation<R> validation) {

		validation.validate(obj);
		this.validations.add(validation);

		return this;
	}

	public ValidatorVerifyInterface errorMessage(String errorMessage) {

		Validation<?> validation = this.validations.get(this.validations.size() - 1);

		if (validation != null) {
			validation.setErrorMessage(errorMessage);
		}

		return this;
	}

	public Validator validate() {

		validations.stream() //
				.filter(Objects::nonNull) //
				.map(Validation::getErrorOptional) //
				.filter(Optional::isPresent) //
				.map(Optional::get) //
				.forEachOrdered(e -> this.errors.add(e));

		return this;
	}

	private static <T> T getNewInstance(Class<T> clazz) {
		try {
			return (T) clazz.getConstructor().newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
