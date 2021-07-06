package lab2;

/**
 * Representação de uma conta de cantina, a qual possui controle dos itens adquiridos pelos alunos e dos valores pagos por eles.  
 * 
 * @author Emannuelly Larissa Freitas de Melo - 119210167.
 *
 */

public class ContaCantina {
	
	/**
	 * Identificação da cantina em que será gerada a conta a partir do seu nome.
	 */
	private String nome;
	
	/**
	 * Registro dos itens consumidos por determinado aluno.
	 */
	private int itens;
	
	/**
	 * Identificação do valor total gasto pelo aluno na cantina.
	 */
	private int valor;
	
	/**
	 * Indica o pagamento realizado pelo estudante.
	 */
	private int pago;
	
	/**
	 * Constrói uma conta na cantina a partir da identificação do nome da cantina.
	 * 
	 * @param nomeDaCantina define a cantina em que o aluno vai criar a conta.
	 */
	public ContaCantina(String nomeDaCantina) {
		this.nome = nomeDaCantina;
	}
	
	/**
	 * Registra a quantidade de itens adquiridos pelo estudante e o valor gasto na compra.
	 * 
	 * @param qtdItens refere-se a quantidade de itens comprados.
	 * @param valorCentavos indica o valor, em centavos, gasto nessa aquisição.
	 */
	public void cadastraLanche(int qtdItens, int valorCentavos) {
		this.setItens(this.getItens() + qtdItens);
		this.setValor(this.getValor() + valorCentavos);
	}
	
	/**
	 * Controla a quantia paga pelo estudante na compra realizada na cantina.
	 * 
	 * @param valorCentavos quantia, em centavos, utilizada para efetuar o pagamento.
	 */
	public void pagaConta(int valorCentavos) {
		this.setPago(this.getPago() + valorCentavos);	
	}
	
	/**
	 * Retorna a quantia que o estudante deve à cantina.
	 * 
	 * @return valor que ainda deve ser pago pelo aluno para a cantina.
	 */
	public int getFaltaPagar() {
		return this.getValor() - this.getPago();
	}
	
	/**
	 * Retorna uma String que informa o nome do aluno, a quantidade de itens comprados por ele e o valor total gasto por ele na cantina.
	 * 
	 */
	public String toString() {
		return this.getNome() + " " + this.getItens() + " " + this.getValor();	
	}
	
	/**
	 * Retorna a quantidade de itens consumidos pelo estudante.
	 * 
	 * @return número de itens adquiridos.
	 */
	public int getItens() {
		return this.itens;
	}
	
	/**
	 * Retorna o valor total gasto pelo aluno na cantina.
	 * 
	 * @return quantia total de gastos do estudante.
	 */
	public int getValor() {
		return this.valor;
	}
	
	/**
	 * Retorna o nome da cantina em que o estudante abriu a conta.
	 * 
	 * @return o nome da cantina.
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * Retorna o pagamento já efetuado pelo estudante.
	 * 
	 * @return valor pago pelo aluno à cantina.
	 */
	public int getPago() {
		return this.pago;
	}
	
	/**
	 * Atualiza o nome da cantina em que será criada uma conta.
	 * 
	 * @param nome nome da cantina.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Atualiza a quantidade de itens consumidos pelo aluno.
	 * 
	 * @param quantidade_itens número de itens comprados.
	 */
	public void setItens(int quantidade_itens) {
		this.itens = quantidade_itens;
	}
	
	/**
	 * Atualiza o valor total investido pelo aluno na cantina.
	 * 
	 * @param valor valor gasto na cantina.
	 */
	public void setValor(int valor) {
		this.valor = valor;
	}
	
	/**
	 * Atualiza a quantia paga pelo estudante à cantina.
	 * 
	 * @param pagamento valor pago pelo estudante.
	 */
	public void setPago(int pagamento) {
		this.pago = pagamento;
	}

}

