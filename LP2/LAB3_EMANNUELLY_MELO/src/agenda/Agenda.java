package agenda;

/**
 * Uma agenda que mant�m uma lista de contatos com posi��es. Podem existir 100 contatos. 
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
	 * Acessa os dados de um contato espec�fico.
	 * @param posicao Posi��o do contato na agenda.
	 * @return Dados do contato. Null se n�o h� contato na posi��o.
	 */
	public String getContato(int posicao) {
		return contatos[posicao-1].getNomeCompleto();
	}
	
	/**
	 * Acessa os n�meros priorit�rios dados pelos contatos.
	 * @param posicao Posi��o que o contato foi cadastrado na agenda.
	 * @return O n�mero preferido cadastrado ou "N�o tem" caso n�o exista um n�mero priorit�rio v�lido cadastrado.
	 */
	public String getContatoPrioritario(int posicao) {
		if(!contatos[posicao-1].getTelefones()[contatos[posicao-1].getIndicePrioridade()].equals(" ")) {
			return contatos[posicao-1].getTelefones()[contatos[posicao-1].getIndicePrioridade()];
		} else {
			return "N�o tem";
		}
	}
	
	/**
	 * Acessa os n�meros de Whatsapp informados pelo usu�rio.
	 * @param posicao Posi��o que o contato foi cadastrado na agenda.
	 * @return O n�mero de Whatsapp cadastrado ou "N�o tem" caso n�o exista um n�mero v�lido de Whatsapp cadastrado.
	 */
	public String getContatoWhatsapp(int posicao) {
		if(!contatos[posicao-1].getTelefones()[contatos[posicao-1].getIndiceWhatsapp()].equals(" ")) {
			return contatos[posicao-1].getTelefones()[contatos[posicao-1].getIndiceWhatsapp()];
		} else {
			return "N�o tem";
		}
	}
	

	/**
	 * Cadastra um contato em uma posi��o. Um cadastro em uma posi��o que j� existe sobrescreve o anterior. 
	 * @param posicao Posi��o do contato.
	 * @param nome Nome do contato.
	 */
	public void cadastraContato(int posicao, String nome, String sobrenome, String tel1, String tel2, String tel3, int telPrioritario, int telWhatsapp) {
		Contato amigo = new Contato(posicao, nome, sobrenome, tel1, tel2, tel3, telPrioritario, telWhatsapp);
		this.contatos[posicao-1] = amigo;
	}


}
