package ufcg.ccc.domino;

import ufcg.ccc.domino.Jogada.TipoJogadaVitoria;
import ufcg.ccc.domino.estrategia.EstrategiaDeJogo;
import ufcg.ccc.domino.estrategia.EstrategiaInvalidaException;
import ufcg.ccc.domino.estrategia.JogaPrimeiraPossivel;
import ufcg.ccc.domino.estrategia.JogaPrimeiroCarrocao;
import ufcg.ccc.domino.estrategia.JogaRepetidosPorUltimo;

/**
 * Exemplo de como fazer um um main com uma disputa de muuuitos jogos entre duas
 * estrat�gias.
 * 
 */
public class DominoBrutalRepetido {

	public static void main(String[] args) throws EstrategiaInvalidaException, JogadaInvalidaException {
		int pontuacaoJ1 = 0, pontuacaoJ2 = 0, empates = 0;
		int batidaNormalJ1 = 0, batidaNormalJ2 = 0, batidaCarrocaJ1 = 0, batidaCarrocaJ2 = 0, batidalaloJ1 = 0, batidalaloJ2 = 0, batidalaloCarrocaJ1 = 0, batidalaloCarrocaJ2 = 0, trancamentos = 0;
		String nomeEstrategia1 = "Joga Repetidos Por �ltimo";
		String nomeEstrategia2 = "Joga Primeiro Carro��o";
		EstrategiaDeJogo estrategia1 = new JogaRepetidosPorUltimo(), estrategia2 = new JogaPrimeiroCarrocao();
		
		for (int i = 0; i < 10000; i++) {
			Jogo j = new Jogo("J1", estrategia1, "J2", estrategia2, 12);
			HistoricoDeJogo historico = j.jogaJogoCompleto();
			if (historico.isEmpate()) {
				empates ++;
			} else if (historico.getVencedor() == "J1") {
				pontuacaoJ1 += j.getPontuacao();
				if(j.getBatida() == TipoJogadaVitoria.BATIDA_NORMAL) {
					batidaNormalJ1 ++;
				} else if(j.getBatida() == TipoJogadaVitoria.BATIDA_CARROCA) {
					batidaCarrocaJ1 ++;
				} else if(j.getBatida() == TipoJogadaVitoria.LA_LO) {
					batidalaloJ1 ++;
				} else if(j.getBatida() == TipoJogadaVitoria.LA_LO_DE_CARROCA) {
					batidalaloCarrocaJ1 ++;
				} else if(j.getBatida() == null) {
					trancamentos ++;
				}
			} else if (historico.getVencedor() == "J2") {
				pontuacaoJ2 += j.getPontuacao();
				if(j.getBatida() == TipoJogadaVitoria.BATIDA_NORMAL) {
					batidaNormalJ2 ++;
				} else if(j.getBatida() == TipoJogadaVitoria.BATIDA_CARROCA) {
					batidaCarrocaJ2 ++;
				} else if(j.getBatida() == TipoJogadaVitoria.LA_LO) {
					batidalaloJ2 ++;
				} else if(j.getBatida() == TipoJogadaVitoria.LA_LO_DE_CARROCA) {
					batidalaloCarrocaJ2 ++;
				} else if(j.getBatida() == null) {
					trancamentos ++;
				}
			}
		}
		
		System.out.println("================== Novo Jogo ==================\n");

		System.out.println("Total de Jogos:\t" + (empates + trancamentos + batidaNormalJ1 + batidaCarrocaJ1 + batidalaloCarrocaJ1 + batidalaloJ1 + batidaNormalJ2 + batidaCarrocaJ2 + batidalaloJ2 + batidalaloCarrocaJ2 ) + "\n" +"\nEstrat�gia J1:\t" + nomeEstrategia1 + "\nPontua��o J1:\t" + (pontuacaoJ1  + empates) + "pontos\nQuantidade de batidas normais: " + batidaNormalJ1 + "\nQuantidade de batidas de carro�a: " + batidaCarrocaJ1 + "\nQuantidade de batidas l� l�: " + batidalaloJ1 + "\nQuantidade de batidas l� l� de carro�a: " + batidalaloCarrocaJ1 
				+ "\n" + "\nEstrat�gia J2:\t" + nomeEstrategia2 +  "\nPontua��o J2:\t" + (pontuacaoJ2 + empates) + "pontos\nQuantidade de batidas normais: " + batidaNormalJ2 + "\nQuantidade de batidas de carro�a: " + batidaCarrocaJ2 + "\nQuantidade de batidas l� l�: " + batidalaloJ2 + "\nQuantidade de batidas l� l� de carro�a: " + batidalaloCarrocaJ2
				+ pontuacaoJ2 + "\n" + "\nN�mero de Trancamentos:\t" + trancamentos +"\nN�mero de Empates:\t" + empates);
		
		System.out.println("\n================== Novo Jogo ==================\n");
		
		int pontuacaoJ3 = 0, pontuacaoJ4 = 0, empates2 = 0;
		int batidaNormalJ3 = 0, batidaNormalJ4 = 0, batidaCarrocaJ3 = 0, batidaCarrocaJ4 = 0, batidalaloJ3 = 0, batidalaloJ4 = 0, batidalaloCarrocaJ3 = 0, batidalaloCarrocaJ4 = 0, trancamentos2 = 0;
		String nomeEstrategia3 = "Joga Primeira Poss�vel";
		String nomeEstrategia4 = "Joga Primeiro Carro��o";
		
		EstrategiaDeJogo estrategia3 = new JogaPrimeiraPossivel(), estrategia4 = new JogaPrimeiroCarrocao();
		
		for (int i = 0; i < 10000; i++) {
			Jogo j = new Jogo("J1", estrategia3, "J2", estrategia4, 12);
			HistoricoDeJogo historico = j.jogaJogoCompleto();
			if (historico.isEmpate()) {
				empates2 ++;
			} else if (historico.getVencedor() == "J1") {
				pontuacaoJ3 += j.getPontuacao();
				if(j.getBatida() == TipoJogadaVitoria.BATIDA_NORMAL) {
					batidaNormalJ3 ++;
				} else if(j.getBatida() == TipoJogadaVitoria.BATIDA_CARROCA) {
					batidaCarrocaJ3 ++;
				} else if(j.getBatida() == TipoJogadaVitoria.LA_LO) {
					batidalaloJ3 ++;
				} else if(j.getBatida() == TipoJogadaVitoria.LA_LO_DE_CARROCA) {
					batidalaloCarrocaJ3 ++;
				} else if(j.getBatida() == null) {
					trancamentos2 ++;
				}
			} else if (historico.getVencedor() == "J2") {
				pontuacaoJ4 += j.getPontuacao();
				if(j.getBatida() == TipoJogadaVitoria.BATIDA_NORMAL) {
					batidaNormalJ4 ++;
				} else if(j.getBatida() == TipoJogadaVitoria.BATIDA_CARROCA) {
					batidaCarrocaJ4 ++;
				} else if(j.getBatida() == TipoJogadaVitoria.LA_LO) {
					batidalaloJ4 ++;
				} else if(j.getBatida() == TipoJogadaVitoria.LA_LO_DE_CARROCA) {
					batidalaloCarrocaJ4 ++;
				} else if(j.getBatida() == null) {
					trancamentos2 ++;
				}
			}
		}

		System.out.println("Total de Jogos:\t" + (empates2 + trancamentos2 + batidaNormalJ3 + batidaCarrocaJ3 + batidalaloCarrocaJ3 + batidalaloJ3 + batidaNormalJ4 + batidaCarrocaJ4 + batidalaloJ4 + batidalaloCarrocaJ4 ) + "\n" + "\nEstrat�gia J1:\t" + nomeEstrategia3 + "\nPontua��o J1:\t" + (pontuacaoJ3 + empates2) + "pontos\nQuantidade de batidas normais: " + batidaNormalJ3 + "\nQuantidade de batidas de carro�a: " + batidaCarrocaJ3 + "\nQuantidade de batidas l� l�: " + batidalaloJ3 + "\nQuantidade de batidas l� l� de carro�a: " + batidalaloCarrocaJ3 
				+ "\n"+ "\nEstrat�gia J2:\t" + nomeEstrategia4 +  "\nPontua��o J2:\t" + pontuacaoJ4 + "pontos\nQuantidade de batidas normais: " + batidaNormalJ4 + "\nQuantidade de batidas de carro�a: " + batidaCarrocaJ4 + "\nQuantidade de batidas l� l�: " + batidalaloJ4 + "\nQuantidade de batidas l� l� de carro�a: " + batidalaloCarrocaJ4
				+ (pontuacaoJ4 + empates2) + "\n" + "\nN�mero de Trancamentos:\t" + trancamentos2 +"\nN�mero de Empates:\t" + empates2);
		
		System.out.println("\n================== Novo Jogo ==================\n");
		
		int pontuacaoJ5 = 0, pontuacaoJ6 = 0, empates3 = 0;
		int batidaNormalJ5 = 0, batidaNormalJ6 = 0, batidaCarrocaJ5 = 0, batidaCarrocaJ6 = 0, batidalaloJ5 = 0, batidalaloJ6 = 0, batidalaloCarrocaJ5 = 0, batidalaloCarrocaJ6 = 0, trancamentos3 = 0;
		String nomeEstrategia5 = "Joga Primeira Poss�vel";
		String nomeEstrategia6 = "Joga Repetidos Por �ltimo";
		
		EstrategiaDeJogo estrategia5 = new JogaPrimeiraPossivel(), estrategia6 = new JogaPrimeiroCarrocao();
		
		for (int i = 0; i < 10000; i++) {
			Jogo j = new Jogo("J1", estrategia5, "J2", estrategia6, 12);
			HistoricoDeJogo historico = j.jogaJogoCompleto();
			if (historico.isEmpate()) {
				empates3 ++;
			} else if (historico.getVencedor() == "J1") {
				pontuacaoJ5 += j.getPontuacao();
				if(j.getBatida() == TipoJogadaVitoria.BATIDA_NORMAL) {
					batidaNormalJ5 ++;
				} else if(j.getBatida() == TipoJogadaVitoria.BATIDA_CARROCA) {
					batidaCarrocaJ5 ++;
				} else if(j.getBatida() == TipoJogadaVitoria.LA_LO) {
					batidalaloJ5 ++;
				} else if(j.getBatida() == TipoJogadaVitoria.LA_LO_DE_CARROCA) {
					batidalaloCarrocaJ5 ++;
				} else if(j.getBatida() == null) {
					trancamentos3 ++;
				}
			} else if (historico.getVencedor() == "J2") {
				pontuacaoJ6 += j.getPontuacao();
				if(j.getBatida() == TipoJogadaVitoria.BATIDA_NORMAL) {
					batidaNormalJ6 ++;
				} else if(j.getBatida() == TipoJogadaVitoria.BATIDA_CARROCA) {
					batidaCarrocaJ6 ++;
				} else if(j.getBatida() == TipoJogadaVitoria.LA_LO) {
					batidalaloJ6 ++;
				} else if(j.getBatida() == TipoJogadaVitoria.LA_LO_DE_CARROCA) {
					batidalaloCarrocaJ6 ++;
				} else if(j.getBatida() == null) {
					trancamentos3 ++;
				}
			}
		}

		System.out.println("Total de Jogos:\t" + (empates3 + trancamentos3 + batidaNormalJ5 + batidaCarrocaJ5 + batidalaloCarrocaJ5 + batidalaloJ5 + batidaNormalJ6 + batidaCarrocaJ6 + batidalaloJ6 + batidalaloCarrocaJ6 ) + "\n" + "\nEstrat�gia J1:\t" + nomeEstrategia5 + "\nPontua��o J1:\t" + (pontuacaoJ5 + empates3) + "pontos\nQuantidade de batidas normais: " + batidaNormalJ5 + "\nQuantidade de batidas de carro�a: " + batidaCarrocaJ5 + "\nQuantidade de batidas l� l�: " + batidalaloJ5 + "\nQuantidade de batidas l� l� de carro�a: " + batidalaloCarrocaJ5 
				+ "\n" + "\nEstrat�gia J2:\t" + nomeEstrategia6 +  "\nPontua��o J2:\t" + pontuacaoJ6 + "pontos\nQuantidade de batidas normais: " + batidaNormalJ6 + "\nQuantidade de batidas de carro�a: " + batidaCarrocaJ6 + "\nQuantidade de batidas l� l�: " + batidalaloJ6 + "\nQuantidade de batidas l� l� de carro�a: " + batidalaloCarrocaJ6
				+ (pontuacaoJ6 + empates3) + "\n"  +"\nN�mero de Trancamentos:\t" + trancamentos3 +"\nN�mero de Empates:\t" + empates3);

	}

}
