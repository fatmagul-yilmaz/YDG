package com.example.AlisverisSitesi.selenium;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("selenium")
public class LoginTest extends BaseTest {

    @Test
    void homePageShouldOpen() {
        driver.get("http://localhost:8084");
    }
}
