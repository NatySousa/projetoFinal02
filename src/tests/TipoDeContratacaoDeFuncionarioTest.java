package tests;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Ent�o;
import cucumber.api.java.pt.Quando;

public class TipoDeContratacaoDeFuncionarioTest {

	// declarando o selenium webdriver
	WebDriver webdriver;

	@Dado("^Acessar a p�gina de cadastro de tipo de contrata��o$")
	public void acessar_a_p�gina_de_cadastro_de_tipo_de_contrata��o() {
		// configurar o driver do navegador
		System.setProperty("webdriver.chrome.driver", "c:\\chromedriver\\chromedriver.exe");

		// abrindo o googlechrome
		webdriver = new ChromeDriver();

		// maximizando o navegador
		webdriver.manage().window().maximize();

		// acessando a p�gina de de tipo de contrata��o
		webdriver.get("http://exercteste01-001-site1.gtempurl.com/Home/Exercicio02");
	}

	@Dado("^Selecionar o funcion�rio \"([^\"]*)\"$")
	public void selecionar_o_funcion�rio(String nome) {
		// preecher o nome do funcion�rio
		webdriver.findElement(By.xpath("//*[@id=\"Funcionario\"]")).sendKeys(nome);
	}

	@Dado("^Selecionar o tipo de contrata��o \"([^\"]*)\"$")
	public void selecionar_o_tipo_de_contrata��o(String TipoContratacao) {
		webdriver.findElement(By.xpath("//*[@id=\"TipoContratacao\"]")).sendKeys(TipoContratacao);

	}

	@Quando("^solicitar a realiza��o do cadastro$")
	public void solicitar_a_realiza��o_do_cadastro() {
		// clicando no bot�o de cadastro
		webdriver.findElement(By.xpath("//*[@id=\"btnCadastro\"]")).click();

	}

	@Ent�o("^Sistema exibe a mensagem \"([^\"]*)\"$")
	public void sistema_exibe_a_mensagem(String mensagem) {
		// ler a mensagem exibida pelo sistema
		String resultado = webdriver.findElement(By.xpath("//*[@id=\"mensagem\"]")).getText();

		// comparando o resultado com a mensagem escrita na feature
		assertEquals(resultado, mensagem);

		// fechar o navegador
		webdriver.close();
		webdriver.quit();

	}

	@Ent�o("^Sistema informa que o nome do funcion�rio � obrigat�rio$")
	public void sistema_informa_que_o_nome_do_funcion�rio_�_obrigat�rio() {

		// capturando a mensagem de erro de valida��o do campo nome
		String resultado = webdriver.findElement(By.xpath("/html/body/div/div[2]/form/div/div/div[1]/span")).getText();

		// comparando a mensagem de erro
		assertEquals(resultado, "Por favor, selecione o funcion�rio.");

	}

	@Ent�o("^Sistema informa que o tipo de contrata��o � obrigat�rio$")
	public void sistema_informa_que_o_tipo_de_contrata��o_�_obrigat�rio() {
		// capturando a mensagem de erro de valida��o do campo nome
		String resultado = webdriver.findElement(By.xpath("/html/body/div/div[2]/form/div/div/div[2]/span")).getText();

		// comparando a mensagem de erro
		assertEquals(resultado, "Por favor, informe o tipo de contrata��o.");
	}

}
