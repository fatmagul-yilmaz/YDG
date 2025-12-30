package com.example.AlisverisSitesi.selenium;

import org.junit.jupiter.api.Test;

public class ProductTest extends BaseTest {

    @Test
    void productPageShouldOpen() {
        driver.get("http://localhost:8084/products");
    }
}
