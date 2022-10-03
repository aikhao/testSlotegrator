package com.testslotegrator.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    protected static WebDriver driver;

    @BeforeEach
    void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
//    @BeforeEach
//    void setup() {
//        driver = new ChromeDriver();
//    }

    @AfterAll
    void teardown() {
        driver.quit();
    }

    @BeforeAll
    @Step("PreConfiguration")
    public static void preConfiguration() {

//        SelenideLogger.addListener("AllureSelenide",
//                new AllureSelenide()
//                        .screenshots(true)
//                        .savePageSource(true)
//                        .includeSelenideSteps(true)
//                        .enableLogs(LogType.BROWSER, Level.ALL)
//                        .enableLogs(LogType.CLIENT, Level.ALL)
//                        .enableLogs(LogType.DRIVER, Level.ALL));
    }

    @AfterEach
    @Step("Close browser")
    public void closeAndClear() {
//        if (WebDriverRunner.hasWebDriverStarted()) {
//            if (WebDriverRunner.getSelenideProxy() != null && WebDriverRunner.getSelenideProxy().isStarted()) {
//                WebDriverRunner.getSelenideProxy().shutdown();
//            }
//            WebDriverRunner.getWebDriver().quit();
//        }
    }
}
