package co.edu.uco.ucobet.generales.domain.city.exception;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcoBetException;
import co.edu.uco.ucobet.generales.infraestructure.secondaryadapters.redis.MessageCatalogServiceImpl;

public class CityNameIsEmptyExcpetion extends RuleUcoBetException {


	private static final long serialVersionUID = 1L;

	public CityNameIsEmptyExcpetion(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	public static final CityNameIsEmptyExcpetion create(MessageCatalogServiceImpl messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("CityNameIsEmptyExcpetion");
		return new CityNameIsEmptyExcpetion(userMessage, userMessage, new Exception());
	}

}
