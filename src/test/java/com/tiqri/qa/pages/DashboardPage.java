package com.tiqri.qa.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {

    final static Logger logger = Logger.getLogger(DashboardPage.class);

    WebDriver driver;

    By logOffLink = By.xpath("//*[@id=\"ctl01\"]/div[3]/div/div[2]/ul[2]/li[2]/a");
    By welcomeMessage = By.xpath("//*[@id=\"ctl01\"]/div[3]/div/div[2]/ul[2]/li[1]/a");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public DashboardPage clickLogoff() {
        driver.findElement(logOffLink).click();
        return this;
    }

    public String getWelcomeMessage() {

        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement welcomeMsgElement = wait.until(ExpectedConditions.elementToBeClickable(welcomeMessage));
        String welcome = welcomeMsgElement.getText();
        logger.info("Welcome message : " + welcome);
        return welcome;
    }


}

