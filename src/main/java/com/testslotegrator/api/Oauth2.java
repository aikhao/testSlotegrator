package com.testslotegrator.api;


import com.testslotegrator.properties.PropertiesProvider;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

import static com.testslotegrator.properties.Properties.path_api_shopping_list;
import static io.restassured.RestAssured.given;

public class Oauth2 {












//    public static ShoppingList createShoppingList(List values){
//        return given()
//                .filter(new RequestLoggingFilter())
//                .filter(new ResponseLoggingFilter())
//                .header("Authorization","Bearer " + PropertiesProvider.getProperty("api.key"))
//                .header("Content-Type","application/json")
//                .body(values)
//                .when()
//                .post(path_api_shopping_list)
//                .then()
//                .statusCode(200)
//                .extract()
//                .as(ShoppingList.class);
//    }

//    public static ShoppingList getShoppingList(String id){
//        return given()
//                .filter(new RequestLoggingFilter())
//                .filter(new ResponseLoggingFilter())
//                .header("Authorization","Bearer " + PropertiesProvider.getProperty("api.key"))
//                .header("Content-Type","application/json")
//                .when()
//                .get(path_api_shopping_list + "/" + id)
//                .then()
//                .statusCode(200)
//                .extract()
//                .as(ShoppingList.class);
//    }

    public static void deleteShoppingList(String id) {
        given()
            .filter(new RequestLoggingFilter())
            .filter(new ResponseLoggingFilter())
            .header("Authorization","Bearer " + PropertiesProvider.getProperty("api.key"))
            .header("Content-Type","application/json")
            .when()
            .delete(path_api_shopping_list + "/" + id)
            .then()
            .statusCode(200)
            .extract();
    }
}
