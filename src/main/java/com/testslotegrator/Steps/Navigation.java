package com.testslotegrator.Steps;

import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Navigation {

    static WebDriver driver;

    public Navigation() {
        this.driver = Hooks.driver;
    }

    @Then("Application open Dashboard page")
    public void applicationDisplaysTheMessageOutputCode() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(com.testslotegrator.view.uikit.Navigation.rootElement));
    }
}
