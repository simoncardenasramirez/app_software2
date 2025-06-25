package co.edu.uco.ucobet.generales.domain.city.exception;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcoBetException;
import co.edu.uco.ucobet.generales.infraestructure.secondaryadapters.redis.MessageCatalogServiceImpl;

public final class CityIdDoesNotExistsException extends RuleUcoBetException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CityIdDoesNotExistsException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	public static final CityIdDoesNotExistsException create(MessageCatalogServiceImpl messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("CityIdDoesNotExistsException");
		return new CityIdDoesNotExistsException(userMessage, userMessage, new Exception());
	}

}
