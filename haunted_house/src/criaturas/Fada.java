package criaturas;


public class Fada extends Criatura{

	//adicionar depois interface de ajudante/amigavel
	public Fada() {
		super("Luna", "Olá aventureiro! Parece que você se meteu numa enrascada, deixe eu te ajudar!(Cura, item extra e buff ^^)", 25, 15, 10);
	}

	@Override
	public void tomaDanoHP(int dano) {
		System.out.println("por favor não me ataque, eu só quero te ajudar ;-;");
		
	}

}
