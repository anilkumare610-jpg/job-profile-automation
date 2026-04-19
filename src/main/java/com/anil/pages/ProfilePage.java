package com.anil.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ProfilePage {

    WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators (may change - we’ll fix if needed)
    By profileIcon = By.xpath("//div[contains(@class,'nI-gNb-drawer__icon')]");
    By viewProfile = By.xpath("//a[contains(text(),'View & Update Profile')]");
    By uploadResume = By.xpath("//input[@id='attachCV']");
    // Actions
    public void clickViewProfile() {
        driver.findElement(viewProfile).click();
    }
    public void navigateToProfile() throws InterruptedException {

WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

wait.until(ExpectedConditions.visibilityOfElementLocated(profileIcon)).click();
        Thread.sleep(2000);

wait.until(ExpectedConditions.elementToBeClickable(viewProfile)).click();
    }

public void uploadResume(String filePath) throws InterruptedException {

    Thread.sleep(3000);

    ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");

    driver.findElement().sendKeys(filePath);
    Thread.sleep(7000);
}
}