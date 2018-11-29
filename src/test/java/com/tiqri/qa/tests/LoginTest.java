package com.tiqri.qa.tests;

import com.tiqri.qa.pages.DashboardPage;
import com.tiqri.qa.pages.LandingPage;
import com.tiqri.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    LandingPage landingPage;
    DashboardPage dashboard;
    LoginPage loginPage;


    @BeforeClass
    public void beforeClass() {
        logger.info("Starting Login Test");
        landingPage = new LandingPage(driver);
    }

    @Test
    public void loginRegisteredUser() {

        landingPage.clickLogin();

        loginPage = new LoginPage(driver);
        loginPage.typeUserName(userName);
        loginPage.typePassword(password);
        loginPage.clickLogin();

        dashboard = new DashboardPage(driver);
        String welcomeMessage = dashboard.getWelcomeMessage();
        Assert.assertTrue(welcomeMessage.contains(userName), "Expected :" + userName + " Actual: " + welcomeMessage);
        dashboard.clickLogoff();
    }
}
