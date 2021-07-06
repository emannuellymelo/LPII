package fornecedores;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import saga.VerificaEntrada;

/**
 * 
 * Representacao de um controlador, capaz de adicionar, editar, acessar e remover fornecedores.
 * 
 * @author Emannuelly Larissa Freitas de Melo - 119210167.
 *
 */
public class FornecedoresController {
	
	/**
	 * Mapa com informacoes de fornecedores, que sao identificados pelo nome.
	 * 
	 */
	private HashMap<String, Fornecedor> fornecedores;
	
	/**
	 * 
	 * Avalia se as entradas recebidas correspondem ao que era esperado pelo sistema.
	 * 
	 */
	private VerificaEntrada verificador;
	
	/**
	 * 
	 * Constroi o manipulador de dados de fornecedores.
	 * 
	 */
	public FornecedoresController() {
		this.fornecedores = new HashMap<>();
		
	}
	
	
	/**
	 * 
	 * Verifica, a partir de um nome, se existe um fornecedor com tal nome cadastrado.
	 * 
	 * @param nome do fornecedor.
	 * @return retorna true, caso exista um fornecedor com mesmo nome cadastrado; false, caso nao exista um fornecedor com o nome fornecido.
	 */
	public boolean verificaExistenciaFornecedor(String nome) {
		this.verificador = new VerificaEntrada(nome, "Erro na verificacao da existencia de fornecedor: nome nao pode ser invalido ou nulo.");
		if(this.fornecedores.containsKey(nome)) {
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * Cadastra o fornecedor a partir do nome, email e telefone. Caso ja exista um fornecedor com o nome fornecido, é lançada uma excecao e o cadastro nao é realizado.
	 * 
	 * @param nome nome do fornecedor.
	 * @param email email do fornecedor.
	 * @param telefone telefone do fornecedor.
	 * @return retorna o nome do fornecedor cadastrado.
	 */
	public String cadastraFornecedor(String nome, String email, String telefone) {
		this.verificador = new VerificaEntrada(nome, email, telefone, "Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.", "Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.","Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
		if(this.verificaExistenciaFornecedor(nome)) {
			throw new IllegalArgumentException("Erro no cadastro de fornecedor: fornecedor ja existe.");
		}
		this.fornecedores.put(nome, new Fornecedor(nome, email, telefone));
		return this.fornecedores.get(nome).getNome();
	}
	
	/**
	 * 
	 * Retorna uma String com nome, email, e telefone do fornecedor, a partir do seu nome.
	 * 
	 * @param nome nome do fornecedor.
	 * @return retorna uma String composta por informacoes do fornecedor.
	 */
	public String representacaoFornecedor(String nome) {
		this.verificador = new VerificaEntrada(nome, "Erro na exibicao do fornecedor: fornecedor nao pode ser vazio ou nulo.");
		if(this.fornecedores.get(nome) == null) {
			throw new NullPointerException("Erro na exibicao do fornecedor: fornecedor nao existe.");
		}
		return this.fornecedores.get(nome).toString();
	}
	
	
	/**
	 * 
	 * Retorna uma String com nome, email e telefone de todos os fornecedores cadastrados.
	 * 
	 * @return retorna uma String composta por dados de todos os fornecedores.
	 */
	public String representacaoGeralFornecedores() {
		ArrayList<Fornecedor> listaFornecedores = new ArrayList<>(this.fornecedores.values());
		Collections.sort(listaFornecedores);
		String sequenciaTodosFornecedores = "";
		int contador = this.fornecedores.size();
		for(Fornecedor fornecedor : listaFornecedores) {
			sequenciaTodosFornecedores += fornecedor.toString();
			if(contador > 1) {
				sequenciaTodosFornecedores += " | ";
			}
			contador -= 1;
		}
		
		return sequenciaTodosFornecedores;
	}
	
	/**
	 * 
	 * Edita informacoes do fornecedor. Caso haja a tentativa de mudança do nome, é lançada uma exceção que não permite a concretizacao da edicao.
	 * 
	 * @param nome nome do fornecedor.
	 * @param atributo fator que deve ser alterado.
	 * @param novoValor valor que deve fazer a substituicao.
	 */
	public void editarFornecedor(String nome, String atributo, String novoValor) {
		this.verificador = new VerificaEntrada(nome, atributo, novoValor, "Erro na edicao do fornecedor: nome nao pode ser vazio ou nulo.", "Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.","Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
		if(this.fornecedores.get(nome) == null) {
			throw new NullPointerException("Erro na edicao do fornecedor: fornecedor nao existe.");
		}
		if(atributo.equals("email")) {
			this.fornecedores.get(nome).setEmail(novoValor);
		} else if (atributo.equals("telefone")) {
			this.fornecedores.get(nome).setTelefone(novoValor);
		} else if(atributo.equals("nome")) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser editado.");
		} else {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao existe.");
		}
		
	}
	
	/**
	 * 
	 * Remove um fornecedor a partir de um nome dado. Caso seja fornecido um nome não cadastrado, é lançada uma exceção que sinaliza o ato.
	 * 
	 * @param nome nome do fornecedor.
	 */
	public void removerFornecedor(String nome) {
		this.verificador = new VerificaEntrada(nome, "Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio ou nulo.");
		if(this.fornecedores.get(nome) == null) {
			throw new NullPointerException("Erro na remocao do fornecedor: fornecedor nao existe.");
		}
		this.fornecedores.remove(nome);
	}
	
	
	/**
	 * 
	 * Verifica, a partir do fornecedor, do produto e da descricao do produto se existe um produto com tais caracteristicas cadastradas.
	 * 
	 * @param fornecedor fornecedor do produto.
	 * @param produto nome do produto.
	 * @param descricao descricao do produto.
	 * @return retorna true, caso exista o produto descrito; false, caso nao exista o produto.
	 */
	public boolean verificaExistenciaProduto(String fornecedor, String produto, String descricao) {
		this.verificador = new VerificaEntrada(fornecedor, produto, descricao, "Erro na verificacao da existencia de produto: fornecedor nulo ou inválido.", "Erro na verificacao da existencia de produto: produto nulo ou inválido.", "Erro na verificacao da existencia de produto: descricao nula ou inválida.");
		return this.fornecedores.get(fornecedor).verificaExistenciaProduto(produto, descricao);
	}
	
	
	/**
	 * 
	 * Retorna o preco do produto, recuperado a partir do seu fornecedor, do produto e da sua descricao.
	 * 
	 * @param fornecedor nome do fornecedor.
	 * @param produto nome do produto.
	 * @param descricao descricao do produto.
	 * @return retorna um double com o preco do produto fornecido.
	 */
	public double getValorProduto(String fornecedor, String produto, String descricao) {
		return this.fornecedores.get(fornecedor).getPrecoProduto(produto, descricao);
	}
	
	/**
	 * 
	 * Cadastra um produto a partir do seu fornecedor, nome do produto, descricao do produto e valor do produto. Caso ja exista um produto com essas caracteristicas cadastradas ou caso o fornecedor referenciado nao exista, é lançada uma excecao e o cadastro nao é realizado.
	 * 
	 * @param fornecedor fornecedor do produto.
	 * @param produto nome do produto.
	 * @param descricao descricao do produto.
	 * @param valor preco do produto.
	 */
	public void cadastraProduto(String fornecedor, String produto, String descricao, double valor) {
		this.verificador = new VerificaEntrada(fornecedor, produto, descricao, "Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.", "Erro no cadastro de produto: nome nao pode ser vazio ou nulo.", "Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
		if(this.fornecedores.get(fornecedor) == null) {
			throw new NullPointerException("Erro no cadastro de produto: fornecedor nao existe.");
		}
		if(valor < 0) {
			throw new IllegalArgumentException("Erro no cadastro de produto: preco invalido.");
		}
		if(this.verificaExistenciaProduto(fornecedor, produto, descricao)) {
			throw new IllegalArgumentException("Erro no cadastro de produto: produto ja existe.");
		}
		
		this.fornecedores.get(fornecedor).cadastrarProduto(fornecedor, produto, descricao, valor);
	}
	
	/**
	 * 
	 * Retorna uma String com nome, descricao, fornecedor e valor do produto.
	 * 
	 * @param produto nome do produto.
	 * @param descricao descricao do produto.
	 * @param fornecedor nome do fornecedor.
	 * @return retorna uma representacao textual composta pelos dados do produto.
	 */
	public String representacaoProduto(String produto, String descricao, String fornecedor) {
		this.verificador = new VerificaEntrada(produto, descricao, fornecedor, "Erro na exibicao de produto: nome nao pode ser vazio ou nulo.", "Erro na exibicao de produto: descricao nao pode ser vazia ou nula.", "Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		if(this.fornecedores.get(fornecedor) == null) {
			throw new NullPointerException("Erro na exibicao de produto: fornecedor nao existe.");
		}
		
		return this.fornecedores.get(fornecedor).getDadosProduto(produto, descricao);
	}
	
	/**
	 * 
	 * Retorna uma String com nome, descricao, fornecedor e valor de todos os produtos desse fornecedor.
	 * 
	 * @param fornecedor fornecedor do produto.
	 * @return retorna uma representacao textual composta pelos dados de todos os produtos desse fornecedor.
	 */
	public String representacaoProdutosFornecedor(String fornecedor) {
		this.verificador = new VerificaEntrada(fornecedor, "Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		if(this.fornecedores.get(fornecedor) == null) {
			throw new NullPointerException("Erro na exibicao de produto: fornecedor nao existe.");
		}
		return this.fornecedores.get(fornecedor).getDadosProdutosFornecedor();
	}
	
	
	/**
	 * 
	 * Retorna uma String com nome, descricao, fornecedor e valor de todos os produtos cadastrados.
	 * 
	 * @return retorna uma representacao textual composta pelos dados de todos os produtos cadastrados.
	 */
	public String representacaoGeralProdutos(){
		ArrayList<Fornecedor> listaFornecedores = new ArrayList<>(this.fornecedores.values());
		Collections.sort(listaFornecedores);
		String sequenciaTodosProdutos = "";
		int contador = this.fornecedores.size();
		for(Fornecedor fornecedor : listaFornecedores) {
			if(fornecedor.getDadosProdutosFornecedor().equals("")) {
				sequenciaTodosProdutos += fornecedor.getNome() +  " -";
			} else {
				sequenciaTodosProdutos += fornecedor.getDadosProdutosFornecedor();
			}
			if(contador > 1) {
				sequenciaTodosProdutos += " | ";
			}
			contador -= 1;
		}
		
		return sequenciaTodosProdutos;
	}
	
	/**
	 * 
	 * Edita o preco do produto. Caso haja a tentativa de mudança de um produto de um fornecedor nao cadastrado, é lançada uma exceção que não permite a concretizacao da edicao.
	 * 
	 * @param produto nome do produto.
	 * @param descricao descricao do produto.
	 * @param fornecedor fornecedor do produto.
	 * @param novoValor novo preco do produto.
	 */
	public void editarProduto(String produto, String descricao, String fornecedor, double novoValor) {
		this.verificador = new VerificaEntrada(fornecedor, produto, descricao, "Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.", "Erro na edicao de produto: nome nao pode ser vazio ou nulo.", "Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
		if(novoValor < 0) {
			throw new IllegalArgumentException("Erro na edicao de produto: preco invalido.");
		} else if(this.fornecedores.get(fornecedor) == null) {
			throw new NullPointerException("Erro na edicao de produto: fornecedor nao existe.");
		}
		this.fornecedores.get(fornecedor).editarProduto(produto, descricao, novoValor);
	}
	
	/**
	 * 
	 * Remove um produto a partir do nome do produto, da descricao do produto e do nome do fornecedor. Caso seja fornecido um nome de fornecedor não cadastrado, é lançada uma exceção que sinaliza o ato.
	 * 
	 * @param produto nome do produto;
	 * @param descricao descricao do produto;
	 * @param fornecedor nome do fornecedor do produto.
	 */
	public void removerProduto(String produto, String descricao, String fornecedor) {
		this.verificador = new VerificaEntrada(fornecedor, produto, descricao, "Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.", "Erro na remocao de produto: nome nao pode ser vazio ou nulo.", "Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
		if(this.fornecedores.get(fornecedor) == null) {
			throw new NullPointerException("Erro na remocao de produto: fornecedor nao existe.");
		}
		
		this.fornecedores.get(fornecedor).removeProduto(produto, descricao);
	}
	
	
}
