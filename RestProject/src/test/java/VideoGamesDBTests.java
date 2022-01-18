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

    @Test
    public void createGameByXML() {
        String gameBodyXML = "<videoGame category=\"Simulation\" rating=\"Universal\">\n" +
                "    <id>12</id>\n" +
                "    <name>EliteDangerous</name>\n" +
                "    <releaseDate>2001-04-23T00:00:00Z</releaseDate>\n" +
                "    <reviewScore>90</reviewScore>\n" +
                "  </videoGame>";
        given()
                .body(gameBodyXML)
                .header("Accept", "application/xml")
                .header("Content-Type", "application/xml").
        when()
                .post(VideoGamesEndpoint.ALL_VIDEO_GAMES).
        then();
    }
}
