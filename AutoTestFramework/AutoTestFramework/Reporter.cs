using AventStack.ExtentReports;
using AventStack.ExtentReports.Reporter;
using System;
using System.IO;

namespace AutoTestFramework
{
    public class Reporter
    {
        private static Reporter instance = null;
        public ExtentTest test { get; set; }
        public ExtentReports extent { get; set; }
        private static readonly object padlock = new object();

        public static Reporter Instance 
        { get
            {
                lock(padlock)
                {
                    if(instance == null)
                    {
                        instance = new Reporter();
                    }
                    return instance;
                }
            }
        }

        private Reporter()
        {
            extent = new ExtentReports();
            var htmlreporter = new ExtentHtmlReporter(Directory.GetCurrentDirectory() + @"\TestReport.html");
            extent.AttachReporter(htmlreporter);
        }

    }
}
