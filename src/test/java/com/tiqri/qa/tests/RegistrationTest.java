package com.tiqri.qa.tests;

import com.tiqri.qa.pages.DashboardPage;
import com.tiqri.qa.pages.LandingPage;
import com.tiqri.qa.pages.LoginPage;
import com.tiqri.qa.pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test
public class RegistrationTest extends BaseTest {

    LandingPage landingPage;
    RegisterPage registerPage;
    DashboardPage dashboard;
    LoginPage loginPage;

    String userName = "John_" + System.currentTimeMillis();
    String password = "Ousl2018";
    String age = "35";

    @BeforeClass
    public void beforeClass() {
        landingPage = new LandingPage(driver);
    }


    @Test(priority = 1)
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

    @Test(priority = 2)
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
