package com.example.museumApp.integrationTest.step_definitions.navigation;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NavigatingStepDefinitions {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Given("I have a browser open")
    public void i_have_a_browser_open() {
        driver = new ChromeDriver();
    }
    @When("I navigate to {string}")
    public void i_navigate_to(String url) {
        driver.get(url);
    }
    @Then("I am on the {string} page")
    public void i_am_on_the_page(String title) {
        String pageTitle = driver.getTitle();
        assertTrue(pageTitle.contains(title));
    }


    @And("click the {string} button")
    public void clickThePageLinkButton(String link) {
        WebElement button = driver.findElement(By.id(link));
        button.click();
    }
}
