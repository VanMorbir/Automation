package tests;


import config.Reporter;
import config.uiconfig.ParaBankActions;
import org.junit.*;
import org.openqa.selenium.WebDriver;

public class ParaBankUITests {
    public WebDriver driver;
    //public AndroidDriver<WebElement> driver;
    public static Reporter reporter;

    @Before
    public void setup() {
        //driver = ParaBankActions.InitMobileDriver();
        driver = ParaBankActions.InitDriver();
        reporter = Reporter.getInstance();
    }

    @Test
    public void testValidContact() {
        UITestsCollection.testValidContact(driver,reporter, "UI-TEST001", "Testing Valid 'Contact Us' request");
    }

    @Test
    public void testMissingPhoneNumberInContact() {
        UITestsCollection.testMissingPhoneNumberInContact(driver, reporter, "UI-TEST002", "Testing 'Contact Us' request with missing phone number");
    }

    @After
    public void teardown(){
        driver.quit();
    }


}
