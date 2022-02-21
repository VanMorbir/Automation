package config.apiconfig;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.BeforeClass;

import java.io.FileReader;
import java.io.IOException;

public class ParaBankAPIConfig {
    public static RequestSpecification requestSpec;
    public static ResponseSpecification responseSpec;

    private static JSONObject getUrlObject() {
        JSONParser parser = new JSONParser();
        JSONObject urlObject = null;
        try {
            FileReader reader = new FileReader("src/test/java/config/apiconfig/configAPI.json");
            JSONObject obj = (JSONObject) parser.parse(reader);
            urlObject = (JSONObject) obj.get("url");
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return urlObject;
    }

    @BeforeClass
    public static void setup(){
        JSONObject url = getUrlObject();
        String baseUri = (String) url.get("baseUri");
        String basePath = (String) url.get("basePath");
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(baseUri)
                .setBasePath(basePath)
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();

        RestAssured.requestSpecification = requestSpec;
        RestAssured.responseSpecification = responseSpec;
    }
}
