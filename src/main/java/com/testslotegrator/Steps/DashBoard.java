package com.testslotegrator.Steps;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;

public class DashBoard {

    static WebDriver driver;

    public DashBoard() {
        this.driver = Hooks.driver;
    }

    @Then("Application open Dashboard page")
    public void applicationDisplaysTheMessageOutputCode() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("nav-container")));
//        assertThat(driver.getTitle(), containsString("Dashboard - Casino"));
    }
}
