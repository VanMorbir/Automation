
using NUnit.Framework;
using OpenQA.Selenium;

namespace AutoTestFramework.Tests
{
    [Parallelizable]
    public class LoginInvalidUsername
    {
        IAlert alert;
        public IWebDriver Driver { get; set; }

        [OneTimeSetUp]
        public void Init()
        {
            Driver = Actions.InitDriver();
            NavigateTo.LoginFromThroughMenu(Driver);
        }

        [Test]
        public void UserNameLessThan5Chars()
        {
            Actions.FillLoginForm(Config.Credentials.Invalid.UserName.FourCharacters,
                                  Config.Credentials.Valid.Password,
                                  Config.Credentials.Valid.RepeatPassword,
                                  Driver);
            alert = Driver.SwitchTo().Alert();
            Assert.AreEqual(Config.AlertMessages.UserNameLengthOutOfRange, alert.Text);
            alert.Accept();
        }

        [Test]
        public void UserNameMoreThan12Chars()
        {
            Actions.FillLoginForm(Config.Credentials.Invalid.UserName.ThirteenCharacters,
                                  Config.Credentials.Valid.Password,
                                  Config.Credentials.Valid.RepeatPassword,
                                  Driver);
            alert = Driver.SwitchTo().Alert();
            Assert.AreEqual(Config.AlertMessages.UserNameLengthOutOfRange, alert.Text);
            alert.Accept();
        }

        [OneTimeTearDown]
        public void CleanUp()
        {
            Driver.Quit();
        }
    }
}
