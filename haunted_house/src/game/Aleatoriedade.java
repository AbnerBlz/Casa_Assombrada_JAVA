package game;
import java.util.Random;
import criaturas.*;
import armadilhas.*;
import itens.*;

public class Aleatoriedade {
	private Random Aleatorio;
	
	public Aleatoriedade() {
		this.Aleatorio = new Random();
	}
	
	public Object geraEvento() {
		int evento = Aleatorio.nextInt(3);
		
		switch (evento) {
		case 1:
			return geraCriatura();
		default: return null;
		}
		
	}

	private Object geraCriatura() {
		int azar = Aleatorio.nextInt(1);
		
		switch (azar) {
		case 1:
			return new Vampiro();
			
		default: return null;
		}
		
		
	}
	
	
}
