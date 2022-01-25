package config;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Reporter {
    private static Reporter instance = null;
    public ExtentReports extents;
    public ExtentTest test;

    private Reporter(){
        extents = new ExtentReports(System.getProperty("user.dir") + "Report.html");
    }

    synchronized public static Reporter getInstance(){
        if(instance == null) {
            instance = new Reporter();
            return instance;
        }
        else {
            return instance;
        }
    }
}
