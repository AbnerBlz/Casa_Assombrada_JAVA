package itens;

import jogador.Jogador;

public class Cigarro extends Item{
	private int statQuant2 = 10;
	
	public Cigarro() {
		super("Cigarro", "Um cigarro solto no meio de uma casa assombrada. Você sabe que isso vai te fazer mal...Mas você viu tanta coisa que seus nervos estão implorando por um alívio.", 20);

	}

	@Override
	public void consome(Jogador jogador) {
		System.out.println("Você sabia que ia fazer mal. Perdeu 10 hp");
		jogador.setSanidade(jogador.getSanidade()+this.getStatQuant());
		jogador.setHP(jogador.getHP() - statQuant2);
		
	}
	
}
