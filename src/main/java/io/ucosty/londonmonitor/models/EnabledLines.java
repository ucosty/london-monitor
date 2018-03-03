package io.ucosty.londonmonitor.models;

import java.util.List;

public class EnabledLines {
    private List<String> busLines;
    private List<String> tubeLines;
    private List<String> trainLines;

    public List<String> getBusLines() {
        return busLines;
    }

    public List<String> getTubeLines() {
        return tubeLines;
    }

    public List<String> getTrainLines() {
        return trainLines;
    }
}
