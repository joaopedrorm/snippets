package validator.interfaces;

import java.util.List;

import validator.Erro;

public interface Validator {

	public Boolean hasErrors();
	
	public List<Erro> getErrorList();
	
}
