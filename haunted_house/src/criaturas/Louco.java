package criaturas;

public class Louco extends Criatura{

	public Louco() {
		super("Akrislav", "heheehee...1...2...3...cante outra vez...HAHAAAHAHAHAA!!!", 20, 20, 15);

	}

	@Override
	public void tomaDanoHP(int dano) {
		this.setHP(this.getHP()-dano);
	}

}
