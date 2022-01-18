import config.VideoGamesDBconfig;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class VideoDBFirstTest extends VideoGamesDBconfig {
    @Test
    public void FirstTest(){
        given()
                .log().all().
        when().get("videogames").
        then()
                .log().all();
    }
}
