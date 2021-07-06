package produto;

/**
 * Classe com a representa��o abstrata de um produto, o qual tem nome e descricao.
 * 
 * @author Aluno de período anterior// Emannuelly Larissa Freitas de Melo - Matr�cula: 119210167.
 *
 */
public abstract class Produto {
	/**
	 * Nome do produto
	 */
	private String nome;

	/**
	 * Descricao do produto
	 */
	private String descricao;


	/**
	 * Cria um produto a partir do seu nome e descricao.
	 * 
	 * @param nome nome do produto.
	 * @param descricao descricao do produto.
	 */
	public Produto(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}

	/**
	 * Representa��o textual de um produto a partir do seu nome e descricao.
	 */
	@Override
	public String toString() {
		return this.getNome() + " - " + this.getDescricao();
	}

	/**
	 * Compara se dois objetos s�o iguais a partir do seu nome e descricao.
	 */
	@Override
	public boolean equals(Object o) {
		if (o != null && o instanceof Produto) {
			Produto p = (Produto) o;

			if ((this.getNome() + this.getDescricao()).equals(p.getNome() + p.getDescricao())) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Cria um identificador �nico em forma de n�mero inteiro para cada produto a partir do nome e da descri��o do produto.
	 */
	@Override
	public int hashCode() {
		return (this.getNome() + this.getDescricao()).hashCode();
	}

	/**
	 * Retorna o nome do produto.
	 * @return retorna o nome do produto.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Retorna a descri��o do produto.
	 * @return retorna a descri��o do produto.
	 */
	public String getDescricao() {
		return descricao;
	}


}
