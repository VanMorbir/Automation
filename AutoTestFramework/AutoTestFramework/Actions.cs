using AutoTestFramework.UIElements;
using OpenQA.Selenium.Chrome;

namespace AutoTestFramework
{
    public static class Actions
    {
        public static void InitDriver()
        {
            Driver.driver = new ChromeDriver();
            Driver.driver.Navigate().GoToUrl(Config.baseURL);
        }
        public static void FillLoginForm(string username, string password, string repeatPassword)
        {
            LoginScenarioPost lsPost = new LoginScenarioPost();

            lsPost.UsernameField.Clear();
            lsPost.PasswordField.Clear();
            lsPost.RepeatPasswordField.Clear();

            lsPost.UsernameField.SendKeys(username);
            lsPost.PasswordField.SendKeys(password);
            lsPost.RepeatPasswordField.SendKeys(repeatPassword);
            lsPost.LoginButton.Click();
        }
    }
}
