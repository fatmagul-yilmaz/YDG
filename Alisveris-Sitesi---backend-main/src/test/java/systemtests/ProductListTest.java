package systemtests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

public class ProductListTest {

    @Test
    void product_list_should_be_accessible() {
        RestAssured
            .given()
            .when()
            .get("http://localhost:8084/api/products")
            .then()
            .statusCode(200);
    }
}
