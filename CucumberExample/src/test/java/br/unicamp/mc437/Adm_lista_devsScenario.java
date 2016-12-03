package br.unicamp.mc437;

import static org.assertj.core.api.Assertions.fail;

import org.assertj.core.api.Assertions;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import junit.framework.Assert;

import org.junit.Test;
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
    int numberOfDevsDB;
    @Before
    public void setUp() throws IOException, InterruptedException{
    	// Optional, if not specified, WebDriver will search your path for chromedriver.
    	System.setProperty("webdriver.chrome.driver", "driver/chromedriver");

    	driver = new ChromeDriver();
    	driver.get("file:///home/ec2013/ra147338/git/MC437/SADE-Backend/WebContent/WEB-INF/Admin.html");
    }

    @After
    public void tearDown(){
    	driver.close();
    }

    @Given("^Existem (\\d+) cadastrados$")
 	public void admListaDevsTemDevs(int num) throws Throwable {
    	numberOfDevsDB = num;
    }
    
    @When("^Administrador abre pagina de listar desenvolvedores$")
 	public void admListaDevsAbrePagina() throws Throwable {
    }
    
  	@Then("^Devem ter (\\d+) listados$")
  	public void admListaDevsMostrarListagem(int num) throws Throwable {
  		List<WebElement> rows =  driver.findElements(By.cssSelector("table#example>tbody>tr"));
  		System.out.println("number of rows: " + rows.size());
  		
  		WebElement searchBox = driver.findElement(By.cssSelector("div#example_info"));
  		String input = searchBox.getText();
  	  
  		String pattern = "(\\d+) (entries)$";
  		Pattern r = Pattern.compile(pattern);
  	  
  		Matcher m = r.matcher(input);
  		if(m.find()){
  			int devsGotInHtml = Integer.parseInt(m.group(1));
  			Assert.assertEquals(numberOfDevsDB, devsGotInHtml);
  		} else{
  			System.out.println("MATCH NOT FOUND");
  		}
  	}
  	
}
