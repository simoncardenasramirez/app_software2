package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.domain.city.exception.CityIdDoesNotExistsException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdDoesExistRule;
import co.edu.uco.ucobet.generales.infraestructure.secondaryadapters.redis.MessageCatalogServiceImpl;

@Service
public class CityIdDoesExistRuleImpl implements CityIdDoesExistRule{
	@Autowired
	private CityRepository cityRepository;
	
	private MessageCatalogServiceImpl messageCatalogService;

	public CityIdDoesExistRuleImpl(final CityRepository cityRepository) {
		this.cityRepository= cityRepository;
	}

	@Override
	public void execute(UUID data) {
		if (!cityRepository.existsById(data)){
			throw CityIdDoesNotExistsException.create(messageCatalogService);
		}
		
	}

}
