import config.VideoGamesDBconfig;
import config.VideoGamesEndpoint;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class VideoGamesDBTests extends VideoGamesDBconfig {

    @Test
    public void getAllGames()
    {
        given().
        when().get(VideoGamesEndpoint.ALL_VIDEO_GAMES).
        then();
    }

    @Test
    public void createNewGameByJson(){
        String gameBodyJson= "{\n" +
                "  \"id\": 11,\n" +
                "  \"name\": \"Monster Hunter Rise\",\n" +
                "  \"releaseDate\": \"2022-01-12T09:56:39.072Z\",\n" +
                "  \"reviewScore\": 99,\n" +
                "  \"category\": \"rpg\",\n" +
                "  \"rating\": \"everyone\"\n" +
                "}";
        given()
                .body(gameBodyJson).
        when()
                .post(VideoGamesEndpoint.ALL_VIDEO_GAMES).
        then();
    }
}
