
using NUnit.Framework;
using OpenQA.Selenium;

namespace AutoTestFramework.Tests
{
    [Parallelizable]
    public class ValidLoginTest
    {
        IAlert alert;
        public IWebDriver Driver { get; set; }

        [OneTimeSetUp]
        public void Initialize()
        {
            Driver = Actions.InitDriver();
        }

        [Test]
        public void ValidLogin()
        {
            NavigateTo.LoginFromThroughMenu(Driver);
            Actions.FillLoginForm(Config.Credentials.Valid.Username,
                                  Config.Credentials.Valid.Password,
                                  Config.Credentials.Valid.RepeatPassword,
                                  Driver);
            alert = Driver.SwitchTo().Alert();
            Assert.AreEqual(Config.AlertMessages.SuccessfulLogin, alert.Text);
            alert.Accept();
        }

        [OneTimeTearDown]
        public void Cleanup()
        {
            Driver.Quit();
        }
    }
}
