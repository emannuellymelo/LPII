package controle;

/**
 * Representa��o de um aluno, a partir do armazenamento dos seus dados.
 * 
 * @author Emannuelly Larissa Freitas de Melo - 119210167.
 *
 */
public class Aluno {
	
	/**
	 * Matr�cula do aluno.
	 */
	private String matricula;
	
	/**
	 * Nome do aluno.
	 */
	private String nome;
	
	/**
	 * Nome do curso do estudante.
	 */
	private String curso;
	
	
	/**
	 * Cria um estudante a partir da sua matr�cula, do seu nome e do seu curso. Caso seja passada uma informa��o nula ou vazia � lan�ada uma exce��o que encerra o sistema.
	 * 
	 * @param matricula matr�cula do aluno.
	 * @param nome nome do estudante.
	 * @param curso curso do aluno.
	 */
	public Aluno(String matricula, String nome, String curso) {
		if(matricula == null || nome == null || curso == null) {
			throw new NullPointerException("Entrada nula");
		} else if(matricula.equals("") || nome.equals("") || curso.equals("")) {
			throw new IllegalArgumentException("Entrada inv�lida");
		}
		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
	}
	
	/**
	 * Retorna o nome do aluno.
	 * 
	 * @return nome do aluno.
	 */
	public String getNomeAluno() {
		return this.nome;
	}
	
	/**
	 * Retorna o curso do estudante.
	 * 
	 * @return curso do estudante.
	 */
	public String getCurso() {
		return this.curso;
	}

	/**
	 * Retorna uma String que informa a matr�cula, o nome e o curso do aluno.
	 * 
	 * @return String com matr�cula, nome e curso do estudante.
	 */
	@Override
	public String toString() {
		return "Aluno: " + this.matricula + " - " + this.nome + " - " + this.curso;
	}

	/**
	 * Gera um n�mero inteiro que identifica unicamente um aluno.
	 * 
	 * @return n�mero inteiro que identifica um aluno de forma �nica.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	/**
	 * Compara matr�culas para verificar se um aluno � igual a outro.
	 * 
	 * @return true, caso o objeto comparado seja igual a um determinado aluno; false, caso os objetos comparados sejam diferentes.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}


	
}

