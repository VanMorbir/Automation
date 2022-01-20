package config.uiconfig;

import config.uiconfig.uielements.RightSideNavBar;
import org.openqa.selenium.WebDriver;

public class NavigateTo {
    public static void ContactThroughRightNavBar(WebDriver driver){
        RightSideNavBar navBar = new RightSideNavBar(driver);

        navBar.ContactButton.click();
    }
}
