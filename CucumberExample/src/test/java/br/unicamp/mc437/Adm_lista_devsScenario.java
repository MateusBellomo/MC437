package br.unicamp.mc437;

import static org.assertj.core.api.Assertions.fail;

import org.assertj.core.api.Assertions;

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

public class Adm_lista_devsScenario {
    private WebDriver driver;

    @Before
    public void setUp() throws IOException{
    	//File classpathRoot = new File(System.getProperty("user.dir"));
    	//File chromedriver = new File(classpathRoot, "driver/chromedriver");
    	//System.setProperty("webdriver.chrome.driver", chromedriver.getAbsolutePath());
    	//driver = new ChromeDriver();
    }

    @After
    public void tearDown(){
    	//driver.close();
    }

    @Given("^Existem (\\d+) cadastrados$")
 	public void admListaDevsTemDevs(int num) throws Throwable {
    	fail("");
    }
    
    @When("^Administrador abre pagina de listar desenvolvedores$")
 	public void admListaDevsAbrePagina() throws Throwable {
    	fail("");
    }
    
  	@Then("^Devem ter (\\d+) listados$")
  	public void admListaDevsMostrarListagem(int num) throws Throwable {
  		fail("");
  	}
}
