package controle;

/**
 * Representação de um aluno, a partir do armazenamento dos seus dados.
 * 
 * @author Emannuelly Larissa Freitas de Melo - 119210167.
 *
 */
public class Aluno {
	
	/**
	 * Matrícula do aluno.
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
	 * Cria um estudante a partir da sua matrícula, do seu nome e do seu curso. Caso seja passada uma informação nula ou vazia é lançada uma exceção que encerra o sistema.
	 * 
	 * @param matricula matrícula do aluno.
	 * @param nome nome do estudante.
	 * @param curso curso do aluno.
	 */
	public Aluno(String matricula, String nome, String curso) {
		if(matricula == null || nome == null || curso == null) {
			throw new NullPointerException("Entrada nula");
		} else if(matricula.equals("") || nome.equals("") || curso.equals("")) {
			throw new IllegalArgumentException("Entrada inválida");
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
	 * Retorna uma String que informa a matrícula, o nome e o curso do aluno.
	 * 
	 * @return String com matrícula, nome e curso do estudante.
	 */
	@Override
	public String toString() {
		return "Aluno: " + this.matricula + " - " + this.nome + " - " + this.curso;
	}

	/**
	 * Gera um número inteiro que identifica unicamente um aluno.
	 * 
	 * @return número inteiro que identifica um aluno de forma única.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	/**
	 * Compara matrículas para verificar se um aluno é igual a outro.
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

