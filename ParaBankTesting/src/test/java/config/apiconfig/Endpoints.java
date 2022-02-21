package config.apiconfig;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class Endpoints {

    private static JSONObject getEndpointsObject(){
        JSONParser parser = new JSONParser();
        JSONObject endpointsObject = null;
        try{
            FileReader reader = new FileReader("src/test/java/config/apiconfig/configAPI.json");
            JSONObject obj = (JSONObject) parser.parse(reader);
            endpointsObject = (JSONObject) obj.get("endpoints");
        }
        catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return endpointsObject;
    }

    public static String CUSTOMER(String id){
        JSONObject obj = getEndpointsObject();
        return obj.get("customers") + id;
    }
    public static String ACCOUNT(String id){
        JSONObject obj = getEndpointsObject();
        return obj.get("accounts") + id;
    }
}
