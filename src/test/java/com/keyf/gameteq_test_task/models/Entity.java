package com.keyf.gameteq_test_task.models;

public enum Entity {
    CATEGORY("categories", "category"),
    GROUP("groups", "group"),
    NETWORK("networks", "networks"),
    OFFER("offers", "offer"),
    SEGMENT("segments", "segment");

    private final String dashboardLabel;
    private final String addPageLabel;

    public String getDashboardLabel() {
        return dashboardLabel;
    }

    public String getAddPageLabel() {
        return addPageLabel;
    }

    Entity(String dashboardLabel, String addPageLabel) {
        this.dashboardLabel = dashboardLabel;
        this.addPageLabel = addPageLabel;
    }
}