package com.example.museumApp.integrationTest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/java/com/example/museumApp/features",
        glue = "com/example/museumApp/step_definitions",
        tags = "@AddingTests")
public class AddingTestRunner {
}
