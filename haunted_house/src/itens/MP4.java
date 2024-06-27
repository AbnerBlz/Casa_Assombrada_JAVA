package itens;

import jogador.Jogador;

public class MP4 extends Item{

	public MP4() {
		super("Player MP4", "Um dispositivo de tempos antigos! E parece possuir só os clássicos...ABBA, Queen, Michael Jackson...pena que só da pra escutar uma vez", 25);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void consome(Jogador jogador) {
		jogador.setSanidade(jogador.getSanidade()+this.getStatQuant());
		
	}

}
