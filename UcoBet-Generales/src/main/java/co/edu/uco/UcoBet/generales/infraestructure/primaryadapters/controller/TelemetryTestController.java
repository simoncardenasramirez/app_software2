package co.edu.uco.ucobet.generales.infraestructure.primaryadapters.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.ucobet.generales.application.secondaryports.traceability.TelemetryService;

@RestController
@RequestMapping("/api/test")
public class TelemetryTestController {

    private final TelemetryService telemetryService;

    public TelemetryTestController(TelemetryService telemetryService) {
        this.telemetryService = telemetryService;
    }

    @GetMapping("/event")
    public String trackEvent() {
        Map<String, String> properties = new HashMap<>();
        properties.put("TestProperty", "TestValue");
        telemetryService.trackEvent("TestEvent", properties);
        return "Event tracked!";
    }

    @GetMapping("/metric")
    public String trackMetric() {
        telemetryService.trackMetric("TestMetric", 123.45);
        return "Metric tracked!";
    }

    @GetMapping("/exception")
    public String trackException() {
        try {
            // Genera una excepción de prueba
            throw new RuntimeException("This is a test exception");
        } catch (Exception e) {
            telemetryService.trackException(e);
            return "Exception tracked!";
        }
    }
}
