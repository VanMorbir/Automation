import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static io.restassured.RestAssured.given;

public class TestClass {
    @Test
    public void driverTest() {
        WebDriver driver = new ChromeDriver();
    }

    @Test
    public void restTest(){
        given();
    }

}
