package com.example.AlisverisSitesi.systemtests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HealthCheckIT {
    WebDriver driver;

    @BeforeEach
    void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Jenkins için şart
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
    }

    @Test
    void test_ui_is_accessible() {
        // Docker üzerinde çalışan backend'in sunduğu statik sayfaya gider
        driver.get("http://localhost:8084/"); 
        String bodyText = driver.findElement(By.tagName("body")).getText();
        
        // Controller'daki HomeController "/" dönüşüyle karşılaştırıyoruz
        assertTrue(bodyText.contains("Backend ayakta"));
        System.out.println("Selenium Sistem Testi Başarılı!");
    }

    @AfterEach
    void tearDown() {
        if (driver != null) driver.quit();
    }
}