package ufcg.ccc.domino;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ufcg.ccc.domino.Jogada.TipoJogada;
import ufcg.ccc.domino.Jogada.TipoJogadaVitoria;

class JogadaTest {

	@Test
	void testJogadaPassa() {
		Jogada j1 = new Jogada();
		assertEquals(TipoJogada.PASSA, j1.getTipo());
	}

	@Test
	void testJogadaComPeca() {
		Jogada j1 = new Jogada(new Peca(1, 1), TipoJogada.NA_ESQUERDA);
		assertEquals(TipoJogada.NA_ESQUERDA, j1.getTipo());
	}
	
	@Test
	void testPontuacaoBatidaNormal() {
		Jogada j1 = new Jogada(new Peca(1, 2), TipoJogada.NA_DIREITA, TipoJogadaVitoria.BATIDA_NORMAL);
		assertEquals(TipoJogadaVitoria.BATIDA_NORMAL, j1.getTipoVitoria());
		assertEquals(1, j1.getPontuacao());
		Jogada j2 = new Jogada(new Peca(1, 2), TipoJogada.NA_ESQUERDA, TipoJogadaVitoria.BATIDA_NORMAL);
		assertEquals(TipoJogadaVitoria.BATIDA_NORMAL, j2.getTipoVitoria());
		assertEquals(1, j2.getPontuacao());
	}
	
	@Test
	void testPontuacaoBatidaCarrocao() {
		Jogada j1 = new Jogada(new Peca(1, 2), TipoJogada.NA_DIREITA, TipoJogadaVitoria.BATIDA_CARROCA);
		assertEquals(TipoJogadaVitoria.BATIDA_CARROCA, j1.getTipoVitoria());
		assertEquals(2, j1.getPontuacao());
		Jogada j2 = new Jogada(new Peca(1, 2), TipoJogada.NA_ESQUERDA, TipoJogadaVitoria.BATIDA_CARROCA);
		assertEquals(TipoJogadaVitoria.BATIDA_CARROCA, j2.getTipoVitoria());
		assertEquals(2, j2.getPontuacao());
	}
	
	@Test
	void testPontuacaoBatidaLALO() {
		Jogada j1 = new Jogada(new Peca(1, 2), TipoJogada.NA_DIREITA, TipoJogadaVitoria.LA_LO);
		assertEquals(TipoJogadaVitoria.LA_LO, j1.getTipoVitoria());
		assertEquals(3, j1.getPontuacao());
		Jogada j2 = new Jogada(new Peca(1, 2), TipoJogada.NA_ESQUERDA, TipoJogadaVitoria.LA_LO);
		assertEquals(TipoJogadaVitoria.LA_LO, j2.getTipoVitoria());
		assertEquals(3, j2.getPontuacao());
	}
	
	@Test
	void testPontuacaoBatidaLALO_CARROCA() {
		Jogada j1 = new Jogada(new Peca(1, 2), TipoJogada.NA_DIREITA, TipoJogadaVitoria.LA_LO_DE_CARROCA);
		assertEquals(TipoJogadaVitoria.LA_LO_DE_CARROCA, j1.getTipoVitoria());
		assertEquals(6, j1.getPontuacao());
		Jogada j2 = new Jogada(new Peca(1, 2), TipoJogada.NA_ESQUERDA, TipoJogadaVitoria.LA_LO_DE_CARROCA);
		assertEquals(TipoJogadaVitoria.LA_LO_DE_CARROCA, j2.getTipoVitoria());
		assertEquals(6, j2.getPontuacao());
	}
	
	@Test
	void testPontuacaoTrancamento() {
		Jogada j1 = new Jogada();
		assertEquals(1, j1.getPontuacaoTrancamento());
	}
	
}
