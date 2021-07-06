package agenda;

/**
 * Permite o armazenamento de dados de um contato.
 * 
 * @author Emannuelly Larissa Freitas de Melo - 119210167.
 *
 */
public class Contato {
	
	/**
	 * Posição em que o contato foi cadastrado.
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
	 * Junção do nome e do sobrenome do contato.
	 */
	private String nomeCompleto;
	
	/**
	 * Array que armazena os telefones oferecidos pelo contato.
	 */
	private String[] telefones;
	
	/**
	 * Quantidade máxima de telefones que podem ser disponibilizados pelo contato.
	 */
	private static final int QUANTIDADE_TELEFONES = 3;
	
	/**
	 * Indicação de qual dos telefones cadastrados é o prioritário.
	 */
	private int indicePrioridade;
	
	/**
	 * Indicação de qual dos telefones cadastrados é o do Whatsapp.
	 */
	private int indiceWhatsapp;
	
	/**
	 * Constrói um contato a partir das suas informações. Não permite o cadastro de informações nulas ou inválidas.
	 *  
	 * @param posicaoContato Posição em que o contato foi cadastrado.
	 * @param nome Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @param tel1 Primeiro telefone possível de ser cadastrado.
	 * @param tel2 Segundo telefone possível de ser cadastrado.
	 * @param tel3 Terceiro telefone possível de ser cadastrado.
	 * @param telPrioritario Número de telefone prioritário.
	 * @param telWhatsapp Número de Whatsapp.
	 */
	public Contato(int posicaoContato, String nome, String sobrenome, String tel1, String tel2, String tel3, int telPrioritario, int telWhatsapp) {
		if(nome == null || sobrenome == null || tel1 == null || tel2 == null || tel3 == null) {
			throw new NullPointerException("Entrada nula");
		} else if(nome.equals("") || sobrenome.equals("") || tel1.equals("") || tel2.equals("") || tel3.equals("")) {
			throw new IllegalArgumentException("Entrada inválida");
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
	 * Compara o nome do contato recém criado com algum já existente.
	 * @return true, caso já tenha sido cadastrado um contato com mesmo nome; false, se nenhum contato cadastrado possua mesmo nome.
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
	 * Gera um número inteiro que identifica cada contato de pessoas distintas.
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
	 * Retorna a posição de um contato na agenda.
	 * @return posição de um contato na agenda.
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
	 * Retorna array com os números de telefone passados pelo contato.
	 * @return array com números de telefones do contato.
	 */
	public String[] getTelefones() {
		return telefones;
	}
	
	/**
	 * Retorna o índice que identifica a posição do número prioritário no array contendo todos os telefones.
	 * @return índice que identifica o número prioritário dentre os outros telefones cadastrados.
	 */
	public int getIndicePrioridade() {
		return indicePrioridade - 1;
	}
	
	/**
	 * Retorna o índice que identifica a posição do número de whatsapp no array contendo todos os telefones.
	 * @return índice que identifica o número de whatsapp dentre os outros telefones cadastrados.
	 */
	public int getIndiceWhatsapp() {
		return indiceWhatsapp - 1;
	}

}
