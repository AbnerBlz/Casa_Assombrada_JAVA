package criaturas;

public class Vampiro extends Criatura{
	
	
	public Vampiro() {
		super("Vlad Laszlo Dracula", "Lentamente desapareço entre as trevas, e deixo com que os arcanjos o levem...você será chupado!", 40, 200, 20);
		
	}


	@Override
	public void tomaDanoHP(int dano) {
		this.setHP(this.getHP()-dano);
		
	}
	
	
}
