package itens;

import interfaces.Consumivel;
import jogador.Jogador;

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
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
    public String toString() {
        return nome + "|" + descricao + "|" + statQuant;
    }

	public static Item fromString(String str) {
        String[] parts = str.split("\\|");
        return new SomeConcreteItem(parts[0], parts[1], Integer.parseInt(parts[2]));
    }
}

	class SomeConcreteItem extends Item {
		public SomeConcreteItem(String nome, String descricao, int statQuant) {
			super(nome, descricao, statQuant);
		}

		@Override
		public void consome(Jogador jogador) {
			throw new UnsupportedOperationException("Unimplemented method 'consome'");
		}
	}

