package criaturas;

public class Demonio extends Criatura{

	public Demonio() {
		super("Baphomet Lucius Satanius", "PEREÇA MORTAL INSOLENTE!", 666, 666, 666);
	}

	@Override
	public void tomaDanoHP(int dano) {
		this.setHP(this.getHP()-dano);
	}
	
}
