package com.testslotegrator.api.libs;


import com.testslotegrator.api.entities.ClientCredentials;
import com.testslotegrator.api.entities.ClientToken;
import com.testslotegrator.web.properties.PropertiesProvider;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;

import static com.testslotegrator.api.helper.Constants.UrlsApi.path_api_client_token;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class Oauth2 {


    public static ClientToken getClientToken(ClientCredentials values) {
        return given()
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter())
                .header("Authorization","Bearer " + PropertiesProvider.getProperty("api.key"))
                .header("Content-Type","application/json")
                .body(values)
                .when()
                .post(path_api_client_token)
                .then()
                .statusCode(200)
                .extract()
                .as(ClientToken.class);
    }

    public static Response getClientTokens(ClientCredentials values) {
        return given()
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter())
                .header("Authorization","Bearer " + PropertiesProvider.getProperty("api.key"))
                .header("Content-Type","application/json")
                .body(values)
                .when()
                .get(path_api_client_token);

    }


}
