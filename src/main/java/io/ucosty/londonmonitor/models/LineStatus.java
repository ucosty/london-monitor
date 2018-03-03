package io.ucosty.londonmonitor.models;

public class LineStatus {
    private int id;
    private int statusSeverity;
    private String statusSeverityDescription;
    private String created;
    private ValidityPeriod[] validityPeriods;

    public int getId() {
        return id;
    }

    public int getStatusSeverity() {
        return statusSeverity;
    }

    public String getStatusSeverityDescription() {
        return statusSeverityDescription;
    }

    public String getCreated() {
        return created;
    }

    public ValidityPeriod[] getValidityPeriods() {
        return validityPeriods;
    }

    public Disruption getDisruption() {
        return disruption;
    }

    private Disruption disruption;
}
