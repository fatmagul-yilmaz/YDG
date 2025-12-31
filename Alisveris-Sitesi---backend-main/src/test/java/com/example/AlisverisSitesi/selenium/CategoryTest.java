package com.example.AlisverisSitesi.selenium;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("selenium")
public class CategoryTest extends BaseTest {

    @Test
    void categoryPageShouldOpen() {
        driver.get("http://localhost:8084/categories");
    }
}
