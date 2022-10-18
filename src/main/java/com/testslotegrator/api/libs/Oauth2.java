package com.testslotegrator.api.libs;


import com.testslotegrator.api.entities.ClientCredentials;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;

import static com.testslotegrator.api.helper.Constants.UrlsApi.path_api_client_token;
import static com.testslotegrator.api.properties.Properties.keyApi;
import static io.restassured.RestAssured.given;

public class Oauth2 {

    public static Response getClientTokens(ClientCredentials values) {
        return given()
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter())
                .header("Authorization","Bearer " + keyApi)
                .header("Content-Type","application/json")
                .body(values)
                .post(path_api_client_token);
    }
}
