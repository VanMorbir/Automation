
using NUnit.Framework;
using OpenQA.Selenium;

namespace AutoTestFramework.Tests
{
    public class ValidLoginTest
    {
        IAlert alert;

        [OneTimeSetUp]
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

        [OneTimeTearDown]
        public void Cleanup()
        {
            Driver.driver.Quit();
        }
    }
}
