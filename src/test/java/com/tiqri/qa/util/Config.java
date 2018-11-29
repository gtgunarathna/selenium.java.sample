package com.tiqri.qa.util;

import java.io.FileInputStream;
import java.util.Properties;

public class Config {
    private static Config instance = new Config();

    private Properties properties;

    private Config() {

        properties = new Properties();
        try {
            properties.load(new FileInputStream("src/test/resources/config.properties"));
        } catch (Exception e) {

        }
    }

    public static Config getConfigs() {

        return instance;
    }

    public String getValue(String key) {

        return properties.getProperty(key);
    }
}
