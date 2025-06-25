package co.edu.uco.ucobet.generales.crosscutting.exceptions;

import java.util.HashMap;
import java.util.Map;

import co.edu.uco.ucobet.generales.application.secondaryports.traceability.TelemetryService;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.enums.Layer;

public final class DtoUcoBetException extends UcoBetException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DtoUcoBetException(final String technicalMessage,final  String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, Layer.DTO, rootException);
	}
	
	public static final DtoUcoBetException create(final String technicalMessage,final  String userMessage, 
			final Exception rootException) {
		
		return new DtoUcoBetException(technicalMessage, userMessage, rootException);
		
	}
	
	public static final DtoUcoBetException create(final  String userMessage, 
			final Exception rootException) {
		
		return new DtoUcoBetException(userMessage, userMessage, rootException);
		
	}
	
	public static final DtoUcoBetException create(final String technicalMessage,final  String userMessage) {
		
		return new DtoUcoBetException(technicalMessage, userMessage, new Exception());
		
	}
	
	public static final DtoUcoBetException create(final  String userMessage) {
		
		return new DtoUcoBetException(userMessage,userMessage, new Exception());
		
	}
	
    public void registerInTelemetry(String userMessage, String technicalMessage) {
        TelemetryService telemetryService = GlobalTelemetry.getTelemetryService();
        if (telemetryService != null) {
            // Registrar la excepción en Application Insights
            telemetryService.trackException(this);

            // Opcional: agregar propiedades personalizadas como evento
            Map<String, String> properties = new HashMap<>();
            properties.put("UserMessage", userMessage);
            properties.put("TechnicalMessage", technicalMessage);
            telemetryService.trackEvent("RuleUCOBETException Occurred", properties);
        }
    }

	
	

}
