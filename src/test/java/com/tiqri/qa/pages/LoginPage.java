package com.tiqri.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {

    WebDriver driver;
    By userNameInput = By.id("MainContent_UserName");
    By passwordInput = By.id("MainContent_Password");
    By loginButtion = By.xpath("//*[@id=\"loginForm\"]/div/div[4]/div/input");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    public LoginPage typeUserName(String userName) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement userNameElement = wait.until(ExpectedConditions.elementToBeClickable(userNameInput));
        userNameElement.sendKeys(userName);
        return this;
    }

    public LoginPage typePassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
        return this;
    }

    public LoginPage clickLogin() {
        driver.findElement(loginButtion).click();
        return this;
    }


}
