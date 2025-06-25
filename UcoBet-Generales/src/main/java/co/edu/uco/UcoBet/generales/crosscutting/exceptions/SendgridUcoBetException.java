package co.edu.uco.ucobet.generales.crosscutting.exceptions;

import java.util.HashMap;
import java.util.Map;

import co.edu.uco.ucobet.generales.application.secondaryports.traceability.TelemetryService;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.enums.Layer;

public class SendgridUcoBetException extends UcoBetException{

    private static final long serialVersionUID = 1L;

    public SendgridUcoBetException(final String userMessage, final String technicalMessage,
                               final Exception rootException) {
        super(userMessage, technicalMessage, Layer.EMAIL, rootException);
    }

    public static SendgridUcoBetException create (final String userMessage, final String technicalMessage,
                                              final Exception rootException) {
        return new SendgridUcoBetException(userMessage, technicalMessage, rootException);
    }

    public static SendgridUcoBetException create (final String userMessage, final String technicalMessage){
        return new SendgridUcoBetException(userMessage, technicalMessage, new Exception());
    }

    public static SendgridUcoBetException create (final String userMessage){
        return new SendgridUcoBetException(userMessage, userMessage, new Exception());
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
