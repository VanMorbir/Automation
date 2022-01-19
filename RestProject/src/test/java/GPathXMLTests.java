import config.VideoGamesDBconfigXML;
import config.VideoGamesEndpoint;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class GPathXMLTests extends VideoGamesDBconfigXML {

    @Test
    public void getFirstGame(){
        Response response = get(VideoGamesEndpoint.ALL_VIDEO_GAMES);
        String name = response.path("videoGames.videoGame.name[0]");
        Assert.assertEquals("Gran Turismo 3", name);
    }
}
