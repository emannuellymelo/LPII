package contas;


/**
 * Representacao de uma compra entre um fornecedor e um cliente.
 * 
 * @author Emannuelly Larissa Freitas de Melo - 119210167.
 *
 */
public class Compra {
	
	/**
	 * Data da compra.
	 * 
	 */
	private String data;
	
	/**
	 * Nome do produto adquirido.
	 */
	private String produto;
	
	/**
	 * Descricao do produto adquirido.
	 * 
	 */
	private String descricao;
	
	/**
	 * Valor da compra.
	 * 
	 */
	private double valor;
	
	/**
	 * Nome do cliente.
	 * 
	 */
	private String nomeCliente;
	
	/**
	 * Nome do fornecedor.
	 * 
	 */
	private String nomeFornecedor;
	
	/**
	 * Cria uma compra a partir de um cliente, de um fornecedor, de uma data de compra, de um nome de produto, da descricao do produto e do valor da compra.
	 * 
	 * @param cliente nome do cliente.
	 * @param fornecedor nome do fornecedor.
	 * @param data data da compra.
	 * @param produto nome do produto.
	 * @param descricao descricao do produto.
	 * @param valorCompra preco da compra.
	 */
	public Compra(String cliente, String fornecedor, String data, String produto, String descricao, double valorCompra) {
		this.nomeCliente = cliente;
		this.nomeFornecedor = fornecedor;
		this.data = data;
		this.produto = produto;
		this.descricao = descricao;
		this.valor = valorCompra;
	}
	
	/**
	 * Retorna o nome do cliente.
	 * 
	 * @return nome do cliente.
	 */
	public String getNomeCliente() {
		return this.nomeCliente;
	}
	
	/**
	 * Retorna o nome do fornecedor.
	 * 
	 * @return nome do fornecedor.
	 */
	public String getNomeFornecedor() {
		return this.nomeFornecedor;
	}
	
	/**
	 * Retorna o preco da compra.
	 * 
	 * @return preco da compra.
	 */
	public double getPreco() {
		return this.valor;
	}
	
	/**
	 * Retorna o nome do produto.
	 * 
	 * @return nome do produto.
	 */
	public String getProduto() {
		return this.produto;
	}
	
	/**
	 * Retorna a descricao da compra.
	 * 
	 * @return descricao da compra.
	 */
	public String getDescricaoCompra() {
		return this.descricao;
	}
	
	/**
	 * Retorna data na forma em que foi fornecida.
	 * 
	 * @return data fornecida.
	 */
	public String getDataOriginal() {
		return this.data;
	}
	
	/**
	 * Retorna data com diferente formatacao.
	 * 
	 * @return data formatada.
	 */
	public String getDataPersonalizada() {
		return this.data.replaceAll("/", "-");
	}
	
	/**
	 * Retorna ano da compra.
	 * 
	 * @return ano da compra.
	 */
	public int getAno() {
		return Integer.parseInt(this.data.substring(6, 10));
	}
	
	/**
	 * Retorna mes da compra.
	 * 
	 * @return mes da compra.
	 */
	public int getMes() {
		return Integer.parseInt(this.data.substring(3, 5));
	}
	
	/**
	 * Retorna dia da compra.
	 * 
	 * @return dia da compra.
	 */
	public int getDia() {
		return Integer.parseInt(this.data.substring(0, 2));
	}
	
	/**
	 * Retorna representacao textual da compra.
	 * 
	 * @return representacao textual da compra.
	 */
	public String toString() {
		return this.produto + " - " + this.getDataPersonalizada(); 
	}

}
