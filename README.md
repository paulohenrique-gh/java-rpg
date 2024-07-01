# Projeto RPG de Turno em Java

## Como funciona

Inicialmente será solicitado que o jogador escolha uma classe e em seguida um nome para o personagem.

Após escolha do personagem e nome, começa a sequência de 4 batalhas: 3 monstros normais e 1 chefe.

No início da rodada o jogador pode escolher entre atacar, usar habilidade, usar item e fugir.

- Atacar: ataque normal com dano calculado de acordo com poder de ataque do personagem ativo e poder de defesa do personagem atacado
- Usar habilidade: os personagens tem habilidades disponíveis de acordo com o arquétipo de suas classes.
  - Guerreiro:
    - Cura Fraca | Custo: 5 MP
  - Mago:
    - Tempestade de Fogo | Custo: 15 MP
    - Nevasca | Custo: 15 MP
    - Raio de Odin | Custo: 15 MP
  - Clérigo:
    - Cura | Custo: 10 MP
    - Luz Divina | Custo: 15 MP
  - Arqueiro:
    - Chuva de Flechas | Custo: 5 MP
    - Ataque Triplo | Custo 10 MP
- Usar item: cada personagem tem um item com um efeito diferente
  - Guerreiro:
    - Bomba de Atordoamento | Efeito: Atordoamento | Descrição: Impede alvo de atacar no próximo turno
  - Mago:
    - Marca de Fogo | Efeito: Queimadura | Descrição: Causa dano de fogo no alvo a cada turno por 3 turnos
  - Clérigo:
    - Pó Sonífero | Efeito: Sono | Descrição: Faz o alvo dormir por 3 turnos ou até ser atacado
  - Arqueiro:
    - Bomba de Veneno | Efeito: Veneno | Descrição: Causa dano no alvo a cada rodada por 3 rodadas
- Fugir: vai para a próxima batalha.

O jogo acaba quando o jogador derrota todos os inimigos ou quando seus pontos de vida acabam.

## Conceitos de POO aplicados

Herança e abstração foram utilizadas para reaproveitamento de atributos e comportamentos.

Além disso, foi aplicado bastante polimorfismo declarando variáveis com um tipo mais genérico e instanciando objetos com tipos específicos, para que fosse possível reaproveitar vários métodos. Por exemplo, a classe abstrata `BattleAction` tem o método `perform` que as subclasse diretas ou seus descentes precisam implementar, e isso permite que variáveis do tipo `BattleAction` chamem o método `perform` com a implementação específica da classe do objeto

## Desafios extras implementados

- Sistema de efeitos de combate:
  - Envenenado
  - Atordoado
  - Queimado
  - Dormindo
- Sistema de nível
- Sistema de defesa