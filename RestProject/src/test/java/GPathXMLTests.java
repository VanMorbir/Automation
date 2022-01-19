import config.VideoGamesDBconfigXML;
import config.VideoGamesEndpoint;
import io.restassured.path.xml.XmlPath;
import io.restassured.path.xml.element.Node;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.*;

public class GPathXMLTests extends VideoGamesDBconfigXML {

    @Test
    public void getFirstGame(){
        Response response = get(VideoGamesEndpoint.ALL_VIDEO_GAMES);
        String name = response.path("videoGames.videoGame.name[0]");
        Assert.assertEquals("Gran Turismo 3", name);
    }

    @Test
    public void getAttribute(){
        Response response = get(VideoGamesEndpoint.ALL_VIDEO_GAMES);
        String category = response.path("videGames.videoGame[1].@category");
        Assert.assertEquals("Driving", category);
    }

    @Test
    public void getListXmlNodes(){
        String response = get(VideoGamesEndpoint.ALL_VIDEO_GAMES).asString();
        List<Node> allResults = XmlPath.from(response).get(
                "videoGames.videoGame.findAll { element -> return element }");
        Assert.assertEquals("Tetris", allResults.get(2).get("name").toString());
    }
}
