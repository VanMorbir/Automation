using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;

class EntryPoint
{
    public static void Main()
    {
        IWebDriver driver = new ChromeDriver();

        //initial test
        driver.Navigate().GoToUrl("http://testing.todorvachev.com");
        //Thread.Sleep(3000);
        driver.Quit();

        //element test
        driver = new ChromeDriver();
        driver.Navigate().GoToUrl("http://testing.todorvachev.com/name/");
        IWebElement elementName = driver.FindElement(By.Name("myName"));
        if (elementName.Displayed)
        {
            GreenMessage("Name is visible");
        }
        else
        {
            RedMessage("Name is NOT VISIBLE");
        }
        driver.Quit();

        //selector test
        string url = "http://testing.todorvachev.com/id/";
        string ID = "testImage";
        driver = new ChromeDriver();
        driver.Navigate().GoToUrl(url);
        IWebElement elementID = driver.FindElement(By.Id(ID));
        if (elementID.Displayed)
        {
            GreenMessage("ID is visible");
        }
        else
        {
            RedMessage("ID is NOT VISIBLE");
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