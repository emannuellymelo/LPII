package agenda;

/**
 * Uma agenda que mantém uma lista de contatos com posições. Podem existir 100 contatos. 
 * 
 * @author Emannuelly Larissa Freitas de Melo - 119210167.
 *
 */
public class Agenda {
	
	private static final int TAMANHO_AGENDA = 100;
	private Contato[] contatos;

	/**
	 * Cria uma agenda.
	 */
	public Agenda() {
		this.contatos = new Contato[TAMANHO_AGENDA];
	}
	
	/**
	 * Acessa a lista de contatos mantida.
	 * @return O array de contatos.
	 */
	public Contato[] getContatos() {
		return this.contatos.clone();
	}

	/**
	 * Acessa os dados de um contato específico.
	 * @param posicao Posição do contato na agenda.
	 * @return Dados do contato. Null se não há contato na posição.
	 */
	public String getContato(int posicao) {
		return contatos[posicao-1].getNomeCompleto();
	}
	
	/**
	 * Acessa os números prioritários dados pelos contatos.
	 * @param posicao Posição que o contato foi cadastrado na agenda.
	 * @return O número preferido cadastrado ou "Não tem" caso não exista um número prioritário válido cadastrado.
	 */
	public String getContatoPrioritario(int posicao) {
		if(!contatos[posicao-1].getTelefones()[contatos[posicao-1].getIndicePrioridade()].equals(" ")) {
			return contatos[posicao-1].getTelefones()[contatos[posicao-1].getIndicePrioridade()];
		} else {
			return "Não tem";
		}
	}
	
	/**
	 * Acessa os números de Whatsapp informados pelo usuário.
	 * @param posicao Posição que o contato foi cadastrado na agenda.
	 * @return O número de Whatsapp cadastrado ou "Não tem" caso não exista um número válido de Whatsapp cadastrado.
	 */
	public String getContatoWhatsapp(int posicao) {
		if(!contatos[posicao-1].getTelefones()[contatos[posicao-1].getIndiceWhatsapp()].equals(" ")) {
			return contatos[posicao-1].getTelefones()[contatos[posicao-1].getIndiceWhatsapp()];
		} else {
			return "Não tem";
		}
	}
	

	/**
	 * Cadastra um contato em uma posição. Um cadastro em uma posição que já existe sobrescreve o anterior. 
	 * @param posicao Posição do contato.
	 * @param nome Nome do contato.
	 */
	public void cadastraContato(int posicao, String nome, String sobrenome, String tel1, String tel2, String tel3, int telPrioritario, int telWhatsapp) {
		Contato amigo = new Contato(posicao, nome, sobrenome, tel1, tel2, tel3, telPrioritario, telWhatsapp);
		this.contatos[posicao-1] = amigo;
	}


}
