package agenda;

/**
 * Permite o armazenamento de dados de um contato.
 * 
 * @author Emannuelly Larissa Freitas de Melo - 119210167.
 *
 */
public class Contato {
	
	/**
	 * Posi��o em que o contato foi cadastrado.
	 */
	private int posicao;
	
	/**
	 * Nome do contato.
	 */
	private String nome;
	
	/**
	 * Sobrenome do contato.
	 */
	private String sobrenome;
	
	/**
	 * Jun��o do nome e do sobrenome do contato.
	 */
	private String nomeCompleto;
	
	/**
	 * Array que armazena os telefones oferecidos pelo contato.
	 */
	private String[] telefones;
	
	/**
	 * Quantidade m�xima de telefones que podem ser disponibilizados pelo contato.
	 */
	private static final int QUANTIDADE_TELEFONES = 3;
	
	/**
	 * Indica��o de qual dos telefones cadastrados � o priorit�rio.
	 */
	private int indicePrioridade;
	
	/**
	 * Indica��o de qual dos telefones cadastrados � o do Whatsapp.
	 */
	private int indiceWhatsapp;
	
	/**
	 * Constr�i um contato a partir das suas informa��es. N�o permite o cadastro de informa��es nulas ou inv�lidas.
	 *  
	 * @param posicaoContato Posi��o em que o contato foi cadastrado.
	 * @param nome Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @param tel1 Primeiro telefone poss�vel de ser cadastrado.
	 * @param tel2 Segundo telefone poss�vel de ser cadastrado.
	 * @param tel3 Terceiro telefone poss�vel de ser cadastrado.
	 * @param telPrioritario N�mero de telefone priorit�rio.
	 * @param telWhatsapp N�mero de Whatsapp.
	 */
	public Contato(int posicaoContato, String nome, String sobrenome, String tel1, String tel2, String tel3, int telPrioritario, int telWhatsapp) {
		if(nome == null || sobrenome == null || tel1 == null || tel2 == null || tel3 == null) {
			throw new NullPointerException("Entrada nula");
		} else if(nome.equals("") || sobrenome.equals("") || tel1.equals("") || tel2.equals("") || tel3.equals("")) {
			throw new IllegalArgumentException("Entrada inv�lida");
		}
		this.posicao = posicaoContato;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.nomeCompleto = nome + " " + sobrenome;
		this.telefones = new String[QUANTIDADE_TELEFONES];
		this.telefones[0] = tel1;
		this.telefones[1] = tel2;
		this.telefones[2] = tel3;
		this.indicePrioridade = telPrioritario;
		this.indiceWhatsapp = telWhatsapp;
		
	}
	
	/**
	 * Compara o nome do contato rec�m criado com algum j� existente.
	 * @return true, caso j� tenha sido cadastrado um contato com mesmo nome; false, se nenhum contato cadastrado possua mesmo nome.
	 */
	public boolean equals(Object objeto) {
		if(objeto == null) {
			return false;
		}
		if(this.getClass() != objeto.getClass()) {
			return false;
		}
		Contato contato = (Contato) objeto;
		return this.nomeCompleto.equals(contato.nomeCompleto);
	}
	
	/**
	 * Gera um n�mero inteiro que identifica cada contato de pessoas distintas.
	 */
	public int hashCode() {
		return this.nomeCompleto.hashCode();
	}
	
	/**
	 * Retorna o nome completo do contato desejado.
	 * @return nome completo do contato.
	 */
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	
	/**
	 * Retorna a posi��o de um contato na agenda.
	 * @return posi��o de um contato na agenda.
	 */
	public int getPosicao() {
		return posicao;
	}
	
	/**
	 * Retorna o primeiro nome do contato.
	 * @return primeiro nome do contato.
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Retorna sobrenome do contato.
	 * @return sobrenome do contato.
	 */
	public String getSobrenome() {
		return sobrenome;
	}
	
	/**
	 * Retorna array com os n�meros de telefone passados pelo contato.
	 * @return array com n�meros de telefones do contato.
	 */
	public String[] getTelefones() {
		return telefones;
	}
	
	/**
	 * Retorna o �ndice que identifica a posi��o do n�mero priorit�rio no array contendo todos os telefones.
	 * @return �ndice que identifica o n�mero priorit�rio dentre os outros telefones cadastrados.
	 */
	public int getIndicePrioridade() {
		return indicePrioridade - 1;
	}
	
	/**
	 * Retorna o �ndice que identifica a posi��o do n�mero de whatsapp no array contendo todos os telefones.
	 * @return �ndice que identifica o n�mero de whatsapp dentre os outros telefones cadastrados.
	 */
	public int getIndiceWhatsapp() {
		return indiceWhatsapp - 1;
	}

}
