package co.edu.uco.ucobet.generales.domain.city.exception;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcoBetException;
import co.edu.uco.ucobet.generales.infraestructure.secondaryadapters.redis.MessageCatalogServiceImpl;

public class CityNameForStateDoesExistsException extends RuleUcoBetException {

	private static final long serialVersionUID = 1L;

	public CityNameForStateDoesExistsException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}

	public static final CityNameForStateDoesExistsException create(MessageCatalogServiceImpl messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("CityNameForStateDoesExistsException");
		return new CityNameForStateDoesExistsException(userMessage, userMessage, new Exception());
	}

}
