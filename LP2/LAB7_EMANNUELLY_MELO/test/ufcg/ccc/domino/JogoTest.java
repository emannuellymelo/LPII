package ufcg.ccc.domino;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;

import ufcg.ccc.domino.estrategia.EstrategiaInvalidaException;
import ufcg.ccc.domino.estrategia.JogaPrimeiraPossivel;
import ufcg.ccc.domino.estrategia.JogaPrimeiroCarrocao;
import ufcg.ccc.domino.estrategia.JogaRepetidosPorUltimo;

class JogoTest {

	@Test
	void testRodadaInicial() throws JogadaInvalidaException, EstrategiaInvalidaException {
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), 14);

		assertEquals(0, j.getNumRodadas());
		assertEquals(14, j.getNumPecasJ1());
		assertEquals(14, j.getNumPecasJ2());

		j.rodada();

		assertEquals(1, j.getNumRodadas());
		assertEquals(13, j.getNumPecasJ1());
		assertEquals(13, j.getNumPecasJ2());
	}
	
	@Test
	void testJogoAleatorio() throws JogadaInvalidaException, EstrategiaInvalidaException {
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), 10, new Random(1));

		HistoricoDeJogo historico = j.jogaJogoCompleto();

		assertTrue(j.isFinalizado());
		assertEquals("J1", j.getVencedor());
		
		System.out.println(historico.toString());
	}

	@Test
	void testVencedorJ1Simples() throws Exception {
		List<Peca> mao1 = List.of(new Peca(0, 0), new Peca(0, 1));
		List<Peca> mao2 = List.of(new Peca(0, 2), new Peca(0, 3));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		assertFalse(j.isFinalizado());
		assertEquals(null, j.getVencedor());

		j.jogaJogoCompleto();
		
		assertTrue(j.isFinalizado());
		assertEquals("J1", j.getVencedor());
	}
	
	@Test
	void testVitoriaJ1DiferentesEstrategias() throws Exception {
		List<Peca> mao1 = List.of(new Peca(0, 0), new Peca(0, 1));
		List<Peca> mao2 = List.of(new Peca(0, 2), new Peca(0, 3));
		
		Jogo jogo1 = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiroCarrocao(), mao1, mao2);
		
		jogo1.jogaJogoCompleto();
		
		assertTrue(jogo1.isFinalizado());
		assertEquals("J1", jogo1.getVencedor());
		
		Jogo jogo2 = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaRepetidosPorUltimo(), mao1, mao2);
		
		jogo2.jogaJogoCompleto();
		
		assertTrue(jogo2.isFinalizado());
		assertEquals("J1", jogo2.getVencedor());
		
		Jogo jogo3 = new Jogo("J1", new JogaRepetidosPorUltimo(), "J2", new JogaPrimeiroCarrocao(), mao1, mao2);
		
		jogo3.jogaJogoCompleto();
		
		assertTrue(jogo3.isFinalizado());
		assertEquals("J1", jogo3.getVencedor());
		
	}
	
	@Test
	void testEmpate() throws Exception {
		List<Peca> mao1 = List.of(new Peca(0, 0), new Peca(4, 6));
		List<Peca> mao2 = List.of(new Peca(0, 1), new Peca(5, 5));
		//Jogadores passam com soma e quantidade de peças iguais
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		j.jogaJogoCompleto();
		
		assertTrue(j.isFinalizado());
		assertNull(j.getVencedor());
	}
	
	@Test
	void testTrancamento() throws Exception {
		List<Peca> mao1 = List.of(new Peca(0, 0), new Peca(4, 6));
		List<Peca> mao2 = List.of(new Peca(0, 1), new Peca(6, 6));
		List<Peca> mao3 = List.of(new Peca(0, 1), new Peca(5, 5), new Peca(6, 6));
		
		//Jogadores passam com quantidade de peças iguais mas com somas diferentes
		Jogo novaPartida = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao2, mao1);
		
		HistoricoDeJogo historico = novaPartida.jogaJogoCompleto();
		
		assertTrue(novaPartida.isFinalizado());
		assertEquals("J2", novaPartida.getVencedor());
		
		//Pontuacao do vencedor do desempate
		assertEquals(1, novaPartida.getPontuacao());
		
		System.out.println(historico.toString());
		
		//Jogadores passam com quantidade de pecas distintas
		Jogo novaPartida2 = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao3);
		
		HistoricoDeJogo historico2 = novaPartida2.jogaJogoCompleto();
		
		assertTrue(novaPartida2.isFinalizado());
		assertEquals("J1", novaPartida2.getVencedor());
		
		//Pontuacao do vencedor do desempate
		assertEquals(1, novaPartida2.getPontuacao());
		
		System.out.println(historico2.toString());
		
	}
	
	@Test
	void testVitoriaJ2() throws Exception {
		List<Peca> mao1 = List.of(new Peca(0, 0), new Peca(6, 6));
		List<Peca> mao2 = List.of(new Peca(0, 1), new Peca(1, 2));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		j.jogaJogoCompleto();
		
		assertTrue(j.isFinalizado());
		assertEquals("J2", j.getVencedor());
	}
	
	@Test
	void testVitoriaJ2DiferentesEstrategias() throws Exception {
		List<Peca> mao1 = List.of(new Peca(0, 0), new Peca(6, 6));
		List<Peca> mao2 = List.of(new Peca(0, 1), new Peca(1, 2));
		
		Jogo jogo1 = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiroCarrocao(), mao1, mao2);
		
		jogo1.jogaJogoCompleto();
		
		assertTrue(jogo1.isFinalizado());
		assertEquals("J2", jogo1.getVencedor());
		
		Jogo jogo2 = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaRepetidosPorUltimo(), mao1, mao2);
		
		jogo2.jogaJogoCompleto();
		
		assertTrue(jogo2.isFinalizado());
		assertEquals("J2", jogo2.getVencedor());
		
		Jogo jogo3 = new Jogo("J1", new JogaRepetidosPorUltimo(), "J2", new JogaPrimeiroCarrocao(), mao1, mao2);
		
		jogo3.jogaJogoCompleto();
		
		assertTrue(jogo3.isFinalizado());
		assertEquals("J2", jogo3.getVencedor());
	}
	
	
}
