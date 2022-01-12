using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;

class EntryPoint
{
    public static void Main()
    {
        IWebDriver driver = new ChromeDriver();

        //initial test
        driver.Navigate().GoToUrl("http://testing.todorvachev.com");
        Thread.Sleep(3000);
        driver.Quit();

        //element test
        driver = new ChromeDriver();
        driver.Navigate().GoToUrl("http://testing.todorvachev.com/name/");
        IWebElement element = driver.FindElement(By.Name("myName"));
        if (element.Displayed)
        {
            GreenMessage("element is visible");
        }
        else
        {
            RedMessage("element is NOT VISIBLE");
        }
        driver.Quit();
    }

    private static void RedMessage(string message)
    {
        Console.ForegroundColor = ConsoleColor.Red;
        Console.WriteLine(message);
        Console.ForegroundColor = ConsoleColor.White;
    }

    private static void GreenMessage(string message)
    {
        Console.ForegroundColor = ConsoleColor.Green;
        Console.WriteLine(message);
        Console.ForegroundColor = ConsoleColor.White;
    }
}