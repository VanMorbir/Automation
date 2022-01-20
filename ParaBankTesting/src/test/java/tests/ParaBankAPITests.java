package tests;

import config.apiconfig.Endpoints;
import config.apiconfig.ParaBankAPIConfig;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ParaBankAPITests extends ParaBankAPIConfig {
    @Test
    public void verifySingleCustomer(){
        given().
        when().get(Endpoints.CUSTOMER("12212")).
        then().
                assertThat().body("customer.id", equalTo("12212")).
                and().
                assertThat().body("customer.firstName", equalTo("John")).
                and().
                assertThat().body("customer.lastName", equalTo("Smith"));
    }

    @Test
    public void verifySingleAccount(){
        given().
        when().get(Endpoints.ACCOUNT("12345")).
        then().
                assertThat().body("account.id", equalTo("12345")).
                and().
                assertThat().body("account.customerId", equalTo("12212")).
                and().
                assertThat().body("account.type", equalTo("CHECKING"));

    }
}