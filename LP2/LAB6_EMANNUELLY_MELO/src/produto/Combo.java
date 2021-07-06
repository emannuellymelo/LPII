package produto;

import java.util.ArrayList;

/**
 * Classe que representa um combo, combina��o de produtos, composto por nome, descri��o e fator de desconto.
 * 
 * @author Emannuelly Larissa Freitas de Melo - Matr�cula: 119210167.
 *
 */
public class Combo extends Produto {
	
	/**
	 * Fator de desconto do combo.
	 * 
	 */
	private double fator;
	
	/**
	 * Lista com todos os produtos que comp�em o combo.
	 * 
	 */
	private ArrayList<ProdutoSimples> todosProdutos;
	
	/**
	 * Cria um combo a partir do seu nome, descri��o, fator de desconto e a partir de uma lista que possui os produtos que o comp�e.
	 * 
	 * @param nome nome do combo.
	 * @param descricao descri��o dos produtos do combo.
	 * @param fator fator de desconto do combo.
	 * @param todosProdutos todos os produtos que comp�em o combo.
	 */
	public Combo(String nome, String descricao, double fator, ArrayList<ProdutoSimples> todosProdutos) {
		super(nome, descricao);
		this.fator = fator;
		this.todosProdutos = todosProdutos;
	}
	
	/**
	 * Retorna o pre�o do combo levando em considera��o seu fator de desconto.
	 * 
	 * @return preco do combo.
	 */
	public double getPrecoCombo() {
		double preco = 0;
		for(ProdutoSimples produto : this.todosProdutos) {
			preco += produto.getPreco();
		}
		return preco * (1 - this.fator);
	}
	
	/**
	 * Altera o fator de desconto do combo a partir de um fornecido.
	 * 
	 * @param novoFator novo fator de desconto do combo.
	 */
	public void setFator(double novoFator) {
		this.fator = novoFator;
	}
	
	/**
	 * Representa��o textual do combo, apresentando seu nome, descri��o e pre�o formatado com duas casas decimais.
	 * 
	 */
	public String toString() {
		return String.format("%s - %s - R$%,.2f", this.getNome(), this.getDescricao(), this.getPrecoCombo());
	}
}
