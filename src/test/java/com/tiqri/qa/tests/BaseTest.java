package com.tiqri.qa.tests;

import com.tiqri.qa.util.StringUtil;
import com.tiqri.qa.util.WebDriverUtil;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    final static Logger logger = Logger.getLogger(BaseTest.class);

    static WebDriver driver;
    static String userName = "John_" + StringUtil.getUniqueString();
    static String password = "Ousl2018";

    @BeforeSuite
    public void beforeSuite() {
        driver = WebDriverUtil.getDriver();
    }

    @AfterSuite
    public void afterSuite() {
        driver.quit();
    }
}
