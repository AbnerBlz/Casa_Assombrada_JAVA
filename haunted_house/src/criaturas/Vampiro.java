package criaturas;

public class Vampiro extends Criatura{
	
	
	public Vampiro() {
		super("Vlad Laszlo Dracula", "Meu nome é Vlad Laszlo Dracula, eu sou ELE, e você será chupado!", 40, 200, 20);
		
	}


	@Override
	public void tomaDanoHP(int dano) {
		this.setHP(this.getHP()-dano);
		
	}
	
	
}
