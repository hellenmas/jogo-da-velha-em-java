package jogo.tictactoe.core;

import jogo.tictactoe.UI.UI;

public class Jogador {
	
	private String nome;
	private Tabuleiro tabuleiro;
	private char simbolo;
	
	public Jogador(String nome, Tabuleiro tabuleiro, char simbolo) {
		this.nome = nome;
		this.tabuleiro = tabuleiro;
		this.simbolo = simbolo;
	}

	public String getNome() {
		return nome;
	}

	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

	public char getSimbolo() {
		return simbolo;
	}

	private Mover movimento() throws MovimentoInvalidoException {
		String moveStr = UI.lerTextoDigitado("Jogador '" + nome + "' =>");
		return new Mover(moveStr);
	}
	
	public boolean play() throws MovimentoInvalidoException {
		Mover movim = movimento();
		return tabuleiro.play(this, movim);
	}

}
