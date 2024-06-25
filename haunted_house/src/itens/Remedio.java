package itens;

import jogador.Jogador;

public class Remedio extends Item{

	public Remedio() {
		super("Remédio", "Um remédio. Parece não ter adiantado muita coisa, considerando os habitantes dessa casa...espera, parece ser um...Dorflex?", 40);
	}

	@Override
	public void consome(Jogador jogador) {
		jogador.setHP(jogador.getHP()+ getStatQuant());
		
	}

}
