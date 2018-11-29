package com.tiqri.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {

    WebDriver driver;

    By userNameInput = By.id("MainContent_UserName");
    By ageInput = By.id("MainContent_Age");
    By passwordInput = By.id("MainContent_Password");
    By confirmPasswordInput = By.id("MainContent_ConfirmPassword");
    By registerButton = By.xpath("//*[@id=\"ctl01\"]/div[4]/div/div[6]/div/input");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public RegisterPage typeUserName(String userName) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement userNameElement = wait.until(ExpectedConditions.elementToBeClickable(userNameInput));
        userNameElement.sendKeys(userName);
        return this;
    }

    public RegisterPage typeAge(String password) {
        driver.findElement(ageInput).sendKeys(password);
        return this;
    }

    public RegisterPage typePassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
        return this;
    }

    public RegisterPage typeConfirmPassword(String password) {
        driver.findElement(confirmPasswordInput).sendKeys(password);
        return this;
    }

    public RegisterPage clickRegister() {
        driver.findElement(registerButton).click();
        return this;
    }

}

