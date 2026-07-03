package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;
import utils.DriverManager;
import utils.Log;
import utils.Screenshot;

import static org.junit.Assert.assertTrue;

public class LoginTest {
    WebDriver driver;
    HomePage home = new HomePage();
    LoginPage login = new LoginPage();

    String featureName = "login";

    @Before
    public void beforeScenario() {
        driver = DriverManager.getDriver();
    }

    @Test
    public void validarLogin() throws InterruptedException {
        Log.escreverLog(featureName, "Iniciando teste...");

        home.acessarSite("https://www.petz.com.br/");
        home.aceitarCookies();
        Thread.sleep(5000);
        Screenshot.tirarPrint(driver, featureName, "inicio_teste");

        home.loginPageMouseOver();

        home.clicarLogin();
        Screenshot.tirarPrint(driver,featureName, "clicar_para_logar");

        Log.escreverLog(featureName,"Preenchendo login...");
        login.preencherEmail("testeautaut@gmail.com");
        login.preencherSenha("Teste@#2026");

        Screenshot.tirarPrint(driver,featureName, "tela_login_preenchida");
        login.clicarLogin();
        Log.escreverLog(featureName,"Logando...");

        boolean check = login.validarModalSeguranca();
        assertTrue(check);
        Screenshot.tirarPrint(driver,featureName, "tela_modal_seguranca");
        Log.escreverLog(featureName,"Modal de segurança validado!");
        Log.escreverLog(featureName,"TESTE PASSOU!");
    }

    @After
    public void afterScenario() {DriverManager.quitDriver();}

}
