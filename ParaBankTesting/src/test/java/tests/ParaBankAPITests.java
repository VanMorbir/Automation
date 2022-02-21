package tests;

import com.relevantcodes.extentreports.LogStatus;
import config.Reporter;
import config.apiconfig.Endpoints;
import config.apiconfig.ParaBankAPIConfig;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ParaBankAPITests extends ParaBankAPIConfig {
    Reporter reporter;
    JSONObject credentialsObject = null;


    @Before
    public void SetUp(){
        reporter = Reporter.getInstance();
        JSONParser parser = new JSONParser();
        try{
            FileReader reader = new FileReader("src/test/java/tests/TestCredentials.json");
            credentialsObject = (JSONObject) parser.parse(reader);
        }
        catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void verifySingleCustomer(){
        reporter.test = reporter.extents.startTest("API-TEST001", "Verify the details of a single customer");
        JSONObject customer = (JSONObject) credentialsObject.get("customer");
        String id = (String) customer.get("id");
        String firstName = (String) customer.get("firstName");
        String lastName = (String) customer.get("lastName");
        try {
            given().
                    when().get(Endpoints.CUSTOMER("12212")).
                    then().
                    assertThat().body("customer.id", equalTo(id)).
                    and().
                    assertThat().body("customer.firstName", equalTo(firstName)).
                    and().
                    assertThat().body("customer.lastName", equalTo(lastName));
            reporter.test.log(LogStatus.PASS, "Response from server matched credentials");
        }
        catch (AssertionError e){
            reporter.test.log(LogStatus.FAIL, "Response from server mismatch:" + e.getMessage());
            throw e;
        }
        finally {
            reporter.extents.endTest(reporter.test);
        }
    }

    @Test
    public void verifySingleAccount() {
        reporter.test = reporter.extents.startTest("API-TEST002", "Verify the details of a single account");
        try {
            given().
                    when().get(Endpoints.ACCOUNT("13344")).
                    then().
                    assertThat().body("account.id", equalTo("13344")).
                    and().
                    assertThat().body("account.customerId", equalTo("12212")).
                    and().
                    assertThat().body("account.type", equalTo("SAVINGS"));
            reporter.test.log(LogStatus.PASS, "Response from server matched credentials");

        }
        catch (AssertionError e)
        {
            reporter.test.log(LogStatus.FAIL, "Response from server mismatch:" + e.getMessage());
            throw e;
        }
        finally {
            reporter.extents.endTest(reporter.test);
        }
    }
}