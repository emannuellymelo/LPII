package saga;

import easyaccept.EasyAccept;
import saga.GerenciadorContasController;

/**
 * Classe que abstrai todo o sistema.
 * 
 * @author Emannuelly Larissa Freitas de Melo - 119210167.
 *
 */
public class Facade {
	public static void main(String[] args) {
		args = new String[] { "saga.Facade", "acceptance_test/use_case_1.txt", "acceptance_test/use_case_2.txt", "acceptance_test/use_case_3.txt", "acceptance_test/use_case_4.txt", "acceptance_test/use_case_5.txt", "acceptance_test/use_case_6.txt"};
		EasyAccept.main(args);
	}
	
	/**
	 * Controlador geral de contas, capaz de manipular clientes, fornecedores e contas.
	 * 
	 */
	public GerenciadorContasController gerenciadorContasController;
	
	/**
	 * Cria a fachada do sistema, classe que vai abstrair todo o sistema.
	 * 
	 */
	public Facade() {
		this.gerenciadorContasController = new GerenciadorContasController();
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
		return this.gerenciadorContasController.adicionaCliente(cpf, nome, email, local);
	}
	
	/**
	 * Exibe informacoes de um cliente, a partir do fornecimento do seu cpf.
	 * 
	 * @param cpf cpf do cliente.
	 * @return retorna uma representacao textual composta pelas informacoes do cliente.
	 */
	public String exibeCliente(String cpf) {
		return this.gerenciadorContasController.exibeCliente(cpf);
	}
	
	/**
	 * Exibe informacoes de todos os clientes cadastrados.
	 * 
	 * @return retorna uma representacao textual composta pelas informacoes de todos os clientes.
	 */
	public String exibeClientes() {
		return this.gerenciadorContasController.exibeClientes();
	}
	
	/**
	 * Edita informacoes do cliente, a partir do fornecimento do cpf do cliente, da caracteristica a ser trocada e da nova informacao a fazer a substituicao.
	 * 
	 * @param cpf do cliente.
	 * @param atributo fator a ser alterado.
	 * @param novoValor valor a fazer a substituicao.
	 */
	public void editaCliente(String cpf, String atributo, String novoValor) {
		this.gerenciadorContasController.editaCliente(cpf, atributo, novoValor);
	}
	
	/**
	 * Remove um cliente a partir do fornecimento do cpf.
	 * 
	 * @param cpf do cliente.
	 */
	public void removeCliente(String cpf) {
		this.gerenciadorContasController.removeCliente(cpf);
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
		return this.gerenciadorContasController.adicionaFornecedor(nome, email, telefone);
	}
	

	/**
	 * Exibe informacoes de um fornecedor, a partir do fornecimento do seu nome.
	 * 
	 * @param nome nome do fornecedor.
	 * @return retorna a representacao textual composta por informacoes do fornecedor.
	 */
	public String exibeFornecedor(String nome) {
		return this.gerenciadorContasController.exibeFornecedor(nome);
	}
	
	/**
	 * Exibe informacoes de todos os fornecedores já cadastrados.
	 * 
	 * @return retorna uma representacao textual contendo caracteristicas de todos os fornecedores.
	 */
	public String exibeFornecedores() {
		return this.gerenciadorContasController.exibeFornecedores();
	}
	

	/**
	 * Edita informacoes de um dado fornecedor, a partir do fonecimento do seu nome, do fator a ser alterado e da nova caracteristica que fará a substituicao.
	 * 
	 * @param nome nome do cliente.
	 * @param atributo fator a ser alterado.
	 * @param novoValor valor a fazer a substituicao.
	 */
	public void editaFornecedor(String nome, String atributo, String novoValor) {
		this.gerenciadorContasController.editaFornecedor(nome, atributo, novoValor);
	}
	
	/**
	 * Remove um fornecedor a partir do fornecimento do seu nome.
	 * 
	 * @param nome nome do fornecedor.
	 */
	public void removeFornecedor(String nome) {
		this.gerenciadorContasController.removeFornecedor(nome);
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
		this.gerenciadorContasController.adicionaProduto(fornecedor, produto, descricao, preco);
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
		return this.gerenciadorContasController.exibeProduto(produto, descricao, fornecedor);
	}
	
	/**
	 * Exibe informacoes de produtos de um dado fornecedor, a partir do fornecimento do seu nome.
	 * 
	 * @param fornecedor fornecedor do produto.
	 * @return retorna uma representacao textual contendo informacoes dos produtos oferecidos pelo fornecedor dado.
	 */
	public String exibeProdutosFornecedor(String fornecedor) {
		return this.gerenciadorContasController.exibeProdutosFornecedor(fornecedor);
	}
	

	/**
	 * Exibe informacoes de todos os produtos cadastrados.
	 * 
	 * @return retorna uma representacao textual contendo informacoes de todos os produtos.
	 */
	public String exibeProdutos() {
		return this.gerenciadorContasController.exibeProdutos();
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
		this.gerenciadorContasController.editaProduto(produto, descricao, fornecedor, novoValor);
	}
	
	/**
	 * Remove um produto a partir do seu nome, da sua descricao e do nome do fornecedor.
	 * 
	 * @param produto nome do produto.
	 * @param descricao descricao do produto.
	 * @param fornecedor fornecedor do produto.
	 */
	public void removeProduto(String produto, String descricao, String fornecedor) {
		this.gerenciadorContasController.removeProduto(produto, descricao, fornecedor);
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
	public void adicionaCompra(String cliente, String fornecedor, String data, String produto, String descricao) {
		this.gerenciadorContasController.adicionaCompra(cliente, fornecedor, data, produto, descricao);
	
	}
	
	/**
	 * Retorna o valor total da conta entre um cliente e um fornecedor.
	 * 
	 * @param cpfCliente cpf do cliente.
	 * @param nomeFornecedor nome do fornecedor.
	 * @return retorna uma representacao textual com duas casas decimais do valor de debito entre o cliente e o fornecedor dados.
	 */
	public String getDebito(String cliente, String fornecedor) {
		return this.gerenciadorContasController.getDebito(cliente, fornecedor);
	}
	
	/**
	 * Exibe uma representacao textual de uma conta, entre um dado cliente e fornecedor, que possui informacoes da compra realizada, isto é, cliente, fornecedor, produto, valor e data da compra.
	 * 
	 * @param cpfCliente cpf do cliente.
	 * @param nomeFornecedor nome do fornecedor.
	 * @return retorna a representacao textual de uma conta com detalhes da compra realizada entre um especifico cliente e fornecedor.
	 */
	public String exibeContas(String cliente, String fornecedor) {
		return this.gerenciadorContasController.exibeContas(cliente, fornecedor);
	}
	
	/**
	 * Exibe a representacao textual de todas as contas de um dado cliente, que possui informacoes de todas as compras realizadas, isto é, cliente, fornecedor, produto, valor e data das compras.
	 * 
	 * @param cpfCliente cpf do cliente
	 * @return retorna a reprentacao textual de todas as contas realizadas por um cliente.
	 */
	public String exibeContasClientes(String cliente) {
		return this.gerenciadorContasController.exibeContasClientes(cliente);
	}
	
	/**
	 * Define o criterio de ordenacao a partir do que a ele é fornecido. Caso seja dado um criterio diferente de "cliente", "fornecedor", ou "data", uma excecao é lançada e a definicao do criterio nao é permitida.
	 * 
	 * @param criterio criterio de ordenacao.
	 */
	public void ordenaPor(String criterio) {
		this.gerenciadorContasController.ordenaPor(criterio);
	}
	

	/**
	 * Retorna uma representacao textual das compras cadastradas a partir de critérios. Caso o critério seja de "Cliente", uma representacao é feita colocando o cliente em evidencia, em ordem alfabética; caso o critério seja de "Fornecedor", uma representacao é feita colocando o fornecedor em evidencia, em ordem alfabética; caso o critério seja de "Data", uma representacao é feita colocando a data em evidencia, em ordem da compra mais antiga para a mais recente.
	 * 
	 * @return retorna uma listagem de compras de acordo com um criterio definido.
	 */
	public String listarCompras() {
		return this.gerenciadorContasController.listarCompras();
	}
	
}
