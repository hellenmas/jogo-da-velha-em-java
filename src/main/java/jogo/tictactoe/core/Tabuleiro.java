package jogo.tictactoe.core;

import jogo.tictactoe.Constants;
import jogo.tictactoe.UI.UI;

public class Tabuleiro {
	
	private char[][] matriz;
	
	public Tabuleiro() {
		matriz = new char[Constants.BOARD_SIZE][Constants.BOARD_SIZE];
		limpar();
	}
	
	public void limpar() {
		for (int i=0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = ' ';
			}
		}
	}
	
	public void imprimir() {
		UI.imprimeNovaLinha();
		
		for (int i=0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				UI.imprimeTextoSemNovaLinha(String.valueOf(matriz[i][j]));
				
				if (j < matriz[i].length - 1) {
					UI.imprimeTextoSemNovaLinha(" | ");
				}
			}
			
			UI.imprimeNovaLinha();
			
			if (i < matriz.length - 1) {
				UI.imprimeTexto("---------");
			}
		}
	}
	
	public boolean cheio() {
		for (int i=0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (matriz[i][j] == ' ') {
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean play(Jogador player, Mover movimento) throws MovimentoInvalidoException {
		int i = movimento.getI();
		int j = movimento.getJ();
		
		if (i < 0 || j < 0 || i >= matriz.length || j >= matriz.length) {
			throw new MovimentoInvalidoException("O intervalo da jogada é inválido");
		}
		
		if (matriz[i][j] != ' ') {
			throw new MovimentoInvalidoException("Este espaço já está preenchido");
		}
		
		matriz[i][j] = player.getSimbolo();
		
		return checkLinhaS(player) || checkColunaS(player) || checkDiagonal1(player) || checkDiagonal2(player);
	}
	
	private boolean checkLinha(int i, Jogador player) {
		char simbolo = player.getSimbolo();
		
		for(int j = 0; j < Constants.BOARD_SIZE; j++) {
			if(matriz[i][j]!= simbolo) {
				return false;
			}
		}
		
		return true;
	}
	
	private boolean checkLinhaS(Jogador player) {
		for(int i = 0; i < Constants.BOARD_SIZE; i++) {
			if(checkLinha(i, player)) {
				return true;
			}
		}
		
		return false;
	}

	private boolean checkColuna(int j, Jogador player) {
		char simbolo = player.getSimbolo();
		
		for(int i = 0; i < Constants.BOARD_SIZE; i++) {
			if(matriz[i][j]!= simbolo) {
				return false;
			}
		}
		
		return true;
	}
	
	private boolean checkColunaS(Jogador player) {
		for(int j = 0; j < Constants.BOARD_SIZE; j++) {
			if(checkColuna(j, player)) {
				return true;
			}
		}
		
		return false;
	}
	
	private boolean checkDiagonal1(Jogador player) {
		char simbolo = player.getSimbolo();

		for(int i = 0; i < Constants.BOARD_SIZE; i++) {
			if(matriz[i][i] != simbolo) {
				return false;
			}
		}
		return true;
	}
	
	private boolean checkDiagonal2(Jogador player) {
		char simbolo = player.getSimbolo();
		int ultimaLinha = Constants.BOARD_SIZE - 1; 
		
		for(int i = ultimaLinha, j = 0; i >= 0; i--, j++) {
			if (matriz[i][j] != simbolo) {
				return false;
			}
		}
		
		return true;
	}
}
