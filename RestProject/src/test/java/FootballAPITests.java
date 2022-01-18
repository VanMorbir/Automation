import config.FootballAPIConfig;
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
}
