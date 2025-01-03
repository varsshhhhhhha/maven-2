package com.example.automation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class LoginAutomationTest {

    @Mock
    private WebDriver mockDriver;

    @Mock
    private WebElement mockUsernameField;

    @Mock
    private WebElement mockPasswordField;

    @Mock
    private WebElement mockLoginButton;

    @InjectMocks
    private LoginAutomation loginAutomation;

    @BeforeEach
    public void setUp() {
        // Initialize the mocks
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testLogin_Success() {
        // Mock the WebDriver behaviors
        when(mockDriver.getTitle()).thenReturn("Dashboard");
        when(mockDriver.findElement(By.id("username"))).thenReturn(mockUsernameField);
        when(mockDriver.findElement(By.id("password"))).thenReturn(mockPasswordField);
        when(mockDriver.findElement(By.id("loginButton"))).thenReturn(mockLoginButton);

        // Mock the actions performed on elements
        doNothing().when(mockUsernameField).sendKeys("testUser");
        doNothing().when(mockPasswordField).sendKeys("testPassword");
        doNothing().when(mockLoginButton).click();

        // Call the method under test
        boolean loginSuccessful = loginAutomation.testLogin("testUser", "testPassword");

        // Verify the result
        assertTrue(loginSuccessful);
    }

    @Test
    public void testLogin_Failure() {
        // Mock the WebDriver behaviors
        when(mockDriver.getTitle()).thenReturn("Login");
        when(mockDriver.findElement(By.id("username"))).thenReturn(mockUsernameField);
        when(mockDriver.findElement(By.id("password"))).thenReturn(mockPasswordField);
        when(mockDriver.findElement(By.id("loginButton"))).thenReturn(mockLoginButton);

        // Mock the actions performed on elements
        doNothing().when(mockUsernameField).sendKeys("testUser");
        doNothing().when(mockPasswordField).sendKeys("testPassword");
        doNothing().when(mockLoginButton).click();

        // Call the method under test
        boolean loginSuccessful = loginAutomation.testLogin("testUser", "testPassword");

        // Verify the result
        assertFalse(loginSuccessful);
    }
}
