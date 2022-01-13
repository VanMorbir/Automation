namespace AutoTestFramework
{
    public class EntryPoint
    {
        static void Main()
        {
            Driver.driver.Navigate().GoToUrl(Config.baseURL);
            NavigateTo.LoginFromThroughMenu();
            Actions.FillLoginForm(Config.Credentials.Valid.Username,
                                  Config.Credentials.Valid.Password,
                                  Config.Credentials.Valid.RepeatPassword);
        }
    }
}