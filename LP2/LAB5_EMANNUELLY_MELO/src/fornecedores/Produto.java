package fornecedores;

/**
 * Representacao de um produto.
 * 
 * @author Emannuelly Larissa Freitas de Melo - 119210167.
 *
 */
public class Produto implements Comparable<Produto>{
	
	/**
	 * Nome do produto.
	 */
	private String nome;
	
	/**
	 * Descricao do produto.
	 */
	private String descricao;
	
	/**
	 * Preco do produto.
	 * 
	 */
	private double preco;
	
	/**
	 * Controi um produto a partir do seu nome, descricao e preco.
	 * 
	 * @param produto nome do produto.
	 * @param descricao descricao do produto.
	 * @param valor preco do produto.
	 */
	public Produto(String produto, String descricao, double valor) {
		this.nome = produto;
		this.descricao = descricao;
		this.preco = valor;
	}
	
	/**
	 * Retorna o nome do produto juntamente com sua descricao.
	 * 
	 * @return retorna nome do produto juntamente com sua descricao.
	 */
	public String getNomeProduto() {
		return nome + " " + descricao;
	}
	
	
	/**
	 * Retorna o preco do produto.
	 * 
	 * @return retorna preco do produto.
	 */
	public double getPrecoProduto() {
		return this.preco;
	}
	
	/**
	 * Altera o preco do produto por meio de um novo valor dado.
	 * 
	 * @param valor novo preco do produto.
	 */
	public void setPreco(double valor) {
		this.preco = valor;
	}

	/**
	 * Representacao textual de um produto, com nome, descricao e preco.
	 * 
	 * return representacao textual de um produto.
	 * 
	 */
	@Override
	public String toString() {
		return String.format("%s - %s - R$%,.2f", this.nome, this.descricao, this.preco);
	}

	/**
	 * Compara a representacao textual entre produtos.
	 * 
	 * return retorna um inteiro que representa a comparacao entre os objetos.
	 * 
	 */
	@Override
	public int compareTo(Produto produto) {
		return this.toString().compareTo(produto.toString());
	}

	
	/** 
	 * Retorna um inteiro que representa unicamente um produto.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	/**
	 * 
	 * Permite a comparacao entre produtos, a partir do seu nome e descricao.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	

}
