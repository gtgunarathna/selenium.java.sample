package com.tiqri.qa.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverUtil {

    public static WebDriver getDriver() {

        WebDriver driver;
        String browser = Config.getConfigs().getValue("browser");
        System.setProperty("webdriver.gecko.driver", Config.getConfigs().getValue("driver.location"));

        switch (browser) {
            case "Chrome": {
                driver = new ChromeDriver();
                break;
            }
            case "Firefox": {
                driver = new FirefoxDriver();
                break;
            }
            default: {
                driver = new ChromeDriver();
                break;
            }
        }
        driver.get(Config.getConfigs().getValue("url"));
        return driver;
    }
}
