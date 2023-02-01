package validator.interfaces;

public interface ValidatorErrorMessageInterface {

	public <X> ValidatorVerifyInterface verify(X obj, Class<? extends CustomValidation<X>> clazz);

	public <X> ValidatorErrorMessageInterface verify(X obj, Validation<X> validation);

	public ValidatorVerifyInterface errorMessage(String errorMessage);

	public Validator validate();
}
