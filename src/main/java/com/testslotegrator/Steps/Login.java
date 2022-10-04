package com.testslotegrator.Steps;

import com.testslotegrator.helper.Constants;
import com.testslotegrator.properties.Users;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.testslotegrator.properties.Properties.urlFront;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.StringContains.containsString;

public class Login {

    static WebDriver driver;

    public Login() {
        this.driver = Hooks.driver;
    }

    @Given("Navigate to Page Login")
    public void navigateToPageForgotPassword() {
        driver.get(urlFront+ Constants.Urls.login);
    }

    @When("A User enters a valid login")
    public void aUserEntersAValidLogin() {
        driver.findElement(By.id("UserLogin_username")).sendKeys(Users.admin.login);
    }

    @And("A User enters a valid password")
    public void aUserEntersAValidPassword() {
        driver.findElement(By.id("UserLogin_password")).sendKeys(Users.admin.password);
    }

    @And("A User clicks on Submit button")
    public void aUserClicksOnSubmitButton() {
        driver.findElement(By.cssSelector("input.btn")).click();
    }

    ///for delete

    @When("A User Clicks on status Code {int}")
    public void aUserClicksOnStatusCodeInput(Integer inputCode) {
        driver.findElement(By.partialLinkText(inputCode.toString())).click();
    }

    @Then("Application displays the message {int}")
    public void applicationDisplaysTheMessageOutputCode(Integer outputCode) {
        String expectedMessage = "This page returned a "+outputCode.toString()+" status code.";
        String actualMessage = driver.findElement(By.cssSelector("h3 + p")).getText();

        assertThat(actualMessage, containsString(expectedMessage));
    }
}
