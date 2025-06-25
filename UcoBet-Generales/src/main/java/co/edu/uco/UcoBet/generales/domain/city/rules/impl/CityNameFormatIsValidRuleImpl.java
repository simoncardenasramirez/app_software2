package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.domain.city.exception.CityNameFormatIsNotValidException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameFormatIsValidRule;
import co.edu.uco.ucobet.generales.infraestructure.secondaryadapters.redis.MessageCatalogServiceImpl;


@Service
public class CityNameFormatIsValidRuleImpl implements CityNameFormatIsValidRule {
	
	@Autowired
	private MessageCatalogServiceImpl messageCatalogService;
	
	String format = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$";

    @Override
    public void execute(String data) {
        if (!data.matches(format)) {
            throw CityNameFormatIsNotValidException.create(messageCatalogService);
        }
    }
}
