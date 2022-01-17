package tests;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class TipoDeContratacaoDeFuncionarioTest {

	// declarando o selenium webdriver
	WebDriver webdriver;

	@Dado("^Acessar a página de cadastro de tipo de contratação$")
	public void acessar_a_página_de_cadastro_de_tipo_de_contratação() {
		// configurar o driver do navegador
		System.setProperty("webdriver.chrome.driver", "c:\\chromedriver\\chromedriver.exe");

		// abrindo o googlechrome
		webdriver = new ChromeDriver();

		// maximizando o navegador
		webdriver.manage().window().maximize();

		// acessando a página de de tipo de contratação
		webdriver.get("http://exercteste01-001-site1.gtempurl.com/Home/Exercicio02");
	}

	@Dado("^Selecionar o funcionário \"([^\"]*)\"$")
	public void selecionar_o_funcionário(String nome) {
		// preecher o nome do funcionário
		webdriver.findElement(By.xpath("//*[@id=\"Funcionario\"]")).sendKeys(nome);
	}

	@Dado("^Selecionar o tipo de contratação \"([^\"]*)\"$")
	public void selecionar_o_tipo_de_contratação(String TipoContratacao) {
		webdriver.findElement(By.xpath("//*[@id=\"TipoContratacao\"]")).sendKeys(TipoContratacao);

	}

	@Quando("^solicitar a realização do cadastro$")
	public void solicitar_a_realização_do_cadastro() {
		// clicando no botão de cadastro
		webdriver.findElement(By.xpath("//*[@id=\"btnCadastro\"]")).click();

	}

	@Então("^Sistema exibe a mensagem \"([^\"]*)\"$")
	public void sistema_exibe_a_mensagem(String mensagem) {
		// ler a mensagem exibida pelo sistema
		String resultado = webdriver.findElement(By.xpath("//*[@id=\"mensagem\"]")).getText();

		// comparando o resultado com a mensagem escrita na feature
		assertEquals(resultado, mensagem);

		// fechar o navegador
		webdriver.close();
		webdriver.quit();

	}

	@Então("^Sistema informa que o nome do funcionário é obrigatório$")
	public void sistema_informa_que_o_nome_do_funcionário_é_obrigatório() {

		// capturando a mensagem de erro de validação do campo nome
		String resultado = webdriver.findElement(By.xpath("/html/body/div/div[2]/form/div/div/div[1]/span")).getText();

		// comparando a mensagem de erro
		assertEquals(resultado, "Por favor, selecione o funcionário.");

	}

	@Então("^Sistema informa que o tipo de contratação é obrigatório$")
	public void sistema_informa_que_o_tipo_de_contratação_é_obrigatório() {
		// capturando a mensagem de erro de validação do campo nome
		String resultado = webdriver.findElement(By.xpath("/html/body/div/div[2]/form/div/div/div[2]/span")).getText();

		// comparando a mensagem de erro
		assertEquals(resultado, "Por favor, informe o tipo de contratação.");
	}

}
