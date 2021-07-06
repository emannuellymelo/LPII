package lab2;

import java.util.Arrays;

/**
 * Representa uma disciplina, que deve possuir horas de dedica��o destinadas pelo aluno e deve apresentar 4 notas.
 * 
 * @author Emannuelly Larissa Freitas de Melo - 119210167.
 *
 */
public class Disciplina {
	
	/**
	 * Identifica��o da disciplina a partir do seu nome.
	 */
	private String nome;
	
	/**
	 * Defini��o do tempo dedicado pelo aluno � mat�ria em horas.
	 */
	private int horas;
	
	/**
	 * Array que deve conter as notas do estudante.
	 */
	private double[] notas;
	
	/**
	 * Regristro do peso que cada prova possui.
	 */
	private int[] pesosProva;
	
	/**
	 * Indica a quantidade de notas que a disciplina � composta.
	 */
	private int quantidadeNotasDisciplina;
	
	/**
	 * Informa a quantidade padr�o de notas que a disciplina � composta.
	 */
	private final int QUANTIDADE_NOTAS_PADRAO = 4;
	
	/**
	 * Informa a m�dia para aprova��o na mat�ria.
	 */
	private final double MEDIA_PARA_APROVACAO = 7.0;
	
	/**
	 * Constr�i uma disciplina a partir do seu nome e da quantidade de notas por ela composta. Todo aluno inicia a mat�ria com a hora de dedica��o � ela e com as notas nulas.
	 * 
	 * @param nomeDisciplina nome da disciplina que ser� gerada.
	 * @param quantidadeNotas quantidade de notas que comp�e a mat�ria.
	 */
	public Disciplina(String nomeDisciplina, int quantidadeNotas) {
		this.nome = nomeDisciplina;
		this.quantidadeNotasDisciplina = quantidadeNotas;
		this.notas = new double[quantidadeNotas];
	}
	
	/**
	 * Constr�i uma disciplina a partir do seu nome, da quantidade de notas por ela composta e pelos pesos destinados a cada prova. Todo aluno inicia a mat�ria com a hora de dedica��o � ela e com as notas nulas.
	 * 
	 * @param nomeDisciplina nome da disciplina que ser� criada.
	 * @param quantidadeNotas quantidade de notas que fazem parte da mat�ria.
	 * @param pesosProvas pesos que cada avalia��o possui.
	 */
	
	public Disciplina(String nomeDisciplina, int quantidadeNotas, int[] pesosProvas) {
		this.nome = nomeDisciplina;
		this.quantidadeNotasDisciplina = quantidadeNotas;
		this.notas = new double[quantidadeNotas];
		this.pesosProva = pesosProvas;	
	}
	
	/**
	 * Constr�i uma disciplina a partir da informa��o do seu nome. Todo aluno inicia a mat�ria com a hora de dedica��o � ela e com as notas nulas.
	 * 
	 * @param nomeDisciplina nome da disciplina que ser� gerada.
	 */
	public Disciplina(String nomeDisciplina) {
		this.nome = nomeDisciplina;
		this.quantidadeNotasDisciplina = QUANTIDADE_NOTAS_PADRAO;
		this.notas = new double[QUANTIDADE_NOTAS_PADRAO];
	}
	
	/**
	 * Registra a quantidade de horas que o aluno dedicou � disciplina.
	 * 
	 * @param horas tempo, em horas, destinado pelo aluno para focar na disciplina.
	 */
	public void cadastraHoras(int horas) {
		this.setHoras(this.getHoras() + horas);
	}
	
	/**
	 * A partir da identifica��o da nota que ser� registrada, cadastra a nota do aluno nas provas oferecidas pela mat�ria,
	 * 
	 * @param nota n�mero da prova que ser� cadastrada.
	 * @param valorNota nota do estudante na prova.
	 */
	public void cadastraNota(int nota, double valorNota) {
		this.setNotas(nota, valorNota);
	}
	
	/**
	 * Informa se o aluno est� aprovado ou n�o na disciplina. Um estudante s� � considerado como aprovado caso possua m�dia maior ou igual a sete.
	 * 
	 * @return true, caso o aluno tenha sido aprovado, e false, se o aluno foi reprovado.
	 */
	public boolean aprovado() {
		if(this.getMedia() >= this.MEDIA_PARA_APROVACAO) {
			return true;
		}
		return false;
	}
	
	/**
	 * Retorna uma String com o nome da disciplina, com o n�mero de horas a ela dedicado, com a m�dia do estudante e com as notas recebidas por ele em cada prova.
	 */
	public String toString() {
		return this.getNome() + " " + this.getHoras() + " " + this.getMedia() + " " +  Arrays.toString(this.getNotas());
	}
	
	/**
	 * Retorna o nome da disciplina constru�da.
	 * 
	 * @return nome da mat�ria.
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * Retorna o n�mero de horas dedicado pelo aluno para a disciplina.
	 * 
	 * @return tempo em horas investido pelo estudante na mat�ria.
	 */
	public int getHoras() {
		return this.horas;
	}
	
	/**
	 * Retorna o array em que as notas da disciplina est�o inseridas.
	 * 
	 * @return array com as notas do estudante.
	 */
	public double[] getNotas() {
		return this.notas;
	}
	
	/**
	 * Retorna o array em que os pesos das provas est�o inseridos;
	 * 
	 * @return array com pesos de cada avalia��o.
	 */
	public int[] getPesosProvas() {
		return this.pesosProva;
	}
	
	/**
	 * Retorna a m�dia do estudante na disciplina.
	 * 
	 * @return m�dia alcan�ada pelo aluno.
	 */
	public double getMedia() {
		if(this.pesosProva == null) {
			return calculaMediaAritmetica();
		} else {
			return calculaMediaPonderada();
		}
	}
	
	/**
	 * Calcula a m�dia aritm�tica do aluno na disciplina.
	 * 
	 * @return m�dia do estudante.
	 */
	public double calculaMediaAritmetica() {
		double soma = 0;
		for(int e = 0; e < this.getNotas().length ; e ++) {
			soma += this.getNotas()[e];
		}
		return soma/this.quantidadeNotasDisciplina;
	}
	
	/**
	 * Calcula a m�dia ponderada do estudante, uma vez que as provas possuem pesos.
	 * 
	 * @return m�dia ponderada do aluno.
	 */
	public double calculaMediaPonderada() {
		double soma = 0;
		int somaPeso = 0;
		for(int i = 0; i < this.getNotas().length; i++) {
			soma += this.getNotas()[i] * this.getPesosProvas()[i];
			somaPeso += this.getPesosProvas()[i];
		}
		return soma/somaPeso;
	}
	
	/**
	 * Atribui o nome da disciplina que foi criada.
	 * 
	 * @param nome nome da mat�ria.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Atualiza o tempo, em horas, que o estudante destinou � mat�ria.
	 * 
	 * @param hora quantidade de horas destinadas � disciplina.
	 */
	public void setHoras(int hora) {
		this.horas = hora;
	}
	
	/**
	 * Atribui as notas do aluno na disciplina ao array que possuir� o conjunto de notas.
	 * 
	 * @param prova n�mero da prova em que a nota est� relacionada.
	 * @param nota nota obtida na prova.
	 */
	public void setNotas(int prova, double nota) {
		this.getNotas()[prova-1] = nota;
	}

}
