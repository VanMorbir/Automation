package tests;

import config.ParaBankAPIConfig;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ParaBankAPITests extends ParaBankAPIConfig {
    @Test
    public void verifySingleAccount(){
        given().log().all().
                when().get("customers/12212").
                then().
                assertThat().body("customer.id", equalTo("12212")).
                and().
                assertThat().body("customer.firstName", equalTo("John")).
                and().
                assertThat().body("customer.lastName", equalTo("Smith"));
    }
}