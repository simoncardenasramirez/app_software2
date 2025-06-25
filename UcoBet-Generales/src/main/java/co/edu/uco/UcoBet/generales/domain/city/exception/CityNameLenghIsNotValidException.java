package co.edu.uco.ucobet.generales.domain.city.exception;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcoBetException;
import co.edu.uco.ucobet.generales.infraestructure.secondaryadapters.redis.MessageCatalogServiceImpl;

public class CityNameLenghIsNotValidException extends RuleUcoBetException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CityNameLenghIsNotValidException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	public static final CityNameLenghIsNotValidException create(MessageCatalogServiceImpl messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("CityNameLenghIsNotValidException");
		return new CityNameLenghIsNotValidException(userMessage, userMessage, new Exception());
	}

}
