package game;
import java.util.Scanner;
import criaturas.*;
import itens.*;
import armadilhas.*;
import jogador.Jogador;

public class CASA_ASSOMBRADA {
	private boolean Rodando;
	private Jogador jogador;
	private Scanner scanner = new Scanner(System.in);
	private TipoMenu tipoMenu;
	private Aleatoriedade aleatoriedade;
	
	CASA_ASSOMBRADA(){
		this.setJogador(new Jogador());
		this.tipoMenu = TipoMenu.MENU_PRINCIPAL;
		this.aleatoriedade = new Aleatoriedade();
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
		/*
		 * Object evento = aleatoriedade.geraEvento();
		 * 
		 * if (evento instanceof Criatura) { Criatura criatura = (Criatura) evento;
		 * System.out.println("Você encontrou um " + criatura.getNome() + "!");
		 * iniciarCombate(criatura); } else if (evento instanceof Item) { Item item =
		 * (Item) evento; System.out.println("Você encontrou um " + item.getNome() +
		 * "!"); jogador.addItem(item); System.out.println("Você pegou o " +
		 * item.getNome() + "."); } else if (evento instanceof Armadilha) { Armadilha
		 * armadilha = (Armadilha) evento;
		 * System.out.println("Você ativou uma armadilha: " + armadilha.getNome() +
		 * "!"); jogador.receberDano(armadilha.getDano());
		 * System.out.println("Você recebeu " + armadilha.getDano() + " de dano.");
		 */
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
