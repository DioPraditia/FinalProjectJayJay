package com.dio.testRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:reports/cucumber.html", "json:reports/cucumber.json"},//Cucumber Reports
        glue = {"com.dio"},
        features = {"src/test/resources/web"},
        monochrome = true,
        tags = "@web"
)

public class CucumberWebTest {
}
