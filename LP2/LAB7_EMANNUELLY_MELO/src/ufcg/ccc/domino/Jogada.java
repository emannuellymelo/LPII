package ufcg.ccc.domino;

/**
 * Encapsula uma jogada, incluindo uma peça e a posição onde jogar.
 *
 */
public class Jogada {

	/**
	 * Constantes para informar se a jogada é na direita, esquerda (da mesa), ou é
	 * para passar a vez.
	 */
	public enum TipoJogada {
		NA_ESQUERDA, NA_DIREITA, PASSA
	}
	
	/**
	 * Constantes para informar se é uma jogada de batida normal, batida de carroça, Lá Lô ou Lá Lô de carroça.
	 */
	public enum TipoJogadaVitoria {
		BATIDA_NORMAL, BATIDA_CARROCA, LA_LO, LA_LO_DE_CARROCA
	}
	
	/**
	 * Peça utilizada na jogada.
	 */
	private Peca peca;
	
	/**
	 * Tipo de jogada, se  é na direita, na esquerda (da mesa), ou é
	 * para passar a vez
	 */
	private TipoJogada tipo;
	
	/**
	 * Tipo de batida, se  é normal, de carroça, lá lô, ou lá lô de carroça.
	 */
	private TipoJogadaVitoria jogadaVitoria;

	/**
	 * Cria a jogada.
	 * 
	 * @param peca A peÃ§a a jogar.
	 * @param tipo Se Ã© uma jogada Ã  esquerda, direita ou um passa.
	 */
	public Jogada(Peca peca, TipoJogada tipo) {
		this.peca = peca;
		this.tipo = tipo;
	}

	/**
	 * Cria uma jogada de PASSA. Sem usar peça, o jogador passa a vez.
	 */
	public Jogada() {
		this(null, TipoJogada.PASSA);
	}
	
	/**
	 * Cria a jogada de vitória.
	 * 
	 * @param peca A peça a jogar.
	 * @param tipo Se é uma jogada a esquerda, direita ou um passa.
	 * @param jogadaVitoria Se é uma batida normal, batida de carroça, lá lô ou lá lô de carroça.
	 */
	public Jogada(Peca peca, TipoJogada tipo, TipoJogadaVitoria jogadaVitoria) {
		this.peca = peca;
		this.tipo = tipo;
		this.jogadaVitoria = jogadaVitoria;
	}

	/**
	 * @return Se é uma jogada a esquerda, direita ou um passa.
	 */
	public TipoJogada getTipo() {
		return tipo;
	}
	
	/**
	 * @return Se é uma vitória com batida normal, batida de carroça, lá lô ou lá lô de carroça.
	 */
	public TipoJogadaVitoria getTipoVitoria() {
		return this.jogadaVitoria;
	}
	
	/**
	 * Pontuação de vitória recebida que depende do tipo de batida. Uma batida normal (em uma única "cabeça") vale 1 ponto, batida de "carroça" (uma peça com 2 números iguais) vale 2 pontos, o famoso "lá e ló" que significa bater com uma pedra simples que encaixa nas duas pontas, vale 3 pontos, já o "lá e ló" de carroça vale 6 pontos
	 * @return
	 */
	public int getPontuacao() {
			switch (this.jogadaVitoria) {
			case BATIDA_NORMAL: {
				return 1;
			}
			case BATIDA_CARROCA: {
				return 2;
			}
			case LA_LO: {
				return 3;
			}
			case LA_LO_DE_CARROCA: {
				return 6;
			}default: {
				return 1;
			}
			}
	}
	
	/**
	 * Pontuação fixa recebida em situação de trancamento.
	 * 
	 * @return
	 */
	public int getPontuacaoTrancamento() {
		return 1;
	}

	/**
	 * @return A peça da jogada.
	 */
	public Peca getPeca() {
		return peca;
	}

	@Override
	public String toString() {
		return (this.tipo == TipoJogada.PASSA ? "" : peca.toString() + " ") + this.getTipoEmString();
	}

	/*
	 * Para facilitar o toString() 
	 */
	private String getTipoEmString() {
		switch (tipo) {
		case PASSA: {
			return "Passou";
		}
		case NA_DIREITA: {
			return "na direita";
		}
		case NA_ESQUERDA: {
			return "na esquerda";
		}
		default: {
			return null;
		}
		}
	}

}
