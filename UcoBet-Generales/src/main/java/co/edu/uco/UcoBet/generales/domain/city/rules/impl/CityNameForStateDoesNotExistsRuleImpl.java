package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.secondaryports.entity.CityEntity;
import co.edu.uco.ucobet.generales.application.secondaryports.mapper.StateEntityMapper;
import co.edu.uco.ucobet.generales.application.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import co.edu.uco.ucobet.generales.domain.city.exception.CityNameForStateDoesExistsException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameForStateDoesNotExistsRule;
import co.edu.uco.ucobet.generales.infraestructure.secondaryadapters.redis.MessageCatalogServiceImpl;

@Service
public class CityNameForStateDoesNotExistsRuleImpl implements CityNameForStateDoesNotExistsRule {

	private CityRepository cityRepository;
	
	private MessageCatalogServiceImpl messageCatalogService;

	public CityNameForStateDoesNotExistsRuleImpl(CityRepository cityRepository,MessageCatalogServiceImpl messageCatalogService) {
		this.cityRepository = cityRepository;
		this.messageCatalogService=messageCatalogService;
	}

	@Override
	public void execute(CityDomain data) {
		var cityEntity = CityEntity.create().setName(data.getName())
				.setState(StateEntityMapper.INSTANCE.toEntity(data.getState()));

		var resultado = cityRepository.findByFilter(cityEntity);

		if (!resultado.isEmpty()) {
			throw CityNameForStateDoesExistsException.create(messageCatalogService);
		}

	}

}
