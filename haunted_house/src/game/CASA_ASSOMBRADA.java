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
		int opcao;
		Rodando = true;
		System.out.println("Você está agora numa casa assombrada, e não tem pra onde fugir.");
		while (Rodando == true) {
			System.out.println("Você gostaria de: ");
			System.out.println("1 - Explorar o próximo quarto?");
			System.out.println("2 - Verificar sua deplorável situação atual?");
			System.out.println("3 - Ver seu inventário?");
		}
		opcao = scanner.nextInt();
		scanner.nextLine();
		
		switch (opcao) {
		case 1: {
			
		}
		case 2: {
			jogador.mostraStats();
		}
		case 3: {
			
		}
		default:
			throw new IllegalArgumentException("Não adianta tentar correr.");
		}
	}


	public Jogador getJogador() {
		return jogador;
	}


	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}
	
}
