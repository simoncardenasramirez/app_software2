package co.edu.uco.ucobet.generales.crosscutting.exceptions;

import java.util.HashMap;
import java.util.Map;

import co.edu.uco.ucobet.generales.application.secondaryports.traceability.TelemetryService;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.enums.Layer;

public final class ApplicationUcoBetException extends UcoBetException {

	private static final long serialVersionUID = 1L;

	public ApplicationUcoBetException(final String technicalMessage,final  String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, Layer.APPLICATION, rootException);
	}
	
	public static final ApplicationUcoBetException create(final String technicalMessage,final  String userMessage, 
			final Exception rootException) {
		
		return new ApplicationUcoBetException(technicalMessage, userMessage, rootException);
		
	}
	
	public static final ApplicationUcoBetException create(final  String userMessage, 
			final Exception rootException) {
		
		return new ApplicationUcoBetException(userMessage, userMessage, rootException);
		
	}
	
	public static final ApplicationUcoBetException create(final String technicalMessage,final  String userMessage) {
		
		return new ApplicationUcoBetException(technicalMessage, userMessage, new Exception());
		
	}
	
	public static final ApplicationUcoBetException create(final  String userMessage) {
		
		return new ApplicationUcoBetException(userMessage,userMessage, new Exception());
		
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
            telemetryService.trackEvent("RuleucobetException Occurred", properties);
        }
    }

	

}
