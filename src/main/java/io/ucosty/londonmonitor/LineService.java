package io.ucosty.londonmonitor;

import io.ucosty.londonmonitor.models.Line;
import io.ucosty.londonmonitor.models.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@org.springframework.stereotype.Service
public class LineService {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());
    private static final String STATUS_URL = "https://api.tfl.gov.uk/line/mode/%s/status";

    private RestTemplate restTemplate;

    public LineService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Line[] GetStatus(Service service) {
        LOG.info("Updating line status for service: {}", service.getServiceId());
        String url = String.format(STATUS_URL, service.getServiceId());
        ResponseEntity<Line[]> response = restTemplate.getForEntity(url, Line[].class);
        if(response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        }
        return new Line[]{};
    }

}
