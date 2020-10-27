package servico;

import java.util.ArrayList;
import java.util.List;

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
		List<Integer> codigoBarrasTemp = new ArrayList<>();
		List<Integer> codigoBarrasTempModulo11 = new ArrayList<>();
		int j = 0;
		int m = 24;
		int pesso1 = 1;
		int pesso2 = 1;
		int pesso3 = 1;
		int total = 0;
		int totalSoma = 0;

		addCodBarrasTmp(campoLivre, codigoBarrasTemp, codigoBarrasTempModulo11, j, m);

		return getString(codigoBarrasTempModulo11, pesso1, pesso2, pesso3, total, totalSoma);

	}

	private void addCodBarrasTmp(String campoLivre, List<Integer> codigoBarrasTemp, List<Integer> codigoBarrasTempModulo11, int j, int m) {
		Integer numero;
		for(int i = 0; i < campoLivre.length(); i++) {
			j = j + 1;
			numero = Integer.parseInt(campoLivre.substring(i,j));
			codigoBarrasTemp.add(numero);
		}

		for(int i = codigoBarrasTemp.size(); i >= 1; i--){
			m =  m - 1;
			numero = codigoBarrasTemp.get(m);
			codigoBarrasTempModulo11.add(numero);
		}
	}

	private static String getString(List<Integer> codigoBarrasTempModulo11, int pesso1, int pesso2, int pesso3, int total, int totalSoma) {
		int m;
		int totalTemp;
		int totalModuloDivisao;
		int retorno;
		for(int i = 0; i < codigoBarrasTempModulo11.size(); i++){
			m = i;
			if(m <= 8) {		
				pesso1 += 1;
				totalTemp = codigoBarrasTempModulo11.get(m);
				total = totalTemp * pesso1;
			}
			if(m  >= 8 && m <= 16 ) {
				pesso2 += 1;
				totalTemp = codigoBarrasTempModulo11.get(m);
				total = totalTemp * pesso2;
			}
			if(m >= 16) {
				pesso3 += 1;
				totalTemp = codigoBarrasTempModulo11.get(m);
				total = totalTemp * pesso3;
			}
			
			totalSoma += total;
			total = 0;
		}

		totalModuloDivisao = totalSoma % 11;
		retorno = 11 - totalModuloDivisao;

		return String.valueOf(retorno);
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

		List<Integer> codigoBarrasTemp = new ArrayList<>();
		List<Integer> codigoBarrasTempModulo11 = new ArrayList<>();
		int j = 0;
		int m = 43;
		int pesso1 = 1;
		int pesso2 = 1;
		int pesso3 = 1;
		int pesso4 = 1;
		int pesso5 = 1;
		int pesso6 = 1;
		int total = 0;
		int totalTemp = 0;
		int totalSoma = 0;
		int totalModuloDivisao = 0;
		int retorno = 0;

		addCodBarrasTmp(codigoBarras, codigoBarrasTemp, codigoBarrasTempModulo11, j, m);

		for(int i = 0; i < codigoBarrasTempModulo11.size(); i++){
			m = i;
			if(m <= 8) {		
				pesso1 += 1;
				totalTemp = codigoBarrasTempModulo11.get(m);
				total = totalTemp * pesso1;
			}
			if(m  >= 8 && m <= 16 ) {
				pesso2 += 1;
				totalTemp = codigoBarrasTempModulo11.get(m);
				total = totalTemp * pesso2;
			}
			if(m >= 16 && m <= 24 ) {
				pesso3 += 1;
				totalTemp = codigoBarrasTempModulo11.get(m);
				total = totalTemp * pesso3;
			}
			if(m >= 24 && m <= 32 ) {
				pesso4 += 1;
				totalTemp = codigoBarrasTempModulo11.get(m);
				total = totalTemp * pesso4;
			}
			if(m >= 32 && m <= 40) {
				pesso5 += 1;
				totalTemp = codigoBarrasTempModulo11.get(m);
				total = totalTemp * pesso5;
			}
			if(m >= 40) {
				pesso6 += 1;
				totalTemp = codigoBarrasTempModulo11.get(m);
				total = totalTemp * pesso6;
			}
			
			totalSoma += total;
			total = 0;
		}
		
		 totalModuloDivisao = totalSoma % 11;
		 retorno = 11 - totalModuloDivisao;

		return  String.valueOf(retorno);
	}
	
	/**
	 * Calcula o digito verificador dos campos da linha digit�vel
	 * 
	 * @param campo sequencia numerica a ser calculada o Digito verificador
	 * @return String com campo + DV
	 */
	public String calcularDvCampos(String campo){//Modulo 10

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

		List<Integer> codigoBarrasTemp = new ArrayList<>();
		List<Integer> codigoBarrasTempModulo11 = new ArrayList<>();
		List<Integer> multiplicacao = new ArrayList<>();
		int j = 0;
		int m = 9;
		int pesso = 1;
		int total = 0;
		int totalTemp = 0;
		int totalSoma = 0;
		int totalModuloDivisao = 0;
		int retorno = 0;

		addCodBarrasTmp(campo, codigoBarrasTemp, codigoBarrasTempModulo11, j, m);

		for(int i = 0; i < codigoBarrasTempModulo11.size(); i++){
			m = i;		
			pesso += 1;
			
			totalTemp = codigoBarrasTempModulo11.get(m);
			total = totalTemp * pesso;

			if(total >= 10) {
				String tempTotal = String.valueOf(total);
				String tempPrimeiroNumero = tempTotal.substring(0,1);
				String tempSegundoNumero = tempTotal.substring(1,2);
				int tempPrimNumInt = Integer.parseInt(tempPrimeiroNumero);
				int tempSegNumInt = Integer.parseInt(tempSegundoNumero);
				total = tempPrimNumInt + tempSegNumInt;
				
			}
			multiplicacao.add(total);
			totalSoma += total;
			
			if(pesso == 2){
				pesso = 0;
			}

		}
		
		totalModuloDivisao = totalSoma % 10;
		retorno = 10 - totalModuloDivisao;

		return  retorno;
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
		
		Integer numero;
		List<Integer> codigoBarrasTemp = new ArrayList<Integer>();
		List<Integer> codigoBarrasTempModulo11 = new ArrayList<Integer>();
		int j = 0;
		int m = 17;
		int pesso1 = 1;
		int pesso2 = 1;
		int pesso3 = 1;
		int total = 0;
		int totalSoma = 0;

		for(int i = 0; i < nossoNumero.length(); i++) {
			j = j + 1;
			numero = Integer.parseInt(nossoNumero.substring(i,j));
			codigoBarrasTemp.add(numero);
		}
		
		for(int i = codigoBarrasTemp.size(); i >= 1; i--){
			m =  m - 1;
			numero = codigoBarrasTemp.get(m);
			codigoBarrasTempModulo11.add(numero);
		}

		return getString(codigoBarrasTempModulo11, pesso1, pesso2, pesso3, total, totalSoma);
	}
	
	
}
