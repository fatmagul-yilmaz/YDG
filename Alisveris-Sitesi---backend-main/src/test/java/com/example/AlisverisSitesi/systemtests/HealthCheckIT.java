package com.example.AlisverisSitesi.systemtests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class HealthCheckIT {

    @Test
    void backend_should_be_running() {
        RestAssured
            .given()
            .when()
            .get("/actuator/health")
            .then()
            .statusCode(200)
            .body("status", equalTo("UP"));
    }
}
