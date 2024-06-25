package criaturas;

public class Zumbi extends Criatura{

	public Zumbi() {
		super("Morto-Vivo comum", "uuurrr...cérebros!", 20, 10);
		
	}

	@Override
	public void tomaDano(int dano) {
		this.setHP(this.getHP()-dano);
		
	}
	
}
