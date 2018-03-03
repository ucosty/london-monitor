package io.ucosty.londonmonitor.models;

public class Disruption {
    private String category;
    private String categoryDescription;
    private String description;
    private String additionalInfo;
    private String[] affectedRoutes;
    private String[] affectedStops;
    private String closureText;

    public String getCategory() {
        return category;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public String getDescription() {
        return description;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public String[] getAffectedRoutes() {
        return affectedRoutes;
    }

    public String[] getAffectedStops() {
        return affectedStops;
    }

    public String getClosureText() {
        return closureText;
    }
}
