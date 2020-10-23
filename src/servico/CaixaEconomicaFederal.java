package servico;

public class CaixaEconomicaFederal {
	
	/**
	 * C�LCULO DO DIGITO VERIFICADOR DO CAMPO LIVRE
	 * <p>
	 * <ul><b>1� PASSO</b>
	 * <li>Aplicar o m�dulo 11, o primeiro d�gito da direita para a esquerda ser� multiplicado por 2, o segundo, por 3 e assim sucessivamente at� o 9;</li>
	 * </ul>
	 * <ul><b>2� PASSO</b>
	 * <li>Somar o resultado da multiplica��o. Obs: Quando o Total da Soma for MENOR que o quociente (no caso 11), pular o 3� PASSO, ou seja, 
	 * o Total da Soma dever� ser diminu�do diretamente do quociente, obtendo-se o DV como resultado.</li>
	 * </ul>
	 * <ul><b>3� PASSO</b>
	 * <li>Dividir o Total da Soma por 11</li>
	 * </ul>
	 * <ul><b>4� PASSO</b>
	 * <li>Subtrair o resto da divis�o de 11. Se o RESULTADO for maior que 9 (nove) o DV ser� 0 (zero)*, caso contr�rio o RESULTADO ser� o DV.</li>
	 * </ul>
	 *
	 * @param campoLivre o campo livre a ser calculado o dv
	 * @return a string com o d�gito verificador do campo livre
	 * @author Filipe Wutzke
	 */
	public String calcularDvCampoLivre(String campoLivre) {
		//TODO escreva o c�digo AQUI
		return "1";
	}
	
	/**
	 * Calcula o digito verificador do c�digo de barras.
	 * <p>
	 * O DV GERAL do C�digo de Barras, localizado na posi��o 5, � calculado atrav�s do M�DULO 11, com peso de 2 a 9; 
	 * Considerar as posi��es de 1 a 4 e de 6 a 44, iniciando pela posi��o 44 e saltando a posi��o 5.</br>
	 * Para o c�lculo do d�gito verificado do c�digo de barras, procede a seguinte forma:
	 * <ul><b>1� PASSO</b>
	 * <li>Aplicar o m�dulo 11, com peso de 2 a 9. O primeiro d�gito da direita para a esquerda ser� multiplicado por 2, 
	 * o segundo por 3 e assim sucessivamente at� o 9</li>
	 * </ul>
	 * <ul><b>2� PASSO</b>
	 * <li>Somar o resultado da multiplica��o</li>
	 * </ul>
	 * <ul><b>3� PASSO</b>
	 * <li>Dividir o Total da Soma por 11</li>
	 * </ul>
	 * <ul><b>4� PASSO</b>
	 * <li>O Resto da divis�o deve ser subtra�do de 11. O RESULTADO deve ser inclu�do na 5� posi��o do C�digo de Barras</li>
	 * </ul>
	 * <b>ATEN��O:</b> Em nenhuma hip�tese poder� ser utilizado o d�gito igual a 0 (zero) como DV Geral.
	 * Se o RESULTADO for igual 0 (zero) ou maior que 9 (nove) o DV ser� 1 (um).
	 * Regra exclusiva para c�lculo do DV geral do c�digo de barras que n�o admite 0 (zero).
	 *
	 * @param codigoBarras o c�digo de barras
	 * @return o c�digo de barrar acrescido do digito verificador na posi��o correta
	 * 
	 * @author Filipe Wutzke
	 */
	public String calcularDigitoVerificadorCodigoDeBarras(String codigoBarras) {
		//TODO escreva o c�digo AQUI
		return "4";
	}
	
	/**
	 * Calcula o digito verificador dos campos da linha digit�vel
	 * 
	 * @param campo sequencia numerica a ser calculada o Digito verificador
	 * @return String com campo + DV
	 */
	public String calcularDvCampos(String campo){//Modulo 10
		//Pega o codigo de barras, e j� coloca o digito verificador (soma) no codigo de barras
		return campo + calcularDACLinhaDigitavel(campo);
	}
	
	/**
	 * Calcula o digito verificador ou d�gito de auto confer�ncia (DAC) da linha digit�vel
	 * <p>
	 * Para o c�lculo do d�gito verificado do c�digo de barras, procede a seguinte forma:
	 * <ul>
	 * <li>O c�lculo � atrav�s do m�dulo 10, com base de c�lculo igual a 2</li>
	 * <li>O primeiro d�gito da esquerda para direita ser� multiplicado por 2, o segundo por 1, o terceiro por 2 e assim sucessivamente.</li>
	 * <li>Os resultados das multiplica��es devem ser acumulados.</li>
	 * <li>No final, o valor acumulado dever� ser dividido por 10.</li>
	 * <li>O resto da divis�o dever� ser subtra�do de 10.<ul>
	 * <li>Se o resultado da subtra��o for igual a 10 (dez) devera assumir o d�gito igual a 0 (zero).</li> 
	 * <li>Caso contr�rio, o resultado da subtra��o ser� o pr�prio d�gito.</li>
	 * </ul></li> 
	 * </ul>
	 *
	 * @param campo o campo da linha digit�vel que dever� ser calculado para encontrar o DAC
	 * @return o DAC calculado sobre o campo informado
	 * 
	 * @author Filipe Wutzke
	 */
	public int calcularDACLinhaDigitavel(String campo) {
		//TODO escreva o c�digo AQUI
		//Documente o m�todo, as partes importantes
		return 5;
	}
	
	/**
	 * Calcula o d�gito de auto-confer�ncia do nosso n�mero.
	 * <p>
	 * O DV do Nosso N�mero � calculado atrav�s do M�DULO 11, com peso de 2 a 9;
	 * Para c�lculo do DV do Nosso N�mero s�o consideradas as 17 posi��es.</br>
	 * Para o c�lculo do d�gito de auto-confer�ncia, procede a seguinte forma:
	 * <ul><b>1� PASSO</b>
	 * <li>Aplicar o m�dulo 11, com peso de 2 a 9. O primeiro d�gito da direita para a esquerda ser� multiplicado por 2, 
	 * o segundo por 3 e assim sucessivamente at� o 9</li>
	 * </ul>
	 * <ul><b>2� PASSO</b>
	 * <li>Somar o resultado da multiplica��o</li>
	 * </ul>
	 * <ul><b>3� PASSO</b>
	 * <li>Dividir o Total da Soma por 11</li>
	 * </ul>
	 * <ul><b>4� PASSO</b>
	 * <li>O Resto da divis�o deve ser subtra�do de 11. Se o RESULTADO for maior que 9 (nove) o DV ser� 0 (zero), caso contr�rio o RESULTADO ser� o DV</li>
	 * </ul>
	 *
	 * @param nossoNumero o n�mero nosso numero, com 17 n�meros, sem formata��o
	 * @return o nosso n�mero com o d�gito calculado
	 * 
	 * @author Filipe Wutzke
	 */
	public static String calcularDvNossoNumero(String nossoNumero){//Modulo 11
		//TODO escreva o c�digo AQUI
		return "7";
	}
	
}
