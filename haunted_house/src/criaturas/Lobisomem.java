package criaturas;

public class Lobisomem extends Criatura{

	public Lobisomem() {
		super("Lewulfe, o lobisomem", "AAAWWWOOOOOOOO!!!", 25, 150, 25);
	}

	@Override
	public void tomaDanoHP(int dano) {
		this.setHP(this.getHP()-dano);
		
	}

}
