package criaturas;

public class Vampiro extends Criatura{
	
	
	public Vampiro(String nome, String frase, int dano, int hp) {
		super("Vlad Laszlo Dracula", "Meu nome é Vlad Laszlo Dracula, eu sou ELE, e você será chupado!", 40, 200);
		
	}


	@Override
	public void tomaDano(int dano) {
		this.setHP(this.getHP()-dano);
		
	}
	
	
}
