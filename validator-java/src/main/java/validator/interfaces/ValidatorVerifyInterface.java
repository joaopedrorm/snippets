package validator.interfaces;

public interface ValidatorVerifyInterface {
    
	public <X> ValidatorVerifyInterface verify(X obj, Class<? extends CustomValidation<X>> clazz);
	
	public <X> ValidatorErrorMessageInterface verify(X obj, Validation<X> validation);
    
    public Validator validate();
}