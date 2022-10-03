package com.testslotegrator.web.regres;

import com.testslotegrator.properties.Users;
import com.testslotegrator.web.BaseTest;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class UITests extends BaseTest {

    private static String url = "http://test-app.d6.dev.devcaz.com";
    private static String login = Users.admin.login;;
    private static String password = Users.admin.password;;

    @Test
    @Tag("core")
    @Epic("Core")
    @Feature("Core")
    @DisplayName("Авторизоваться в админке")
    public void test_1() {

        driver.get(url+"/admin/login");

        driver.findElement(By.id("UserLogin_username")).sendKeys(login);
        driver.findElement(By.id("UserLogin_password")).sendKeys(password);
        driver.findElement(By.cssSelector("input.btn")).click();
        assertTrue(driver.getTitle().contains("Dashboard - Casino"));
        //проверка успешного открытия
    }

    @Test
    @Tag("core")
    @Epic("Core")
    @Feature("Core")
    @DisplayName("Открыть список игроков")
    public void test_2() {

        driver.get(url+"/admin/login");
        driver.findElement(By.id("UserLogin_username")).sendKeys(login);
        driver.findElement(By.id("UserLogin_password")).sendKeys(password);
        driver.findElement(By.cssSelector("input.btn")).click();
        assertTrue(driver.getTitle().contains("Dashboard - Casino"));

        driver.get(url+"/user/player/admin");
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#payment-system-transaction-grid > table")));
        assertFalse(driver.findElements(By.cssSelector("#payment-system-transaction-grid > table tbody tr")).isEmpty());

    }

    @Test
    @Tag("core")
    @Epic("Core")
    @Feature("Core")
    @DisplayName("Отсортировать по любому столбцу и проверить сортировку")
    public void test_3() {

        driver.get(url+"/admin/login");
        driver.findElement(By.id("UserLogin_username")).sendKeys(login);
        driver.findElement(By.id("UserLogin_password")).sendKeys(password);
        driver.findElement(By.cssSelector("input.btn")).click();
        assertTrue(driver.getTitle().contains("Dashboard - Casino"));

        driver.get(url+"/user/player/admin");
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#payment-system-transaction-grid > table")));
        assertTrue(1 < driver.findElements(By.cssSelector("div.page table tbody tr")).size());

        //задать статсут Not active
        new Select(driver.findElement(By.name("PlayerSearch[status]"))).selectByVisibleText("Not active");


        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("#payment-system-transaction-grid:not(.grid-view-loading)")));

        assertEquals(1, driver.findElements(By.cssSelector("div.page table tbody tr")).size());
        List<WebElement> elements = driver.findElements(By.cssSelector("div.page table tbody tr"));
        for (WebElement element:elements) {
            assertEquals(
                    element.findElement(By.cssSelector("td:nth-child(15) span")).getText(),
                    "Not active"
            );
        }
        //проверить что в таблице 1 запись которая содержит выбранный статус

    }


}
