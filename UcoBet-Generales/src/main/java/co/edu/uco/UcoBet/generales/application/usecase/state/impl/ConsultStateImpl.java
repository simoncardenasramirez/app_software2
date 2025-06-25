package co.edu.uco.ucobet.generales.application.usecase.state.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.secondaryports.mapper.StateEntityMapper;
import co.edu.uco.ucobet.generales.application.secondaryports.repository.StateRepository;
import co.edu.uco.ucobet.generales.application.usecase.state.ConsultState;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.DataUcoBetException;
import co.edu.uco.ucobet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.domain.state.StateDomain;


@Service
public class ConsultStateImpl implements ConsultState{
	
	private StateRepository stateRepository;
	
	public ConsultStateImpl(StateRepository stateRepository) {
		ObjectHelper.getObjectHelper();
		if(ObjectHelper.isNull(stateRepository)) {
			var mensajeUsuario = "Se ha presentado un problema tratando de llevar a cabo la consulta de las ciudades...";
			throw DataUcoBetException.create(mensajeUsuario);
		}
		this.stateRepository=stateRepository;
	}

	@Override
	public List<StateDomain> execute(StateDomain data) {
		var stateEntity= StateEntityMapper.INSTANCE.toEntity(data);
		var resultados = stateRepository.findByFilter(stateEntity);
		return StateEntityMapper.INSTANCE.toDomainCollection(resultados);
	}

}
