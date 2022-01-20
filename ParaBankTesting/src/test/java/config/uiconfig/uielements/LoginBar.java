package config.uiconfig.uielements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginBar {
    public LoginBar(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "username")
    public WebElement UserNameTextBox;

    @FindBy(name = "password")
    public WebElement PasswordTextBox;

    @FindBy(css = "#loginPanel > form > div:nth-child(5) > input")
    public WebElement LoginButton;
}
