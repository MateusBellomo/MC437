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
import cucumber.annotation.en_scouse.An;

public class Dev_cadastra_devScenario {
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
    
    @Given("^Estou na pagina de cadastrar dev$")
    public void abrirPaginaCadastroDev() throws Throwable {
    	//driver.get(page);
    }
    
    // And
    @Given("^nao estou logado$")
    public void checarNaoLogado() throws Throwable {
    }

    @Given("^Nenhum usuario esta cadastrado$")
    public void nenhumCadastrado() throws Throwable {
    }
    
    @When("^Eu preencho o campo usuario como \"([^\"]*)\"$")
    public void preenchoCampoUsuarioCadastro(String username) throws Throwable {
    }
    
    @When("^Preencho o restante dos campos com dados validos$")
    public void preenchoCamposCadastro() throws Throwable {
    }
    
    @Then("^Devo ir para a pagina confirmando cadastro de \"([^\"]*)\"$")
    public void irPaginaConfirmacaoCadastro() throws Throwable {
    }
    
    @When("^Preencho os campos de registro com dados invalidos$")
    public void preencherCamposInvalidos() throws Throwable {
    }
    
    @Then("^Recebo feedback de como preencher os campos corretamente$")
    public void feedbackCamposRegistro() throws Throwable {
    }
    
    @Given("^existem usuarios cadastrados$")
    public void populateUsuarios() throws Throwable {
    }
    
    @When("^tento cadastrar com dados conflitantes com usuarios cadastrados$")
    public void cadastroConflitante() throws Throwable {
    }
    
    @Then("^Sou informado dos dados conflitantes$")
    public void informaConflito() throws Throwable {
    }
}
