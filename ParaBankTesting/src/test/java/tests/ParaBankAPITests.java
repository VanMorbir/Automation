package tests;

import com.relevantcodes.extentreports.LogStatus;
import config.Reporter;
import config.apiconfig.Endpoints;
import config.apiconfig.ParaBankAPIConfig;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ParaBankAPITests extends ParaBankAPIConfig {
    Reporter reporter;

    @Before
    public void getReporter(){
        reporter = Reporter.getInstance();
    }

    @Test
    public void verifySingleCustomer(){
        reporter.test = reporter.extents.startTest("API-TEST001", "Verify the details of a single customer");
        try {
            given().
                    when().get(Endpoints.CUSTOMER("12212")).
                    then().
                    assertThat().body("customer.id", equalTo("12212")).
                    and().
                    assertThat().body("customer.firstName", equalTo("John")).
                    and().
                    assertThat().body("customer.lastName", equalTo("Smith"));
            reporter.test.log(LogStatus.PASS, "Response from server matched credentials");
            reporter.extents.endTest(reporter.test);
        }
        catch (AssertionError e){
            reporter.test.log(LogStatus.FAIL, "Response from server mismatch");
            reporter.extents.endTest(reporter.test);
            throw e;
        }
    }

    @Test
    public void verifySingleAccount() {
        reporter.test = reporter.extents.startTest("API-TEST002", "Verify the details of a single account");
        try {
            given().
                    when().get(Endpoints.ACCOUNT("12345")).
                    then().
                    assertThat().body("account.id", equalTo("12345")).
                    and().
                    assertThat().body("account.customerId", equalTo("12212")).
                    and().
                    assertThat().body("account.type", equalTo("CHECKING"));
            reporter.test.log(LogStatus.PASS, "Response from server matched credentials");
            reporter.extents.endTest(reporter.test);

        }
        catch (AssertionError e)
        {
            reporter.test.log(LogStatus.FAIL, "Response from server mismatch");
            reporter.extents.endTest(reporter.test);
            throw e;
        }
    }
}