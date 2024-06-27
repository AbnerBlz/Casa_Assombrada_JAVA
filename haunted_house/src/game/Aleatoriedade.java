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
		int evento = Aleatorio.nextInt(100);
		
		if (evento < 10) {
			return "saida";
		}else if (evento < 40) {
			return geraCriatura();
		}else if (evento < 70) {
			return geraItem();
		}else{
			return geraArmadilha();
		}
		
	}



	public Object geraCriatura() {
		int azar = Aleatorio.nextInt(100);
		
		if (azar < 10) {
            return new Demonio();
        } else if (azar < 30) {
            return new Esqueleto();
        } else if (azar < 40) {
            return new Fada();
        } else if (azar < 50) {
            return new Fantasma();
        } else if (azar < 60) {
            return new Lobisomem();
        } else if (azar < 70) {
            return new Louco();
        } else if (azar < 80) {
            return new Vampiro();
        } else {
            return new Zumbi();
        }
    }
	
	
	public Object geraItem() {
		int sorte = Aleatorio.nextInt(100);
		
		if (sorte < 20) {
            return new Cafe();
        } else if (sorte < 30) {
            return new Cigarro();
        } else if (sorte < 60) {
            return new Erva();
        } else if (sorte < 70) {
            return new Espada();
        } else if (sorte < 80) {
            return new MP4();
        } else if (sorte < 95) {
            return new Remedio();
        } else {
            return new TresOitao();
        }
	}
	
	public Object geraArmadilha() {
		int azar = Aleatorio.nextInt(5);
		
		switch (azar) {
		case 0:
			return new Flechas();
			
		case 1:
			return new Fogo();
		
		case 2:
			return new Pendulo();
			
		case 3:
			return new Poco();
			
		case 4:
			return new Poltergeist();
		}
		return null;
		
	}
	
}
