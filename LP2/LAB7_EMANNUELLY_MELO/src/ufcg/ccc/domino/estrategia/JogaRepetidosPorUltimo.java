package ufcg.ccc.domino.estrategia;

import java.util.ArrayList;
import java.util.List;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Peca;
import ufcg.ccc.domino.Jogada.TipoJogada;
import ufcg.ccc.domino.Jogada.TipoJogadaVitoria;

/**
 * Joga sempre as peças com números que mais se repetem por último. Tenta primeiro no lado direito e
 * depois esquerdo, se encaixar em ambos.
 * 
 * @author Emannuelly Larissa Freitas de Melo - Matrícula: 119210167.
 *
 */
public class JogaRepetidosPorUltimo implements EstrategiaDeJogo{
	private int[] frequenciaPecas;
	private int maiorContadorFrequencia;
	private ArrayList<Integer> numeroMaisRepetido;
	private ArrayList<Peca> pecasComNumeroMaisRepetido;
	private ArrayList<Peca> copiaMaoOriginal;
	private static int NUMEROS_DISTINTOS_PECA = 7;
	
	@Override
	public Jogada decideJogada(VisaoDaMesa mesa, List<Peca> mao) {
		this.frequenciaPecas = new int[NUMEROS_DISTINTOS_PECA];
		this.numeroMaisRepetido = new ArrayList<>();
		this.pecasComNumeroMaisRepetido = new ArrayList<>();
		this.copiaMaoOriginal = new ArrayList<>();
		
		for(Peca peca : mao) {
			this.copiaMaoOriginal.add(peca);
		}
		
		for(Peca peca : mao) {
			this.frequenciaPecas[peca.getNumDireito()] = this.frequenciaPecas[peca.getNumDireito()] + 1;
			this.frequenciaPecas[peca.getNumEsquerdo()] = this.frequenciaPecas[peca.getNumEsquerdo()] + 1;
		}
		
		for(int i = 0; i < this.frequenciaPecas.length; i++) {
			if(this.frequenciaPecas[i] > this.maiorContadorFrequencia) {
				this.maiorContadorFrequencia = frequenciaPecas[i];
			}
		}
		for(int e = 0; e < this.frequenciaPecas.length; e++) {
			if(this.frequenciaPecas[e] == this.maiorContadorFrequencia) {
				this.numeroMaisRepetido.add(e);
			}
		}
		
		for(Peca peca : mao) {
			if(this.numeroMaisRepetido.contains(peca.getNumDireito()) || this.numeroMaisRepetido.contains(peca.getNumEsquerdo())) {
				this.pecasComNumeroMaisRepetido.add(peca);
				this.copiaMaoOriginal.remove(peca);
			}
		}
		
		if (mesa.getNumPecas() == 0) {
			if(this.copiaMaoOriginal.size()  > 0) {
				return new Jogada(copiaMaoOriginal.get(0), TipoJogada.NA_DIREITA);
			} else {
				return new Jogada(pecasComNumeroMaisRepetido.get(0), TipoJogada.NA_DIREITA);
			}
		}
		
		for(Peca peca : copiaMaoOriginal) {
			if (peca.encaixa(mesa.getNumNaDireita())) {
					if(peca.getNumDireito() == peca.getNumEsquerdo()) {
						if((mesa.getNumNaDireita() == peca.getNumDireito() && mesa.getNumNaEsquerda() == peca.getNumEsquerdo( )) || (mesa.getNumNaDireita() == peca.getNumEsquerdo() && mesa.getNumNaEsquerda() == peca.getNumDireito( ))) {
							return new Jogada(peca, TipoJogada.NA_DIREITA, TipoJogadaVitoria.LA_LO_DE_CARROCA);
						} else {
							return new Jogada(peca, TipoJogada.NA_DIREITA, TipoJogadaVitoria.BATIDA_CARROCA);
						}
					} else {
						if((mesa.getNumNaDireita() == peca.getNumDireito() && mesa.getNumNaEsquerda() == peca.getNumEsquerdo( )) || (mesa.getNumNaDireita() == peca.getNumEsquerdo() && mesa.getNumNaEsquerda() == peca.getNumDireito( ))) {
							return new Jogada(peca, TipoJogada.NA_DIREITA, TipoJogadaVitoria.LA_LO);
						} else {
							return new Jogada(peca, TipoJogada.NA_DIREITA, TipoJogadaVitoria.BATIDA_NORMAL);
						}
					}
			}
			if (peca.encaixa(mesa.getNumNaEsquerda())) {
					if(peca.getNumDireito() == peca.getNumEsquerdo()) {
						if((mesa.getNumNaDireita() == peca.getNumDireito() && mesa.getNumNaEsquerda() == peca.getNumEsquerdo( )) || (mesa.getNumNaDireita() == peca.getNumEsquerdo() && mesa.getNumNaEsquerda() == peca.getNumDireito( ))) {
							return new Jogada(peca, TipoJogada.NA_ESQUERDA, TipoJogadaVitoria.LA_LO_DE_CARROCA);
						} else {
							return new Jogada(peca, TipoJogada.NA_ESQUERDA, TipoJogadaVitoria.BATIDA_CARROCA);
						}
					} else {
						if((mesa.getNumNaDireita() == peca.getNumDireito() && mesa.getNumNaEsquerda() == peca.getNumEsquerdo( )) || (mesa.getNumNaDireita() == peca.getNumEsquerdo() && mesa.getNumNaEsquerda() == peca.getNumDireito( ))) {
							return new Jogada(peca, TipoJogada.NA_ESQUERDA, TipoJogadaVitoria.LA_LO);
						} else {
							return new Jogada(peca, TipoJogada.NA_ESQUERDA, TipoJogadaVitoria.BATIDA_NORMAL);
						}
					}
			}
		}
		
		for(Peca peca : this.pecasComNumeroMaisRepetido) {
			if (peca.encaixa(mesa.getNumNaDireita())) {
				if(peca.getNumDireito() == peca.getNumEsquerdo()) {
					if((mesa.getNumNaDireita() == peca.getNumDireito() && mesa.getNumNaEsquerda() == peca.getNumEsquerdo( )) || (mesa.getNumNaDireita() == peca.getNumEsquerdo() && mesa.getNumNaEsquerda() == peca.getNumDireito( ))) {
						return new Jogada(peca, TipoJogada.NA_DIREITA, TipoJogadaVitoria.LA_LO_DE_CARROCA);
					} else {
						return new Jogada(peca, TipoJogada.NA_DIREITA, TipoJogadaVitoria.BATIDA_CARROCA);
					}
				} else {
					if((mesa.getNumNaDireita() == peca.getNumDireito() && mesa.getNumNaEsquerda() == peca.getNumEsquerdo( )) || (mesa.getNumNaDireita() == peca.getNumEsquerdo() && mesa.getNumNaEsquerda() == peca.getNumDireito( ))) {
						return new Jogada(peca, TipoJogada.NA_DIREITA, TipoJogadaVitoria.LA_LO);
					} else {
						return new Jogada(peca, TipoJogada.NA_DIREITA, TipoJogadaVitoria.BATIDA_NORMAL);
					}
				}
			}
			if (peca.encaixa(mesa.getNumNaEsquerda())) {
					if(peca.getNumDireito() == peca.getNumEsquerdo()) {
						if((mesa.getNumNaDireita() == peca.getNumDireito() && mesa.getNumNaEsquerda() == peca.getNumEsquerdo( )) || (mesa.getNumNaDireita() == peca.getNumEsquerdo() && mesa.getNumNaEsquerda() == peca.getNumDireito( ))) {
							return new Jogada(peca, TipoJogada.NA_ESQUERDA, TipoJogadaVitoria.LA_LO_DE_CARROCA);
						} else {
							return new Jogada(peca, TipoJogada.NA_ESQUERDA, TipoJogadaVitoria.BATIDA_CARROCA);
						}
					} else {
						if((mesa.getNumNaDireita() == peca.getNumDireito() && mesa.getNumNaEsquerda() == peca.getNumEsquerdo( )) || (mesa.getNumNaDireita() == peca.getNumEsquerdo() && mesa.getNumNaEsquerda() == peca.getNumDireito( ))) {
							return new Jogada(peca, TipoJogada.NA_ESQUERDA, TipoJogadaVitoria.LA_LO);
						} else {
							return new Jogada(peca, TipoJogada.NA_ESQUERDA, TipoJogadaVitoria.BATIDA_NORMAL);
						}
					}
			}
		}

		return new Jogada();
	}

}
