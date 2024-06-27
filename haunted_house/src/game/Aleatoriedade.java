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
		case 0:
			return geraCriatura();
						
		case 1:
			return geraArmadilha();
		
		case 2:
			return geraItem();
		default: return null;
		}
		
	}



	public Object geraCriatura() {
		int azar = Aleatorio.nextInt(1);
		
		switch (azar) {
		case 0:
			return new Vampiro();
			
		default: return null;
		}
		
	}
	
	public Object geraArmadilha() {
		int azar = Aleatorio.nextInt(1);
		
		switch (azar) {
		case 0:
			return new Flechas();
		}
		return null;
	}
	
	public Object geraItem() {
		int sorte = Aleatorio.nextInt(1);
		
		switch (sorte) {
		case 0: return new Cafe();
		}
		
		return null;
	}
	
}
