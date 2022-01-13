using AutoTestFramework.UIElements;

namespace AutoTestFramework
{
    public static class Actions
    {
        public static void FillLoginForm(string username, string password, string repeatPassword)
        {
            LoginScenarioPost lsPost = new LoginScenarioPost();

            lsPost.UsernameField.SendKeys(username);
            lsPost.PasswordField.SendKeys(password);
            lsPost.RepeatPasswordField.SendKeys(repeatPassword);
            lsPost.LoginButton.Click();
        }
    }
}
