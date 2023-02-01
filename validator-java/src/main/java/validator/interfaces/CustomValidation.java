package validator.interfaces;

import java.util.List;

public interface CustomValidation<T> {
	
	List<Validation<?>> verify(T obj);

}
