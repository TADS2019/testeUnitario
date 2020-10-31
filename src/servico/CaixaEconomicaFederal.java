package servico;
import java.util.ArrayList;
import java.util.List;

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
		Integer number = null;
		List<Integer> codigoBarrasTemp = new ArrayList<Integer>();
		List<Integer> codigoBarrasTempModulo = new ArrayList<Integer>();
		int j = 0;
		int m = 24;
		int pesso1 = 1;
		int pesso2 = 1;
		int pesso3 = 1;
		int total = 0;
		int totalModuloDivisao = 0;
		int totalTemp = 0;
		int totalSoma = 0;
		int retorno = 0;

		for(int i = 0; i < campoLivre.length(); i++) {
			j = j + 1;
			number = Integer.parseInt(campoLivre.substring(i,j));
			codigoBarrasTemp.add(number);
			number = null;
		}

		for(int i = codigoBarrasTemp.size(); i >= 1; i--){
			m =  m - 1;
			number = codigoBarrasTemp.get(m);
			codigoBarrasTempModulo.add(number);
			number = null;
		}

		for(int i = 0; i < codigoBarrasTempModulo.size(); i++){
			m = i;
			if(m >= 0 && m <= 8) {		
				pesso1 += 1;
				totalTemp = codigoBarrasTempModulo.get(m);
				total = totalTemp * pesso1;
			}
			if(m  >= 8 && m <= 16) {
				pesso2 += 1;
				totalTemp = codigoBarrasTempModulo.get(m);
				total = totalTemp * pesso2;
			}
			if(m >= 16) {
				pesso3 += 1;
				totalTemp = codigoBarrasTempModulo.get(m);
				total = totalTemp * pesso3;
			}

			totalSoma += total;
			number = null;
			total = 0;
			totalTemp = 0;
		}

		totalModuloDivisao = totalSoma % 11;
		retorno = 11 - totalModuloDivisao;
		totalSoma = 0;

		return String.valueOf(retorno);
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
			Integer number = null;
			List<Integer> codigoBarrasTemp = new ArrayList<Integer>();
			List<Integer> codigoBarrasTempModulo11 = new ArrayList<Integer>();
			int j = 0;
			int m = 43;
			int pesso1 = 1;
			int pesso2 = 1;
			int pesso3 = 1;
			int pesso4 = 1;
			int pesso5 = 1;
			int pesso6 = 1;
			int total = 0;
			int totalModuloDivisao = 0;
			int totalTemp = 0;
			int totalSoma = 0;
			int retorno = 0;

			for(int i = 0; i < codigoBarras.length(); i++) {
				j = j + 1;
				number = Integer.parseInt(codigoBarras.substring(i,j));
				codigoBarrasTemp.add(number);
				number = null;
			}

			for(Integer i = codigoBarrasTemp.size(); i >= 1; i--){
				m =  m - 1;
				number = codigoBarrasTemp.get(m);
				codigoBarrasTempModulo11.add(number);
				number = null;
			}

			for(Integer i = 0; i < codigoBarrasTempModulo11.size(); i++){
				m = i;
				if (m >= 0 && m <=8 ) {		
					pesso1 += 1;
					totalTemp = codigoBarrasTempModulo11.get(m);
					total = totalTemp * pesso1;
				}
				if (m  >= 8 && m <= 16 ) {
					pesso2 += 1;
					totalTemp = codigoBarrasTempModulo11.get(m);
					total = totalTemp * pesso2;
				}
				if (m >= 16 && m <= 24 ) {
					pesso3 += 1;
					totalTemp = codigoBarrasTempModulo11.get(m);
					total = totalTemp * pesso3;
				}
				if (m >= 24 && m <= 32 ) {
					pesso4 += 1;
					totalTemp = codigoBarrasTempModulo11.get(m);
					total = totalTemp * pesso4;
				}
				if (m >= 32 && m <= 40) {
					pesso5 += 1;
					totalTemp = codigoBarrasTempModulo11.get(m);
					total = totalTemp * pesso5;
				}
				if (m >= 40) {
					pesso6 += 1;
					totalTemp = codigoBarrasTempModulo11.get(m);
					total = totalTemp * pesso6;
				}

				totalSoma += total;
				number = null;
				total = 0;
				totalTemp = 0;
			}

			 totalModuloDivisao = totalSoma % 11;
			 retorno = 11 - totalModuloDivisao;

			totalSoma = 0;

	 		return  String.valueOf(retorno);
		}

	
	/**
	 * Calcula o digito verificador dos campos da linha digitável
	 * 
	 * @param campo sequencia numerica a ser calculada o Digito verificador
	 * @return String com campo + DV
	 */
	public String calcularDvCampos(String campo){//Modulo 10
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
		Integer number = null;
		List<Integer> codigoBarrasTemp = new ArrayList<Integer>();
		List<Integer> codigoBarrasTempModulo11 = new ArrayList<Integer>();
		List<Integer> multiplicacao = new ArrayList<Integer>();
		int j = 0;
		int m = 9;
		int pesso = 1;
		int total = 0;
		int totalModuloDivisao = 0;
		int totalTemp = 0;
		int totalSoma = 0;
		int retorno = 0;

		for(int i = 0; i < campo.length(); i++) {
			j = j + 1;
			number = Integer.parseInt(campo.substring(i,j));
			codigoBarrasTemp.add(number);
			number = null;
		}

		for(Integer i = codigoBarrasTemp.size(); i >= 1; i--){
			m =  m - 1;
			number = codigoBarrasTemp.get(m);
			codigoBarrasTempModulo11.add(number);
			number = null;
		}

		for(Integer i = 0; i < codigoBarrasTempModulo11.size(); i++){
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
				int tempFinalTotal = tempPrimNumInt + tempSegNumInt;
				total = tempFinalTotal;

			}
			multiplicacao.add(total);
			totalSoma += total;

			if(pesso == 2){
				pesso = 0;
			}

			number = null;
			total = 0;
			totalTemp = 0;
		}

		totalModuloDivisao = totalSoma % 10;
		retorno = 10 - totalModuloDivisao;
		totalSoma = 0;

 		return  retorno;
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
		Integer number = null;
		List<Integer> codigoBarrasTemp = new ArrayList<Integer>();
		List<Integer> codigoBarrasTempModulo11 = new ArrayList<Integer>();
		int j = 0;
		int m = 17;
		int pesso1 = 1;
		int pesso2 = 1;
		int pesso3 = 1;
		int total = 0;
		int totalModuloDivisao = 0;
		int totalTemp = 0;
		int totalSoma = 0;
		int retorno = 0;

		for(int i = 0; i < nossoNumero.length(); i++) {
			j = j + 1;
			number = Integer.parseInt(nossoNumero.substring(i,j));
			codigoBarrasTemp.add(number);
			number = null;
		}

		for(Integer i = codigoBarrasTemp.size(); i >= 1; i--){
			m =  m - 1;
			number = codigoBarrasTemp.get(m);
			codigoBarrasTempModulo11.add(number);
			number = null;
		}

		for(Integer i = 0; i < codigoBarrasTempModulo11.size(); i++){
			m = i;
			if(m >= 0 && m <=8 ) {		
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
			number = null;
			total = 0;
			totalTemp = 0;
		}

		totalModuloDivisao = totalSoma % 11;
		retorno = 11 - totalModuloDivisao;
		totalSoma = 0;

		return String.valueOf(retorno);
	}
}
