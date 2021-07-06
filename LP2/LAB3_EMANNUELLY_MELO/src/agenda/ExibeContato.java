package agenda;

/**
 * Exibe todas as informações cadastradas de um contato.
 * 
 * @author Emannuelly Larissa Freitas de Melo - 119210167.
 *
 */
public class ExibeContato {
	
	/**
	 * Posição em que o contato se encontra na agenda.
	 */
	private int indicaContato;
	
	/**
	 * Agenda com contatos.
	 */
	private Agenda agenda;
	
	/**
	 * Contrói, a partir da agenda e da posição do contato, o meio para a exibição das informações do contato.
	 * 
	 * @param agenda Agenda de contatos.
	 * @param indice Posição do contato que deve ter as informações exibidas.
	 */
	public ExibeContato(Agenda agenda, int indice) {
		this.indicaContato = indice;
		this.agenda = agenda;
	}
	
	/**
	 * Analisa se a posição indicada está ocupada por um contato.
	 * @return true, caso exista um contato cadastrado na posição indicada; false, se é uma posição nula.
	 */
	public boolean validaContato() {
		if(agenda.getContato(this.indicaContato) == null) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * Retorna um String contendo nome, número prioritário e número de whatsapp passados pelo contato, se foi conferida uma posição válida. Caso contrário, retorna um String que informa que a posição informada é inválida. 
	 */
	public String toString() {
		if(validaContato()) {
			return agenda.getContato(this.indicaContato) + "\n" + agenda.getContatoPrioritario(this.indicaContato) + " (prioritário)\n" + agenda.getContatoWhatsapp(this.indicaContato) + " (zap)";
		} else {
			return "POSIÇÃO INVÁLIDA";
		}
	}

}
