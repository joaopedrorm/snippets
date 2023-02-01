package validator.interfaces;

import java.util.Optional;

import validator.Erro;

public interface Validation<S> {

	Validation<S> validate(S Obj);

	Validation<S> setErrorMessage(String errorMessage);

	Optional<Erro> getErrorOptional();
}