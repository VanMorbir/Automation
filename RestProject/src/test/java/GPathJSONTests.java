import config.FootballAPIConfig;
import io.restassured.response.Response;
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
}
