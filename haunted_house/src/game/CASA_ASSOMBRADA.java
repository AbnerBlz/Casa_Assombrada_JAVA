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

    public CASA_ASSOMBRADA() {
        this.setJogador(new Jogador());
        this.tipoMenu = TipoMenu.MENU_PRINCIPAL;
        this.aleatoriedade = new Aleatoriedade();
    }

    public void exibeMenuPrincipal() {
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
                tipoMenu = TipoMenu.MENU_PRINCIPAL;
                break;
        }
    }

    public void explorarProximoQuarto() {
        Object evento = aleatoriedade.geraEvento();

        if (evento instanceof Criatura) {
            Criatura criatura = (Criatura) evento;
            System.out.println(criatura.getNome() + ": " + criatura.getFrase());
            iniciaCombate(criatura);
        } else if (evento instanceof Item) {
            Item item = (Item) evento;
            System.out.println("Você encontrou: " + item.getNome() + ", " + item.getDescricao());
            jogador.addItem(item);
            System.out.println("Item adicionado ao inventário.");
        } else if (evento instanceof Armadilha) {
            Armadilha armadilha = (Armadilha) evento;
            System.out.println("Você ativou a armadilha " + armadilha.getNome());
            System.out.println(armadilha.getDescricao());
            jogador.tomaDanoHPPsico(armadilha.getDano(), armadilha.getDanoPsicologico());
            System.out.println("Você recebeu " + armadilha.getDano() + " de dano físico e " + armadilha.getDanoPsicologico() + " de dano psicológico.");
            jogador.mostraStats();
        } else {
            System.out.println("Nada aconteceu.");
        }
        tipoMenu = TipoMenu.MENU_PRINCIPAL;
    }

    public void inicia() {
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
                    // mostrarMenuCombate();
                    break;
                case MOSTRAR_STATS:
                    jogador.mostraStats();
                    tipoMenu = TipoMenu.MENU_PRINCIPAL;
                    break;
                case MOSTRAR_INVENTARIO:
                    jogador.mostraInventario();
                    tipoMenu = TipoMenu.MENU_PRINCIPAL;
                    break;
                default:
                    System.out.println("Opção inválida. Retornando ao menu principal.");
                    tipoMenu = TipoMenu.MENU_PRINCIPAL;
                    break;
            }
        }
    }

    public void iniciaCombate(Criatura criatura) {
        while (criatura.getHP() > 0 && jogador.getHP() > 0) {
            // Lógica de turno de combate
            System.out.println("Escolha sua ação: ");
            System.out.println("1 - Atacar");
            System.out.println("2 - Fugir");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            if (escolha == 1) {
                criatura.tomaDanoHP(jogador.getDano());
                System.out.println("Você atacou " + criatura.getNome() + " e causou " + jogador.getDano() + " de dano.");
                if (criatura.getHP() > 0) {
                    jogador.tomaDanoHP(criatura.getDano());
                    System.out.println(criatura.getNome() + " atacou você e causou " + criatura.getDano() + " de dano.");
                }
            } else if (escolha == 2) {
                System.out.println("Você fugiu do combate!");
                tipoMenu = TipoMenu.MENU_PRINCIPAL;
                return;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

        if (jogador.getHP() <= 0) {
            System.out.println("Você morreu! Fim de jogo.");
            Rodando = false;
        } else if (criatura.getHP() <= 0) {
            System.out.println("Você derrotou " + criatura.getNome() + "!");
            tipoMenu = TipoMenu.MENU_PRINCIPAL;
        }
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }
}