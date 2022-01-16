using AutoTestFramework.UIElements;
using OpenQA.Selenium;

namespace AutoTestFramework
{
    public static class NavigateTo
    {
        public static void LoginFromThroughMenu(IWebDriver driver)
        {
            Menu menu = new Menu(driver); 
            TestScenariosPage tsPage = new TestScenariosPage(driver);

            menu.TestScenarios.Click();
            tsPage.LoginForm.Click();
        }
    }
}
