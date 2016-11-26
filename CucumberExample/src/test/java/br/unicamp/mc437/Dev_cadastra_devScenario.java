package br.unicamp.mc437;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import java.io.File;
import java.io.IOException;

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
import cucumber.annotation.en_scouse.An;

public class Dev_cadastra_devScenario {
    private WebDriver driver;
    private WebElement usr_name;
    
    @Before
    public void setUp() throws IOException{
    	//File classpathRoot = new File(System.getProperty("user.dir"));
    	//File chromedriver = new File(classpathRoot, "driver/chromedriver");
    	System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
    	driver = new ChromeDriver();
    }

    @After
    public void tearDown(){
    	driver.close();
    }
    
    @Given("^Estou na pagina de cadastrar dev$")
    public void abrirPaginaCadastroDev() throws Throwable {
    	driver.get("file:///home/cc2013/ra148131/workspace/MC437/SADE-Backend/WebContent/WEB-INF/Dev.html");
    }
    
    // And
    @Given("^nao estou logado$")
    public void checarNaoLogado() throws Throwable {
    	
    }

    @Given("^Nenhum usuario esta cadastrado$")
    public void nenhumCadastrado() throws Throwable {
    	usr_name = driver.findElement(By.id("inputNome"));
    }
    
    @When("^Eu preencho o campo usuario como \"([^\"]*)\"$")
    public void preenchoCampoUsuarioCadastro(String username) throws Throwable {
    	usr_name.sendKeys(username);

    }
    
    @When("^Preencho o restante dos campos com dados validos$")
    public void preenchoCamposCadastro() throws Throwable {
    	WebElement aux = driver.findElement(By.id("inputRG"));
    	aux.sendKeys("99.999.999-9");    	
    	aux = driver.findElement(By.id("inputTelRes"));
    	aux.sendKeys("(99)99896-9999");  
    	aux = driver.findElement(By.id("inputCel"));
    	aux.sendKeys("(99)99999-9669"); 
    	aux = driver.findElement(By.id("inputEnd"));
    	aux.sendKeys("Rua Abc 233"); 
    	aux = driver.findElement(By.id("inputInst"));
    	aux.sendKeys("Unicamp"); 
    	aux = driver.findElement(By.id("inputCurso"));
    	aux.sendKeys("Ciência da Computação"); 
    	aux = driver.findElement(By.id("inputHorasGrad"));
    	aux.sendKeys("90"); 
    	aux = driver.findElement(By.id("inputHorasDisp"));
    	aux.sendKeys("100"); 
    	aux = driver.findElement(By.id("inputHorasEst"));
    	aux.sendKeys("50"); 
    	//Thread.sleep(5000);
    	aux.submit();
    }
    
    @Then("^Devo ir para a pagina confirmando cadastro de \"([^\"]*)\"$")
    public void irPaginaConfirmacaoCadastro(String username) throws Throwable {
    	fail("");
    }
    
    @When("^Preencho os campos de registro com dados invalidos$")
    public void preencherCamposInvalidos() throws Throwable {
    	WebElement aux = driver.findElement(By.id("inputRG"));
    	aux.sendKeys("159");    	
    	aux = driver.findElement(By.id("inputTelRes"));
    	aux.sendKeys("telephone");  
    	aux = driver.findElement(By.id("inputCel"));
    	aux.sendKeys("cel"); 
    	aux = driver.findElement(By.id("inputEnd"));
    	aux.sendKeys("/]["); 
    	aux = driver.findElement(By.id("inputInst"));
    	aux.sendKeys("1987"); 
    	aux = driver.findElement(By.id("inputCurso"));
    	aux.sendKeys("Presidente"); 
    	aux = driver.findElement(By.id("inputHorasGrad"));
    	aux.sendKeys("-1"); 
    	aux = driver.findElement(By.id("inputHorasDisp"));
    	aux.sendKeys("99999999999"); 
    	aux = driver.findElement(By.id("inputHorasEst"));
    	aux.sendKeys("Nada"); 
    	//Thread.sleep(5000);
    	aux.submit();
    }
    
    @Then("^Recebo feedback de como preencher os campos corretamente$")
    public void feedbackCamposRegistro() throws Throwable {
    	fail("");
    }
    
    @Given("^existem usuarios cadastrados$")
    public void populateUsuarios() throws Throwable {
    	fail("");
    }
    
    @When("^tento cadastrar com dados conflitantes com usuarios cadastrados$")
    public void cadastroConflitante() throws Throwable {
    	fail("");
    }
    
    @Then("^Sou informado dos dados conflitantes$")
    public void informaConflito() throws Throwable {
    	fail("");
    }
}
