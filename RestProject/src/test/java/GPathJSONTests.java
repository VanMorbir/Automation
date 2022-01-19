import config.FootballAPIConfig;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

import static io.restassured.RestAssured.*;

public class GPathJSONTests extends FootballAPIConfig {

    @Test
    public void extractMapWithFind(){
        Response response = get("competitions/2021/teams");
        Map<String,?> allDataForSingleTeam = response.path(
                "teams.find { it.name == 'Manchester United FC'}");
        System.out.println("Map of Team Data: " + allDataForSingleTeam);
    }

    @Test
    public void extractSingleValueWithFind(){
        Response response = get("teams/57");
        String singlePlayer = response.path(
                "squad.find { it.shirtNumber == 48}.name"
        );
        Assert.assertEquals("Albert Sambi Lokonga", singlePlayer);
    }
}
