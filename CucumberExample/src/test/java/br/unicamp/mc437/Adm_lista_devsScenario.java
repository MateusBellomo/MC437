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

import java.util.Random;

public class Adm_lista_devsScenario {
    private WebDriver driver;
    int numberOfDevsDB;
    @Before
    public void setUp() throws IOException, InterruptedException{
    	// Optional, if not specified, WebDriver will search your path for chromedriver.
    	System.setProperty("webdriver.chrome.driver", "driver/chromedriver");

    	driver = new ChromeDriver();
    }

    @After
    public void tearDown(){
    	driver.close();
    }

    @Given("^Existem (\\d+) cadastrados$")
 	public void admListaDevsTemDevs(int num) throws Throwable {
    	int i, rg, email;
    	WebElement aux;
    	String classe;
    	Random randomGenerator = new Random();
    	
    	driver.get("http://localhost:8080/SADE/service/dev/cleanDB");
    	numberOfDevsDB = num;
    	rg = randomGenerator.nextInt(100000000)+100000000;
    	for (i = 0; i < num; i++){
	    	driver.get("http://localhost:8080/SADE/Dev.html");
	  		aux = driver.findElement(By.id("inputNome"));
			aux.sendKeys("AAAAAAAA");  
	    	aux = driver.findElement(By.id("inputTelRes"));
	    	aux.sendKeys("(99)99896999");  
	    	aux = driver.findElement(By.id("inputCel"));
	    	aux.sendKeys("(99)998969999"); 
	    	aux = driver.findElement(By.id("inputEnd"));
	    	aux.sendKeys("Rua Abc 233"); 
	    	aux = driver.findElement(By.id("inputInst"));
	    	aux.sendKeys("Unicamp"); 
	    	aux = driver.findElement(By.id("inputCurso"));
	    	aux.sendKeys("Ciência da Computação"); 
	    	aux = driver.findElement(By.id("inputHorasGrad"));
	    	aux.sendKeys("9"); 
	    	aux = driver.findElement(By.id("inputHorasDisp"));
	    	aux.sendKeys("1"); 
	    	aux = driver.findElement(By.id("inputHorasEst"));
	    	aux.sendKeys("5");    	
    		rg += 1;
        	aux = driver.findElement(By.id("inputRG"));
        	aux.sendKeys(Integer.toString(rg));
        	aux = driver.findElement(By.id("inputEmail"));
        	aux.sendKeys(Integer.toString(rg) + "@email.com");  
	    	aux = driver.findElement(By.id("submit"));
	    	classe = aux.getAttribute("class");
	    	aux.click();
	    	/*
	    	Thread.sleep(50);
	    	aux = driver.findElement(By.id("btnFecharModalSucesso"));
	    	aux.click();*/
    	}
    }
    
    @When("^Administrador abre pagina de listar desenvolvedores$")
 	public void admListaDevsAbrePagina() throws Throwable {
    	driver.get("http://localhost:8080/SADE/Admin.html");
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
