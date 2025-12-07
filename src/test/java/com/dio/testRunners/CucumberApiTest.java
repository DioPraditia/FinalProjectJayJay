package com.dio.testRunners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/api",
                glue = {"com.dio"},
        plugin = {
                "pretty",                                      // console output
                "html:reports/API/cucumber.html",  // HTML report
                "json:reports/API/cucumber.json"   // JSON report
        },
        monochrome = true,
        tags = "@api"
)


public class CucumberApiTest {
    // Tidak perlu isi apa-apa, ini hanya runner
}
