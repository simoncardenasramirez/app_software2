package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.domain.city.exception.CityIdIsNullException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdIsNotNullRule;
import co.edu.uco.ucobet.generales.infraestructure.secondaryadapters.redis.MessageCatalogServiceImpl;


@Service
public class CityIdIsNotNullRuleImpl implements CityIdIsNotNullRule {
	
	@Autowired
	private MessageCatalogServiceImpl messageCatalogService;
	
	@Override
	public void execute(UUID data) {
		if(ObjectHelper.isNull(data)) {
			throw CityIdIsNullException.create(messageCatalogService);
		}
		
	}

}
