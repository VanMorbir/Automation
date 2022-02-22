package tests;

import config.Reporter;
import config.uiconfig.ParaBankActions;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

public class ParaBankMobileTests {
    public AndroidDriver<WebElement> driver;
    public static Reporter reporter;

    @Before
    public void setup() throws MalformedURLException {
        driver = ParaBankActions.InitMobileDriver();
        reporter = Reporter.getInstance();
    }

    @Test
    public void testValidContact() {
        UITestsCollection.testValidContact(driver,reporter, "MOBILE-TEST001", "Testing Valid 'Contact Us' request");
    }

    @Test
    public void testMissingPhoneNumberInContact() {
        UITestsCollection.testMissingPhoneNumberInContact(driver, reporter, "MOBILE-TEST002", "Testing 'Contact Us' request with missing phone number");
    }

    @After
    public void teardown(){
        driver.quit();
    }
}
