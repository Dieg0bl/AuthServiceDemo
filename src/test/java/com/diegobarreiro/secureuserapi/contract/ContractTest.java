package com.diegobarreiro.secureuserapi.contract;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ContractTest {

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
    }

    @Test
    void testLoginOk() {
        given()
            .contentType(ContentType.JSON)
            .body("{\"usernameOrEmail\":\"demo\",\"password\":\"demo123\"}")
        .when()
            .post("/auth/login")
        .then()
            .statusCode(200)
            .body("token", notNullValue());
    }

    @Test
    void testRefreshOk() {
        given()
            .contentType(ContentType.JSON)
            .body("{\"refreshToken\":\"dummy_refresh_token\"}")
        .when()
            .post("/auth/refresh")
        .then()
            .statusCode(200)
            .body("token", notNullValue());
    }

    @Test
    void testAccessWithoutToken() {
        given()
        .when()
            .get("/me")
        .then()
            .statusCode(401);
    }
}