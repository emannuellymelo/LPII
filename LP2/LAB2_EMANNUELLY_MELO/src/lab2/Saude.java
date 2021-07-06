package lab2;

/**
 * Representa o estado de sa�de, f�sico e mental, do estudante.
 * 
 * @author Emannuelly Larissa Freitas de Melo - 119210167.
 *
 */
public class Saude {
	
	/**
	 * Identifica��o da sa�de mental do aluno. Pode ser avaliada como "boa" ou "fraca". 
	 */
	private String saude_mental;
	
	/**
	 * Identifica��o da sa�de f�sica do aluno. Pode ser considerada como "boa" ou "fraca".
	 */
	private String saude_fisica;
	
	/**
	 * Constr�i a sa�de do aluno, considerando como padr�o a sa�de f�sica e mental do estudante como boa.
	 */
	public Saude() {
		this.setSaudeFisica("boa");
		this.setSaudeMental("boa");
	}
	
	/**
	 * Registra a sa�de mental do estudante.
	 * 
	 * @param valor estado de sa�de mental informada pelo estudante.
	 */
	
	public void defineSaudeMental(String valor) {
		this.setSaudeMental(valor);
	}
	
	/**
	 * Define a sa�de f�sica do estudante.
	 * 
	 * @param valor condi��o de sa�de f�sica passada pelo aluno.
	 */
	public void defineSaudeFisica(String valor) {
		this.setSaudeFisica(valor);
	}
	
	/**
	 * Retorna a avalia��o geral da sa�de do estudante. Caso a sa�de f�sica e mental sejam consideradas como "boa", a sa�de geral � considerada "boa"; na situa��o de cada condi��o ser considerada como "fraca", a sa�de do aluno � considera como "fraca"; e caso uma dessas ser "boa" e a outra "fraca", o status geral do aluno � "ok".
	 * 
	 * @return "boa", "fraca" ou "ok" dependendo da avalia��o da sa�de do aluno.
	 */
	public String getStatusGeral() {
		if(this.getSaudeMental().equals("boa") && this.getSaudeFisica().equals("boa")) {
			return "boa";
		} else if(this.getSaudeMental().equals("fraca") && this.getSaudeFisica().equals("fraca")) {
			return "fraca";
		} else {
			return "ok";
		}
	}
	
	/**
	 * Retorna a sa�de mental do estudante.
	 * 
	 * @return sa�de mental do aluno.
	 */
	public String getSaudeMental() {
		return this.saude_mental;
	}
	
	/**
	 * Retorna a sa�de f�sica do aluno.
	 * 
	 * @return sa�de f�sica do estudante.
	 */
	public String getSaudeFisica() {
		return this.saude_fisica;
	}
	
	/**
	 * Atualiza o estado de sa�de mental.
	 * 
	 * @param condicao_mental defini��o da condi��o de sa�de mental.
	 */
	public void setSaudeMental(String condicao_mental) {
		this.saude_mental = condicao_mental;
	}
	
	/**
	 * Atualiza a situa��o de sa�de f�sica.
	 * 
	 * @param condicao_fisica defini��o da condi��o de sa�de f�sica.
	 */
	public void setSaudeFisica(String condicao_fisica) {
		this.saude_fisica = condicao_fisica;
	}

}
