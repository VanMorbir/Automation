package tests;

import com.relevantcodes.extentreports.LogStatus;
import config.Reporter;
import config.uiconfig.NavigateTo;
import config.uiconfig.ParaBankActions;
import config.uiconfig.ParaBankUIConfig;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UITestsCollection {

    public static void testValidContact(WebDriver driver, Reporter reporter, String testName, String description){
        reporter.test = reporter.extents.startTest(testName,description);
        NavigateTo.ContactThroughRightNavBar(driver);
        ParaBankActions.FillContactForm(
                ParaBankUIConfig.Credentials.ContactInfo.Name,
                ParaBankUIConfig.Credentials.ContactInfo.Email,
                ParaBankUIConfig.Credentials.ContactInfo.PhoneNumber,
                ParaBankUIConfig.Credentials.ContactInfo.Message,
                driver
        );
        boolean isContactSucceeded = driver.findElement(By.cssSelector("#rightPanel > h1")).isDisplayed();
        try {
            Assert.assertTrue(isContactSucceeded);
            reporter.test.log(LogStatus.PASS, "Contact filled successfully");
        }
        catch (AssertionError e){
            reporter.test.log(LogStatus.FAIL, "Failed to submit contact information");
            throw e;
        }
        finally {
            reporter.extents.endTest(reporter.test);
        }
    }

    public static void testMissingPhoneNumberInContact(WebDriver driver, Reporter reporter, String testName, String description) {
        reporter.test = reporter.extents.startTest(testName,description);
        NavigateTo.ContactThroughRightNavBar(driver);
        ParaBankActions.FillContactForm(
                ParaBankUIConfig.Credentials.ContactInfo.Name,
                ParaBankUIConfig.Credentials.ContactInfo.Email,
                "",
                ParaBankUIConfig.Credentials.ContactInfo.Message,
                driver
        );
        WebElement alert = driver.findElement(By.cssSelector("#phone\\.errors"));

        try {

            Assert.assertTrue(alert.isDisplayed());
            reporter.test.log(LogStatus.PASS, "Missing phone number alert is visible");
        }
        catch (AssertionError e){
            reporter.test.log(LogStatus.FAIL, "Missing phone number alert is not visible");
            throw e;
        }
        finally {
            reporter.extents.endTest(reporter.test);
        }

        try {
            Assert.assertEquals(ParaBankUIConfig.Alerts.Contact.MissingPhoneNumber, alert.getText());
            reporter.test.log(LogStatus.PASS, "Missing phone number alert text is correct");
        }
        catch (AssertionError e){
            reporter.test.log(LogStatus.FAIL, "Missing phone number alert text mismatch");
            throw e;
        }
        finally {
            reporter.extents.endTest(reporter.test);
        }
    }
}
