
using AventStack.ExtentReports;
using AventStack.ExtentReports.Reporter;
using NUnit.Framework;
using OpenQA.Selenium;
using System.IO;

namespace AutoTestFramework.Tests
{
    [TestFixture]
    [Parallelizable]
    public class ValidLoginTest
    {
        IAlert alert;
        Reporter reporter;
        ExtentTest testCase;
        ExtentReports report;
        public IWebDriver Driver { get; set; }

        [OneTimeSetUp]
        public void Initialize()
        {
            Driver = Actions.InitDriver();
            reporter = Reporter.Instance;

            report = new ExtentReports();
            var htmlreporter = new ExtentHtmlReporter(Directory.GetCurrentDirectory() + @"\Valid.html");
            report.AttachReporter(htmlreporter);
        }

        [Test]
        public void ValidLogin()
        {
            reporter.test = null;
            reporter.test = reporter.extent.CreateTest("T003").Info("Valid login");
            testCase = report.CreateTest("T003").Info("Valid login");

            NavigateTo.LoginFromThroughMenu(Driver);
            Actions.FillLoginForm(Config.Credentials.Valid.Username,
                                  Config.Credentials.Valid.Password,
                                  Config.Credentials.Valid.RepeatPassword,
                                  Driver);
            alert = Driver.SwitchTo().Alert();
            try
            {
                Assert.AreEqual(Config.AlertMessages.SuccessfulLogin, alert.Text);
                reporter.test.Log(AventStack.ExtentReports.Status.Pass, "Test Passed");
                testCase.Log(AventStack.ExtentReports.Status.Pass, "Test Passed");
            }
            catch (System.Exception)
            {
                reporter.test.Log(AventStack.ExtentReports.Status.Fail, "Test Failed");
                throw;
            }
            
            alert.Accept();
        }

        [OneTimeTearDown]
        public void Cleanup()
        {
            Driver.Quit();
            reporter.extent.Flush();
            report.Flush();
        }
    }
}
