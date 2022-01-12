using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;

class EntryPoint
{
    public static void Main()
    {
        IWebDriver driver = new ChromeDriver();

        driver.Navigate().GoToUrl("http://testing.todorvachev.com");
        Thread.Sleep(3000);
        driver.Quit();
    }
}