package config.uiconfig;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class ParaBankUIConfig {
    static private JSONObject configObj;

    static {
        try {
            configObj = (JSONObject) new JSONParser().parse(new FileReader("src/test/java/config/uiconfig/configUI.json"));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public static String baseURL = (String) ((JSONObject) configObj.get("urls")).get("baseURL");
    public static String appiumServer = (String) ((JSONObject) configObj.get("urls")).get("appiumServer");
    public static String deviceName = (String) ((JSONObject) configObj.get("urls")).get("deviceName");


    public static class Credentials {
        public static class ValidLogin {
            public static String userName = "john";
            public static String password = "demo";
        }
        public static class InvalidLogin {
            public static String wrongPassword = "123";
        }
        public static class ContactInfo {
            public static String Name = (String) ((JSONObject) configObj.get("contactInfo")).get("Name");
            public static String Email = (String) ((JSONObject) configObj.get("contactInfo")).get("Email");
            public static String PhoneNumber = (String) ((JSONObject) configObj.get("contactInfo")).get("PhoneNumber");
            public static String Message = (String) ((JSONObject) configObj.get("contactInfo")).get("Message");
        }
    }
    public static class Alerts{
        public static class Contact{
            public static String MissingPhoneNumber = (String) ((JSONObject) configObj.get("alerts")).get("missingPhoneNumber");
        }
    }
}
