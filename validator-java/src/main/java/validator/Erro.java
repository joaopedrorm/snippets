package validator;

import java.util.Optional;

public class Erro {

	private String errorMessage;

	private Exception exception;

	public Erro(String errorMessage) {
		this.exception = null;
		this.errorMessage = errorMessage;
	}

	public Erro(Exception exception) {
		this.exception = exception;
		this.errorMessage = exception.getMessage();
	}

	public String getErrorMessage() {

		if (this.exception != null) {
			this.errorMessage += ": " + this.exception.getClass().getName() + ": " + this.exception.getMessage();
		}

		return this.errorMessage;
	}

	public Erro setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
		return this;
	}

	public Optional<Exception> getExceptionOptional() {
		return Optional.ofNullable(this.exception);
	}
}
