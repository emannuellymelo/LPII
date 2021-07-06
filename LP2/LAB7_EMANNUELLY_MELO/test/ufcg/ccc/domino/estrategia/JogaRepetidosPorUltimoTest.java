package ufcg.ccc.domino.estrategia;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Mesa;
import ufcg.ccc.domino.Peca;
import ufcg.ccc.domino.Jogada.TipoJogada;
import ufcg.ccc.domino.Jogada.TipoJogadaVitoria;

class JogaRepetidosPorUltimoTest {
	private Mesa mesa;
	private Mesa novaMesa;

	@BeforeEach
	void setUp() throws Exception {
		mesa = new Mesa();
		mesa.jogaNaDireita(new Peca(1, 2));
		mesa.jogaNaEsquerda(new Peca(1, 1));
	}

	@Test
	void testPassa() {
		JogaRepetidosPorUltimo estrategia = new JogaRepetidosPorUltimo();

		Jogada j1 = estrategia.decideJogada(mesa, List.of(new Peca(5, 5), new Peca(0, 3)));

		assertEquals(TipoJogada.PASSA, j1.getTipo());
	}
	
	//Primeira peca colocada possui um número diferente do que mais se repete
	@Test
	void testJogaPrimeira() {
		JogaRepetidosPorUltimo estrategia = new JogaRepetidosPorUltimo();

		Jogada j1 = estrategia.decideJogada(mesa, List.of(new Peca(1, 3), new Peca(0, 2), new Peca(1, 1)));

		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
		assertEquals(0, j1.getPeca().getNumEsquerdo());
		assertEquals(2, j1.getPeca().getNumDireito());
	}
	
	@Test
	void testVerificaBatidaNormal() {
		JogaRepetidosPorUltimo estrategia = new JogaRepetidosPorUltimo();

		Jogada j1 = estrategia.decideJogada(mesa, List.of(new Peca(2, 2), new Peca(1, 2), new Peca(1, 6)));

		assertEquals(TipoJogada.NA_ESQUERDA, j1.getTipo());
		assertEquals(1, j1.getPeca().getNumEsquerdo());
		assertEquals(6, j1.getPeca().getNumDireito());
		assertEquals(TipoJogadaVitoria.BATIDA_NORMAL, j1.getTipoVitoria());
	}
	
	
	@Test
	void testVerificaBatidaCarroca() {
		JogaRepetidosPorUltimo estrategia = new JogaRepetidosPorUltimo();

		Jogada j1 = estrategia.decideJogada(mesa, List.of(new Peca(1, 1), new Peca(2, 2), new Peca(1, 6)));

		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
		assertEquals(2, j1.getPeca().getNumEsquerdo());
		assertEquals(2, j1.getPeca().getNumDireito());
		assertEquals(TipoJogadaVitoria.BATIDA_CARROCA, j1.getTipoVitoria());
	}
	
	@Test
	void testVerificaBatidaLaLo() {
		JogaRepetidosPorUltimo estrategia = new JogaRepetidosPorUltimo();

		Jogada j1 = estrategia.decideJogada(mesa, List.of(new Peca(2, 1), new Peca(3, 1), new Peca(3, 3)));

		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
		assertEquals(2, j1.getPeca().getNumEsquerdo());
		assertEquals(1, j1.getPeca().getNumDireito());
		assertEquals(TipoJogadaVitoria.LA_LO, j1.getTipoVitoria());
	}
	
	@Test
	void testVerificaBatidaLaLoDeCarroca() throws Exception {
		novaMesa = new Mesa();
		novaMesa.jogaNaDireita(new Peca(1, 2));
		novaMesa.jogaNaEsquerda(new Peca(1, 1));
		novaMesa.jogaNaDireita(new Peca(2, 1));
		
		JogaPrimeiraPossivel estrategia = new JogaPrimeiraPossivel();
		
		Jogada j1 = estrategia.decideJogada(novaMesa, List.of(new Peca(2, 3), new Peca(1, 1), new Peca(2, 2)));

		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
		assertEquals(1, j1.getPeca().getNumEsquerdo());
		assertEquals(1, j1.getPeca().getNumDireito());
		assertEquals(TipoJogadaVitoria.LA_LO_DE_CARROCA, j1.getTipoVitoria());
	}

}
