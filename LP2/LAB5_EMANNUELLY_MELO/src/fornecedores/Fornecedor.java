package fornecedores;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * 
 * Representacao de um fornecedor de produtos.
 * 
 * @author Emannuelly Larissa Freitas de Melo - 119210167.
 *
 */
public class Fornecedor implements Comparable<Fornecedor>{
	
	/**
	 * Nome do fornecedor.
	 * 
	 */
	private String nome;
	
	/**
	 * Email do fornecedor.
	 * 
	 */
	private String email;
	
	/**
	 * 
	 * Telefone do fornecedor.
	 * 
	 */
	private String telefone;
	
	/**
	 * 
	 * Mapa com informacoes dos produtos, que sao identificados pelo nome.
	 * 
	 */
	private HashMap<String, Produto> produtos;
	
	/**
	 * 
	 * Constrói um fornecedor a partir do seu nome, email e telefone.
	 * 
	 * @param nome nome do fornecedor.
	 * @param email email do fornecedor.
	 * @param telefone telefone do fornecedor.
	 */
	public Fornecedor(String nome, String email, String telefone) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.produtos = new HashMap<>();
	}
	
	
	/**
	 * 
	 * Retorna o nome do fornecedor.
	 * 
	 * @return retorna o nome do fornecedor.
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * 
	 * Permite a alteracao do email a partir de um novo fornecido.
	 * 
	 * @param email email que fará a substituicao.
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	/**
	 * 
	 * Permite a alteracao do telefone a partir de um novo fornecido.
	 * 
	 * @param telefone que fará a substituicao.
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
	/**
	 * 
	 * Representacao textual de um fornecedor.
	 * 
	 */
	@Override
	public String toString() {
		return nome + " - " + email + " - " + telefone;
	}
	
	/**
	 * 
	 * Verifica se existe um produto com caracteristicas de nome de produto e descricao de produto fornecidas.
	 * 
	 * @param produto nome do produto.
	 * @param descricao descricao do produto.
	 * @return retorna true, caso exista o produto descrito; false, caso nao exista o produto.
	 */
	public boolean verificaExistenciaProduto(String produto, String descricao) {
		String chaveProduto = produto + " - " + descricao;
		if(this.produtos.containsKey(chaveProduto)) {
			return true;
		}
		return false;
	}
	
	
	/**
	 * 
	 * Retorna o preco de um produto.
	 * 
	 * @param produto nome do produto.
	 * @param descricao descricao do produto.
	 * @return retorna o preco de um produto.
	 */
	public double getPrecoProduto(String produto, String descricao) {
		String chaveProduto = produto + " - " + descricao;
		return this.produtos.get(chaveProduto).getPrecoProduto();
	}
	
	/**
	 * 
	 * Cadastra um produto a partir do seu fornecedor, nome do produto, descricao do produto e valor do produto.
	 * 
	 * @param fornecedor fornecedor do produto.
	 * @param produto nome do produto.
	 * @param descricao descricao do produto.
	 * @param valor preco do produto.
	 */
	public void cadastrarProduto(String fornecedor, String produto, String descricao, double valor) {
		String chaveProduto = produto + " - " + descricao;
		Produto novoProduto = new Produto(produto, descricao, valor);
		this.produtos.put(chaveProduto, novoProduto);
	}
	
	/**
	 * 
	 * Retorna infomacoes de um produto, recuperado a partir do seu nome e sua descricao. Caso haja a tentativa de acessar um produto nao cadastrado, é lancada uma exceção que  que sinaliza o ato.
	 * 
	 * @param produto nome do produto.
	 * @param descricao descricao do produto.
	 * @return retorna uma representacao textual composta pelas informacoes do produto.
	 */
	public String getDadosProduto(String produto, String descricao) {
		String chaveProduto = produto + " - " + descricao;
		if(!this.produtos.containsKey(chaveProduto)) {
			throw new NullPointerException("Erro na exibicao de produto: produto nao existe.");
		}
		return this.produtos.get(chaveProduto).toString();
	}
	
	
	/**
	 * 
	 * Retorna informacoes de produtos de um fornecedor especifico.
	 * 
	 * @return retorna uma representacao textual com informacoes de produtos de um dado fornecedor.
	 */
	public String getDadosProdutosFornecedor(){
		ArrayList<Produto> listaProdutos = new ArrayList<>(this.produtos.values());
		Collections.sort(listaProdutos);
		String sequenciaProdutos = "";
		int contador = this.produtos.size();
		for(Produto produto : listaProdutos) {
			sequenciaProdutos += this.nome + " - ";
			sequenciaProdutos += produto.toString();
			if(contador > 1) {
				sequenciaProdutos += " | ";
			}
			contador -= 1;
		}
		return sequenciaProdutos;
	}
	
	
	/**
	 * 
	 * Edita o preco do produto.
	 * 
	 * @param produto nome do produto.
	 * @param descricao descricao do produto.
	 * @param novoValor novo valor do produto.
	 */
	public void editarProduto(String produto, String descricao, double novoValor) {
		String chaveProduto = produto + " - " + descricao;
		if(!this.produtos.containsKey(chaveProduto)) {
			throw new NullPointerException("Erro na edicao de produto: produto nao existe.");
		}
		this.produtos.get(chaveProduto).setPreco(novoValor);
	}
	
	/**
	 * 
	 * Remove um produto a partir do nome do produto e da descricao do produto.
	 * 
	 * @param produto nome do produto.
	 * @param descricao descricao do produto.
	 */
	public void removeProduto(String produto, String descricao) {
		String chaveProduto = produto + " - " + descricao;
		if(!this.produtos.containsKey(chaveProduto)) {
			throw new NullPointerException("Erro na remocao de produto: produto nao existe.");
		}
		this.produtos.remove(chaveProduto);
		
	}
	
	
	/**
	 * Compara fornecedores a partir da sua representacao textual.
	 * 
	 * retorna um inteiro que representa a comparacao entre dois fornecedores.
	 */
	@Override
	public int compareTo(Fornecedor fornecedor) {
		return this.toString().compareTo(fornecedor.toString());
	}

	/**
	 * 
	 * Retorna um inteiro que representa unicamente um fornecedor.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	/**
	 * 
	 * Permite a comparacao entre fornecedores, a partir do seu nome.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fornecedor other = (Fornecedor) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	
	
}
