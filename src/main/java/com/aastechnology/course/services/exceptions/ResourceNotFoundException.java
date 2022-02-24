package com.aastechnology.course.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	
	/*
	 * Metodo abaixo retorna a mensagem de erro quendo um id é procurado e não encontrado
	 */
	public ResourceNotFoundException(Object id) { 
		super("Recurso não encontrado. Id " + id);
	}

}
