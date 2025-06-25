package co.edu.uco.ucobet.generales.domain.city.exception;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcoBetException;
import co.edu.uco.ucobet.generales.infraestructure.secondaryadapters.redis.MessageCatalogServiceImpl;

public final class CityIdFormatIsNotValidException extends RuleUcoBetException {

	private static final long serialVersionUID = 1L;

	public CityIdFormatIsNotValidException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}

	public static final CityIdFormatIsNotValidException create(MessageCatalogServiceImpl messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("CityIdFormatIsNotValidException");
		return new CityIdFormatIsNotValidException(userMessage, userMessage, new Exception());
	}

}
