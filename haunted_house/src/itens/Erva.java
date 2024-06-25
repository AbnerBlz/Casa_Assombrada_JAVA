package itens;

import jogador.Jogador;

public class Erva extends Item{

	public Erva() {
		super("Erva verde", "Uma erva de cor esverdeada que por algum motivo, parece que vai te curar...huh, eu achava que isso só existia em jogos de fantasia.", 20);
	}

	@Override
	public void consome(Jogador jogador) {
		jogador.setHP(jogador.getHP()+ getStatQuant());
	}
	
}
