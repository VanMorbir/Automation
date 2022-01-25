import config.Reporter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.ParaBankAPITests;
import tests.ParaBankUITests;

@RunWith(Suite.class)
@Suite.SuiteClasses({ParaBankAPITests.class, ParaBankUITests.class})
public class AllTestsSuite {
    static Reporter reporter;

    @BeforeClass
    public static void InitReporter(){
        reporter = Reporter.getInstance();
    }

    @AfterClass
    public static void finish(){
        reporter.extents.flush();
    }
}
