package clientes;

/**
 * 
 * Representacao de um cliente.
 * 
 * @author Emannuelly Larissa Freitas de Melo - 119210167.
 *
 */
public class Cliente implements Comparable<Cliente>{
	
	/**
	 * Cpf do cliente.
	 * 
	 */
	private String cpf;
	
	/**
	 * 
	 * Nome do cliente.
	 */
	private String nome;
	
	/**
	 * Email do cliente.
	 * 
	 */
	private String email;
	
	/**
	 * Local de trabalho do cliente.
	 * 
	 */
	private String local;
	
	/**
	 * 
	 * Constrói um cliente a partir do seu cpf, nome, email e local de trabalho.
	 * 
	 * @param cpf cpf do cliente.
	 * @param nome nome do cliente.
	 * @param email email do cliente.
	 * @param local local de trabalho do cliente.
	 */
	public Cliente(String cpf, String nome, String email, String local){
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.local = local;	
	}
	
	/**
	 * Retorna o cpf do cliente.
	 * 
	 * @return cpf do cliente.
	 */
	public String getCpf() {
		return this.cpf;
	}
	
	/**
	 * Retorna o nome do cliente.
	 * 
	 * @return nome do cliente.
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * Altera o nome do cliente a partir de um novo dado.
	 * @param nome nome a fazer substituicao.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Altera o email do cliente a partir de um novo dado.
	 * @param email email a fazer substituicao.
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Altera o local de trabalho do cliente a partir de um novo dado.
	 * @param localizacao localizacao a fazer substituicao.
	 */
	public void setLocalizacao(String localizacao) {
		this.local = localizacao;
	}

	/**
	 * Representacao textual de um cliente, a partir do seu nome, local de trabalho e email.
	 * 
	 * return representacao textual de um cliente.
	 */
	@Override
	public String toString() {
		return this.nome + " - " + this.local + " - " + this.email;
	}

	/**
	 * 
	 * Retorna um inteiro que representa unicamente um cliente.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	/**
	 * 
	 * Permite a comparacao entre clientes, a partir do seu cpf.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

	/**
	 * Compara clientes a partir da sua representacao textual.
	 * 
	 * retorna um inteiro que representa a comparacao entre dois clientes.
	 */
	@Override
	public int compareTo(Cliente cliente) {
		return this.toString().compareTo(cliente.toString());
	}
	
	

}
