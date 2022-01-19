package config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.BeforeClass;

public class VideoGamesDBconfigXML {

    public static RequestSpecification VideoGameRequestSpec;
    public static ResponseSpecification VideoGameResponseSpec;

    @BeforeClass
    public static void setup(){
        VideoGameRequestSpec = new RequestSpecBuilder()
                .setBaseUri("http://167.99.197.177")
                .setBasePath("/app/")
                .setPort(8080)
                .addHeader("Content-Type", "application/xml")
                .addHeader("Accept", "application/xml")
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
        VideoGameResponseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();

        RestAssured.requestSpecification = VideoGameRequestSpec;
        RestAssured.responseSpecification = VideoGameResponseSpec;
    }
}
