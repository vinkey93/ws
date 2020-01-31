package fr.afcepf.al34.xs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND) //404 
//status Http qui sera par défaut retourné quand ce type d'excption sera remontée par throw
public class MyEntityNotFoundException extends RuntimeException {

	public MyEntityNotFoundException() {
	}

	public MyEntityNotFoundException(String message) {
		super(message);
	}

	public MyEntityNotFoundException(Throwable cause) {
		super(cause);
	}

	public MyEntityNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public MyEntityNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
