package config.uiconfig;

import jdk.jfr.Timespan;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ParaBankActions {
    public static WebDriver InitDriver(){
        WebDriver driver = new ChromeDriver();
        driver.navigate().to(ParaBankUIConfig.baseURL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;
    }
}
