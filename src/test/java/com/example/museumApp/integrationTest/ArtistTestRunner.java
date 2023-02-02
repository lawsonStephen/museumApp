package com.example.museumApp.integrationTest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/java/com/example/museumApp/integrationTest/features/artist",
        glue = "com/example/museumApp/integrationTest/step_definitions/artist")
public class ArtistTestRunner {
}
