package com.example.museumApp.integrationTest.test_runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/java/com/example/museumApp/integrationTest/features/painting",
        glue = "com/example/museumApp/integrationTest/step_definitions/painting")
public class PaintingTestRunner {
}
