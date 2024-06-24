package monstros;

public class Demonio extends Monstro{

	public Demonio() {
		super("Baphomet Lucius Satanius", "PEREÇA MORTAL INSOLENTE!", 200, 666);
	}

	@Override
	public void tomaDano(int dano) {
		this.setHP(this.getHP()-dano);
	}
	
}
