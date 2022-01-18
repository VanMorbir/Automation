import org.junit.Test;

import static io.restassured.RestAssured.*;

public class VideoDBFirstTest {
    @Test
    public void FirstTest(){
        given()
                .log().all().
        when().get("http://167.99.197.177:8080/app/videogames").
        then()
                .log().all();
    }
}
