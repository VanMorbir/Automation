import config.VideoGamesDBconfig;
import config.VideoGamesEndpoint;
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

    @Test
    public void TestEndpoint(){
        get(VideoGamesEndpoint.ALL_VIDEO_GAMES)
                .then().log().all();
    }
}
