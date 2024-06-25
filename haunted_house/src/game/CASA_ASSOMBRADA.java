package game;
import java.util.Scanner;

import jogador.Jogador;

public class CASA_ASSOMBRADA {
	private boolean Rodando;
	private Jogador jogador;
	private Scanner scanner = new Scanner(System.in);
	private TipoMenu tipoMenu;
	
	CASA_ASSOMBRADA(){
		this.setJogador(new Jogador());
		this.tipoMenu = TipoMenu.MENU_PRINCIPAL;
	}
	
	public void exibeMenuPrincipal(){
		System.out.println("Você gostaria de: ");
        System.out.println("1 - Explorar o próximo quarto?");
        System.out.println("2 - Verificar sua deplorável situação atual?");
        System.out.println("3 - Ver seu inventário?");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                tipoMenu = TipoMenu.EXPLORAR_QUARTO;
                break;
            case 2:
                tipoMenu = TipoMenu.MOSTRAR_STATS;
                break;
            case 3:
                tipoMenu = TipoMenu.MOSTRAR_INVENTARIO;
                break;
            default:
                System.out.println("Correr não é uma opção.");
                break;
        }
    }
	
	public void explorarProximoQuarto(){
		
	}
	
	public void inicia() {
		int opcao;
		Rodando = true;
		System.out.println("Você está agora numa casa assombrada, e não tem pra onde fugir.");
		while (Rodando) {
			switch (tipoMenu) {
            case MENU_PRINCIPAL:
            	exibeMenuPrincipal();
                break;
            case EXPLORAR_QUARTO:
                explorarProximoQuarto();
                break;
            case COMBATE:
                //mostrarMenuCombate();
                break;
            case MOSTRAR_STATS:
                jogador.mostraStats();
                tipoMenu = TipoMenu.MENU_PRINCIPAL;
                break;
            case MOSTRAR_INVENTARIO:
                jogador.mostraInventario();
                tipoMenu = TipoMenu.MENU_PRINCIPAL;
                break;
		}
			
           /* case ARMADILHA:
                encontrarArmadilha();
                gameState = GameState.MENU_PRINCIPAL;
                break;*/
			}
		}


	public Jogador getJogador() {
		return jogador;
	}


	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}
	
}
