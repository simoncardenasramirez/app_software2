package co.edu.uco.ucobet.generales.domain.city.exception;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcoBetException;
import co.edu.uco.ucobet.generales.infraestructure.secondaryadapters.redis.MessageCatalogServiceImpl;

public class CityIdIsNullException extends RuleUcoBetException {

	private static final long serialVersionUID = 1L;

	public CityIdIsNullException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);

	}
	
	public static final CityIdIsNullException create(MessageCatalogServiceImpl messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("CityIdIsNullException");
		return new CityIdIsNullException(userMessage, userMessage, new Exception());
	}

}
