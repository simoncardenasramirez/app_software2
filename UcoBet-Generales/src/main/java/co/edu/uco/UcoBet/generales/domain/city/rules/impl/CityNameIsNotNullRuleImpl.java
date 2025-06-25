package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.domain.city.exception.CityNameIsNullException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameIsNotNullRule;
import co.edu.uco.ucobet.generales.infraestructure.secondaryadapters.redis.MessageCatalogServiceImpl;


@Service
public class CityNameIsNotNullRuleImpl implements CityNameIsNotNullRule {
	
	@Autowired
	private MessageCatalogServiceImpl messageCatalogService;

	@Override
	public void execute(String data) {
		if(TextHelper.isNull(data)) {
			throw CityNameIsNullException.create(messageCatalogService);
		}
		
	}

}
