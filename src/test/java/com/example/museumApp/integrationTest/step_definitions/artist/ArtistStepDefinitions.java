package com.example.museumApp.integrationTest.step_definitions.artist;

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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArtistStepDefinitions {

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

    @When("I enter {string} in the name box")
    public void i_enter_in_the_name_box(String name) {
        WebElement nameBox = driver.findElement(By.id("name"));
        nameBox.clear();
        nameBox.sendKeys(name);
    }
    @When("I Enter {string} in the birthplace box")
    public void i_enter_in_the_birthplace_box(String birthplace) {
        WebElement birthplaceBox = driver.findElement(By.id("birthplace"));
        birthplaceBox.clear();
        birthplaceBox.sendKeys(birthplace);
    }
    @When("I Enter {string} in the birth_year box")
    public void i_enter_in_the_birth_year_box(String birth_year) {
        WebElement birth_yearBox = driver.findElement(By.id("birth_year"));
        birth_yearBox.clear();
        birth_yearBox.sendKeys(birth_year);
    }
    @When("I click the submit button")
    public void i_click_the_submit_button() {
        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();
    }
    @Then("I see that {string} was successfully added")
    public void i_see_that_was_successfully_added(String name) {
        WebElement messageDisplayed = driver.findElement(By.id("success"));
        String message = messageDisplayed.getText();
        assertTrue(message.contains(name));
    }

    @Then("I see the {string} error message")
    public void i_see_the_error_message(String expected) {
        WebElement errorBlock = driver.findElement(By.id("artist.errors"));
        String message = errorBlock.getText();
        assertTrue(message.contains(expected));
    }


    @Then("I see both error messages")
    public void iSeeBothErrorMessages() {
        WebElement errorBlock = driver.findElement(By.id("artist.errors"));
        String message = errorBlock.getText();
        assertTrue(message.contains("Artist name is blank"));
        assertTrue(message.contains("Artist birthplace is blank"));
    }

    @And("the birth_year of Da Vinci displays as 1968")
    public void theBirth_yearOfDaVinciDisplaysAs() {
        WebElement birth_year = driver.findElement(By.xpath("/html/body/table/tbody/tr[6]/td[3]"));
        int new_year = Integer.parseInt(birth_year.getText());

        assertEquals(1968,new_year );
    }

}
