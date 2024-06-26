package criaturas;

public class Esqueleto extends Criatura{

	public Esqueleto() {
		super("Esqueleto", "ARRGH!", 20, 20);
	}

	@Override
	public void tomaDanoHP(int dano) {
		this.setHP(this.getHP()-dano);
		
	}

}
