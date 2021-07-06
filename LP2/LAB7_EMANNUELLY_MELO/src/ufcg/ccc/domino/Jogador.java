package ufcg.ccc.domino;

import java.util.LinkedList;
import java.util.List;

import ufcg.ccc.domino.Jogada.TipoJogada;
import ufcg.ccc.domino.estrategia.EstrategiaDeJogo;
import ufcg.ccc.domino.estrategia.EstrategiaInvalidaException;
import ufcg.ccc.domino.estrategia.VisaoDaMesa;

/**
 * Encapsula as informaÃ§Ãµes de um jogador em uma partida de dominÃ³.
 *
 */
public class Jogador {

	private EstrategiaDeJogo estrategia;
	private List<Peca> mao;
	private String nome;
	private Jogada ultimaJogada;

	/**
	 * Cria um jogador
	 * 
	 * @param nome       Id do jogador
	 * @param estrategia A estratégia para decidir a próxima jogada
	 * @param maoJogador A mão inicial do jogador, com suas peças
	 */
	public Jogador(String nome, EstrategiaDeJogo estrategia, List<Peca> maoJogador) {
		this.nome = nome;
		this.estrategia = estrategia;
		this.mao = new LinkedList<>(maoJogador);
		this.ultimaJogada = null;
	}

	/**
	 * @return O nome do jogador
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Decide a prÃ³xima jogada a ser feita pelo jogador dado o estado da mesa.
	 * Verifica se a decisÃ£o da estratÃ©gia Ã© para uma peÃ§a que estÃ¡ de fato na mÃ£o
	 * do jogador.
	 * 
	 * @param mesa A visÃ£o da mesa, mostrando as peÃ§as jogadas e pontas.
	 * @return A Jogada decidida.
	 * @throws EstrategiaInvalidaException Caso a estratÃ©goa decida jogar uma peÃ§a
	 *                                     que nÃ£o estÃ¡ na mÃ£o do jogador.
	 */
	public Jogada decideJogada(VisaoDaMesa mesa) throws EstrategiaInvalidaException {
		Jogada jogada = this.estrategia.decideJogada(mesa, mao);

		if (jogada.getTipo() != TipoJogada.PASSA) {
			Peca pecaJogada = jogada.getPeca();
			boolean realmenteTem = mao.contains(pecaJogada);
			if (!realmenteTem) {
				throw new EstrategiaInvalidaException(nome + " tentou jogar peça que não tem: " + pecaJogada);
			}
		}
		this.ultimaJogada = jogada;
		return jogada;
	}

	/**
	 * Retira uma peça da mão do jogador. É ncessário quando a peça é posta na mesa.
	 * 
	 * @param peca A peça a retirar.
	 */
	public void removeDaMao(Peca peca) {
		this.mao.remove(peca);
	}

	/**
	 * Número de peças na mão do jogador.
	 * 
	 * @return peças na mão ainda por jogar.
	 */
	public int getNumPecas() {
		return mao.size();
	}

	@Override
	public String toString() {
		return this.getNome() + (ultimaJogada == null ? "" : ", joga: " + ultimaJogada.toString()) + ", mão: "
				+ mao.toString();
	}

	/**
	 * @return A última jogada desse jogador. Null se não há.
	 */
	public Jogada getUltimaJogada() {
		return ultimaJogada;
	}
	
	/**
	 * @return CÃ³pia da mÃ£o disponÃ­vel para esse jogador.
	 */
	public List<Peca> getMao() {
		return new LinkedList<>(mao);
	}
	
	/**
	 * Retorna a soma dos números presentes nas peças.
	 * @return soma dos números presentes nas peças.
	 */
	public int getSomaPecas() {
		int cont = 0;
		for(Peca peca : this.getMao()) {
			cont += peca.getNumEsquerdo() + peca.getNumDireito();
		}
		return cont;
	}
	
	
}
