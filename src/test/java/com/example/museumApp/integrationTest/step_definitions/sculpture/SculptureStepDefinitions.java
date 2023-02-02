package com.example.museumApp.integrationTest.step_definitions.sculpture;

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
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SculptureStepDefinitions {

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

    @When("I enter {string} in the name box")
    public void i_enter_in_the_name_box(String name) {
        WebElement nameBox = driver.findElement(By.id("name"));
        nameBox.clear();
        nameBox.sendKeys(name);
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
        WebElement errorBlock = driver.findElement(By.id("sculpture.errors"));
        String message = errorBlock.getText();
        assertTrue(message.contains(expected));
    }

    @And("I Select {string} from the artist dropdown")
    public void iSelectArtistFromTheDropdown(String artist) {
        WebElement artistBox = driver.findElement(By.id("artist"));
        Select select = new Select(artistBox);
        select.selectByVisibleText(artist);

    }

    @And("I Enter {string} in the sculpture_price box")
    public void iEnterInTheSculpture_priceBox(String price) {
        WebElement sculpture_priceBox = driver.findElement(By.id("sculpture_price"));
        sculpture_priceBox.clear();
        sculpture_priceBox.sendKeys(price);
    }

    @And("I Enter {string} in the sculpture_year box")
    public void iEnterInTheSculpture_yearBox(String year) {
        WebElement sculpture_yearBox = driver.findElement(By.id("sculpture_year"));
        sculpture_yearBox.clear();
        sculpture_yearBox.sendKeys(year);
    }

    @And("I Select {string} from the museum dropdown")
    public void iSelectMuseumFromTheMuseumDropdown(String museum) {
        WebElement museumBox = driver.findElement(By.id("museum"));
        Select select = new Select(museumBox);
        select.selectByVisibleText(museum);
    }


    @Then("the sculpture_year of Thinker displays as 2020")
    public void theSculpture_yearOfThinkerDisplaysAs() {
        WebElement sculpture_year = driver.findElement(By.xpath("/html/body/main/table/tbody/tr[3]/td[2]"));
        int new_year = Integer.parseInt(sculpture_year.getText());

        assertEquals(2020,new_year );
    }
}
