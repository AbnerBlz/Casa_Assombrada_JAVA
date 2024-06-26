package armadilhas;

public abstract class Armadilha {
	private String nome;
	private String Descricao;
	private int Dano;
	private int DanoPsicologico;
	
	public Armadilha(String nome,String descricao, int dano, int danoPsico) {
		this.setNome(nome);
		this.setDescricao(descricao);
		this.setDano(dano);
		this.setDanoPsicologico(danoPsico);
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
