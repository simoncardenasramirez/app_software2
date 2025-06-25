package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;
import co.edu.uco.ucobet.generales.domain.city.exception.CityIdFormatIsNotValidException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdFormatIsValidRule;
import co.edu.uco.ucobet.generales.infraestructure.secondaryadapters.redis.MessageCatalogServiceImpl;

@Service
public class CityIdFormatIsValidRuleImpl implements CityIdFormatIsValidRule {
	
	@Autowired
	private MessageCatalogServiceImpl messageCatalogService;
	
	@Override
	public void execute(UUID data) {
		if (UUIDHelper.isDefault(data)) {
			throw CityIdFormatIsNotValidException.create(messageCatalogService);
		}

	}

}
