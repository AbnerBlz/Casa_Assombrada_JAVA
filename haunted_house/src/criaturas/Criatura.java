package criaturas;
import interfaces.Atacavel;

public abstract class Criatura implements Atacavel{
	private String Nome;
	private String Frase;
	private int Dano;
	private int DanoPsicologico;
	private int HP;
	
	public Criatura(String nome, String frase, int dano, int hp, int danoPsico) {
		this.Nome = nome;
		this.Frase = frase;
		this.Dano = dano;
		this.DanoPsicologico = danoPsico;
		this.HP = hp;
	}
	public void mostraStats() {
		System.out.println(this.getDano());
		System.out.println(this.getHP());
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
	public int getDanoPsicologico() {
		return DanoPsicologico;
	}
	public void setDanoPsicologico(int danoPsicologico) {
		DanoPsicologico = danoPsicologico;
	}
	

}
