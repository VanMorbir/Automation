package config.uiconfig;
import config.uiconfig.uielements.ContactPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ParaBankActions {
    public static WebDriver InitDriver(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to(ParaBankUIConfig.baseURL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
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
