package br.unicamp.mc437;

import static org.assertj.core.api.Assertions.assertThat;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.annotation.After;
import cucumber.annotation.Before;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;

public class Adm_filtra_devsScenario {
    private WebDriver driver;

    @Before
    public void setUp() throws IOException{
    	File classpathRoot = new File(System.getProperty("user.dir"));
    	File chromedriver = new File(classpathRoot, "driver/chromedriver");
    	System.setProperty("webdriver.chrome.driver", chromedriver.getAbsolutePath());
    	driver = new ChromeDriver();
    }

    @After
    public void tearDown(){
    	driver.close();
    }

    @Given("^the page is open \"([^\"]*)\"$")
    public void the_page_is_open(String page) throws Throwable {
    	driver.get(page);
    }

    @When("^I introduce my username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void I_search_for(String username, String password) throws Throwable {
    	WebElement username_f = driver.findElement(By.id("username"));
    	username_f.sendKeys(username);
    	WebElement password1 = driver.findElement(By.id("password1"));password1.sendKeys(password);
    	WebElement password2 = driver.findElement(By.id("password2"));
    	password2.sendKeys(password);
    	password2.submit();
    }
    
    @Then("^a page should show the message \"([^\"]*)\"$")
    public void a_browser_title_should_contains(String text) throws Throwable {
    	WebDriverWait wait = new WebDriverWait(driver, 15);
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("msg")));
    	WebElement element = driver.findElement(By.id("msg"));
    	assertThat(element.getText()).contains(text);
    }
}
