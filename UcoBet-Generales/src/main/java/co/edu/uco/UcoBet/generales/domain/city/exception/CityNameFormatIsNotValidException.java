package co.edu.uco.ucobet.generales.domain.city.exception;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcoBetException;
import co.edu.uco.ucobet.generales.infraestructure.secondaryadapters.redis.MessageCatalogServiceImpl;

public class CityNameFormatIsNotValidException extends RuleUcoBetException{

	private static final long serialVersionUID = 1L;

	public CityNameFormatIsNotValidException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	public static final CityNameFormatIsNotValidException create(MessageCatalogServiceImpl messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("CityNameFormatIsNotValidException");
		return new CityNameFormatIsNotValidException(userMessage, userMessage, new Exception());
	}

}
