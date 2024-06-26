package itens;

import interfaces.Consumivel;

public abstract class Item implements Consumivel{
	private String nome;
	private String descricao;
	private int statQuant;
	
	public Item(String nome, String descricao, int statQuant) {
		this.nome = nome;
		this.descricao = descricao;
		this.statQuant = statQuant;
	}
	
	public int getStatQuant() {
		return statQuant;
	}
	public void setStatQuant(int statQuant) {
		this.statQuant = statQuant;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescrição(String descrição) {
		this.descricao = descrição;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
