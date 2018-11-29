package com.tiqri.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

    WebDriver driver;

    By registerLink = By.xpath("//*[@id=\"ctl13_Register\"]");
    By loginLink = By.xpath("//*[@id=\"ctl13_Login\"]");

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public LandingPage clickRegister() {
        driver.findElement(registerLink).click();
        return this;
    }

    public LandingPage clickLogin() {
        driver.findElement(loginLink).click();
        return this;
    }
}
