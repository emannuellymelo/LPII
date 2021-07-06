package agenda;

/**
 * Exibe todas as informa��es cadastradas de um contato.
 * 
 * @author Emannuelly Larissa Freitas de Melo - 119210167.
 *
 */
public class ExibeContato {
	
	/**
	 * Posi��o em que o contato se encontra na agenda.
	 */
	private int indicaContato;
	
	/**
	 * Agenda com contatos.
	 */
	private Agenda agenda;
	
	/**
	 * Contr�i, a partir da agenda e da posi��o do contato, o meio para a exibi��o das informa��es do contato.
	 * 
	 * @param agenda Agenda de contatos.
	 * @param indice Posi��o do contato que deve ter as informa��es exibidas.
	 */
	public ExibeContato(Agenda agenda, int indice) {
		this.indicaContato = indice;
		this.agenda = agenda;
	}
	
	/**
	 * Analisa se a posi��o indicada est� ocupada por um contato.
	 * @return true, caso exista um contato cadastrado na posi��o indicada; false, se � uma posi��o nula.
	 */
	public boolean validaContato() {
		if(agenda.getContato(this.indicaContato) == null) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * Retorna um String contendo nome, n�mero priorit�rio e n�mero de whatsapp passados pelo contato, se foi conferida uma posi��o v�lida. Caso contr�rio, retorna um String que informa que a posi��o informada � inv�lida. 
	 */
	public String toString() {
		if(validaContato()) {
			return agenda.getContato(this.indicaContato) + "\n" + agenda.getContatoPrioritario(this.indicaContato) + " (priorit�rio)\n" + agenda.getContatoWhatsapp(this.indicaContato) + " (zap)";
		} else {
			return "POSI��O INV�LIDA";
		}
	}

}
