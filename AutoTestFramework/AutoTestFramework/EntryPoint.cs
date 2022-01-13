using NUnit.Framework;
using OpenQA.Selenium;

namespace AutoTestFramework
{
    public class EntryPoint
    {
        IAlert alert;
        

        [SetUp]
        public void Initialize()
        {
            Actions.InitDriver();
        }

        [Test]
        public void ValidLogin()
        {
            NavigateTo.LoginFromThroughMenu();
            Actions.FillLoginForm(Config.Credentials.Valid.Username,
                                  Config.Credentials.Valid.Password,
                                  Config.Credentials.Valid.RepeatPassword);
            alert = Driver.driver.SwitchTo().Alert();
            Assert.AreEqual(Config.AlertMessages.SuccessfulLogin, alert.Text);
            alert.Accept();
        }

        [TearDown]
        public void Cleanup()
        {
            Driver.driver.Quit();
        }
    }
}