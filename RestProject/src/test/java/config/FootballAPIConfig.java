package config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.BeforeClass;

public class FootballAPIConfig {
    public static RequestSpecification football_requestSpec;
    public static ResponseSpecification responseSpec;

    @BeforeClass
    public void setup(){
        football_requestSpec = new RequestSpecBuilder()
                .setBaseUri("http://api.football-data.org")
                .setBasePath("/v2/")
                .addHeader("X-Auth-Token", "3d7a7a6046b1495e9db894ef08493d72")
                .addHeader("X-Response-Control", "minified")
                .build();
        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();

        RestAssured.requestSpecification = football_requestSpec;
        RestAssured.responseSpecification = responseSpec;
    }
}
