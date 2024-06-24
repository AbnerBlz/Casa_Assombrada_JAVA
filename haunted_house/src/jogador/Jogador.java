package jogador;
import java.util.ArrayList;
import java.util.List;

import interfaces.Atacavel;
import itens.Item;


public class Jogador implements Atacavel{
	private int HP = 100;
	private int Sanidade = 100;
	private int Dano = 20;
	private List<Item> Inventario;
	
	public Jogador() {
		this.Inventario = new ArrayList<Item>();
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
	public void tomaDano(int dano) {
		this.HP -= dano;
		
	}
	
	
	
	
}
