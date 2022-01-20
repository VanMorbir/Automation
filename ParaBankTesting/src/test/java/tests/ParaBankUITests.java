package tests;

import config.uiconfig.NavigateTo;
import config.uiconfig.ParaBankActions;
import config.uiconfig.ParaBankUIConfig;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ParaBankUITests {
    public WebDriver driver;

    @Before
    public void setup() throws InterruptedException {
        driver = ParaBankActions.InitDriver();
    }

    @Test
    public void testValidContact(){
        NavigateTo.ContactThroughRightNavBar(driver);
        ParaBankActions.FillContactForm(
                ParaBankUIConfig.Credentials.ContactInfo.Name,
                ParaBankUIConfig.Credentials.ContactInfo.Email,
                ParaBankUIConfig.Credentials.ContactInfo.PhoneNumber,
                ParaBankUIConfig.Credentials.ContactInfo.Message,
                driver
        );
        Boolean isContactSucceded = driver.findElement(By.cssSelector("#rightPanel > h1")).isDisplayed();
        Assert.assertTrue(isContactSucceded);
    }

    @Test
    public void testMissingPhoneNumberInContact(){
        NavigateTo.ContactThroughRightNavBar(driver);
        ParaBankActions.FillContactForm(
                ParaBankUIConfig.Credentials.ContactInfo.Name,
                ParaBankUIConfig.Credentials.ContactInfo.Email,
                "",
                ParaBankUIConfig.Credentials.ContactInfo.Message,
                driver
        );
        Boolean isErrorMessageVisible = driver.findElement(By.cssSelector("#phone\\.errors")).isDisplayed();
        Assert.assertTrue(isErrorMessageVisible);
    }

    @After
    public void teardown(){
        driver.quit();
    }
}
