package br.unicamp.mc437;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import java.io.File;
import java.io.IOException;
import java.util.List;

import junit.framework.Assert;

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
    private String name1, name2;
    

    @Before
    public void setUp() throws IOException{
    	System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
    	driver = new ChromeDriver();
    }

    @After
    public void tearDown(){
    	driver.close();
    }
    
    @Given("^desenvolvedores \"([^\"]*)\" e \"([^\"]*)\"$")
    public void admFiltraDevTemDevs(String name1, String name2) throws Throwable {
    	this.name1 = name1;
    	this.name2 = name2;
    	driver.get("http://localhost:8080/SADE/service/dev/cleanDB");
    	
    	driver.get("http://localhost:8080/SADE/Dev.html");
    	WebElement aux = driver.findElement(By.id("inputNome"));
    	aux.sendKeys(name1);  
    	aux =  driver.findElement(By.id("inputRG"));
    	aux.sendKeys("999999999");    	
    	aux = driver.findElement(By.id("inputTelRes"));
    	aux.sendKeys("(99)99896999");  
    	aux = driver.findElement(By.id("inputEmail"));
    	aux.sendKeys("name1@email.com");  
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
    	
    	aux = driver.findElement(By.id("submit"));
    	String classe = aux.getAttribute("class");    	
    	if (classe.contains("disabled"))
    		fail("");
    	aux.click();
    	
    	driver.get("http://localhost:8080/SADE/Dev.html");
    	aux = driver.findElement(By.id("inputNome"));
    	aux.sendKeys(name2);  
    	aux =  driver.findElement(By.id("inputRG"));
    	aux.sendKeys("999999998");    	
    	aux = driver.findElement(By.id("inputTelRes"));
    	aux.sendKeys("(99)99896999");  
    	aux = driver.findElement(By.id("inputEmail"));
    	aux.sendKeys("name2@email.com");  
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
    	
    	aux = driver.findElement(By.id("submit"));
    	classe = aux.getAttribute("class");    	
    	if (classe.contains("disabled"))
    		fail("");
    	aux.click();
    	
    }
    
    @Given("^a pagina de listagem de desenvolvedores esta aberta$")
    public void admFiltraDevPaginaAberta() throws Throwable {
    	driver.get("http://localhost:8080/SADE/Admin.html");
    }
    
    @When("^eu edito as informações do filtro com detalhes pertencentes a Airi Satou e nao a Ashton Cox$")
    public void admFiltraDevEditoInfoFiltro() throws Throwable {
    	WebElement search = driver.findElement(By.cssSelector("div#example_filter>label>input"));
    	search.sendKeys(name1); 
    }
    
    @Then("^a lista de usuarios e atualizada, contendo Airi Satou e nao contendo Ashton Cox$")
    public void admFiltraDevListaAtt() throws Throwable {
    	List<WebElement> rows =  driver.findElements(By.cssSelector("table#example>tbody>tr"));
    	for (WebElement webElement : rows) {
    		List <WebElement> td = webElement.findElements(By.cssSelector("td"));
    		String name = td.get(0).getText();
    		if (name2.equals(name))
    			fail("");
    		Assert.assertEquals(name1, name);
		}
    }
}
