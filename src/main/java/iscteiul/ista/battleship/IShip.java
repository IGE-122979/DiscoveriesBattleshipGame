package iscteiul.ista.battleship;

import java.util.List;

/**
 * Interface que representa um navio no jogo Battleship.
 * <p>
 * Define operações para consultar a categoria, tamanho, posições, orientação,
 * estado do navio (flutuando ou afundado), e métodos relacionados a tiros e proximidade.
 * </p>
 */
public interface IShip {

    /**
     * Retorna a categoria do navio (ex: "Galeao", "Fragata", "Caravela").
     * 
     * @return Categoria do navio
     */
    String getCategory();

    /**
     * Retorna o tamanho do navio (número de posições ocupadas).
     * 
     * @return Tamanho do navio
     */
    Integer getSize();

    /**
     * Retorna a lista de posições ocupadas pelo navio.
     * 
     * @return Lista de posições do navio
     */
    List<IPosition> getPositions();

    /**
     * Retorna a posição inicial do navio (geralmente a "cabeça" ou canto superior esquerdo).
     * 
     * @return Posição inicial do navio
     */
    IPosition getPosition();

    /**
     * Retorna a orientação do navio no tabuleiro.
     * 
     * @return Orientação do navio (NORTE, SUL, LESTE, OESTE)
     */
    Compass getBearing();

    /**
     * Verifica se o navio ainda está flutuando (não totalmente afundado).
     * 
     * @return {@code true} se ainda flutuando, {@code false} se afundado
     */
    boolean stillFloating();

    /**
     * Retorna a linha mais alta (top) ocupada pelo navio.
     * 
     * @return Número da linha superior
     */
    int getTopMostPos();

    /**
     * Retorna a linha mais baixa (bottom) ocupada pelo navio.
     * 
     * @return Número da linha inferior
     */
    int getBottomMostPos();

    /**
     * Retorna a coluna mais à esquerda ocupada pelo navio.
     * 
     * @return Número da coluna esquerda
     */
    int getLeftMostPos();

    /**
     * Retorna a coluna mais à direita ocupada pelo navio.
     * 
     * @return Número da coluna direita
     */
    int getRightMostPos();

    /**
     * Verifica se o navio ocupa uma determinada posição.
     * 
     * @param pos Posição a ser verificada
     * @return {@code true} se ocupa a posição, {@code false} caso contrário
     */
    boolean occupies(IPosition pos);

    /**
     * Verifica se o navio está muito próximo de outro navio.
     * <p>
     * Essa verificação considera a distância mínima exigida entre navios.
     * </p>
     * 
     * @param other Outro navio a ser verificado
     * @return {@code true} se estiver muito próximo, {@code false} caso contrário
     */
    boolean tooCloseTo(IShip other);

    /**
     * Verifica se o navio está muito próximo de uma posição específica.
     * 
     * @param pos Posição a ser verificada
     * @return {@code true} se estiver muito próximo, {@code false} caso contrário
     */
    boolean tooCloseTo(IPosition pos);

    /**
     * Registra que o navio foi atingido em uma posição específica.
     * 
     * @param pos Posição atingida
     */
    void shoot(IPosition pos);
}
