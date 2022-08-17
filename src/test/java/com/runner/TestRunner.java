package com.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features ="src/test/resources/features",
        glue = "com/step_definitions",
        publish = true,
        plugin = {"html:target/cucumber.html",
                "rerun:target/rerun.txt"},
        dryRun = false,
        tags = "@US_1"
)
public class TestRunner {
}
