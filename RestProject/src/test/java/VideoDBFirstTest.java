import org.junit.Test;

import static io.restassured.RestAssured.*;

public class VideoDBFirstTest extends TestConfig {
    @Test
    public void FirstTest(){
        given()
                .log().all().
        when().get("videogames").
        then()
                .log().all();
    }
}
