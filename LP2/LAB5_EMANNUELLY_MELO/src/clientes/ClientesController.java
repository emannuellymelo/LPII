package clientes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import saga.VerificaEntrada;

/**
 * Representacao de um controlador capaz de adicionar, recuperar, editar e apagar clientes.
 * 
 * @author Emannuelly Larissa Freitas de Melo - 119210167.
 *
 */
public class ClientesController {
	
	/**
	 * Mapa com informacoes de clientes, que sao identificados pelo cpf.
	 */
	private HashMap<String, Cliente> clientes;
	
	/**
	 * Avalia se as entradas recebidas correspondem ao que era esperado pelo sistema.
	 */
	private VerificaEntrada validaEntrada;
	
	/**
	 * Constroi o manipulador de dados de clientes.
	 */
	public ClientesController() {
		this.clientes = new HashMap<>();
	}

	/**
	 * 
	 * Cadastra o cliente a partir do cpf, nome, email e localizacao. Caso ja exista um cliente com o cpf fornecido, é lançada uma excecao e o cadastro nao é realizado. 
	 * 	
	 * @param cpf do cliente.
	 * @param nome nome do cliente.
	 * @param email email do cliente.
	 * @param local localizacao de trabalho do cliente.
	 * @return cpf do cliente cadastrado.
	 */
	public String cadastraCliente(String cpf, String nome, String email, String local) {
		this.validaEntrada = new VerificaEntrada(cpf, nome, email, local, "Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.", "Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.", "Erro no cadastro do cliente: email nao pode ser vazio ou nulo.", "Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
		this.validaEntrada.verificaCpf(cpf, "Erro no cadastro do cliente: cpf invalido.");
		if(this.verificaExistenciaCliente(cpf)) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cliente ja existe.");
		}
		this.clientes.put(cpf, new Cliente(cpf, nome, email, local));
		return this.clientes.get(cpf).getCpf();
	}

	/**
	 * 
	 * Retorna uma String com nome, email, e localizacao do cliente, a partir do seu cpf.
	 * 
	 * @param cpf do cliente.
	 * @return String composto por informacoes do cliente.
	 */
	public String representacaoCliente(String cpf) {
		this.validaEntrada = new VerificaEntrada(cpf,"Erro na exibicao do cliente: cpf nao pode ser vazio ou nulo.");
		if(this.clientes.get(cpf) == null) {
			throw new NullPointerException("Erro na exibicao do cliente: cliente nao existe.");
		}
		return this.clientes.get(cpf).toString();
	}
	
	
	/**
	 * 
	 * Retorna uma String com nome, email e localizacao de todos os clientes cadastrados.
	 * 
	 * @return String composto por informacoes de todos os clientes.
	 */
	public String representacaoGeralClientes() {
		ArrayList<Cliente> listaClientes = new ArrayList<>(this.clientes.values());
		Collections.sort(listaClientes);
		String sequenciaTodosClientes = "";
		int contador = this.clientes.size();
		for(Cliente cliente : listaClientes) {
			sequenciaTodosClientes += cliente.toString();
			if(contador > 1) {
				sequenciaTodosClientes += " | ";
			}
			contador -= 1;
		}
		
		return sequenciaTodosClientes;
	}
	
	/**
	 * 
	 * Edita informacoes do cliente. Caso haja a tentativa de mudança do cpf, é lançada uma exceção que não permite a concretizacao da edicao.
	 * 
	 * @param cpf cpf do cliente.
	 * @param atributo o que se deseja alterar.
	 * @param novoValor valor que fará a substituição.
	 */
	public void editarCliente(String cpf, String atributo, String novoValor) {
		this.validaEntrada = new VerificaEntrada(cpf, atributo, novoValor,"Erro na edicao do cliente: cpf nao pode ser vazio ou nulo.", "Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.", "Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
		if(this.clientes.get(cpf) == null) {
			throw new NullPointerException("Erro na edicao do cliente: cliente nao existe.");
		}
		if(atributo.equals("nome")) {
			this.clientes.get(cpf).setNome(novoValor);
		} else if(atributo.equals("email")) {
			this.clientes.get(cpf).setEmail(novoValor);
		} else if (atributo.equals("localizacao")) {
			this.clientes.get(cpf).setLocalizacao(novoValor);
		} else if(atributo.equals("cpf")) {
			throw new IllegalArgumentException("Erro na edicao do cliente: cpf nao pode ser editado.");
		} else {
			throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao existe.");
		}
		
	}
	
	/**
	 * 
	 * Remove um cliente a partir de um dado cpf. Caso seja fornecido um cpf não cadastrado, é lançada uma exceção que sinaliza o ato.
	 * 
	 * @param cpf do cliente.
	 */
	public void removerCliente(String cpf) {
		this.validaEntrada = new VerificaEntrada(cpf, "Erro na remocao do cliente: cpf nao pode ser vazio ou nulo" );
		if(this.clientes.get(cpf) == null) {
			throw new NullPointerException("Erro na remocao do cliente: cliente nao existe.");
		}
		this.clientes.remove(cpf);
	}
	
	
	/**
	 * 
	 * Verifica, a partir de um cpf, se existe um cliente com esse cpf cadastrado.
	 * 
	 * @param cpf cpf a ser avaliado como sendo de um cliente ou não.
	 * @return true, caso o cliente ja esteja cadastrado; false, caso nao exista cliente com esse cpf.
	 */
	public boolean verificaExistenciaCliente(String cpf) {
		this.validaEntrada = new VerificaEntrada(cpf, "Erro na verificacao de existencia do cliente: cpf nao pode ser vazio ou nulo.");
		if(this.clientes.containsKey(cpf)) {
			return true;
		}
		return false;
	}
	
	
	/**
	 * 
	 * Retorna o nome do cliente a partir do cpf dado.
	 * 
	 * @param cpf do cliente.
	 * @return nome do cliente.
	 */
	public String getNomeCliente(String cpf) {
		return this.clientes.get(cpf).getNome();
	}
	

}
