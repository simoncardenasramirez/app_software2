package co.edu.uco.ucobet.generales.domain.state.exception;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcoBetException;

import co.edu.uco.ucobet.generales.infraestructure.secondaryadapters.redis.MessageCatalogServiceImpl;

public class StateDoesNotExistException extends RuleUcoBetException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StateDoesNotExistException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
		// TODO Auto-generated constructor stub
	}
	
	public static final StateDoesNotExistException create(MessageCatalogServiceImpl messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("StateDoesNotExistException");
		return new StateDoesNotExistException(userMessage, userMessage, new Exception());
	}

}
