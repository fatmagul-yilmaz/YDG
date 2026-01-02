package com.example.AlisverisSitesi.systemtests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserRegisterIT {

    @BeforeEach
    void setup() {
        // Port uyuşmazlığını önlemek için merkezi yapılandırma
        RestAssured.port = 8084;
        RestAssured.baseURI = "http://localhost";
    }

    @Test
    void user_can_register_successfully() {
        String body = """
        {
          "email": "test@ydg.com",
          "password": "123456"
        }
        """;

        RestAssured
            .given()
                .contentType("application/json")
                .body(body)
            .when()
                .post("/api/users/add") // baseURI ve port yukarıda tanımlandığı için kısa yazabilirsin
            .then()
                .statusCode(201); // 200 yerine 201 olarak güncelledik
    }
}