package config.uiconfig.uielements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RightSideNavBar {
    public RightSideNavBar(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#headerPanel > ul.button > li.home > a")
    public WebElement HomeButton;

    @FindBy(css = "#headerPanel > ul.button > li.aboutus > a")
    public WebElement AboutButton;

    @FindBy(css = "#headerPanel > ul.button > li.contact > a")
    public WebElement ContactButton;
}
