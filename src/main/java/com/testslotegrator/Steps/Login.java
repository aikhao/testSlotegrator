package com.testslotegrator.Steps;

import com.testslotegrator.helper.Constants;
import com.testslotegrator.properties.Users;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static com.testslotegrator.properties.Properties.urlFront;
import static com.testslotegrator.view.pages.LoginPage.buttonSubmit;
import static com.testslotegrator.view.pages.LoginPage.inputLogin;
import static com.testslotegrator.view.pages.LoginPage.inputPassword;

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
        driver.findElement(inputLogin).sendKeys(Users.admin.login);
    }

    @And("A User enters a valid password")
    public void aUserEntersAValidPassword() {
        driver.findElement(inputPassword).sendKeys(Users.admin.password);
    }

    @And("A User clicks on Submit button")
    public void aUserClicksOnSubmitButton() {
        driver.findElement(buttonSubmit).click();
    }
}
