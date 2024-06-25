package criaturas;

public class Fada extends Criatura{

	public Fada() {
		super("Luna", "Olá aventureiro! Parece que você se meteu numa enrascada, deixe eu te ajudar!", 40, 100);
		
	}

	@Override
	public void tomaDano(int dano) {
		System.out.println("por favor não me ataque, eu só quero te ajudar ;-;");
		
	}

}
