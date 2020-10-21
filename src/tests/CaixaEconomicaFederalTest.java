package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import servico.CaixaEconomicaFederal;

/**
 * A classe para testar o cálculo do dígito verificador do código de barras da Caixa Econômica Federal
 * 
 * @author Filipe Wutzke
 */
public class CaixaEconomicaFederalTest {
	
	private CaixaEconomicaFederal caixaEconomicaFederal;
	private String digitoCalculado;
	private String digitoEsperado;
	
	@Before
	public void setUp() {
		this.caixaEconomicaFederal = new CaixaEconomicaFederal();
	}
	
	/**
	 * Testa o calcula do dígito verificador do código de barras
	 * <ul><b>Dados usados para cálculo:</b>
	 * <li>Código de barras sem dv: 1049324200000321120055077222133347777777771</li>
	 * </ul>
	 * @author Filipe Wutzke
	 */
	@Test
	public void calcularDigitoVerificadorCodigoBarras() {
		//Exemplo do manual
		digitoCalculado = caixaEconomicaFederal.calcularDigitoVerificadorCodigoDeBarras("1049324200000321120055077222133347777777771");
		digitoEsperado = "4";
		
		assertEquals(String.format("O dígito [%s] retornado é diferente do dígito esperado [%s]", digitoCalculado, digitoEsperado), digitoCalculado,
				digitoEsperado);
	}
	
	/**
	 * Testa o calculo do dígito verificador do campo livre do código de barras</br>
	 * <ul><b>Dados usados para cálculo:</b>
	 * <li>Código do Beneficiário - DV: 005507 - 7</li>
	 * <li>Nosso Número (sem DV): 14/222333777777777</li>
	 * </ul>
	 * @author Filipe Wutzke
	 */
	@Test
	public void calcularDigitoVerificadorCampoLivre() {
		//Exemplo do manual
		digitoCalculado = caixaEconomicaFederal.calcularDvCampoLivre("005507722213334777777777");
		digitoEsperado = "1";
		
		assertEquals(String.format("O dígito [%s] retornado é diferente do dígito esperado [%s]", digitoCalculado, digitoEsperado), digitoCalculado,
				digitoEsperado);
	}
	
	/**
	 * Testa o calculo do dígito verificador do nosso número</br>
	 * <ul><b>Dados usados para cálculo:</b>
	 * <li>Nosso Número usado para cálculo: 14/000000000000019</li>
	 * </ul>
	 * @author Filipe Wutzke
	 */
	@Test
	public void calcularDigitoVerificadorNossoNumero() {
		//Exemplo do manual
		digitoCalculado = CaixaEconomicaFederal.calcularDvNossoNumero("14000000000000019");
		digitoEsperado = "7";
		
		assertEquals(String.format("O dígito [%s] retornado é diferente do dígito esperado [%s]", digitoCalculado, digitoEsperado), digitoCalculado,
				digitoEsperado);
	}
	
	/**
	 * Teste do DAC (Dígito de Auto Conferência) do primeiro campo da linha digitável.
	 * <ul><b>Dados usados para cálculo:</b>
	 * <li>Campo 1: 104900550</li>
	 * </ul>
	 * @author Filipe Wutzke
	 */
	@Test
	public void calcularDACPrimeiroDigito() {
		//Usando um exemplo do manual
		int dacCalculado = caixaEconomicaFederal.calcularDACLinhaDigitavel("104900550");
		int dacEsperado = 5;
		
		assertEquals(String.format("O DAC [%s] do primeiro campo retornado é diferente do DAC esperado [%s]", dacCalculado, dacEsperado), dacCalculado,
				dacEsperado);
	}
	
}