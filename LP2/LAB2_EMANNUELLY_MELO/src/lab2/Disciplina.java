package lab2;

import java.util.Arrays;

/**
 * Representa uma disciplina, que deve possuir horas de dedicação destinadas pelo aluno e deve apresentar 4 notas.
 * 
 * @author Emannuelly Larissa Freitas de Melo - 119210167.
 *
 */
public class Disciplina {
	
	/**
	 * Identificação da disciplina a partir do seu nome.
	 */
	private String nome;
	
	/**
	 * Definição do tempo dedicado pelo aluno à matéria em horas.
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
	 * Indica a quantidade de notas que a disciplina é composta.
	 */
	private int quantidadeNotasDisciplina;
	
	/**
	 * Informa a quantidade padrão de notas que a disciplina é composta.
	 */
	private final int QUANTIDADE_NOTAS_PADRAO = 4;
	
	/**
	 * Informa a média para aprovação na matéria.
	 */
	private final double MEDIA_PARA_APROVACAO = 7.0;
	
	/**
	 * Constrói uma disciplina a partir do seu nome e da quantidade de notas por ela composta. Todo aluno inicia a matéria com a hora de dedicação à ela e com as notas nulas.
	 * 
	 * @param nomeDisciplina nome da disciplina que será gerada.
	 * @param quantidadeNotas quantidade de notas que compõe a matéria.
	 */
	public Disciplina(String nomeDisciplina, int quantidadeNotas) {
		this.nome = nomeDisciplina;
		this.quantidadeNotasDisciplina = quantidadeNotas;
		this.notas = new double[quantidadeNotas];
	}
	
	/**
	 * Constrói uma disciplina a partir do seu nome, da quantidade de notas por ela composta e pelos pesos destinados a cada prova. Todo aluno inicia a matéria com a hora de dedicação à ela e com as notas nulas.
	 * 
	 * @param nomeDisciplina nome da disciplina que será criada.
	 * @param quantidadeNotas quantidade de notas que fazem parte da matéria.
	 * @param pesosProvas pesos que cada avaliação possui.
	 */
	
	public Disciplina(String nomeDisciplina, int quantidadeNotas, int[] pesosProvas) {
		this.nome = nomeDisciplina;
		this.quantidadeNotasDisciplina = quantidadeNotas;
		this.notas = new double[quantidadeNotas];
		this.pesosProva = pesosProvas;	
	}
	
	/**
	 * Constrói uma disciplina a partir da informação do seu nome. Todo aluno inicia a matéria com a hora de dedicação à ela e com as notas nulas.
	 * 
	 * @param nomeDisciplina nome da disciplina que será gerada.
	 */
	public Disciplina(String nomeDisciplina) {
		this.nome = nomeDisciplina;
		this.quantidadeNotasDisciplina = QUANTIDADE_NOTAS_PADRAO;
		this.notas = new double[QUANTIDADE_NOTAS_PADRAO];
	}
	
	/**
	 * Registra a quantidade de horas que o aluno dedicou à disciplina.
	 * 
	 * @param horas tempo, em horas, destinado pelo aluno para focar na disciplina.
	 */
	public void cadastraHoras(int horas) {
		this.setHoras(this.getHoras() + horas);
	}
	
	/**
	 * A partir da identificação da nota que será registrada, cadastra a nota do aluno nas provas oferecidas pela matéria,
	 * 
	 * @param nota número da prova que será cadastrada.
	 * @param valorNota nota do estudante na prova.
	 */
	public void cadastraNota(int nota, double valorNota) {
		this.setNotas(nota, valorNota);
	}
	
	/**
	 * Informa se o aluno está aprovado ou não na disciplina. Um estudante só é considerado como aprovado caso possua média maior ou igual a sete.
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
	 * Retorna uma String com o nome da disciplina, com o número de horas a ela dedicado, com a média do estudante e com as notas recebidas por ele em cada prova.
	 */
	public String toString() {
		return this.getNome() + " " + this.getHoras() + " " + this.getMedia() + " " +  Arrays.toString(this.getNotas());
	}
	
	/**
	 * Retorna o nome da disciplina construída.
	 * 
	 * @return nome da matéria.
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * Retorna o número de horas dedicado pelo aluno para a disciplina.
	 * 
	 * @return tempo em horas investido pelo estudante na matéria.
	 */
	public int getHoras() {
		return this.horas;
	}
	
	/**
	 * Retorna o array em que as notas da disciplina estão inseridas.
	 * 
	 * @return array com as notas do estudante.
	 */
	public double[] getNotas() {
		return this.notas;
	}
	
	/**
	 * Retorna o array em que os pesos das provas estão inseridos;
	 * 
	 * @return array com pesos de cada avaliação.
	 */
	public int[] getPesosProvas() {
		return this.pesosProva;
	}
	
	/**
	 * Retorna a média do estudante na disciplina.
	 * 
	 * @return média alcançada pelo aluno.
	 */
	public double getMedia() {
		if(this.pesosProva == null) {
			return calculaMediaAritmetica();
		} else {
			return calculaMediaPonderada();
		}
	}
	
	/**
	 * Calcula a média aritmética do aluno na disciplina.
	 * 
	 * @return média do estudante.
	 */
	public double calculaMediaAritmetica() {
		double soma = 0;
		for(int e = 0; e < this.getNotas().length ; e ++) {
			soma += this.getNotas()[e];
		}
		return soma/this.quantidadeNotasDisciplina;
	}
	
	/**
	 * Calcula a média ponderada do estudante, uma vez que as provas possuem pesos.
	 * 
	 * @return média ponderada do aluno.
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
	 * @param nome nome da matéria.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Atualiza o tempo, em horas, que o estudante destinou à matéria.
	 * 
	 * @param hora quantidade de horas destinadas à disciplina.
	 */
	public void setHoras(int hora) {
		this.horas = hora;
	}
	
	/**
	 * Atribui as notas do aluno na disciplina ao array que possuirá o conjunto de notas.
	 * 
	 * @param prova número da prova em que a nota está relacionada.
	 * @param nota nota obtida na prova.
	 */
	public void setNotas(int prova, double nota) {
		this.getNotas()[prova-1] = nota;
	}

}
