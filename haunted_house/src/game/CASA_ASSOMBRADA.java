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
        this.jogador = Save.load(); 
        if (this.jogador == null) {
            this.jogador = new Jogador();
        }
        this.tipoMenu = TipoMenu.MENU_PRINCIPAL;
        this.aleatoriedade = new Aleatoriedade();
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
                case MOSTRAR_STATS:
                    jogador.mostraStats();
                    tipoMenu = TipoMenu.MENU_PRINCIPAL;
                    break;
                case MOSTRAR_INVENTARIO:
                    jogador.mostraInventario();
                    tipoMenu = TipoMenu.MENU_PRINCIPAL;
                    break;
                case SAIDA:
                    menuSaida();
                    break;
                default:
                    break;
            }

            Save.save(jogador);

            if (jogador.getHP() <= 0 || jogador.getSanidade() <= 0) {
                System.out.println("De duas uma: ou você enlouqueceu, ou sangrou até a morte...de toda forma, fim de jogo. Aqui está o que você se lembra em seus últimos momentos de consciência: ");
                jogador.mostraStats();
                Rodando = false;
                exibirOpcaoReiniciar();
            }
        }
    }

    public void exibeMenuPrincipal() {
        System.out.println("Você gostaria de: ");
        System.out.println("1 - Explorar o próximo quarto?");
        System.out.println("2 - Verificar sua deplorável situação atual?");
        System.out.println("3 - Ver seu inventário?");
        
        int opcao = 0;
        boolean inputValido = false;
    
        while (!inputValido) {
            try {
                opcao = Integer.parseInt(scanner.nextLine());
                inputValido = true;
            } catch (NumberFormatException e) {
                System.out.println("Correr.Não.É.Uma.Opção.");
            }
        }
    
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
                System.out.println("Opção inválida. Correr não é uma opção.");
                tipoMenu = TipoMenu.MENU_PRINCIPAL;
                break;
        }
    }
    

    public void explorarProximoQuarto() {
        Object evento = aleatoriedade.geraEvento();

        if (evento instanceof Criatura) {
            Criatura criatura = (Criatura) evento;
            if (criatura instanceof Fada) {
                System.out.println(criatura.getNome() + ": " + criatura.getFrase());
                jogador.setHP(jogador.getHP() + criatura.getDano());
                jogador.setSanidade(jogador.getSanidade() + criatura.getDanoPsicologico());
                jogador.setDano(jogador.getDano() + criatura.getDanoPsicologico());
                Item item = (Item) aleatoriedade.geraItem();
                jogador.addItem(item);
                System.out.println("Espero que este(a) " + item.getNome() + " te ajude em sua jornada!");
                System.out.println(item.getDescricao() + "\n");
                iniciaCombate(criatura);
            } else {
                System.out.println(criatura.getNome() + ": " + criatura.getFrase()+ "\n");
                iniciaCombate(criatura);
            }
        } else if (evento instanceof Item) {
            Item item = (Item) evento;
            System.out.println("Você encontrou: " + item.getNome() + ", " + item.getDescricao());
            jogador.addItem(item);
            System.out.println("Item adicionado ao inventário.\n");
        } else if (evento instanceof Armadilha) {
            Armadilha armadilha = (Armadilha) evento;
            System.out.println("Você ativou a armadilha " + armadilha.getNome());
            System.out.println(armadilha.getDescricao());
            jogador.tomaDanoHPPsico(armadilha.getDano(), armadilha.getDanoPsicologico());
            System.out.println("Você recebeu " + armadilha.getDano() + " de dano físico e " + armadilha.getDanoPsicologico() + " de dano psicológico.\n");
            jogador.mostraStats();
            System.out.println("Você saiu quase ileso dessa enrascada...ou...será?\n");
        } else if (evento instanceof String){
            tipoMenu = TipoMenu.SAIDA;
            return;
        }
        tipoMenu = TipoMenu.MENU_PRINCIPAL;
    }

    public void iniciaCombate(Criatura criatura) {
        while (criatura.getHP() > 0 && jogador.getHP() > 0) {

            System.out.println("Escolha sua ação: ");
            System.out.println("1 - Atacar, obtendo um item caso derrote a criatura");
            System.out.println("2 - Fugir...");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            if (escolha == 1) {
                jogador.setSanidade(jogador.getSanidade() - criatura.getDanoPsicologico());
                criatura.tomaDanoHP(jogador.getDano());
                System.out.println("Você atacou " + criatura.getNome() + " e causou " + jogador.getDano() + " de dano.");
                System.out.println("Situação da criatura: ");
                System.out.println(criatura.getHP() + "\n");
                if (criatura.getHP() > 0) {
                    jogador.tomaDanoHP(criatura.getDano());
                    System.out.println(criatura.getNome() + " atacou você e causou " + criatura.getDano() + " de dano, você está com " + jogador.getHP() + " de vida.\n");
                }
            } else if (escolha == 2) {
                System.out.println("Você foge, feito um cãozinho assustado, com o rabo entre as pernas...\n");
                tipoMenu = TipoMenu.MENU_PRINCIPAL;
                return;
            } else {
                System.out.println("Isso não é uma opção.\n");
            }
        }

        if (criatura.getHP() <= 0) {
            Item item = (Item) aleatoriedade.geraItem();
            System.out.println("Você erradicou " + criatura.getNome() + ", e acaba de receber um(a) " + item.getNome() + ".");
            System.out.println(item.getDescricao());
            jogador.addItem(item);
            System.out.println();
            tipoMenu = TipoMenu.MENU_PRINCIPAL;
        }
    }

    private void menuSaida() {
        System.out.println("Você encontra um quarto com uma tábua quebrada no canto...deixando vazar o que parece ser...um fino feixe de luz! Certamente se decidir forçá-la você conseguirá sair deste pesadelo...mas qual seria a emoção?");
        System.out.println("1 - Fugir.");
        System.out.println("2 - Continuar desafiando a morte!");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                System.out.println("Você decide fugir, como um pequeno gato amedrontado...lamentável.");
                Rodando = false;
                exibirOpcaoReiniciar();
                break;
            case 2:
                System.out.println("Esse é o espírito! Mostra quem manda nessa casa!");
                tipoMenu = TipoMenu.MENU_PRINCIPAL;
                break;
            default:
                System.out.println("Não é uma opção camarada.");
                tipoMenu = TipoMenu.SAIDA;
                break;
        }
    }
    
    public void reinicia() {
        this.setJogador(new Jogador());
        this.tipoMenu = TipoMenu.MENU_PRINCIPAL;
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
    
    private void exibirOpcaoReiniciar() {
        System.out.println("Você gostaria de tentar novamente? (S/N)");
        String resposta = scanner.nextLine().toUpperCase();
        if (resposta.equals("S")) {
            reinicia();
            Rodando = true;
            inicia();
        } else {
            System.out.println("Que previsível.");
        }
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }
}
