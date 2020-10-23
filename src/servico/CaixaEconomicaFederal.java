package servico;

public class CaixaEconomicaFederal {
	
	/**
	 * CÁLCULO DO DIGITO VERIFICADOR DO CAMPO LIVRE
	 * <p>
	 * <ul><b>1º PASSO</b>
	 * <li>Aplicar o módulo 11, o primeiro dígito da direita para a esquerda será multiplicado por 2, o segundo, por 3 e assim sucessivamente até o 9;</li>
	 * </ul>
	 * <ul><b>2º PASSO</b>
	 * <li>Somar o resultado da multiplicação. Obs: Quando o Total da Soma for MENOR que o quociente (no caso 11), pular o 3º PASSO, ou seja, 
	 * o Total da Soma deverá ser diminuído diretamente do quociente, obtendo-se o DV como resultado.</li>
	 * </ul>
	 * <ul><b>3º PASSO</b>
	 * <li>Dividir o Total da Soma por 11</li>
	 * </ul>
	 * <ul><b>4º PASSO</b>
	 * <li>Subtrair o resto da divisão de 11. Se o RESULTADO for maior que 9 (nove) o DV será 0 (zero)*, caso contrário o RESULTADO será o DV.</li>
	 * </ul>
	 *
	 * @param campoLivre o campo livre a ser calculado o dv
	 * @return a string com o dígito verificador do campo livre
	 * @author Filipe Wutzke
	 */
	public String calcularDvCampoLivre(String campoLivre) {
		//TODO escreva o código AQUI
		return "1";
	}
	
	/**
	 * Calcula o digito verificador do código de barras.
	 * <p>
	 * O DV GERAL do Código de Barras, localizado na posição 5, é calculado através do MÓDULO 11, com peso de 2 a 9; 
	 * Considerar as posições de 1 a 4 e de 6 a 44, iniciando pela posição 44 e saltando a posição 5.</br>
	 * Para o cálculo do dígito verificado do código de barras, procede a seguinte forma:
	 * <ul><b>1º PASSO</b>
	 * <li>Aplicar o módulo 11, com peso de 2 a 9. O primeiro dígito da direita para a esquerda será multiplicado por 2, 
	 * o segundo por 3 e assim sucessivamente até o 9</li>
	 * </ul>
	 * <ul><b>2º PASSO</b>
	 * <li>Somar o resultado da multiplicação</li>
	 * </ul>
	 * <ul><b>3º PASSO</b>
	 * <li>Dividir o Total da Soma por 11</li>
	 * </ul>
	 * <ul><b>4º PASSO</b>
	 * <li>O Resto da divisão deve ser subtraído de 11. O RESULTADO deve ser incluído na 5ª posição do Código de Barras</li>
	 * </ul>
	 * <b>ATENÇÃO:</b> Em nenhuma hipótese poderá ser utilizado o dígito igual a 0 (zero) como DV Geral.
	 * Se o RESULTADO for igual 0 (zero) ou maior que 9 (nove) o DV será 1 (um).
	 * Regra exclusiva para cálculo do DV geral do código de barras que não admite 0 (zero).
	 *
	 * @param codigoBarras o código de barras
	 * @return o código de barrar acrescido do digito verificador na posição correta
	 * 
	 * @author Filipe Wutzke
	 */
	public String calcularDigitoVerificadorCodigoDeBarras(String codigoBarras) {
		//TODO escreva o código AQUI
		return "4";
	}
	
	/**
	 * Calcula o digito verificador dos campos da linha digitável
	 * 
	 * @param campo sequencia numerica a ser calculada o Digito verificador
	 * @return String com campo + DV
	 */
	public String calcularDvCampos(String campo){//Modulo 10
		//Pega o codigo de barras, e já coloca o digito verificador (soma) no codigo de barras
		return campo + calcularDACLinhaDigitavel(campo);
	}
	
	/**
	 * Calcula o digito verificador ou dígito de auto conferência (DAC) da linha digitável
	 * <p>
	 * Para o cálculo do dígito verificado do código de barras, procede a seguinte forma:
	 * <ul>
	 * <li>O cálculo é através do módulo 10, com base de cálculo igual a 2</li>
	 * <li>O primeiro dígito da esquerda para direita será multiplicado por 2, o segundo por 1, o terceiro por 2 e assim sucessivamente.</li>
	 * <li>Os resultados das multiplicações devem ser acumulados.</li>
	 * <li>No final, o valor acumulado deverá ser dividido por 10.</li>
	 * <li>O resto da divisão deverá ser subtraído de 10.<ul>
	 * <li>Se o resultado da subtração for igual a 10 (dez) devera assumir o dígito igual a 0 (zero).</li> 
	 * <li>Caso contrário, o resultado da subtração será o próprio dígito.</li>
	 * </ul></li> 
	 * </ul>
	 *
	 * @param campo o campo da linha digitável que deverá ser calculado para encontrar o DAC
	 * @return o DAC calculado sobre o campo informado
	 * 
	 * @author Filipe Wutzke
	 */
	public int calcularDACLinhaDigitavel(String campo) {
		//TODO escreva o código AQUI
		//Documente o método, as partes importantes
		return 5;
	}
	
	/**
	 * Calcula o dígito de auto-conferência do nosso número.
	 * <p>
	 * O DV do Nosso Número é calculado através do MÓDULO 11, com peso de 2 a 9;
	 * Para cálculo do DV do Nosso Número são consideradas as 17 posições.</br>
	 * Para o cálculo do dígito de auto-conferência, procede a seguinte forma:
	 * <ul><b>1º PASSO</b>
	 * <li>Aplicar o módulo 11, com peso de 2 a 9. O primeiro dígito da direita para a esquerda será multiplicado por 2, 
	 * o segundo por 3 e assim sucessivamente até o 9</li>
	 * </ul>
	 * <ul><b>2º PASSO</b>
	 * <li>Somar o resultado da multiplicação</li>
	 * </ul>
	 * <ul><b>3º PASSO</b>
	 * <li>Dividir o Total da Soma por 11</li>
	 * </ul>
	 * <ul><b>4º PASSO</b>
	 * <li>O Resto da divisão deve ser subtraído de 11. Se o RESULTADO for maior que 9 (nove) o DV será 0 (zero), caso contrário o RESULTADO será o DV</li>
	 * </ul>
	 *
	 * @param nossoNumero o número nosso numero, com 17 números, sem formatação
	 * @return o nosso número com o dígito calculado
	 * 
	 * @author Filipe Wutzke
	 */
	public static String calcularDvNossoNumero(String nossoNumero){//Modulo 11
		//TODO escreva o código AQUI
		return "7";
	}
	
}
