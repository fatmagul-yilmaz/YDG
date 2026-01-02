package com.example.AlisverisSitesi.systemtests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class HealthCheckIT {

    @BeforeEach
    void setup() {
        // RestAssured yapılandırması
        RestAssured.port = 8084;
        RestAssured.baseURI = "http://localhost";
    }

    @Test
    void backend_should_be_running() throws InterruptedException {
        // Test başlamadan önce Docker'daki uygulamanın tamamen ayağa kalkması için 15 saniye bekler
        System.out.println("Uygulamanın hazır olması bekleniyor (15 saniye)...");
        Thread.sleep(15000);

        RestAssured
            .given()
            .when()
                .get("/actuator/health")
            .then()
                .statusCode(200)
                .body("status", equalTo("UP"));
        
        System.out.println("Sağlık kontrolü başarılı!");
    }
}