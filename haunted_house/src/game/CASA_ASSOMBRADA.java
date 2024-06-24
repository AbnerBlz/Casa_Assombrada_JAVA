package game;
import java.util.Scanner;

import jogador.Jogador;

public class CASA_ASSOMBRADA {
	private boolean Rodando;
	private Jogador jogador;
	private Scanner scanner = new Scanner(System.in);
	
	CASA_ASSOMBRADA(){
		this.setJogador(new Jogador());
	}
	
	public void inicia() {
		Rodando = true;
		
		while (Rodando == true) {
			
		}
	}


	public Jogador getJogador() {
		return jogador;
	}


	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}
	
}
