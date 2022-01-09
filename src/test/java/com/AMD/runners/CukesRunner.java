package com.AMD.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty"
        },
        features = "src/test/resources/features",
        glue = "com/AMD/stepDefinitions",
        dryRun = false

)
public class CukesRunner {
}
