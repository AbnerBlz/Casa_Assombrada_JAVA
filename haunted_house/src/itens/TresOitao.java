package itens;

import jogador.Jogador;

public class TresOitao extends Item{

	public TresOitao() {
		super("Três Oitão", "Um revólver .38. Numa casa mal-assombrada. Claro, por que não?...E... está carregado?!", 60);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void consome(Jogador jogador) {
		jogador.setDano(jogador.getDano()+getStatQuant());
	}

}
