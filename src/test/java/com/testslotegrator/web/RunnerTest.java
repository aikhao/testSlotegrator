package com.testslotegrator.web;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/com/testslotegrator/web/features"},
        glue = {"src/main/java/com/testslotegrator/libs" })
public class RunnerTest {

}
