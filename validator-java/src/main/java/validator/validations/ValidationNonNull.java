package validator.validations;

import java.util.Optional;

import validator.Erro;
import validator.interfaces.Validation;

public class ValidationNonNull<T> implements Validation<T> {

	private Erro error;
	
	private String errorMessage;

	private Class<T> clazz;

	public ValidationNonNull(Class<T> clazz) {
		this.clazz = clazz;
	}

	public Validation<T> validate(T obj) {

		try {

			if (obj == null) {
				this.error = new Erro(clazz.getSimpleName() + " is null");
			} else {
				this.error = null;
			}

		} catch (Exception e) {
			this.error = new Erro(e);
		}

		return this;
	}

	public Validation<T> setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
		return this;
	}

	public Optional<Erro> getErrorOptional() {
		
		if (this.error != null && this.errorMessage != null) {
			this.error.setErrorMessage(errorMessage);
		}
		
		return Optional.ofNullable(this.error);
	}

	
	
	public static ValidationNonNull<Object> nonNullObject() {
		return new ValidationNonNull<Object>(Object.class);
	}
	
	public static ValidationNonNull<String> nonNullString() {
		return new ValidationNonNull<String>(String.class);
	}
	
	public static ValidationNonNull<Integer> nonNullInt() {
		return new ValidationNonNull<Integer>(Integer.class);
	}
	
	public static ValidationNonNull<Long> nonNullLong() {
		return new ValidationNonNull<Long>(Long.class);
	}

	public static <R> ValidationNonNull<R> nonNull(Class<R> clazz) {
		return new ValidationNonNull<R>(clazz);
	}

}
