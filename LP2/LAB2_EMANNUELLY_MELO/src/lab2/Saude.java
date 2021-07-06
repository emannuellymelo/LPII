package lab2;

/**
 * Representa o estado de saúde, físico e mental, do estudante.
 * 
 * @author Emannuelly Larissa Freitas de Melo - 119210167.
 *
 */
public class Saude {
	
	/**
	 * Identificação da saúde mental do aluno. Pode ser avaliada como "boa" ou "fraca". 
	 */
	private String saude_mental;
	
	/**
	 * Identificação da saúde física do aluno. Pode ser considerada como "boa" ou "fraca".
	 */
	private String saude_fisica;
	
	/**
	 * Constrói a saúde do aluno, considerando como padrão a saúde física e mental do estudante como boa.
	 */
	public Saude() {
		this.setSaudeFisica("boa");
		this.setSaudeMental("boa");
	}
	
	/**
	 * Registra a saúde mental do estudante.
	 * 
	 * @param valor estado de saúde mental informada pelo estudante.
	 */
	
	public void defineSaudeMental(String valor) {
		this.setSaudeMental(valor);
	}
	
	/**
	 * Define a saúde física do estudante.
	 * 
	 * @param valor condição de saúde física passada pelo aluno.
	 */
	public void defineSaudeFisica(String valor) {
		this.setSaudeFisica(valor);
	}
	
	/**
	 * Retorna a avaliação geral da saúde do estudante. Caso a saúde física e mental sejam consideradas como "boa", a saúde geral é considerada "boa"; na situação de cada condição ser considerada como "fraca", a saúde do aluno é considera como "fraca"; e caso uma dessas ser "boa" e a outra "fraca", o status geral do aluno é "ok".
	 * 
	 * @return "boa", "fraca" ou "ok" dependendo da avaliação da saúde do aluno.
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
	 * Retorna a saúde mental do estudante.
	 * 
	 * @return saúde mental do aluno.
	 */
	public String getSaudeMental() {
		return this.saude_mental;
	}
	
	/**
	 * Retorna a saúde física do aluno.
	 * 
	 * @return saúde física do estudante.
	 */
	public String getSaudeFisica() {
		return this.saude_fisica;
	}
	
	/**
	 * Atualiza o estado de saúde mental.
	 * 
	 * @param condicao_mental definição da condição de saúde mental.
	 */
	public void setSaudeMental(String condicao_mental) {
		this.saude_mental = condicao_mental;
	}
	
	/**
	 * Atualiza a situação de saúde física.
	 * 
	 * @param condicao_fisica definição da condição de saúde física.
	 */
	public void setSaudeFisica(String condicao_fisica) {
		this.saude_fisica = condicao_fisica;
	}

}
