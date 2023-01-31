package com.example.museumApp;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/java/com/example/museumApp/features",
        glue = "com/example/museumApp/step_definitions")
public class NavigationTestRunner {

}
