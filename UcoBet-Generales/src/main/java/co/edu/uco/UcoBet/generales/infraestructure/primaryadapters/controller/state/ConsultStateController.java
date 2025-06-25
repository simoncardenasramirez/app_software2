package co.edu.uco.ucobet.generales.infraestructure.primaryadapters.controller.state;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.ucobet.generales.application.primaryports.dto.state.ConsultStateDto;
import co.edu.uco.ucobet.generales.application.primaryports.interactor.state.ConsultStateInteractor;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.UcoBetException;
import co.edu.uco.ucobet.generales.infraestructure.primaryadapters.controller.response.StateResponse;
import co.edu.uco.ucobet.generales.infraestructure.secondaryadapters.redis.MessageCatalogServiceImpl;

@RestController
@RequestMapping("/generales/api/v1/states")
public class ConsultStateController {

	private ConsultStateInteractor consultStateInteractor;
	private MessageCatalogServiceImpl messageCatalogService;
	
	public ConsultStateController (ConsultStateInteractor consultStateInteractor,MessageCatalogServiceImpl messageCatalogService) {
		this.consultStateInteractor =consultStateInteractor;
		this.messageCatalogService=messageCatalogService;
	}
	
	@GetMapping
	public ResponseEntity<StateResponse> consultar(){
		var httpStatusCode = HttpStatus.ACCEPTED;
		var stateResponse = new StateResponse();
		
		try {
			var consultStateDto = ConsultStateDto.create();
			
			stateResponse.setDatos(consultStateInteractor.execute(consultStateDto));
			stateResponse.getMensajes().add(messageCatalogService.getMessage("estadoExitoso"));
		} catch (UcoBetException exception) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			stateResponse.getMensajes().add(exception.getMessage());
			exception.printStackTrace();
		}catch (Exception exception) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			var mensajeUsuario = messageCatalogService.getMessage("estadoError");
			stateResponse.getMensajes().add(mensajeUsuario);
			exception.printStackTrace();
		}
		
		return new ResponseEntity<>(stateResponse , httpStatusCode);
	}
}
