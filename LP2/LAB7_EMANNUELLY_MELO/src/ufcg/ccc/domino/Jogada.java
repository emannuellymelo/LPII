package ufcg.ccc.domino;

/**
 * Encapsula uma jogada, incluindo uma pe�a e a posi��o onde jogar.
 *
 */
public class Jogada {

	/**
	 * Constantes para informar se a jogada � na direita, esquerda (da mesa), ou �
	 * para passar a vez.
	 */
	public enum TipoJogada {
		NA_ESQUERDA, NA_DIREITA, PASSA
	}
	
	/**
	 * Constantes para informar se � uma jogada de batida normal, batida de carro�a, L� L� ou L� L� de carro�a.
	 */
	public enum TipoJogadaVitoria {
		BATIDA_NORMAL, BATIDA_CARROCA, LA_LO, LA_LO_DE_CARROCA
	}
	
	/**
	 * Pe�a utilizada na jogada.
	 */
	private Peca peca;
	
	/**
	 * Tipo de jogada, se  � na direita, na esquerda (da mesa), ou �
	 * para passar a vez
	 */
	private TipoJogada tipo;
	
	/**
	 * Tipo de batida, se  � normal, de carro�a, l� l�, ou l� l� de carro�a.
	 */
	private TipoJogadaVitoria jogadaVitoria;

	/**
	 * Cria a jogada.
	 * 
	 * @param peca A peça a jogar.
	 * @param tipo Se é uma jogada à esquerda, direita ou um passa.
	 */
	public Jogada(Peca peca, TipoJogada tipo) {
		this.peca = peca;
		this.tipo = tipo;
	}

	/**
	 * Cria uma jogada de PASSA. Sem usar pe�a, o jogador passa a vez.
	 */
	public Jogada() {
		this(null, TipoJogada.PASSA);
	}
	
	/**
	 * Cria a jogada de vit�ria.
	 * 
	 * @param peca A pe�a a jogar.
	 * @param tipo Se � uma jogada a esquerda, direita ou um passa.
	 * @param jogadaVitoria Se � uma batida normal, batida de carro�a, l� l� ou l� l� de carro�a.
	 */
	public Jogada(Peca peca, TipoJogada tipo, TipoJogadaVitoria jogadaVitoria) {
		this.peca = peca;
		this.tipo = tipo;
		this.jogadaVitoria = jogadaVitoria;
	}

	/**
	 * @return Se � uma jogada a esquerda, direita ou um passa.
	 */
	public TipoJogada getTipo() {
		return tipo;
	}
	
	/**
	 * @return Se � uma vit�ria com batida normal, batida de carro�a, l� l� ou l� l� de carro�a.
	 */
	public TipoJogadaVitoria getTipoVitoria() {
		return this.jogadaVitoria;
	}
	
	/**
	 * Pontua��o de vit�ria recebida que depende do tipo de batida. Uma batida normal (em uma �nica "cabe�a") vale 1 ponto, batida de "carro�a" (uma pe�a com 2 n�meros iguais) vale 2 pontos, o famoso "l� e l�" que significa bater com uma pedra simples que encaixa nas duas pontas, vale 3 pontos, j� o "l� e l�" de carro�a vale 6 pontos
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
	 * Pontua��o fixa recebida em situa��o de trancamento.
	 * 
	 * @return
	 */
	public int getPontuacaoTrancamento() {
		return 1;
	}

	/**
	 * @return A pe�a da jogada.
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
