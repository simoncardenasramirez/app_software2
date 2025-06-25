package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.domain.city.exception.CityIdIsEmptyException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdIsNotEmptyRule;
import co.edu.uco.ucobet.generales.infraestructure.secondaryadapters.redis.MessageCatalogServiceImpl;
@Service
public class CityIdIsNotEmptyRuleImpl implements CityIdIsNotEmptyRule {
	
	@Autowired
	private MessageCatalogServiceImpl messageCatalogService;

	@Override
	public final void execute(final UUID data) {
		if(ObjectHelper.isNull(data)) {
			throw CityIdIsEmptyException.create(messageCatalogService);
		}
		
	}

}
