# Casa_Assombrada_JAVA

## Descrição Geral
**Casa_Assombrada_JAVA** é um jogo de RPG baseado em uma casa assombrada onde os jogadores precisam confiar na sorte para sobreviver e avançar. O jogo envolve explorar quartos, enfrentar criaturas, encontrar itens e evitar armadilhas, enquanto se tenta manter a saúde física e mental do personagem.

## Estrutura do Projeto

### Pacote `game`
Este pacote contém a classe principal `CASA_ASSOMBRADA` que gerencia o fluxo do jogo.

#### Classe `CASA_ASSOMBRADA`
- **Atributos:**
  - `Rodando`: Indica se o jogo está em execução.
  - `jogador`: Representa o jogador do jogo.
  - `scanner`: Utilizado para receber entradas do usuário.
  - `tipoMenu`: Gerencia os diferentes menus do jogo.
  - `aleatoriedade`: Gerencia a geração aleatória de eventos no jogo.
- **Métodos:**
  - `inicia()`: Inicia o jogo e controla o loop principal.
  - `exibeMenuPrincipal()`: Exibe o menu principal e processa a escolha do jogador.
  - `explorarProximoQuarto()`: Lida com a exploração dos quartos, incluindo encontros com criaturas, itens e armadilhas.
  - `iniciaCombate(Criatura criatura)`: Gerencia o combate entre o jogador e uma criatura.
  - `menuSaida()`: Lida com a tentativa do jogador de sair da casa assombrada.
  - `reinicia()`: Reinicia o jogo.
  - `exibirOpcaoReiniciar()`: Exibe a opção de reiniciar o jogo após o fim.
  
### Pacote `criaturas`
Contém classes que representam diferentes criaturas que o jogador pode encontrar.

### Pacote `itens`
Contém classes que representam diferentes itens que o jogador pode encontrar e usar.

#### Classe `Item`
- **Atributos:**
  - `nome`: Nome do item.
  - `descricao`: Descrição do item.
  - `statQuant`: Quantidade de status que o item afeta.
- **Métodos:**
  - `toString()`: Serializa o item em uma string.
  - `fromString(String str)`: Desserializa uma string em um objeto Item.

### Pacote `armadilhas`
Contém classes que representam diferentes armadilhas que o jogador pode encontrar.

### Pacote `jogador`
Contém a classe `Jogador` que representa o personagem do jogador.

#### Classe `Jogador`
- **Atributos:**
  - `nome`: Nome do jogador.
  - `HP`: Pontos de vida do jogador.
  - `sanidade`: Pontos de sanidade do jogador.
  - `dano`: Quantidade de dano que o jogador pode causar.
  - `inventario`: Inventário do jogador, armazenado em um `ArrayList` de itens.
- **Métodos:**
  - Métodos getter e setter para os atributos.
  - `mostraStats()`: Exibe as estatísticas do jogador.
  - `mostraInventario()`: Exibe o inventário do jogador.
  - `addItem(Item item)`: Adiciona um item ao inventário do jogador.
  - `tomaDanoHP(int dano)`: Reduz os pontos de vida do jogador.
  - `tomaDanoHPPsico(int dano, int danoPsico)`: Reduz os pontos de vida e sanidade do jogador.

### Classe `SaveManager`
Responsável por gerenciar as operações de salvar e carregar o estado do jogador.

#### Métodos:
- `save(Jogador jogador)`: Salva o estado do jogador em um arquivo de texto.
- `load()`: Carrega o estado do jogador a partir de um arquivo de texto.

## Funcionamento do Jogo
1. **Início:** O jogo começa com a instância `CASA_ASSOMBRADA` iniciando o loop principal.
2. **Menu Principal:** O jogador escolhe entre explorar um novo quarto, verificar estatísticas ou inventário.
3. **Exploração:** Dependendo da sorte, o jogador pode encontrar criaturas, itens ou armadilhas.
4. **Combate:** Se uma criatura for encontrada, o jogador pode lutar ou fugir.
5. **Fim do Jogo:** Se a saúde ou sanidade do jogador chegar a zero, o jogo termina. O jogador pode escolher reiniciar o jogo.
6. **Salvar e Carregar:** O estado do jogador é salvo automaticamente em cada iteração do loop principal e carregado ao iniciar o jogo.

## Observações
- O jogo é baseado na sorte, com eventos gerados aleatoriamente.
- O estado do jogador e seu inventário são persistidos entre sessões, permitindo continuar de onde parou.
- O design modular e a separação de responsabilidades facilitam a manutenção e expansão do jogo.

Este resumo fornece uma visão geral do projeto, explicando a estrutura do código e o propósito das principais classes e métodos envolvidos no jogo "Casa Assombrada".