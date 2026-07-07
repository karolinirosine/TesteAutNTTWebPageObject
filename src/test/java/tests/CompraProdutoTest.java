package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.*;
import utils.DriverManager;
import utils.Log;
import utils.Screenshot;

public class CompraProdutoTest {
    HomePage home = new HomePage();
    ProductPage product = new ProductPage();
    CartPage cart = new CartPage();
    SearchPage search = new SearchPage();
    WebDriver driver;

    String featureName = "compra";
    String precoSacola;
    String precoCarrinho;


    @Before
    public void beforeScenario() {
        driver = DriverManager.getDriver();
    }

    @Test
    public void validarValorProduto() throws InterruptedException {
        String produto = "Escada Baw & Miaw Grafite para Cães e Gatos";

        Log.escreverLog(featureName, "Iniciando teste...");

        home.acessarSite("https://www.petz.com.br/");
        home.aceitarCookies();
        Thread.sleep(5000);
        Screenshot.tirarPrint(driver, featureName, "inicio_teste");

        home.buscarProduto(produto);
        search.selecionarProduto(produto);
        Screenshot.tirarPrint(driver, featureName, "produto_selecionado");
        Log.escreverLog(featureName,"Produto selecionado: " + produto);

        product.fecharModalSale();
        precoSacola = product.pegarPreco();
        home.aceitarCookies();
        product.adicionarAoCarrinho();
        Log.escreverLog(featureName,"Adicionando produto no carrinho...");

        Thread.sleep(5000);
        Log.escreverLog(featureName,"Produto adicionado no carrinho!");
        Screenshot.tirarPrint(driver,featureName, "produto_adicionado_no_carrinho_modal");
        product.irParaCarrinho();

        precoCarrinho = cart.pegarPrecoCarrinho();

        Screenshot.tirarPrint(driver,featureName, "produto_no_carrinho");
        Log.escreverLog(featureName,"Validando preço...");
        Log.escreverLog(featureName,"PRECO PRODUTO: " + precoSacola);
        Log.escreverLog(featureName,"PRECO CARRINHO: " + precoCarrinho);

        Assert.assertEquals(precoSacola, precoCarrinho);
        Log.escreverLog(featureName,"TESTE PASSOU!");
    }

    @After
    public void afterScenario() {DriverManager.quitDriver();}

    }
