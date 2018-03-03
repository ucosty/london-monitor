package io.ucosty.londonmonitor.models;

public class Line {
    private String id;
    private String name;
    private String modeName;
    private String created;
    private String modified;
    private LineStatus[] lineStatuses;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getModeName() {
        return modeName;
    }

    public String getCreated() {
        return created;
    }

    public String getModified() {
        return modified;
    }

    public LineStatus[] getLineStatuses() {
        return lineStatuses;
    }
}
