package jogo.tictactoe.core;

import jogo.tictactoe.Constants;
import jogo.tictactoe.UI.UI;

public class Jogo {
	
	private Tabuleiro board = new Tabuleiro();
	private Jogador[] players = new Jogador[Constants.SYMBOL_PLAYER.length];
	private int indiceJogadorAtual = -1;
	
	public void play() {
		UI.imprimeTituloDoJogo();
		
		for(int i = 0; i < players.length; i++) {
			players[i] = criaJogador(i);
		}
		
		boolean terminou = false;
		Jogador jogadorAtual = proximo();
		Jogador vencedor = null;
		
		while(!terminou) {
			board.imprimir();
			
			boolean sequenciaEncontrada;
			
			try {
				sequenciaEncontrada = jogadorAtual.play();
			} catch (MovimentoInvalidoException e) {
				UI.imprimeTexto("ERRO: " + e.getMessage());
				continue;
			}
			
			if(sequenciaEncontrada) {
				terminou = true;
				vencedor = jogadorAtual;
			} else if (board.cheio()) {
				terminou = true;
				System.out.println("EMPATE");
			}
			
			jogadorAtual = proximo();
		}
		
		if (vencedor == null) {
			UI.imprimeTexto("O jogo terminou empatado!");
		} else {
			UI.imprimeTexto("O jogador '" + vencedor.getNome() + "' venceu o jogo!");
		}
		
		board.imprimir();
		UI.imprimeTexto("---FIM DO JOGO---");
	}
	
	private Jogador criaJogador(int indice) {
		String name = UI.lerTextoDigitado("Jogador " + (indice + 1) + " =>");
		char symbol = Constants.SYMBOL_PLAYER[indice];
		Jogador player = new Jogador(name, board, symbol);
		
		UI.imprimeTexto("O jogador " + name + " vai usar o símbolo '" + symbol +"'");
		
		return player;
	}
	
	private Jogador proximo() {
		indiceJogadorAtual++;
		
	
		if(indiceJogadorAtual >= players.length) {
			indiceJogadorAtual = 0;
		}
		
		return players[indiceJogadorAtual];
	
	}

}
