/**
 * 
 */
package ufcg.ccc.domino.estrategia;

import java.util.List;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Jogada.TipoJogada;
import ufcg.ccc.domino.Jogada.TipoJogadaVitoria;
import ufcg.ccc.domino.Peca;

/**
 * Joga sempre a primeira peça que encaixa. Tenta primeiro no lado direito e
 * depois esquerdo, se encaixar em ambas.
 */
public class JogaPrimeiraPossivel implements EstrategiaDeJogo {

	@Override
	public Jogada decideJogada(VisaoDaMesa mesa, List<Peca> mao) {

		if (mesa.getNumPecas() == 0) {
			return new Jogada(mao.get(0), TipoJogada.NA_DIREITA);
		}
		

		for (Peca peca : mao) {
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
						if((mesa.getNumNaDireita() == peca.getNumDireito() && mesa.getNumNaEsquerda() == peca.getNumEsquerdo( )) || (mesa.getNumNaDireita() == peca.getNumEsquerdo() && mesa.getNumNaEsquerda() == peca.getNumDireito( ))){
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
