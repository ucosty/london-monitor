package io.ucosty.londonmonitor;

import io.ucosty.londonmonitor.models.EnabledLines;
import io.ucosty.londonmonitor.models.Network;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ScreenController {
    private TransportService transportService;
    private LineService lineService;

    @Autowired
    private SimpMessagingTemplate template;

    public ScreenController(TransportService transportService) {
        this.transportService = transportService;
    }

    @GetMapping("/test")
    public Network test() {
        return transportService.GetNetwork();
    }

    @GetMapping("/update")
    @Scheduled(fixedRate = 5000)
    public void update() {
        template.convertAndSend("/topic/update", System.currentTimeMillis());
    }

    @GetMapping("/lines")
    public EnabledLines getEnabledLines() {
        return transportService.getEnabledLines();
    }
}
