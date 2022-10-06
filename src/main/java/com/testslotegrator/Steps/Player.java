package com.testslotegrator.Steps;

import com.testslotegrator.helper.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static com.testslotegrator.properties.Properties.urlFront;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
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
        driver.get(urlFront + Constants.Urls.player);

    }

    @Then("A specify sorting status as \"([^\"]*)\"$")
    public void aSpecifySortingStatusAsNotActive(String value) {
        new Select(driver.findElement(By.name("PlayerSearch[status]"))).selectByVisibleText(value);

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("#payment-system-transaction-grid:not(.grid-view-loading)")));
    }

    @Then("Content table have \"([^\"]*)\" count")
    public void contentTableHaveCount(int arg0) {
//        assertThat(driver.findElements(By.cssSelector("div.page table tbody tr")).size(), greaterThan(arg0));
    }

    @Then("All line in table have status \"([^\"]*)\"$")
    public void allLineInTableHaveStatus(String arg0) {
        List<WebElement> elements = driver.findElements(By.cssSelector("div.page table tbody tr"));
        for (WebElement element:elements) {
            assertThat(
                    element.findElement(By.cssSelector("td:nth-child(15) span")).getText(),
                    containsString(arg0)
            );
        }
    }
}
