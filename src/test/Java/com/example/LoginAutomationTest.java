package com.example.automation;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginAutomationTest {

    @Test
    public void testLoginSuccess() {
        // Set up the WebDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\varsh\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the login page
            driver.get("https://example.com/login");

            // Locate the username and password fields
            WebElement usernameField = driver.findElement(By.id("username"));
            WebElement passwordField = driver.findElement(By.id("password"));
            WebElement loginButton = driver.findElement(By.id("loginButton"));

            // Perform login
            usernameField.sendKeys("testUser");
            passwordField.sendKeys("testPassword");
            loginButton.click();

            // Validate successful login
            String expectedTitle = "Dashboard";
            String actualTitle = driver.getTitle();
            assertEquals(expectedTitle, actualTitle, "Login failed: Title does not match");
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
