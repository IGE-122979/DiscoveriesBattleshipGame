package iscteiul.ista.battleship;

import java.util.List;

/**
 * Interface que representa uma frota de navios no jogo Battleship.
 * <p>
 * Define operações básicas para manipulação de navios, incluindo
 * adição de navios, consulta por categoria ou posição, e impressão
 * do estado da frota.
 * </p>
 */
public interface IFleet {

    /** Tamanho do tabuleiro (10x10) */
    Integer BOARD_SIZE = 10;

    /** Número máximo de navios na frota */
    Integer FLEET_SIZE = 10;

    /**
     * Retorna todos os navios da frota.
     *
     * @return Lista de navios
     */
    List<IShip> getShips();

    /**
     * Adiciona um navio à frota.
     * <p>
     * O navio só é adicionado se houver espaço na frota,
     * se estiver dentro do tabuleiro e se não houver risco
     * de colisão com outros navios.
     * </p>
     *
     * @param s Navio a ser adicionado
     * @return {@code true} se o navio foi adicionado, {@code false} caso contrário
     */
    boolean addShip(IShip s);

    /**
     * Retorna todos os navios que pertencem a uma determinada categoria.
     *
     * @param category Categoria de navios (ex: "Galeao", "Fragata")
     * @return Lista de navios da categoria especificada
     */
    List<IShip> getShipsLike(String category);

    /**
     * Retorna todos os navios que ainda estão flutuando (não foram afundados).
     *
     * @return Lista de navios flutuantes
     */
    List<IShip> getFloatingShips();

    /**
     * Retorna o navio que ocupa uma posição específica do tabuleiro.
     *
     * @param pos Posição a ser verificada
     * @return Navio que ocupa a posição, ou {@code null} se não houver navio
     */
    IShip shipAt(IPosition pos);

    /**
     * Imprime o estado atual da frota, incluindo todos os navios
     * e navios flutuantes, além de navios por categoria.
     */
    void printStatus();
}
