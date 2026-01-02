package com.example.AlisverisSitesi.systemtests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class HealthCheckIT {

    @BeforeEach
    void setup() {
        // RestAssured'a varsayılan 8080 yerine 8084'ü kullanmasını söylüyoruz
        RestAssured.port = 8084;
        RestAssured.baseURI = "http://localhost";
    }

    @Test
    void backend_should_be_running() {
        RestAssured
            .given()
            .when()
            .get("/actuator/health")
            .then()
            .statusCode(200) // Artık 8084/actuator/health'e gideceği için 200 dönecek
            .body("status", equalTo("UP"));
    }
}