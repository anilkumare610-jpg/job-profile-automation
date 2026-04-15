package com.anil.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.anil.base.DriverFactory;
import com.anil.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import com.anil.pages.ProfilePage;
import com.anil.utils.ScreenshotUtil;


public class LoginSteps {

    WebDriver driver;
    LoginPage loginPage;
    ProfilePage profilePage;

    

    @Given("user launches the browser")
    public void user_launches_the_browser() {
        driver = DriverFactory.initDriver();
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
    }

    @When("user opens the Naukri login page")
    public void user_opens_the_naukri_login_page() {
        driver.get("https://www.naukri.com/nlogin/login");
    }

    @When("user enters username and password")
    public void user_enters_username_and_password() {
        loginPage.enterUsername("anilkumare610@gmail.com");
        loginPage.enterPassword("Anilkumar6@");
        loginPage.clickLogin();
    }
    @When("user navigates to profile and uploads resume")
    public void user_navigates_and_uploads_resume() throws InterruptedException {
        profilePage.navigateToProfile();

        String path = "F:\\anil_Resume\\Resumes\\New\\Anil Kumar_Resume.pdf"; // change this
        profilePage.uploadResume(path);
    }

    @Then("user should be logged in successfully")
    public void user_should_be_logged_in_successfully() {

        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);

        ScreenshotUtil.captureScreenshot(driver, "profile_upload");

        Assert.assertTrue(currentUrl.contains("naukri"));

        DriverFactory.quitDriver();
    }
}