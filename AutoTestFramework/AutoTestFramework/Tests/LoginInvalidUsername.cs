
using NUnit.Framework;
using OpenQA.Selenium;

namespace AutoTestFramework.Tests
{
    
    public class LoginInvalidUsername
    {
        IAlert alert;

        [OneTimeSetUp]
        public void Init()
        {
            Actions.InitDriver();
            NavigateTo.LoginFromThroughMenu();
        }

        [Test]
        public void UserNameLessThan5Chars()
        {
            Actions.FillLoginForm(Config.Credentials.Invalid.UserName.FourCharacters,
                                  Config.Credentials.Valid.Password,
                                  Config.Credentials.Valid.RepeatPassword);
            alert = Driver.driver.SwitchTo().Alert();
            Assert.AreEqual(Config.AlertMessages.UserNameLengthOutOfRange, alert.Text);
            alert.Accept();
        }

        [Test]
        public void UserNameMoreThan12Chars()
        {
            Actions.FillLoginForm(Config.Credentials.Invalid.UserName.ThirteenCharacters,
                                  Config.Credentials.Valid.Password,
                                  Config.Credentials.Valid.RepeatPassword);
            alert = Driver.driver.SwitchTo().Alert();
            Assert.AreEqual(Config.AlertMessages.UserNameLengthOutOfRange, alert.Text);
            alert.Accept();
        }

        [OneTimeTearDown]
        public void CleanUp()
        {
            Driver.driver.Quit();
        }
    }
}
