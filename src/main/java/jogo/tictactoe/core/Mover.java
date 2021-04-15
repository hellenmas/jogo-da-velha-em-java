package jogo.tictactoe.core;

public class Mover {
	
	private int i;
	private int j;
	
	public Mover(String moveStr) throws MovimentoInvalidoException {
		try {
			
			String[] tokens = moveStr.split(",");
			
			this.i = Integer.parseInt(tokens[0]); 
			this.j = Integer.parseInt(tokens[1]); 
		} catch (Exception e) {
			throw new MovimentoInvalidoException("A jogada é inválida!");
		}
		
	}
	
	public int getI() {
		return i;
	}
	
	public int getJ() {
		return j;
	}

}
