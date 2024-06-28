package jogador;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import game.TipoMenu;
import interfaces.Atacavel;
import interfaces.Consumivel;
import itens.Item;


public class Jogador implements Atacavel{
	private int HP = 100;
	private int Sanidade = 100;
	private int Dano = 20;
	private List<Item> Inventario;
	
	public Jogador() {
		this.Inventario = new ArrayList<Item>();
	}
	
	public void mostraStats() {
		System.out.println("Vida atual: " + this.getHP());
		System.out.println("Sanidade atual: " + this.getSanidade());
		System.out.println("Dano atual: " + this.getDano()+"\n");
	}

	//se pá atualizar pra ter a opção de ver o item antes de consumir, e talvez dropar.
	public TipoMenu mostraInventario() {
	    if (Inventario.isEmpty()) {
	        System.out.println("Inventário vazio.");
	    } else {
	        System.out.println("Itens no seu inventário (pressione o número respectivo ao item para consumi-lo, pressione qualquer outra tecla para voltar ao menu):");
	        for (int i = 0; i < Inventario.size(); i++) {
	            System.out.println((i + 1) + " - " + getInventario().get(i).getNome());
	        }

	        Scanner scanner = new Scanner(System.in);
	        while (true) {
	            
	            String input = scanner.nextLine();
	            try {
	                int escolha = Integer.parseInt(input);
	                if (escolha > 0 && escolha <= Inventario.size()) {
	                    this.consomeItem(Inventario.get(escolha - 1).getNome());
	                    return TipoMenu.MENU_PRINCIPAL;
	                } else {
	                    return TipoMenu.MENU_PRINCIPAL;
	                }
	            } catch (NumberFormatException e) {
	                return TipoMenu.MENU_PRINCIPAL;
	            }
	        }
	    }
	    return TipoMenu.MENU_PRINCIPAL;
	}
	
	public void addItem(Item item) {
	    Inventario.add(item);
	    System.out.println(item.getNome() + " foi adicionado ao seu inventário.");
	}
	
	public void consomeItem(String nomeItem) {
        for (int i = 0; i < Inventario.size(); i++) {
            Item item = Inventario.get(i);
            if (item.getNome().equals(nomeItem) && item instanceof Consumivel) {
                ((Consumivel) item).consome(this);
                Inventario.remove(i);
                System.out.println(nomeItem + " foi consumido(a).");
                System.out.println("Stats atuais: ");
                mostraStats();
                return;
            }
        }
       //
    }
	
	public int getHP() {
		return HP;
	}
	public void setHP(int hP) {
		HP = hP;
	}
	public int getSanidade() {
		return Sanidade;
	}
	public void setSanidade(int sanidade) {
		Sanidade = sanidade;
	}
	public List<Item> getInventario() {
		return Inventario;
	}
	public void setInventario(List<Item> inventario) {
		Inventario = inventario;
	}
	public int getDano() {
		return Dano;
	}
	public void setDano(int dano) {
		Dano = dano;
	}
	

	@Override
	public void tomaDanoHP(int dano) {
		this.HP -= dano;
	}
	
	public void tomaDanoHPPsico(int dano, int danoPsico) {
		this.HP -= dano;
		this.Sanidade -= danoPsico;
		
	}
	
	
	
}
