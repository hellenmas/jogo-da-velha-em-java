package jogo.tictactoe.UI;

import br.com.softblue.commons.io.Console;

public class UI {

	public static void imprimeTexto(String text) {
		System.out.println(text);
	}

	public static void imprimeTextoSemNovaLinha(String text) {
		System.out.print(text);
	}

	public static void imprimeNovaLinha() {
		System.out.println();
	}

	public static void imprimeTituloDoJogo() {
		imprimeTexto("==================");
		imprimeTexto("| JOGO DA  VELHA |");
		imprimeTexto("==================");
		imprimeNovaLinha();
	}

	public static String lerTextoDigitado(String text) {
		imprimeTextoSemNovaLinha(text + " ");
		return Console.readString();
	}

}
