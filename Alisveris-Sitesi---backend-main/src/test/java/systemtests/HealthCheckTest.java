package systemtests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class HealthCheckTest {

    @Test
    void backend_should_be_running() {
        RestAssured
            .given()
            .when()
            .get("http://localhost:8084/actuator/health")
            .then()
            .statusCode(200)
            .body("status", equalTo("UP"));
    }
}
