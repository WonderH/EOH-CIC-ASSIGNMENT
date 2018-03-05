package za.co.eoh.andile.cic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DataNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2816375944583709644L;

	public DataNotFoundException(String exception) {
		super(exception);
	}

}