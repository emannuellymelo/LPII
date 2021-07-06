package saga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import clientes.ClientesController;
import contas.Conta;
import fornecedores.FornecedoresController;
import ordenacao.OrdenaClientes;
import ordenacao.OrdenaDatas;
import ordenacao.OrdenaFornecedores;


/**
 * Representacao de um controlador geral de contas, capaz de manipular clientes, fornecedores e contas.
 * 
 * @author Emannuelly Larissa Freitas de Melo - 119210167.
 *
 */
public class GerenciadorContasController {
	
	/**
	 * Avalia se as entradas recebidas correspondem ao que era esperado pelo sistema.
	 * 
	 */
	private VerificaEntrada verificador;
	
	/**
	 * Controlador que manipula clientes de forma direta.
	 */
	private ClientesController clientesController;
	
	/**
	 * 
	 * Controlador que manipula fornecedores de forma direta.
	 */
	private FornecedoresController fornecedoresController;
	
	/**
	 * Mapa com informacoes das contas, que sao identificados pelo cliente e pelo fornecedor envolvido na compra de um produto.
	 * 
	 */
	private HashMap<String, Conta> contas;
	
	/**
	 * Define o criterio de listagem das contas.
	 * 
	 */
	private String criterioOrdenacao;
	
	/**
	 * É invocado quando há a necessidade de ordenar pelo criterio de clientes.
	 * 
	 */
	private OrdenaClientes ordenaClientes;
	
	/**
	 * É invocado quando há a necessidade de ordenar pelo criterio de fornecedores.
	 * 
	 */
	private OrdenaFornecedores ordenaFornecedores;
	
	/**
	 * É invocado quando há a necessidade de ordenar pelo criterio de datas.
	 * 
	 */
	private OrdenaDatas ordenaDatas;
	
	/**
	 * Constrói um gerenciador de contas que é capaz de manipular dados de clientes, fornecedores e contas.
	 * 
	 */
	public GerenciadorContasController() {
		this.clientesController = new ClientesController();
		this.fornecedoresController = new FornecedoresController();
		this.contas = new HashMap<>();
		this.criterioOrdenacao = "";
	}
	
	
	/**
	 * Adiciona um cliente a partir do seu cpf, nome, email e local de trabalho.
	 * 
	 * @param cpf cpf do cliente.
	 * @param nome nome do cliente.
	 * @param email email do cliente.
	 * @param local local de trabalho do cliente.
	 * @return retorna o cpf do cliente caso o cadastro tenha sido realizado com sucesso.
	 */
	public String adicionaCliente(String cpf, String nome, String email, String local) {
		return this.clientesController.cadastraCliente(cpf, nome, email, local);
	}
	
	/**
	 * Exibe informacoes de um cliente, a partir do fornecimento do seu cpf.
	 * 
	 * @param cpf cpf do cliente.
	 * @return retorna uma representacao textual composta pelas informacoes do cliente.
	 */
	public String exibeCliente(String cpf) {
		return this.clientesController.representacaoCliente(cpf);
	}
	
	/**
	 * Exibe informacoes de todos os clientes cadastrados.
	 * 
	 * @return retorna uma representacao textual composta pelas informacoes de todos os clientes.
	 */
	public String exibeClientes() {
		return this.clientesController.representacaoGeralClientes();
	}
	
	/**
	 * Edita informacoes do cliente, a partir do fornecimento do cpf do cliente, da caracteristica a ser trocada e da nova informacao a fazer a substituicao.
	 * 
	 * @param cpf do cliente.
	 * @param atributo fator a ser alterado.
	 * @param novoValor valor a fazer a substituicao.
	 */
	public void editaCliente(String cpf, String atributo, String novoValor) {
		this.clientesController.editarCliente(cpf, atributo, novoValor);
	}
	
	/**
	 * Remove um cliente a partir do fornecimento do cpf.
	 * 
	 * @param cpf do cliente.
	 */
	public void removeCliente(String cpf) {
		this.clientesController.removerCliente(cpf);
	}
	
	/**
	 * Adiciona um fornecedor a partir do seu nome, email e telefone.
	 * 
	 * @param nome nome do fornecedor.
	 * @param email email do fornecedor.
	 * @param telefone telefone do fornecedor.
	 * @return retorna o nome do fornecedor caso o cadastro tenha sido realizado com sucesso.
	 */
	public String adicionaFornecedor(String nome, String email, String telefone) {
		return this.fornecedoresController.cadastraFornecedor(nome, email, telefone);
	}
	
	/**
	 * Exibe informacoes de um fornecedor, a partir do fornecimento do seu nome.
	 * 
	 * @param nome nome do fornecedor.
	 * @return retorna a representacao textual composta por informacoes do fornecedor.
	 */
	public String exibeFornecedor(String nome) {
		return this.fornecedoresController.representacaoFornecedor(nome);
	}
	
	/**
	 * Exibe informacoes de todos os fornecedores já cadastrados.
	 * 
	 * @return retorna uma representacao textual contendo caracteristicas de todos os fornecedores.
	 */
	public String exibeFornecedores() {
		return this.fornecedoresController.representacaoGeralFornecedores();
	}
	
	/**
	 * Edita informacoes de um dado fornecedor, a partir do fonecimento do seu nome, do fator a ser alterado e da nova caracteristica que fará a substituicao.
	 * 
	 * @param nome nome do cliente.
	 * @param atributo fator a ser alterado.
	 * @param novoValor valor a fazer a substituicao.
	 */
	public void editaFornecedor(String nome, String atributo, String novoValor) {
		this.fornecedoresController.editarFornecedor(nome, atributo, novoValor);
	}
	
	/**
	 * Remove um fornecedor a partir do fornecimento do seu nome.
	 * 
	 * @param nome nome do fornecedor.
	 */
	public void removeFornecedor(String nome) {
		this.fornecedoresController.removerFornecedor(nome);
	}
	
	
	/**
	 * Adiciona um produto a partir do seu fornecedor, se nome, sua descricao e seu preco.
	 * 
	 * @param fornecedor fornecedor do produto.
	 * @param produto nome do produto.
	 * @param descricao descricao do produto.
	 * @param preco preco do produto.
	 */
	public void adicionaProduto(String fornecedor, String produto, String descricao, double preco) {
		this.fornecedoresController.cadastraProduto(fornecedor, produto, descricao, preco);
	}
	
	/**
	 * Exibe informacoes de um produto, a partir do fornecimento do seu nome, sua descricao e seu fornecedor.
	 * 
	 * @param produto nome do produto.
	 * @param descricao descricao do produto.
	 * @param fornecedor fornecedor do produto.
	 * @return retorna uma representacao textual contendo infomacoes do produto solicitado.
	 */
	public String exibeProduto(String produto, String descricao, String fornecedor) {
		return this.fornecedoresController.representacaoProduto(produto, descricao, fornecedor);
	}
	
	/**
	 * Exibe informacoes de produtos de um dado fornecedor, a partir do fornecimento do seu nome.
	 * 
	 * @param fornecedor fornecedor do produto.
	 * @return retorna uma representacao textual contendo informacoes dos produtos oferecidos pelo fornecedor dado.
	 */
	public String exibeProdutosFornecedor(String fornecedor) {
		return this.fornecedoresController.representacaoProdutosFornecedor(fornecedor);
	}
	
	/**
	 * Exibe informacoes de todos os produtos cadastrados.
	 * 
	 * @return retorna uma representacao textual contendo informacoes de todos os produtos.
	 */
	public String exibeProdutos() {
		return this.fornecedoresController.representacaoGeralProdutos();
	}
	
	/**
	 * Edita preco de um produto, a partir do fonecimento do seu nome, da sua descricao, do seu fornecedor e do novo fator que fará a substituicao de valor.
	 * 
	 * @param produto nome do produto.
	 * @param descricao descricao do produto.
	 * @param fornecedor fornecedor do produto.
	 * @param novoValor novo preco do produto.
	 */
	public void editaProduto(String produto, String descricao, String fornecedor, double novoValor) {
		this.fornecedoresController.editarProduto(produto, descricao, fornecedor, novoValor);
	}
	
	/**
	 * Remove um produto a partir do seu nome, da sua descricao e do nome do fornecedor.
	 * 
	 * @param produto nome do produto.
	 * @param descricao descricao do produto.
	 * @param fornecedor fornecedor do produto.
	 */
	public void removeProduto(String produto, String descricao, String fornecedor) {
		this.fornecedoresController.removerProduto(produto, descricao, fornecedor);
	}
	
	/**
	 * Adiciona uma compra a partir do cpf do cliente, do nome do fornecedor, da data da compra, do produto adquirido e da descricao do produto adquirido. Caso sejam passadas informacoes invalidas ou de clientes, fornecedores ou produtos que nao existem, excecoes sao lancadas e nao é permitida a realizacao do cadastro da compra.
	 * 
	 * @param cpfCliente cpf do cliente.
	 * @param nomeFornecedor nome do fornecedor.
	 * @param data data da compra.
	 * @param produto nome do produto.
	 * @param descricao descricao do produto.
	 */
	public void adicionaCompra(String cpfCliente, String nomeFornecedor, String data, String produto, String descricao) {
		this.verificador = new VerificaEntrada(cpfCliente, nomeFornecedor, data, produto, descricao, "Erro ao cadastrar compra: cpf nao pode ser vazio ou nulo.","Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo." ,"Erro ao cadastrar compra: data nao pode ser vazia ou nula." ,"Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.", "Erro ao cadastrar compra: descricao do produto nao pode ser vazia ou nula.");
		this.verificador.verificaData(data, "Erro ao cadastrar compra: data invalida.");
		if(cpfCliente.length() != 11) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: cpf invalido.");
		}else if(!this.clientesController.verificaExistenciaCliente(cpfCliente)) {
			throw new NullPointerException("Erro ao cadastrar compra: cliente nao existe.");
		} else if(!this.fornecedoresController.verificaExistenciaFornecedor(nomeFornecedor)) {
			throw new NullPointerException("Erro ao cadastrar compra: fornecedor nao existe.");
		} else if(!this.fornecedoresController.verificaExistenciaProduto(nomeFornecedor, produto, descricao)) {
			throw new NullPointerException("Erro ao cadastrar compra: produto nao existe.");
		}
		String chaveCompra = cpfCliente + " - " + nomeFornecedor;
		double valorCompra = this.fornecedoresController.getValorProduto(nomeFornecedor, produto, descricao);
		if(this.contas.containsKey(chaveCompra)) {
			this.contas.get(chaveCompra).adicionaCompra(data, produto, descricao, valorCompra);
		} else {
			this.contas.put(chaveCompra, new Conta(this.clientesController.getNomeCliente(cpfCliente), nomeFornecedor, data, produto, descricao, valorCompra));
		}
	
	}
	
	/**
	 * Retorna o valor total da conta entre um cliente e um fornecedor.
	 * 
	 * @param cpfCliente cpf do cliente.
	 * @param nomeFornecedor nome do fornecedor.
	 * @return retorna uma representacao textual com duas casas decimais do valor de debito entre o cliente e o fornecedor dados.
	 */
	public String getDebito(String cpfCliente, String nomeFornecedor) {
		this.verificador = new VerificaEntrada(cpfCliente, nomeFornecedor, "Erro ao recuperar debito: cpf nao pode ser vazio ou nulo.", "Erro ao recuperar debito: fornecedor nao pode ser vazio ou nulo.");
		this.verificador.verificaCpf(cpfCliente, "Erro ao recuperar debito: cpf invalido.");
		if(!this.clientesController.verificaExistenciaCliente(cpfCliente)) {
			throw new NullPointerException("Erro ao recuperar debito: cliente nao existe.");
		} else if(!this.fornecedoresController.verificaExistenciaFornecedor(nomeFornecedor)) {
			throw new NullPointerException("Erro ao recuperar debito: fornecedor nao existe.");
		}
		String chaveCompra = cpfCliente + " - " + nomeFornecedor;
		if(!this.contas.containsKey(chaveCompra)) {
			throw new NullPointerException("Erro ao recuperar debito: cliente nao tem debito com fornecedor.");
		}
		return this.contas.get(chaveCompra).getValorCompra();
		
		
	}
	
	/**
	 * Exibe uma representacao textual de uma conta, entre um dado cliente e fornecedor, que possui informacoes da compra realizada, isto é, cliente, fornecedor, produto, valor e data da compra.
	 * 
	 * @param cpfCliente cpf do cliente.
	 * @param nomeFornecedor nome do fornecedor.
	 * @return retorna a representacao textual de uma conta com detalhes da compra realizada entre um especifico cliente e fornecedor.
	 */
	public String exibeContas(String cpfCliente, String nomeFornecedor) {
		this.verificador = new VerificaEntrada(cpfCliente, nomeFornecedor,"Erro ao exibir conta do cliente: cpf nao pode ser vazio ou nulo.","Erro ao exibir conta do cliente: fornecedor nao pode ser vazio ou nulo.");
		this.verificador.verificaCpf(cpfCliente, "Erro ao exibir conta do cliente: cpf invalido.");
		if(!this.clientesController.verificaExistenciaCliente(cpfCliente)) {
			throw new NullPointerException("Erro ao exibir conta do cliente: cliente nao existe.");
		} else if(!this.fornecedoresController.verificaExistenciaFornecedor(nomeFornecedor)) {
			throw new NullPointerException("Erro ao exibir conta do cliente: fornecedor nao existe.");
		}
		String chaveCompra = cpfCliente + " - " + nomeFornecedor;
		if(!this.contas.containsKey(chaveCompra)) {
			throw new NullPointerException("Erro ao exibir conta do cliente: cliente nao tem nenhuma conta com o fornecedor.");
		}
		return this.contas.get(chaveCompra).exibeContaClienteFornecedor(this.clientesController.getNomeCliente(cpfCliente),nomeFornecedor);
		
	}
	
	/**
	 * Exibe a representacao textual de todas as contas de um dado cliente, que possui informacoes de todas as compras realizadas, isto é, cliente, fornecedor, produto, valor e data das compras.
	 * 
	 * @param cpfCliente cpf do cliente
	 * @return retorna a reprentacao textual de todas as contas realizadas por um cliente.
	 */
	public String exibeContasClientes(String cpfCliente) {
		this.verificador = new VerificaEntrada(cpfCliente,"Erro ao exibir contas do cliente: cpf nao pode ser vazio ou nulo.");
		this.verificador.verificaCpf(cpfCliente, "Erro ao exibir contas do cliente: cpf invalido.");
		if(!this.clientesController.verificaExistenciaCliente(cpfCliente)) {
			throw new NullPointerException("Erro ao exibir contas do cliente: cliente nao existe.");
		}
		ArrayList<Conta> listaContas = new ArrayList<>(this.contas.values());
		Collections.sort(listaContas);
		String imprimeContas = "Cliente: " + this.clientesController.getNomeCliente(cpfCliente) + " | ";
		boolean existeConta = false;
		for(Conta conta : listaContas) {
			if(conta.getCliente().equals(this.clientesController.getNomeCliente(cpfCliente))) {
				imprimeContas += conta.toString() + " | ";
				existeConta = true;
			}
		}
		int tamanho = imprimeContas.length();
		imprimeContas = imprimeContas.substring(0, tamanho-3);
		if(!existeConta) {
			throw new NullPointerException("Erro ao exibir contas do cliente: cliente nao tem nenhuma conta.");
		}
		return imprimeContas;
	}
	
	/**
	 * Define o criterio de ordenacao a partir do que a ele é fornecido. Caso seja dado um criterio diferente de "cliente", "fornecedor", ou "data", uma excecao é lançada e a definicao do criterio nao é permitida.
	 * 
	 * @param criterio criterio de ordenacao.
	 */
	public void ordenaPor(String criterio) {
		this.verificador = new VerificaEntrada(criterio, "Erro na listagem de compras: criterio nao pode ser vazio ou nulo.");
		if(!(criterio.toLowerCase().equals("cliente") || criterio.toLowerCase().equals("fornecedor") || criterio.toLowerCase().equals("data"))) {
			throw new IllegalArgumentException("Erro na listagem de compras: criterio nao oferecido pelo sistema.");
		}
		this.criterioOrdenacao = criterio;
	}
	
	/**
	 * Retorna uma representacao textual das compras cadastradas a partir de critérios. Caso o critério seja de "Cliente", uma representacao é feita colocando o cliente em evidencia, em ordem alfabética; caso o critério seja de "Fornecedor", uma representacao é feita colocando o fornecedor em evidencia, em ordem alfabética; caso o critério seja de "Data", uma representacao é feita colocando a data em evidencia, em ordem da compra mais antiga para a mais recente.
	 * 
	 * @return retorna uma listagem de compras de acordo com um criterio definido.
	 */
	public String listarCompras() {
		if(this.criterioOrdenacao.toLowerCase().equals("cliente")) {
			this.ordenaClientes = new OrdenaClientes(this.contas);
			return this.ordenaClientes.ordenacaoClientes();
		} else if(this.criterioOrdenacao.toLowerCase().equals("fornecedor")) {
			this.ordenaFornecedores = new OrdenaFornecedores(this.contas);
			return this.ordenaFornecedores.ordenaFornecedores();
		} else if(this.criterioOrdenacao.toLowerCase().equals("data")) {
			this.ordenaDatas = new OrdenaDatas(this.contas);
			return this.ordenaDatas.ordenaDatas();
		} else {
			throw new NullPointerException("Erro na listagem de compras: criterio ainda nao definido pelo sistema.");
		}
	}
	

}
