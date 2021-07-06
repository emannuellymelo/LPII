package ufcg.ccc.domino.estrategia;

import java.util.ArrayList;
import java.util.List;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Peca;
import ufcg.ccc.domino.Jogada.TipoJogada;
import ufcg.ccc.domino.Jogada.TipoJogadaVitoria;

/**
 * Joga sempre a primeira carroça que encaixa. Tenta primeiro no lado direito e
 * depois esquerdo, se encaixar em ambos.
 * 
 * @author Emannuelly Larissa Freitas de Melo - Matrícula: 119210167.
 *
 */
public class JogaPrimeiroCarrocao implements EstrategiaDeJogo {
	private ArrayList<Peca> maoCarrocoes;
	private ArrayList<Peca> copiaMaoOriginal;
	
	@Override
	public Jogada decideJogada(VisaoDaMesa mesa, List<Peca> mao) {
		this.maoCarrocoes = new ArrayList<>();
		this.copiaMaoOriginal = new ArrayList<>();
		
		for(Peca peca : mao) {
			this.copiaMaoOriginal.add(peca);
		}
		
		for(Peca peca : mao) {
			if(peca.getNumDireito() == peca.getNumEsquerdo()) {
				this.maoCarrocoes.add(peca);
				this.copiaMaoOriginal.remove(peca);
			}
		}
		
		if (mesa.getNumPecas() == 0) {
			if(this.maoCarrocoes.size() > 0) {
				return new Jogada(maoCarrocoes.get(0), TipoJogada.NA_DIREITA);
			} else {
				return new Jogada(copiaMaoOriginal.get(0), TipoJogada.NA_DIREITA);
			}
		}
		
		for(Peca carrocao : maoCarrocoes) {
			if (carrocao.encaixa(mesa.getNumNaDireita())) {
				if((mesa.getNumNaDireita() == carrocao.getNumDireito() && mesa.getNumNaEsquerda() == carrocao.getNumEsquerdo( )) || (mesa.getNumNaDireita() == carrocao.getNumEsquerdo() && mesa.getNumNaEsquerda() == carrocao.getNumDireito( ))) {
					return new Jogada(carrocao, TipoJogada.NA_DIREITA, TipoJogadaVitoria.LA_LO_DE_CARROCA);
				} else {
					return new Jogada(carrocao, TipoJogada.NA_DIREITA, TipoJogadaVitoria.BATIDA_CARROCA);
				}
			} else if(carrocao.encaixa(mesa.getNumNaEsquerda())) {
				if((mesa.getNumNaDireita() == carrocao.getNumDireito() && mesa.getNumNaEsquerda() == carrocao.getNumEsquerdo( )) || (mesa.getNumNaDireita() == carrocao.getNumEsquerdo() && mesa.getNumNaEsquerda() == carrocao.getNumDireito( ))) {
					return new Jogada(carrocao, TipoJogada.NA_ESQUERDA, TipoJogadaVitoria.LA_LO_DE_CARROCA);
				} else {
					return new Jogada(carrocao, TipoJogada.NA_ESQUERDA, TipoJogadaVitoria.BATIDA_CARROCA);
				}
			}
		}
		
		for (Peca peca : copiaMaoOriginal) {
			if (peca.encaixa(mesa.getNumNaDireita())) {
				if(mesa.getNumNaDireita() == peca.getNumDireito() || mesa.getNumNaDireita() == peca.getNumEsquerdo( )) {
					if((mesa.getNumNaDireita() == peca.getNumDireito() && mesa.getNumNaEsquerda() == peca.getNumEsquerdo( )) || (mesa.getNumNaDireita() == peca.getNumEsquerdo() && mesa.getNumNaEsquerda() == peca.getNumDireito( ))) {
						return new Jogada(peca, TipoJogada.NA_DIREITA, TipoJogadaVitoria.LA_LO);
					} else {
						return new Jogada(peca, TipoJogada.NA_DIREITA, TipoJogadaVitoria.BATIDA_NORMAL);
					}
				}
			}
			if (peca.encaixa(mesa.getNumNaEsquerda())) { 
				if(mesa.getNumNaEsquerda() == peca.getNumDireito() || mesa.getNumNaEsquerda() == peca.getNumEsquerdo( )) {
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
