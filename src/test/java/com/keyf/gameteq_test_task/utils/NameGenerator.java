package com.keyf.gameteq_test_task.utils;

import java.util.UUID;

public class NameGenerator {

    public static String generateEntityName(String entityType) {
        UUID randomUUID = UUID.randomUUID();
        return entityType + "_keyf_" +  randomUUID;
    }
}
