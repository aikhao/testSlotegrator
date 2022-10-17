package com.testslotegrator.api;


import com.testslotegrator.api.entities.ClientCredentials;
import com.testslotegrator.api.helper.CheckHelper;
import com.testslotegrator.api.libs.Oauth2;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.anything;


public class TestApi {

    private static ClientCredentials newCredentials = ClientCredentials.builder().grant_type("client_credentials").scope("scope1:read scope1:write scope2:read").build();


    @BeforeEach
    @Step("Preconditions")
    public void preconditions(){

    }

    @Test
    @Tag("api")
    @Epic("api")
    @Feature("Api")
    @DisplayName("get client credentials")
    public void test_1() {
        Oauth2.getClientTokens(newCredentials).then()
                .statusCode(200)
                .assertThat()
                .body(CheckHelper.setJsonSchema("post/PostProduct.json"))
                .body(containsString("id"))
                .body("token_type", is("Bearer"))
                .body("expires_in", is(3600))
                .body("expires_in", anything())
                .body("refresh_token", anything());

    }

    @Test
    @Tag("api")
    @Epic("api")
    @Feature("Api")
    @DisplayName("create new player")
    public void test_2() {

    }

    @Test
    @Tag("api")
    @Epic("api")
    @Feature("Api")
    @DisplayName("login with new credentials")
    public void test_3() {

    }

    @Test
    @Tag("api")
    @Epic("api")
    @Feature("Api")
    @DisplayName("get data from new player")
    public void test_4() {


    }

    @Test
    @Tag("api")
    @Epic("api")
    @Feature("Api")
    @DisplayName("get data from another player")
    public void test_5() {

    }



}
