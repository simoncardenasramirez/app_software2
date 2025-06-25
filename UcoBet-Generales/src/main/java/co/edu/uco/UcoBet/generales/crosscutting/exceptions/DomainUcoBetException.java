package co.edu.uco.ucobet.generales.crosscutting.exceptions;

import java.util.HashMap;
import java.util.Map;

import co.edu.uco.ucobet.generales.application.secondaryports.traceability.TelemetryService;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.enums.Layer;

public final class DomainUcoBetException extends UcoBetException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DomainUcoBetException(final String technicalMessage,final  String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, Layer.DOMAIN, rootException);
	}
	
	public static final DomainUcoBetException create(final String technicalMessage,final  String userMessage, 
			final Exception rootException) {
		
		return new DomainUcoBetException(technicalMessage, userMessage, rootException);
		
	}
	
	public static final DomainUcoBetException create(final  String userMessage, 
			final Exception rootException) {
		
		return new DomainUcoBetException(userMessage, userMessage, rootException);
		
	}
	
	public static final DomainUcoBetException create(final String technicalMessage,final  String userMessage) {
		
		return new DomainUcoBetException(technicalMessage, userMessage, new Exception());
		
	}
	
	public static final DomainUcoBetException create(final  String userMessage) {
		
		return new DomainUcoBetException(userMessage,userMessage, new Exception());
		
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
