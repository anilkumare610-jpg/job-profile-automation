package com.anil.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class LoginPage {

    WebDriver driver;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By username = By.xpath("//input[@id='usernameField']");
    By password = By.xpath("//input[@id='passwordField']");
    By loginBtn = By.xpath("//button[@type='submit'][1]");

    // Actions
    public void enterUsername(String user) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(username));

        driver.findElement(username).click();
        driver.findElement(username).sendKeys(user,Keys.TAB);
    }

    public void enterPassword(String pass) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(password));

        driver.findElement(password).click();
        driver.findElement(password).sendKeys(pass);
    }
    public void clickLogin() {
        driver.findElement(loginBtn).click();
    }
}