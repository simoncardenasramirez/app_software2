package co.edu.uco.ucobet.generales.crosscutting.exceptions;


import org.springframework.stereotype.Component;

import co.edu.uco.ucobet.generales.application.secondaryports.traceability.TelemetryService;

@Component
public class GlobalTelemetry {
    private static TelemetryService telemetryService;

    public GlobalTelemetry(TelemetryService telemetryService) {
        GlobalTelemetry.telemetryService = telemetryService;
    }

    public static TelemetryService getTelemetryService() {
        return telemetryService;
    }
}