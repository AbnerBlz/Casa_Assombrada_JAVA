package itens;
import jogador.Jogador;

public class Cafe extends Item{

	
	public Cafe() {
		super("Café", "Um café fresco, quente, e por algum motivo, já adoçado", 25);
	}

	public void consome(Jogador jogador) {
		jogador.setSanidade(jogador.getSanidade()+this.getStatQuant());
		
	}

}
