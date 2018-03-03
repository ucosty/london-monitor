package io.ucosty.londonmonitor.models;

public class ValidityPeriod {
    private String fromDate;
    private String toDate;
    private boolean isNow;

    public String getFromDate() {
        return fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public boolean isNow() {
        return isNow;
    }

}
