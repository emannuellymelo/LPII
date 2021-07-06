package produto;

/**
 * Classe que representa um único produto, sem combinações, o qual possui nome, descrição e preço.
 * 
 * @author Emannuelly Larissa Freitas de Melo - Matrícula: 119210167.
 *
 */
public class ProdutoSimples extends Produto{
	
	/**
	 * Preço do produto.
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
	 * Retorna o preço do produto.
	 * 
	 * @return preco do produto.
	 */
	public double getPreco() {
		return this.preco;
	}
	
	/**
	 * Altera o preco do produto a partir de um novo dado como entrada.
	 * 
	 * @param novoValor novo preço do produto.
	 */
	public void setPreco(double novoValor) {
		this.preco = novoValor;
	}
	
	/**
	 * Representação textual do produto, apresentando seu nome, descrição e preço formatado com duas casas decimais.
	 * 
	 */
	public String toString() {
		return String.format("%s - %s - R$%,.2f", this.getNome(), this.getDescricao(), this.preco);
	}
	
	


}
