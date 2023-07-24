package br.com.mjv.services.exceptions;

public class EmployeeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1869300553614629710L;

	public EmployeeNotFoundException(String mensagem) {
		super(mensagem);
	}

	public EmployeeNotFoundException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
