package criaturas;

public class Lobisomem extends Criatura{

	public Lobisomem() {
		super("Lewulfe", "AAAWWWOOOOOOOO!!!", 25, 80, 25);
	}

	@Override
	public void tomaDanoHP(int dano) {
		this.setHP(this.getHP()-dano);
		
	}

}
