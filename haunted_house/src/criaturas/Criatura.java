package monstros;
import interfaces.Atacavel;

public abstract class Monstro implements Atacavel{
	private String Nome;
	private String Frase;
	private int Dano;
	private int HP;
	
	public Monstro(String nome, String frase, int dano, int hp) {
		this.Nome = nome;
		this.Frase = frase;
		this.Dano = dano;
		this.HP = hp;
	}
	
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		this.Nome = nome;
	}
	public int getHP() {
		return HP;
	}
	public void setHP(int hP) {
		HP = hP;
	}
	public String getFrase() {
		return Frase;
	}
	public void setFrase(String frase) {
		Frase = frase;
	}
	public int getDano() {
		return Dano;
	}
	public void setDano(int dano) {
		Dano = dano;
	}
	

}
