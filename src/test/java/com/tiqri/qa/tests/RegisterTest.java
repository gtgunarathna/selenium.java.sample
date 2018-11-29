package com.tiqri.qa.tests;

import com.tiqri.qa.pages.DashboardPage;
import com.tiqri.qa.pages.LandingPage;
import com.tiqri.qa.pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {
    LandingPage landingPage;
    RegisterPage registerPage;
    DashboardPage dashboard;

    String age = "35";

    @BeforeClass
    public void beforeClass() {
        logger.info("Starting Register Test");
        landingPage = new LandingPage(driver);

    }

    @Test
    public void registerUser() {

        landingPage.clickRegister();

        registerPage = new RegisterPage(driver);
        registerPage.typeUserName(userName);
        registerPage.typeAge(age);
        registerPage.typePassword(password);
        registerPage.typeConfirmPassword(password);
        registerPage.clickRegister();

        dashboard = new DashboardPage(driver);
        String welcomeMessage = dashboard.getWelcomeMessage();
        Assert.assertTrue(welcomeMessage.contains(userName), "Expected :" + userName + " Actual: " + welcomeMessage);
        dashboard.clickLogoff();
    }

}
