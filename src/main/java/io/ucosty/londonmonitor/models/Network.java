package io.ucosty.londonmonitor.models;

public class Network {
    private Line[] busLines;
    private Line[] tubeLines;
    private Line[] railLines;

    public Line[] getBusLines() {
        return busLines;
    }

    public Line[] getTubeLines() {
        return tubeLines;
    }

    public Line[] getRailLines() {
        return railLines;
    }

    public void setBusLines(Line[] busLines) {
        this.busLines = busLines;
    }

    public void setTubeLines(Line[] tubeLines) {
        this.tubeLines = tubeLines;
    }

    public void setRailLines(Line[] railLines) {
        this.railLines = railLines;
    }
}
