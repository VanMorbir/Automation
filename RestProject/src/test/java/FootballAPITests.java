import config.FootballAPIConfig;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.junit.Test;
import static org.hamcrest.Matchers.equalTo;

import static io.restassured.RestAssured.*;

public class FootballAPITests extends FootballAPIConfig {

    @Test
    public void getDetailsOfOneArea(){
        given()
                .queryParam("areas", 2072).
        when()
                .get("areas").
        then();
    }

    @Test
    public void getDateFounded(){
        given().
        when().
                get("teams/57").
        then().
                body("founded", equalTo(1886));
    }

    @Test
    public void getFirstTeamName() {
        given().
                when()
                .get("competitions/2021/teams").
                then().
                body("teams.name[0]", equalTo("Arsenal FC"));
    }

    @Test
    public void getAllTeamData(){
        String responseBody = get("teams/57").asString();
    }

    @Test
    public void getAllTeamData_CheckFirst(){
        Response response =
                given().
                when().get("teams/57").
                then().contentType(ContentType.JSON)
                .extract().response();
        String responseString = response.asString();
    }

    @Test
    public void extractHeaders(){
        Response response =
                given().
                when().get("teams/57").
                then().contentType(ContentType.JSON).
                extract().response();
        Headers Headers = response.getHeaders();
    }
}
