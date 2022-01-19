import config.VideoGamesDBconfig;
import config.VideoGamesEndpoint;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.matchesXsdInClasspath;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

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

    @Test
    public void updateGame(){
        String gameBodyJson = "{\n" +
                "  \"id\": 1,\n" +
                "  \"name\": \"new name\",\n" +
                "  \"releaseDate\": \"2022-01-18T12:48:13.241Z\",\n" +
                "  \"reviewScore\": 69,\n" +
                "  \"category\": \"Driving\",\n" +
                "  \"rating\": \"Mature\"\n" +
                "}";
        given()
                .body(gameBodyJson).
        when()
                .put("videogames/1").
        then();
    }

    @Test
    public void deleteTest(){
        given().
        when().
                delete("videogames/1").
        then();
    }

    @Test
    public void getSingleGame(){
        given()
                .pathParam("videoGameId", 5).
        when()
                .get(VideoGamesEndpoint.SINGLE_VIDEO_GAME).
        then();
    }

    @Test
    public void testSerializationByJSON(){
        VideoGame videoGame = new VideoGame("99", "2010-01-01","Serial Game","Mature","13","Shooter");
        given().
                body(videoGame).
        when().
                post(VideoGamesEndpoint.ALL_VIDEO_GAMES).
        then();
    }

    @Test
    public void testVideoGameSchemaXML(){
        given().
                pathParam("videoGameId", 5).
                header("Content-Type","application/xml").
                header("Accept", "application/xml").
        when().
                get(VideoGamesEndpoint.SINGLE_VIDEO_GAME).
        then().
                body(matchesXsdInClasspath("VideoGameXSD.xsd"));
    }

    @Test
    public void testVideoGameSchemaJSON(){
        given().
                pathParam("videoGameId", 5).
        when().
                get(VideoGamesEndpoint.SINGLE_VIDEO_GAME).
        then().
                body(matchesJsonSchemaInClasspath("VideoGameJsonSchema.json"));
    }
}
