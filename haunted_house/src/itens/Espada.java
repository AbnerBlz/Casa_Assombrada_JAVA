package itens;

import jogador.Jogador;

public class Espada extends Item{

	public Espada() {
		super("Espada", "Uma espada ''comum'', de aparência antiga. Bem conveniente de se encontrar num lugar desses.", 30);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void consome(Jogador jogador) {
		jogador.setDano(jogador.getDano()+getStatQuant());
	}

}
