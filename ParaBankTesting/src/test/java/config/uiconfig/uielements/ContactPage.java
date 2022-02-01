package config.uiconfig.uielements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
    public ContactPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#name")
    public WebElement NameTextBox;

    @FindBy(css = "#email")
    public WebElement EmailTextBox;

    @FindBy(css = "#phone")
    public WebElement PhoneTextBox;

    @FindBy(css = "#message")
    public WebElement MessageTextBox;

    @FindBy(css = "#contactForm > table > tbody > tr:nth-child(5) > td:nth-child(2) > input")
    public WebElement SendButton;
}
