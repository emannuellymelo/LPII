package contas;

import java.util.ArrayList;
import java.util.Locale;

/**
 * 
 * Representacao de uma conta entre um cliente e um fornecedor.
 * 
 * @author Emannuelly Larissa Freitas de Melo - 1192102167.
 *
 */
public class Conta implements Comparable<Conta>{
	
	/**
	 * 
	 * Nome do cliente.
	 */
	private String cliente;
	
	/**
	 * 
	 * Nome do fornecedor.
	 */
	private String fornecedor;
	
	/**
	 * 
	 * Descricao do produto adquirido.
	 */
	private String descricao;
	
	/**
	 * 
	 * Data da compra.
	 */
	private String data;
	
	/**
	 * 
	 * Array que armazena as compras efetuadas entre o fornecedor e o cliente.
	 */
	private ArrayList<Compra> compras;
	
	
	/**
	 * 
	 * Cria uma conta a partir do nome do cliente, do nome do fornecedor, da data da compra, do nome do produto, da descricao do produto e do valor da compra.
	 * 
	 * @param nomeCliente nome do cliente.
	 * @param nomeFornecedor nome do fornecedor.
	 * @param data data da compra.
	 * @param produto nome do produto.
	 * @param descricao descricao do produto.
	 * @param valorCompra preco da compra.
	 */
	public Conta(String nomeCliente, String nomeFornecedor, String data, String produto, String descricao, double valorCompra) {
		this.cliente = nomeCliente;
		this.fornecedor = nomeFornecedor;
		this.data = data;
		Compra novaCompra = new Compra(nomeCliente, nomeFornecedor, data, produto, descricao, valorCompra);
		this.descricao = descricao;
		this.compras = new ArrayList<>();
		this.compras.add(novaCompra);
	}
	
	/**
	 * 
	 * Adiciona uma compra realizada entre o cliente e o fornecedor, a partir da data da compra, do nome do produto, da descricao do produto e do valor da compra
	 * 
	 * @param data data da compra.
	 * @param produto nome do produto.
	 * @param descricao descricao do produto.
	 * @param valorCompra preco da compra.
	 */
	public void adicionaCompra(String data, String produto, String descricao, double valorCompra) {
		Compra novaCompra = new Compra(this.cliente, this.fornecedor, data, produto, descricao, valorCompra);
		this.compras.add(novaCompra);
	}
	
	/**
	 * Calcula o valor total de uma conta a partir da analise do preco de todos os produtos adquiridos.
	 * 
	 * @return retorna uma String que representa o valor total da compra com duas casas decimais.
	 */
	public String getValorCompra() {
		double somaValor = 0.00;
		for(Compra compra : this.compras) {
			somaValor += compra.getPreco();
		}
		
		return String.format(Locale.ENGLISH, "%.2f", somaValor);
		
	}
	
	/**
	 * Retorna a lista contendo todas as compras efetuadas entre o cliente e o fornecedor.
	 * 
	 * @return retorna lista de compras.
	 */
	public ArrayList<Compra> getCompras(){
		return this.compras;
	}
	
	/**
	 * Retorna a descricao de um produto.
	 * 
	 * @return retorna a descricao de um produto.
	 */
	public String getDescricaoCompra() {
		return this.descricao;
	}
	
	/**
	 * Retorna a data da compra.
	 * 
	 * @return retorna a data da compra.
	 */
	public String getData() {
		return this.data;
	}
	
	/**
	 * Exibicao da conta criada entre o cliente e o fornecedor, criada a partir do nome de um cliente e do nome do fornecedor.
	 * 
	 * @param nomeCliente nome do cliente.
	 * @param nomeFornecedor nome do fornecedor.
	 * @return retorna a representacao textual da conta.
	 */
	public String exibeContaClienteFornecedor(String nomeCliente, String nomeFornecedor) {
		String imprimeConta = "Cliente: " + nomeCliente + " | " + nomeFornecedor + " | ";
		int contador = this.compras.size();
		for(Compra compra : this.compras) {
			imprimeConta += compra.getProduto() + " - " + compra.getDataPersonalizada();
			if(contador > 1) {
				imprimeConta += " | ";
			}
			contador -= 1;
		}
		return imprimeConta;
		
	}
	
	
	/**
	 * 
	 * Representacao textual da conta.
	 * 
	 * return representacao da conta.
	 * 
	 */
	public String toString() {
		String imprimeConta = this.fornecedor + " | ";
		int contador = this.compras.size();
		for(Compra compra : this.compras) {
			imprimeConta += compra.toString();
			if(contador > 1) {
				imprimeConta += " | ";
			}
			contador -= 1;
		}
		return imprimeConta;
	}
	
	/**
	 * Retorna nome do cliente.
	 * @return nome do cliente.
	 */
	public String getCliente() {
		return this.cliente;
	}
	
	
	/**
	 * Retorna o nome do fornecedor.
	 * 
	 * @return nome do fornecedor.
	 */
	public String getFornecedor() {
		return this.fornecedor;
	}
	
	/**
	 * Compara a representacao textual entre contas.
	 * 
	 * return retorna um inteiro que representa a comparacao entre os objetos.
	 * 
	 */
	@Override
	public int compareTo(Conta conta) {
		return this.toString().compareTo(conta.toString());
	}
	

}
