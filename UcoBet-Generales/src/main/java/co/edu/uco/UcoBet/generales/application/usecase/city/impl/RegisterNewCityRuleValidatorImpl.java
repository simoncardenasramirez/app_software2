package co.edu.uco.ucobet.generales.application.usecase.city.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCityRuleValidator;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import co.edu.uco.ucobet.generales.domain.city.exception.CityIdDoesExistsException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdDoesNotExistRule;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdFormatIsValidRule;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdIsNotEmptyRule;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdIsNotNullRule;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameForStateDoesNotExistsRule;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameFormatIsValidRule;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameIsNotEmpyRule;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameIsNotNullRule;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameLenghIsValidRule;
import co.edu.uco.ucobet.generales.domain.state.StateDomain;
import co.edu.uco.ucobet.generales.domain.state.rules.StateDoesExistRule;
import co.edu.uco.ucobet.generales.domain.state.rules.StateIdIsNotNullRule;

@Service
public final class RegisterNewCityRuleValidatorImpl implements RegisterNewCityRuleValidator {

	@Autowired
	private CityIdDoesNotExistRule cityIdDoesNotExistRule;
	@Autowired
	private CityIdFormatIsValidRule cityIdFormatIsValidRule;
	@Autowired
	private CityIdIsNotEmptyRule cityIdIsNotEmptyRule;
	@Autowired
	private CityIdIsNotNullRule cityIdIsNotNullRule;
	@Autowired
	private CityNameFormatIsValidRule cityNameFormatIsValidRule;
	@Autowired
	private CityNameForStateDoesNotExistsRule cityNameForStateDoesNotExistsRule;
	@Autowired
	private CityNameIsNotEmpyRule cityNameIsNotEmpyRule;
	@Autowired
	private CityNameIsNotNullRule cityNameIsNotNullRule;
	@Autowired
	private CityNameLenghIsValidRule cityNameLenghIsValidRule;
	@Autowired
	private StateIdIsNotNullRule stateIdIsNotNullRule;
	@Autowired
	private StateDoesExistRule stateDoesExistRule;


	@Override
	public void validate(CityDomain data) {

		data.generateId();
		try {
			cityIdDoesNotExistRule.execute(data.getId());
		} catch (CityIdDoesExistsException exception) {
			validate(data);
		}

		validateRulesRelatedWithId(data.getId());
		validateRulesRelatedWithName(data);
		validateRulesRelatedWithState(data.getState());

	}

	private void validateRulesRelatedWithName(final CityDomain data) {
		cityNameIsNotEmpyRule.execute(data.getName());
		cityNameIsNotNullRule.execute(data.getName());
		cityNameFormatIsValidRule.execute(data.getName());
		cityNameLenghIsValidRule.execute(data.getName());
		cityNameForStateDoesNotExistsRule.execute(data);


	}

	private void validateRulesRelatedWithState(final StateDomain state) {
		stateIdIsNotNullRule.execute(state);
		stateDoesExistRule.execute(state.getId());

	}

	private void validateRulesRelatedWithId(final UUID id) {
		cityIdDoesNotExistRule.execute(id);
		cityIdFormatIsValidRule.execute(id);
		cityIdIsNotEmptyRule.execute(id);
		cityIdIsNotNullRule.execute(id);


	}

}
