package com.testslotegrator.Steps;

import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static com.testslotegrator.properties.Properties.timeoutWaitStep;
import static com.testslotegrator.view.uikit.Navigation.rootElement;

public class Navigation {

    static WebDriver driver;

    public Navigation() {
        this.driver = Hooks.driver;
    }

    @Then("Application open Dashboard page")
    public void applicationDisplaysTheMessageOutputCode() {
        new WebDriverWait(driver, Duration.ofSeconds(timeoutWaitStep))
                .until(ExpectedConditions.presenceOfElementLocated(rootElement));
    }
}
