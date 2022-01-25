import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.ParaBankAPITests;
import tests.ParaBankUITests;

@RunWith(Suite.class)
@Suite.SuiteClasses({ParaBankAPITests.class, ParaBankUITests.class})
public class AllTestsSuite {
}
