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

import static com.testslotegrator.helper.Constants.CssSelector.elementWithLoadTable;
import static com.testslotegrator.helper.Constants.CssSelector.elementWithoutLoadTable;
import static com.testslotegrator.properties.Properties.urlFront;
import static com.testslotegrator.view.pages.PlayerPage.tablePaymentTransaction;
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
                .until(ExpectedConditions.presenceOfElementLocated(tablePaymentTransaction));
//        assertThat(driver.findElements(By.cssSelector("#payment-system-transaction-grid tbody tr")).size(), greaterThan(0));
    }

    @Given("Navigate to Page Players")
    public void navigateToPagePlayers() {
        driver.get(urlFront + Constants.Urls.player);

    }

    @Then("A specify sorting status as \"([^\"]*)\"$")
    public void aSpecifySortingStatusAsNotActive(String value) {
        new Select(driver.findElement(By.name("PlayerSearch[status]"))).selectByVisibleText(value);

        //TODO нужен дебаг загрузки таблицы
//        new WebDriverWait(driver, Duration.ofSeconds(5))
//                .until(ExpectedConditions.elementToBeClickable(By.cssSelector(elementWithLoadTable)));
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector(elementWithoutLoadTable)));
    }

    @Then("All line in table have status \"([^\"]*)\"$")
    public void allLineInTableHaveStatus(String arg0) {
        List<WebElement> elements = driver.findElement(tablePaymentTransaction).findElements(By.cssSelector("tbody tr"));
        for (WebElement element:elements) {
            assertThat(
                    element.findElement(By.cssSelector("td:nth-child(15) span")).getText(),
                    containsString(arg0)
            );
        }
    }
}
