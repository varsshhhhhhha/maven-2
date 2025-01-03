package com.example.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginAutomation {

    private WebDriver driver;

    // Constructor injection of WebDriver
    public LoginAutomation(WebDriver driver) {
        this.driver = driver;
    }

    public boolean testLogin(String username, String password) {
        // Navigate to the login page
        driver.get("https://example.com/login");

        // Locate the username and password fields
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginButton"));

        // Perform login
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();

        // Validate successful login
        String expectedTitle = "Dashboard";
        String actualTitle = driver.getTitle();
        return expectedTitle.equals(actualTitle);
    }
}
