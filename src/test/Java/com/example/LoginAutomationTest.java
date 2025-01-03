package com.example.automation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class LoginAutomationTest {

    @Mock
    private WebDriver driver;

    @InjectMocks
    private LoginAutomation loginAutomation;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);  // Initialize Mockito annotations
    }

    @Test
    public void testLogin() {
        // Mock the elements
        WebElement usernameField = mock(WebElement.class);
        WebElement passwordField = mock(WebElement.class);
        WebElement loginButton = mock(WebElement.class);

        // Mock the driver behavior
        when(driver.findElement(By.id("username"))).thenReturn(usernameField);
        when(driver.findElement(By.id("password"))).thenReturn(passwordField);
        when(driver.findElement(By.id("loginButton"))).thenReturn(loginButton);

        // Call the method to test
        loginAutomation.testLogin();

        // Verify interactions
        verify(usernameField).sendKeys("testUser");
        verify(passwordField).sendKeys("testPassword");
        verify(loginButton).click();
    }
}
