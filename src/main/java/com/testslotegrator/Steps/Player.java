package com.testslotegrator.Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

public class Player {

    static WebDriver driver;

    public Player() {
        this.driver = Hooks.driver;
    }

    @Then("Application open Players page")
    public void applicationDisplaysTheMessageOutputCode() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#payment-system-transaction-grid > table")));
        assertThat(driver.findElements(By.cssSelector("#payment-system-transaction-grid > table tbody tr")).size(), greaterThan(0));
    }

    @Given("Navigate to Page Players")
    public void navigateToPagePlayers() {

    }
}
