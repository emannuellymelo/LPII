package fornecedor;

import java.util.HashMap;

import produto.Combo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import produto.Produto;
import produto.ProdutoSimples;
import utilidades.ComparatorProduto;

/**
 * Classe que representa um fornecedor do sistema
 * 
 * @author Aluno de per�odo anterior// Emannuelly Larissa Freitas de Melo - Matr�cula: 119210167.
 *
 */
public class Fornecedor {
	/**
	 * Nome do fornecedor
	 */
	private String nome;

	/**
	 * Email do fornecedor
	 */
	private String email;

	/**
	 * Telefone do fornecedor
	 */
	private String telefone;

	/**
	 * Hash map dos produtos que o fornecedor oferece sendo as chaves a concatenação
	 * das String que representam o nome e descrição do produto respectivamente, e
	 * os valores são os objetos que representam os produtos
	 */
	private HashMap<String, ProdutoSimples> produtos;

	/**
	 * ArrayList de Strings que são a concatenação do nome e descrição dos produtos
	 */
	private ArrayList<String> produtosCadastrados;

	/**
	 * Comparator que compara dois produtos
	 */
	private Comparator<Produto> comparador;
	
	/**
	 * Mapa com informa��es dos combos, que sao identificados pelo seu nome e descri��o.
	 * 
	 */
	private HashMap<String, Combo> combos;
	
	/**
	 * Lista com informa��es dos produtos que comp�em o combo.
	 * 
	 */
	private ArrayList<ProdutoSimples> produtosCombo;

	/**
	 * Constrói um fornecedor dado seu nome, email e telefone
	 * 
	 * @param nome     Nome do fornecedor
	 * @param email    Email do fornecedor
	 * @param telefone Telefone do fornecedor
	 */
	public Fornecedor(String nome, String email, String telefone) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;

		this.produtos = new HashMap<String, ProdutoSimples>();
		this.produtosCadastrados = new ArrayList<String>();
		this.comparador = new ComparatorProduto();
		this.combos = new HashMap<String, Combo>();
	}

	/**
	 * Retorna a representação textual do fornecedor no formato "Nome" - "Email" -
	 * "Telefone"
	 */
	@Override
	public String toString() {
		return this.getNome() + " - " + this.getEmail() + " - " + this.getTelefone();
	}

	/**
	 * Compara dois fornecedores pelo nome
	 */
	@Override
	public boolean equals(Object o) {
		if (o != null && o instanceof Fornecedor) {
			Fornecedor f = (Fornecedor) o;

			if (this.getNome().equals(f.getNome())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Gera o hashCode do fornecedor baseado no nome
	 */
	@Override
	public int hashCode() {
		return this.getNome().hashCode();
	}

	/**
	 * Retorna o nome do fornecedor
	 * 
	 * @return String contendo o nome do fornecedor
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Retorna o telefone do fornecedor
	 * 
	 * @return String contendo o telefone do fornecedor
	 */
	private String getTelefone() {
		return this.telefone;
	}

	/**
	 * Retorna o email do fornecedor
	 * 
	 * @return String contendo o email do fornecedor
	 */
	private String getEmail() {
		return this.email;
	}

	/**
	 * Redefine o email do fornecedor dado o novo valor
	 * 
	 * @param email Novo email do fornecedor
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Redefine o telefone do fornecedor dado o novo valor
	 * 
	 * @param telefone Novo numero de telefone do fornecedor
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * Adiciona um produto ao forncedor dado o nome, descricao e preco do produto
	 * 
	 * @param nome      Nome do produto
	 * @param descricao Descricao do produto
	 * @param preco     Preco do produto
	 */
	public void adicionaProduto(String nome, String descricao, double preco) {
		String key = nome + descricao;

		if (this.produtos.containsKey(key)) {
			throw new IllegalArgumentException("Erro no cadastro de produto: produto ja existe.");
		}

		this.produtos.put(key, new ProdutoSimples(nome, descricao, preco));
		this.produtosCadastrados.add(key);

		for (int i = this.produtosCadastrados.size() - 1; i > 0; i--) {
			String produto1 = this.produtosCadastrados.get(i);
			String produto2 = this.produtosCadastrados.get(i - 1);

			Produto p1 = this.produtos.get(produto1);
			Produto p2 = this.produtos.get(produto2);

			int compare = this.comparador.compare(p1, p2);

			if (compare < 0) {
				Collections.swap(this.produtosCadastrados, i, i - 1);
			}
		}
	}

	/**
	 * Exibe um produto do fornecedor dado o nome e a descricao do produto
	 * 
	 * @param nome      Nome do produto
	 * @param descricao Descricao do produto
	 * @return Representação String do produto
	 */
	public String exibeProduto(String nome, String descricao) {
		if (!this.produtos.containsKey(nome + descricao)) {
			throw new IllegalArgumentException("Erro na exibicao de produto: produto nao existe.");
		}

		return this.produtos.get(nome + descricao).toString();
	}

	/**
	 * Lista todos os produtos do forncedor em ordem alfabética do nome do produto
	 * 
	 * @return String contendo a lista de todos os produtos do fornecedor
	 */
	public String listaProdutos() {
		String retorno = this.getNome() + " -";

		for (int i = 0; i < this.produtosCadastrados.size(); i++) {
			String produto = this.produtosCadastrados.get(i);

			if (i == 0) {
				retorno += " " + this.produtos.get(produto).toString();
			}

			else {
				retorno += " | " + this.getNome() + " - " + this.produtos.get(produto).toString();
			}
		}

		return retorno;
	}

	/**
	 * Edita o preco de um produto do fornecedor dado o nome e descricao do produto
	 * e o novo preco
	 * 
	 * @param nome      Nome do produto
	 * @param descricao Descricao do produto
	 * @param novoPreco Novo preco do produto
	 */
	public void editaProduto(String nome, String descricao, double novoPreco) {
		String key = nome + descricao;

		if (!this.produtos.containsKey(key)) {
			throw new IllegalArgumentException("Erro na edicao de produto: produto nao existe.");
		}

		this.produtos.get(key).setPreco(novoPreco);

	}

	/**
	 * Remove um produto do fornecedor
	 * 
	 * @param nome      Nome do produto
	 * @param descricao Descricao do produto
	 */
	public void removeProduto(String nome, String descricao) {
		String key = nome + descricao;

		if (!this.produtos.containsKey(key)) {
			throw new IllegalArgumentException("Erro na remocao de produto: produto nao existe.");
		}

		this.produtos.remove(key);

		this.produtosCadastrados.remove(key);
	}

	/**
	 * Retorna o preco de um produto dado o nome e descricao do produto
	 * 
	 * @param nomeProduto      Nome do produto
	 * @param descricaoProduto Descricao do produto
	 * @return Preco do produto
	 */
	public double getPrecoProduto(String nomeProduto, String descricaoProduto) {
		if (!this.produtos.containsKey(nomeProduto + descricaoProduto)) {
			throw new IllegalArgumentException("Erro ao pegar preco do produto: produto nao existe.");
		}

		return this.produtos.get(nomeProduto + descricaoProduto).getPreco();
	}
	
	/**
	 * Adiciona um combo a partir do seu nome, da sua descri��o, do seu fator de desconto(que deve ser um n�mero entre 0 e 1) e dos produtos que o comp�e.
	 * 
	 * @param nomeCombo nome do combo.
	 * @param descricaoCombo descri��o da composi��o do combo.
	 * @param fator fator de desconto do combo.
	 * @param produtos produtos que comp�em o combo.
	 */
	public void adicionaCombo(String nomeCombo, String descricaoCombo, double fator, String produtos) {
		this.produtosCombo = new ArrayList<>();
		String key = nomeCombo + " - " + descricaoCombo;
		String[] separacao = produtos.split(", ");
		if(this.combos.containsKey(key)) {
			throw new IllegalArgumentException("Erro no cadastro de combo: combo ja existe.");
		} else if(this.combos.get(separacao[0]) != null || this.combos.get(separacao[1]) != null) {
			throw new IllegalArgumentException("Erro no cadastro de combo: um combo nao pode possuir combos na lista de produtos.");
		}
		for(String produto : separacao) {
			String[] selecaoProdutos;
			selecaoProdutos = produto.split(" - ");
			if(this.produtos.get(selecaoProdutos[0] + selecaoProdutos[1]) == null) {
				throw new NullPointerException("Erro no cadastro de combo: produto nao existe.");
			}
			this.produtosCombo.add(this.produtos.get(selecaoProdutos[0] + selecaoProdutos[1]));
		}
		this.combos.put(key, new Combo(nomeCombo, descricaoCombo, fator, this.produtosCombo));
		this.adicionaProduto(nomeCombo, descricaoCombo, this.combos.get(key).getPrecoCombo());
	}
	
	/**
	 * Edita o fator de desconto do combo, a partir do fornecimento do nome do combo, da descricao do combo e a partir do novo valor de fator que deve ser utilizado. Caso seja passado um novo fator de valor menor ou igual a zero ou maior ou igual a um � lan�ada uma exce��o que impede a edi��o do fator.
	 * 
	 * @param nomeCombo nome do combo a ser editado.
	 * @param descricaoCombo descri��o da composi��o do combo.
	 * @param novoFator novo fator de desconto do combo.
	 */
	public void editaCombo(String nomeCombo, String descricaoCombo, double novoFator) {
		String key = nomeCombo + " - " + descricaoCombo;
		if(this.produtos.get(nomeCombo + descricaoCombo) == null) {
			throw new NullPointerException("Erro na edicao de combo: produto nao existe.");
		}
		this.combos.get(key).setFator(novoFator);
		this.editaProduto(nomeCombo, descricaoCombo, this.combos.get(key).getPrecoCombo());
	}

}
