package saga;

/**
 * Classe que verifica se uma entrada é valida a partir dos parametros dados.
 * 
 * @author Emannuelly Larissa Freitas de Melo - 119210167.
 *
 */
public class VerificaEntrada {
	
	/**
	 * 
	 * Constroi um verificador que analisa 3 parametros, caso esses parametros sejam nulos ou invalidos, uma exceção é lancada e uma mensagem correspondente sinaliza a situacao ocorrida.
	 * 
	 * @param parametro1 primeiro parametro de analise.
	 * @param parametro2 segundo parametro de analise.
	 * @param parametro3 terceiro parametro de analise.
	 * @param mensagem1 mensagem a ser lancada caso o primeiro parametro possua uma entrada nula ou invalida.
	 * @param mensagem2 mensagem a ser lancada caso o segundo parametro possua uma entrada nula ou invalida.
	 * @param mensagem3 mensagem a ser lancada caso o terceiro parametro possua uma entrada nula ou invalida.
	 */
	public VerificaEntrada(String parametro1, String parametro2, String parametro3, String mensagem1, String mensagem2, String mensagem3) {
		if(parametro1 == null) {
			throw new NullPointerException(mensagem1);
		} else if(parametro1.equals("")) {
			throw new IllegalArgumentException(mensagem1);
		} else if(parametro2 == null) {
			throw new NullPointerException(mensagem2);
		} else if(parametro2.equals("")) {
			throw new IllegalArgumentException(mensagem2);
		} else if(parametro3 == null) {
			throw new NullPointerException(mensagem3);
		} else if(parametro3.equals("")) {
			throw new IllegalArgumentException(mensagem3);
		}
	}
	
	/**
	 * 
	 * Constroi um verificador que analisa 2 parametros, caso esses parametros sejam nulos ou invalidos, uma exceção é lancada e uma mensagem correspondente sinaliza a situacao ocorrida.
	 * 
	 * @param parametro1 primeiro parametro de analise.
	 * @param parametro2 segundo parametro de analise.
	 * @param mensagem1 mensagem a ser lancada caso o primeiro parametro possua uma entrada nula ou invalida.
	 * @param mensagem2 mensagem a ser lancada caso o segundo parametro possua uma entrada nula ou invalida.
	 */
	public VerificaEntrada(String parametro1, String parametro2, String mensagem1, String mensagem2) {
		if(parametro1 == null) {
			throw new NullPointerException(mensagem1);
		} else if(parametro1.equals("")) {
			throw new IllegalArgumentException(mensagem1);
		} else if(parametro2 == null) {
			throw new NullPointerException(mensagem2);
		} else if(parametro2.equals("")) {
			throw new IllegalArgumentException(mensagem2);
		}
	}
	
	/**
	 * 
	 * Constroi um verificador que analisa 1 parametro, caso esse parametro seja nulo ou invalido, uma exceção é lancada e uma mensagem correspondente sinaliza a situacao ocorrida.
	 * 
	 * @param parametro1 primeiro parametro de analise.
	 * @param mensagem1 mensagem a ser lancada caso o primeiro parametro possua uma entrada nula ou invalida.
	 */
	public VerificaEntrada(String parametro1, String mensagem1) {
		if(parametro1 == null) {
			throw new NullPointerException(mensagem1);
		} else if(parametro1.equals("")) {
			throw new IllegalArgumentException(mensagem1);
		}
	}
	
	/**
	 * 
	 * Constroi um verificador que analisa 4 parametros, caso esses parametros sejam nulos ou invalidos, uma exceção é lancada e uma mensagem correspondente sinaliza a situacao ocorrida.
	 * 
	 * @param parametro1 primeiro parametro de analise.
	 * @param parametro2 segundo parametro de analise.
	 * @param parametro3 terceiro parametro de analise.
	 * @param parametro4 quarto parametro de analise.
	 * @param mensagem1 mensagem a ser lancada caso o primeiro parametro possua uma entrada nula ou invalida.
	 * @param mensagem2 mensagem a ser lancada caso o segundo parametro possua uma entrada nula ou invalida.
	 * @param mensagem3 mensagem a ser lancada caso o terceiro parametro possua uma entrada nula ou invalida.
	 * @param mensagem4 mensagem a ser lancada caso o quarto parametro possua uma entrada nula ou invalida.
	 */
	public VerificaEntrada(String parametro1, String parametro2, String parametro3, String parametro4, String mensagem1, String mensagem2, String mensagem3, String mensagem4) {
		if(parametro1 == null) {
			throw new NullPointerException(mensagem1);
		} else if(parametro1.equals("")) {
			throw new IllegalArgumentException(mensagem1);
		} else if(parametro2 == null) {
			throw new NullPointerException(mensagem2);
		} else if(parametro2.equals("")) {
			throw new IllegalArgumentException(mensagem2);
		} else if(parametro3 == null) {
			throw new NullPointerException(mensagem3);
		} else if(parametro3.equals("")) {
			throw new IllegalArgumentException(mensagem3);
		} else if(parametro4 == null) {
			throw new NullPointerException(mensagem4);
		} else if(parametro4.equals("")) {
			throw new IllegalArgumentException(mensagem4);
		}
	}
	
	/**
	 * 
	 * Constroi um verificador que analisa 5 parametros, caso esses parametros sejam nulos ou invalidos, uma exceção é lancada e uma mensagem correspondente sinaliza a situacao ocorrida.
	 * 
	 * @param parametro1 primeiro parametro de analise.
	 * @param parametro2 segundo parametro de analise.
	 * @param parametro3 terceiro parametro de analise.
	 * @param parametro4 quarto parametro de analise.
	 * @param parametro5 quinto parametro de analise.
	 * @param mensagem1 mensagem a ser lancada caso o primeiro parametro possua uma entrada nula ou invalida.
	 * @param mensagem2 mensagem a ser lancada caso o segundo parametro possua uma entrada nula ou invalida.
	 * @param mensagem3 mensagem a ser lancada caso o terceiro parametro possua uma entrada nula ou invalida.
	 * @param mensagem4 mensagem a ser lancada caso o quarto parametro possua uma entrada nula ou invalida.
	 * @param mensagem5 mensagem a ser lancada caso o quinto parametro possua uma entrada nula ou invalida.
	 */
	public VerificaEntrada(String parametro1, String parametro2, String parametro3, String parametro4, String parametro5, String mensagem1, String mensagem2, String mensagem3, String mensagem4, String mensagem5) {
		if(parametro1 == null) {
			throw new NullPointerException(mensagem1);
		} else if(parametro1.equals("")) {
			throw new IllegalArgumentException(mensagem1);
		} else if(parametro2 == null) {
			throw new NullPointerException(mensagem2);
		} else if(parametro2.equals("")) {
			throw new IllegalArgumentException(mensagem2);
		} else if(parametro3 == null) {
			throw new NullPointerException(mensagem3);
		} else if(parametro3.equals("")) {
			throw new IllegalArgumentException(mensagem3);
		} else if(parametro4 == null) {
			throw new NullPointerException(mensagem4);
		} else if(parametro4.equals("")) {
			throw new IllegalArgumentException(mensagem4);
		} else if(parametro5 == null) {
			throw new NullPointerException(mensagem5);
		} else if(parametro5.equals("")) {
			throw new IllegalArgumentException(mensagem5);
		} 
	}
	
	/**
	 * 
	 * Analisa se uma data é coerente em termos de meses, dias e anos possíveis de serem computados.
	 * 
	 * @param data mes, dia e ano.
	 * @param mensagem mensagem a ser lancada caso a data seja invalida.
	 */
	public void verificaData(String data, String mensagem) {
		String[] partesData = data.split("/");
		int dia = Integer.parseInt(partesData[0]);
		int mes = Integer.parseInt(partesData[1]);
		int ano = Integer.parseInt(partesData[2]);
		if(dia > 31 || dia < 1 || mes < 1 || mes > 12 || ano > 2020) {
			throw new IllegalArgumentException(mensagem);
		}
		
	}
	
	/**
	 * 
	 * Verifica se um cpf é valido. Se o cpf dado possui uma quantidade de numeros diferente de 11 uma exceção é lançada.
	 * 
	 * @param cpf cpf do cliente.
	 * @param mensagem mensagem a ser lancada caso o cpf seja invalido.
	 */
	public void verificaCpf(String cpf, String mensagem) {
		if(cpf.length() != 11) {
			throw new IllegalArgumentException(mensagem);
		}
	}

}
