using AutoTestFramework.UIElements;

namespace AutoTestFramework
{
    public static class NavigateTo
    {
        public static void LoginFromThroughMenu()
        {
            Menu menu = new Menu(); 
            TestScenariosPage tsPage = new TestScenariosPage();

            menu.TestScenarios.Click();
            tsPage.LoginForm.Click();
        }
    }
}
