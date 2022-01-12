using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;

class EntryPoint
{
    static IWebDriver driver = new ChromeDriver();
    static IWebElement textBoxElement;

    public static void Main()
    {
        //initial test
        driver.Navigate().GoToUrl("http://testing.todorvachev.com");

        //element test
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

        //selector test
        string url = "http://testing.todorvachev.com/id/";
        string ID = "testImage";
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

        //css path test
        string csspath = "#post-108 > div > figure > img";
        string xpath = "//*[@id=\"post-108\"]/div/figure/img";
        string cssURL = "http://testing.todorvachev.com/css-path/";
        string brokenCSSpath = "#post-108 > div > fig img";

        driver.Navigate ().GoToUrl(cssURL);
        IWebElement cssPathElement = driver.FindElement(By.CssSelector(csspath));
        IWebElement xPathElement = driver.FindElement(By.XPath(xpath));
        if (cssPathElement.Displayed)
        {
            GreenMessage("css Path is visible");
        }
        else
        {
            RedMessage("css Path is NOT VISIBLE");
        }
        if (xPathElement.Displayed)
        {
            GreenMessage("xPath is visible");
        }
        else
        {
            RedMessage("xPath is NOT VISIBLE");
        }
        try
        {
            IWebElement brokenCSSElement = driver.FindElement(By.CssSelector(brokenCSSpath));
            if (brokenCSSElement.Displayed)
            {
                GreenMessage("BrokenCSS is visible");
            }
        }
        catch (NoSuchElementException)
        {
            RedMessage("BrokenCSS is not visible");
        }

        //Textbox test
        string textBoxURL = "http://testing.todorvachev.com/text-input-field/";
        driver.Navigate().GoToUrl(textBoxURL);
        textBoxElement = driver.FindElement(By.Name("username"));

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