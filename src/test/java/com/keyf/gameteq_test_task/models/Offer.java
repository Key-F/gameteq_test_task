package com.keyf.gameteq_test_task.models;

import com.keyf.gameteq_test_task.utils.NameGenerator;

public class Offer {

    String id;
    String name;

    String key;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Offer() {
        this.name = NameGenerator.generateEntityName("Offer");
        this.key = "DEFAULT_KEY";
    }

}
