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

import static com.testslotegrator.helper.Constants.CssSelector.elementTableBodyRows;
import static com.testslotegrator.helper.Constants.CssSelector.elementWithoutLoadTable;
import static com.testslotegrator.helper.Constants.XpathSelector.selectedOptionWithText;
import static com.testslotegrator.properties.Properties.timeoutWaitStep;
import static com.testslotegrator.properties.Properties.urlFront;
import static com.testslotegrator.view.pages.PlayerPage.columnPlayerSearchStatus;
import static com.testslotegrator.view.pages.PlayerPage.selectPlayerSearchStatus;
import static com.testslotegrator.view.pages.PlayerPage.tablePaymentTransaction;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class Player {

    static WebDriver driver;

    public Player() {
        this.driver = Hooks.driver;
    }

    @Then("Application open Players page")
    public void applicationDisplaysTheMessageOutputCode() {
        new WebDriverWait(driver, Duration.ofSeconds(timeoutWaitStep))
                .until(ExpectedConditions.presenceOfElementLocated(tablePaymentTransaction));
    }

    @Given("Navigate to Page Players")
    public void navigateToPagePlayers() {
        driver.get(urlFront + Constants.Urls.player);

    }

    @Then("A specify sorting status as \"([^\"]*)\"$")
    public void aSpecifySortingStatusAsNotActive(String value) {
        new Select(driver.findElement(selectPlayerSearchStatus)).selectByVisibleText(value);

        new WebDriverWait(driver, Duration.ofSeconds(timeoutWaitStep))
                .until(ExpectedConditions.presenceOfNestedElementsLocatedBy(
                        selectPlayerSearchStatus,
//                        By.xpath("//option[@selected and text()=\""+value+"\"]")));
//                        By.xpath("//"+selectedOption+"[text()=\""+value+"\"]"))
                        By.xpath(String.format(selectedOptionWithText, value)))
                );

        new WebDriverWait(driver, Duration.ofSeconds(timeoutWaitStep))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector(elementWithoutLoadTable)));
    }

    @Then("All line in table have status \"([^\"]*)\"$")
    public void allLineInTableHaveStatus(String arg0) {
        List<WebElement> elements =
                driver.findElement(tablePaymentTransaction).findElements(By.cssSelector(elementTableBodyRows));
        for (WebElement element:elements) {
            assertThat(
                    element.findElement(columnPlayerSearchStatus).getText(),
                    containsString(arg0)
            );
        }
    }
}
