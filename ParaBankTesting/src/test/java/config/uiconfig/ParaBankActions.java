package config.uiconfig;
import config.uiconfig.uielements.ContactPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ParaBankActions {
    public static WebDriver InitDriver(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to(ParaBankUIConfig.baseURL);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }

    public static AndroidDriver<WebElement> InitMobileDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, ParaBankUIConfig.deviceName);
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        capabilities.setCapability("chromedriverExecutable", "C:\\Users\\Gil\\Documents\\GitHub\\Automation\\src\\main\\resources\\chromedriver.exe");

        AndroidDriver<WebElement> driver = new AndroidDriver<>(new URL(ParaBankUIConfig.appiumServer), capabilities);
        driver.navigate().to(ParaBankUIConfig.baseURL);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return driver;
    }

    public static void FillContactForm(
        String name,
        String email,
        String phone,
        String message,
        WebDriver driver
    ) {
        ContactPage cp = new ContactPage(driver);

        cp.NameTextBox.clear();
        cp.EmailTextBox.clear();
        cp.PhoneTextBox.clear();
        cp.MessageTextBox.clear();

        cp.NameTextBox.sendKeys(name);
        cp.EmailTextBox.sendKeys(email);
        cp.PhoneTextBox.sendKeys(phone);
        cp.MessageTextBox.sendKeys(message);
        cp.SendButton.click();
    }
}
