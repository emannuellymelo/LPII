package produto;

/**
 * Classe que representa um �nico produto, sem combina��es, o qual possui nome, descri��o e pre�o.
 * 
 * @author Emannuelly Larissa Freitas de Melo - Matr�cula: 119210167.
 *
 */
public class ProdutoSimples extends Produto{
	
	/**
	 * Pre�o do produto.
	 * 
	 */
	private double preco;
	
	/**
	 * Cria um produto a partir do seu nome, descricao e preco.
	 * 
	 * @param nome nome do produto.
	 * @param descricao descricao do produto.
	 * @param preco preco do produto.
	 */
	public ProdutoSimples(String nome, String descricao, double preco) {
		super(nome, descricao);
		this.preco = preco;
	}
	
	/**
	 * Retorna o pre�o do produto.
	 * 
	 * @return preco do produto.
	 */
	public double getPreco() {
		return this.preco;
	}
	
	/**
	 * Altera o preco do produto a partir de um novo dado como entrada.
	 * 
	 * @param novoValor novo pre�o do produto.
	 */
	public void setPreco(double novoValor) {
		this.preco = novoValor;
	}
	
	/**
	 * Representa��o textual do produto, apresentando seu nome, descri��o e pre�o formatado com duas casas decimais.
	 * 
	 */
	public String toString() {
		return String.format("%s - %s - R$%,.2f", this.getNome(), this.getDescricao(), this.preco);
	}
	
	


}
