package br.unicamp.mc437;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

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
    	//File classpathRoot = new File(System.getProperty("user.dir"));
    	//File chromedriver = new File(classpathRoot, "driver/chromedriver");
    	//System.setProperty("webdriver.chrome.driver", chromedriver.getAbsolutePath());
    	//driver = new ChromeDriver();
    }

    @After
    public void tearDown(){
    	//driver.close();
    }
    
    @Given("^desenvolvedores \"([^\"]*)\" e \"([^\"]*)\"$")
    public void admFiltraDevTemDevs(String name1, String name2) throws Throwable {
    	fail("");
    }
    
    @Given("^a página de listagem de desenvolvedores está aberta$")
    public void admFiltraDevPaginaAberta() throws Throwable {
    	fail("");
    }
    
    @Given("^eu editei as informações do filtro com detalhes pertencentes à João e não à Pedro$")
    public void admFiltraDevEditoInfoFiltro() throws Throwable {
    	fail("");
    }
    
    @When("^eu Clico no botão \"([^\"]*)\"$")
    public void admFiltraDevClicoPesquisar(String textName) throws Throwable {
    	fail("");
    }
    
    @Then("^a lista de usuários é atualizada, contendo João e não contendo Pedro$")
    public void admFiltraDevListaAtt() throws Throwable {
    	fail("");
    }
}
