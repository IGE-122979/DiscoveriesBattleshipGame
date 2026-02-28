package iscteiul.ista.battleship;

import java.util.List;

/**
 * Interface que representa uma partida do jogo Battleship.
 * <p>
 * Define operações para disparar tiros, consultar estatísticas do jogo,
 * e exibir o tabuleiro e a frota.
 * </p>
 */
public interface IGame {

    /**
     * Dispara um tiro em uma posição específica do tabuleiro.
     * <p>
     * Atualiza o estado do jogo, incluindo acertos e navios afundados.
     * </p>
     *
     * @param pos Posição do tiro
     * @return O navio afundado se houver, ou {@code null} caso contrário
     */
    IShip fire(IPosition pos);

    /**
     * Retorna a lista de todos os tiros disparados.
     *
     * @return Lista de posições dos tiros
     */
    List<IPosition> getShots();

    /**
     * Retorna o número de tiros repetidos (mesma posição já atirada anteriormente).
     *
     * @return Quantidade de tiros repetidos
     */
    int getRepeatedShots();

    /**
     * Retorna o número de tiros inválidos (fora do tabuleiro).
     *
     * @return Quantidade de tiros inválidos
     */
    int getInvalidShots();

    /**
     * Retorna o número de tiros que acertaram algum navio.
     *
     * @return Quantidade de acertos
     */
    int getHits();

    /**
     * Retorna o número de navios que foram completamente afundados.
     *
     * @return Quantidade de navios afundados
     */
    int getSunkShips();

    /**
     * Retorna o número de navios restantes na frota (ainda flutuando).
     *
     * @return Quantidade de navios ainda flutuantes
     */
    int getRemainingShips();

    /**
     * Imprime o tabuleiro mostrando todos os tiros válidos disparados.
     */
    void printValidShots();

    /**
     * Imprime o tabuleiro mostrando todas as posições ocupadas pelos navios da frota.
     */
    void printFleet();
}
