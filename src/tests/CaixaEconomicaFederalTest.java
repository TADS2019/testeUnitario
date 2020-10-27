package tests;

import org.junit.Before;
import org.junit.Test;
import servico.CaixaEconomicaFederal;

import static org.junit.Assert.assertEquals;

/**
 * A classe para testar o c?lculo do d?gito verificador do c?digo de barras da Caixa Econ?mica Federal
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
	 * Testa o calcula do d?gito verificador do c?digo de barras
	 * <ul><b>Dados usados para c?lculo:</b>
	 * <li>C?digo de barras sem dv: 1049324200000321120055077222133347777777771</li>
	 * </ul>
	 * @author Filipe Wutzke
	 */
	@Test
	public void calcularDigitoVerificadorCodigoBarras() {
		//Exemplo do manual
		digitoCalculado = caixaEconomicaFederal.calcularDigitoVerificadorCodigoDeBarras("1049324200000321120055077222133347777777771");
		digitoEsperado = "4";
		
		assertEquals(String.format("O d?gito [%s] retornado ? diferente do d?gito esperado [%s]", digitoCalculado, digitoEsperado), digitoCalculado,
				digitoEsperado);
	}
	
	/**
	 * Testa o calculo do d?gito verificador do campo livre do c?digo de barras</br>
	 * <ul><b>Dados usados para c?lculo:</b>
	 * <li>C?digo do Benefici?rio - DV: 005507 - 7</li>
	 * <li>Nosso N?mero (sem DV): 14/222333777777777</li>
	 * </ul>
	 * @author Filipe Wutzke
	 */
	@Test
	public void calcularDigitoVerificadorCampoLivre() {
		//Exemplo do manual
		digitoCalculado = caixaEconomicaFederal.calcularDvCampoLivre("005507722213334777777777");
		digitoEsperado = "1";
		
		assertEquals(String.format("O d?gito [%s] retornado ? diferente do d?gito esperado [%s]", digitoCalculado, digitoEsperado), digitoCalculado,
				digitoEsperado);
	}
	
	/**
	 * Testa o calculo do d?gito verificador do nosso n?mero</br>
	 * <ul><b>Dados usados para c?lculo:</b>
	 * <li>Nosso N?mero usado para c?lculo: 14/000000000000019</li>
	 * </ul>
	 * @author Filipe Wutzke
	 */
	@Test
	public void calcularDigitoVerificadorNossoNumero() {
		//Exemplo do manual
		digitoCalculado = CaixaEconomicaFederal.calcularDvNossoNumero("14000000000000019");
		digitoEsperado = "7";
		
		assertEquals(String.format("O d?gito [%s] retornado ? diferente do d?gito esperado [%s]", digitoCalculado, digitoEsperado), digitoCalculado,
				digitoEsperado);
	}
	
	/**
	 * Teste do DAC (D?gito de Auto Confer?ncia) do primeiro campo da linha digit?vel.
	 * <ul><b>Dados usados para c?lculo:</b>
	 * <li>Campo 1: 104900550</li>
	 * </ul>
	 * @author Filipe Wutzke
	 */
	@Test
	public void calcularDACPrimeiroDigito() {
		//Usando um exemplo do manual
		int dacCalculado = caixaEconomicaFederal.calcularDACLinhaDigitavel("104900550");
		int dacEsperado = 5;
		
		assertEquals(String.format("O DAC [%s] do primeiro campo retornado ? diferente do DAC esperado [%s]", dacCalculado, dacEsperado), dacCalculado,
				dacEsperado);
	}
	
}