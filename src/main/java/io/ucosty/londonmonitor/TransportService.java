package io.ucosty.londonmonitor;

import io.ucosty.londonmonitor.models.EnabledLines;
import io.ucosty.londonmonitor.models.Line;
import io.ucosty.londonmonitor.models.Network;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static io.ucosty.londonmonitor.models.Service.Bus;
import static io.ucosty.londonmonitor.models.Service.NationalRail;
import static io.ucosty.londonmonitor.models.Service.Tube;
import static java.util.Arrays.asList;

@Service
public class TransportService {
    private LineService lineService;
    private Set<String> busLines = new HashSet<>();
    private Set<String> railLines = new HashSet<>();

    private EnabledLines enabledLines;

    public TransportService(LineService lineService) {
        this.lineService = lineService;
        this.busLines.addAll(asList("388", "242"));
        this.railLines.addAll(asList("thameslink", "c2c", "southeastern", "southern", "great-northern", "greater-anglia", "east-midlands-trains"));
    }

    @Cacheable("network")
    public Network GetNetwork() {
        Network network = new Network();
        network.setBusLines(getBusLines());
        network.setTubeLines(lineService.GetStatus(Tube));

        Line[] lines = lineService.GetStatus(NationalRail);
        network.setRailLines(Arrays.stream(lines).filter(l -> railLines.contains(l.getId())).toArray(Line[]::new));
        return network;
    }

    public EnabledLines getEnabledLines() {
        return enabledLines;
    }

    private Line[] getBusLines() {
        Line[] lines = lineService.GetStatus(Bus);
        return Arrays.stream(lines).filter(l -> enabledLines.getBusLines().contains(l.getId())).toArray(Line[]::new);
    }

}
