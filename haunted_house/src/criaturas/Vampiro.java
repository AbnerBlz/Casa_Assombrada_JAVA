package monstros;

public class Vampiro extends Monstro{
	
	
	public Vampiro(String nome, String frase, int dano, int hp) {
		super("Vlad Laszlo Dracula", "Meu nome é Vlad Laszlo Dracula, eu sou ELE, e você será chupado!", 40, 200);
		
	}

	/*
	 * public Vampiro() { this.setNome("Vlad Laszlo Dracula"); this.setHP (200);
	 * this.setFrase("Meu nome é " + this.getNome() +
	 * ", eu sou ELE, e você será chupado!"); this.setDano(40); }
	 */

	@Override
	public void tomaDano(int dano) {
		this.setHP(this.getHP()-dano);
		
	}
	
	
}
