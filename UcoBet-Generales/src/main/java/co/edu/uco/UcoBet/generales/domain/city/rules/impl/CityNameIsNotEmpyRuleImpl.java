package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.domain.city.exception.CityNameIsEmptyExcpetion;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameIsNotEmpyRule;
import co.edu.uco.ucobet.generales.infraestructure.secondaryadapters.redis.MessageCatalogServiceImpl;


@Service
public class CityNameIsNotEmpyRuleImpl implements CityNameIsNotEmpyRule{
	
	@Autowired
	private MessageCatalogServiceImpl messageCatalogService;

	@Override
	public void execute(String data) {
		if(TextHelper.isEmpty(data)) {
			throw CityNameIsEmptyExcpetion.create(messageCatalogService);
		}
		
	}

}
