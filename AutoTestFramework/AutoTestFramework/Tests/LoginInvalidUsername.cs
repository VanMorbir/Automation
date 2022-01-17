
using NUnit.Framework;
using OpenQA.Selenium;

namespace AutoTestFramework.Tests
{
    [TestFixture]
    [Parallelizable]
    public class LoginInvalidUsername
    {
        IAlert alert;
        public IWebDriver Driver { get; set; }
        Reporter reporter;

        [OneTimeSetUp]
        public void Init()
        {
            Driver = Actions.InitDriver();
            NavigateTo.LoginFromThroughMenu(Driver);
            reporter = Reporter.Instance;
        }

        [Test]
        public void UserNameLessThan5Chars()
        {
            reporter.test = null;
            reporter.test = reporter.extent.CreateTest("T001").Info("Invalid Login: User name with less than 5 chars");
            Actions.FillLoginForm(Config.Credentials.Invalid.UserName.FourCharacters,
                                  Config.Credentials.Valid.Password,
                                  Config.Credentials.Valid.RepeatPassword,
                                  Driver);
            alert = Driver.SwitchTo().Alert();
            try
            {
                Assert.AreEqual(Config.AlertMessages.UserNameLengthOutOfRange, alert.Text);
                reporter.test.Log(AventStack.ExtentReports.Status.Pass,"Test Passed");
            }
            catch (System.Exception)
            {
                reporter.test.Log(AventStack.ExtentReports.Status.Fail, "Test Failed");
                throw;
            }
            
            alert.Accept();
        }

        [Test]
        public void UserNameMoreThan12Chars()
        {
            reporter.test = null;
            reporter.test = reporter.extent.CreateTest("T002").Info("Invalid login: User name with more than 12 chars");
            Actions.FillLoginForm(Config.Credentials.Invalid.UserName.ThirteenCharacters,
                                  Config.Credentials.Valid.Password,
                                  Config.Credentials.Valid.RepeatPassword,
                                  Driver);
            alert = Driver.SwitchTo().Alert();
            try
            {
                Assert.AreEqual(Config.AlertMessages.UserNameLengthOutOfRange, alert.Text);
                reporter.test.Log(AventStack.ExtentReports.Status.Pass, "Test Passed");
            }
            catch (System.Exception)
            {
                reporter.test.Log(AventStack.ExtentReports.Status.Fail, "Test Failed");
                throw;
            }
           
            alert.Accept();
        }

        [OneTimeTearDown]
        public void CleanUp()
        {
            Driver.Quit();
            reporter.extent.Flush();
        }
    }
}
