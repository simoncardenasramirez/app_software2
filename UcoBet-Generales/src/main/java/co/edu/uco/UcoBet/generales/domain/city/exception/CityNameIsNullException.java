package co.edu.uco.ucobet.generales.domain.city.exception;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcoBetException;
import co.edu.uco.ucobet.generales.infraestructure.secondaryadapters.redis.MessageCatalogServiceImpl;

public class CityNameIsNullException extends RuleUcoBetException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CityNameIsNullException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	public static final CityNameIsNullException create(MessageCatalogServiceImpl messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("CityNameIsEmptyExcpetion");
		return new CityNameIsNullException(userMessage, userMessage, new Exception());
	}

}
