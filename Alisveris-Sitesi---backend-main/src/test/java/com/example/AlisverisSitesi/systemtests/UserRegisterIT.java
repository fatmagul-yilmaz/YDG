package com.example.AlisverisSitesi.systemtests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

public class UserRegisterIT {

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
                .post("http://localhost:8084/api/users/add")
            .then()
                .statusCode(201);
    }
}
