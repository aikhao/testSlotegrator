package com.testslotegrator.api;


import com.testslotegrator.api.entities.ClientCredentials;
import com.testslotegrator.api.entities.PlayerProfile;
import com.testslotegrator.api.libs.Oauth2;
import com.testslotegrator.api.libs.Players;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.testslotegrator.api.properties.Properties.urlApi;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;


public class TestApi {

    private static ClientCredentials newCredentials = ClientCredentials.builder()
            .grant_type("client_credentials")
            .scope("scope1:read scope1:write scope2:read")
            .build();

    private static PlayerProfile newPlayer = PlayerProfile.builder()
            .username("janedoe")
            .email("johndoe@gmail.com")
            .password_change("amFuZWRvZTEyMw==")
            .password_repeat("amFuZWRvZTEyMw==")
            .build();

    private static PlayerProfile newPlayer2 = PlayerProfile.builder()
            .username("janedoe2")
            .email("johndoe2@gmail.com")
            .password_change("amFuZWRvZTEyMw==2")
            .password_repeat("amFuZWRvZTEyMw==2")
            .build();

    private static ClientCredentials newCredentials2 = ClientCredentials.builder()
            .grant_type("password")
            .username(newPlayer2.getUsername())
            .password(newPlayer2.getPassword_change())
            .build();

    @BeforeAll
    public void preconditions(){
        RestAssured.baseURI = urlApi;
    }

    @Test
    @DisplayName("get client credentials")
    public void test_1() {
        Oauth2.getClientTokens(newCredentials).then()
                .statusCode(200)
                .assertThat()
                .body("token_type", is("Bearer"))
                .body("expires_in", is(3600))
                .body("expires_in", anything())
                .body("refresh_token", anything());
    }

    @Test
    @DisplayName("create new player")
    public void test_2() {
        Players.createNewPlayer(newPlayer).then()
                .statusCode(201)
                .assertThat()
                .body("username", is(newPlayer.getUsername()))
                .body("email", is(newPlayer.getEmail()));

    }

    @Test
    @DisplayName("login with new credentials")
    public void test_3() {
        Players.createNewPlayer(newPlayer2).then().statusCode(201);

        Oauth2.getClientTokens(newCredentials2).then()
                .statusCode(200)
                .assertThat()
                .body("token_type", is("Bearer"))
                .body("expires_in", is(3600))
                .body("expires_in", anything())
                .body("refresh_token", anything());

    }

    @Test
    @DisplayName("get data from new player")
    public void test_4() {
        PlayerProfile player =
                Players.createNewPlayer(newPlayer2).then()
                        .statusCode(201)
                        .extract()
                        .as(PlayerProfile.class);

        Players.getPlayersProfileWithId(player.getId()).then()
                .statusCode(200)
                .assertThat()
                .body("username", is(newPlayer2.getUsername()))
                .body("email", is(newPlayer2.getEmail()));
    }

    @Test
    @DisplayName("get data from another player")
    public void test_5() {
        Players.getPlayersProfileWithId("121").then()
                .statusCode(404);
    }

}
