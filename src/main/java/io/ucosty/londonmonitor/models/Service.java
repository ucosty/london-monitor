package io.ucosty.londonmonitor.models;

public enum Service {
    Tube("tube"),
    NationalRail("national-rail"),
    Bus("bus");

    private String serviceId;

    Service(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceId() {
        return this.serviceId;
    }
}
