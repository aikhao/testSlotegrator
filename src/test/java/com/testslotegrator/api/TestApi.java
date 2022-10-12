package com.testslotegrator.api;


import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;



public class TestApi {

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
