package runner;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",  // Relative path instead of absolute
        glue = "stepdefinitions",                 
        plugin = {
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "pretty",
                "json:target/cucumber-report.json",
                "html:target/cucumber-report.html",
                "utils.HooksPlugin"
        }
)
public class CucumberTest {
}