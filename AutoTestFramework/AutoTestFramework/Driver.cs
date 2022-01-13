using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;

namespace AutoTestFramework
{
    public static class Driver
    {
        public static IWebDriver driver = new ChromeDriver();

        public static void InitDriver()
        {
            driver = new ChromeDriver();
        }
    }
}
