package iscteiul.ista.battleship;

/**
 * Interface que representa uma posição no tabuleiro do jogo Battleship.
 * <p>
 * Define operações para consultar coordenadas, marcar posições como ocupadas ou atingidas,
 * e verificar proximidade e estado da posição.
 * </p>
 * 
 * @author fba
 */
public interface IPosition {

    /**
     * Retorna a linha (row) da posição no tabuleiro.
     * 
     * @return Número da linha (0 a BOARD_SIZE-1)
     */
    int getRow();

    /**
     * Retorna a coluna (column) da posição no tabuleiro.
     * 
     * @return Número da coluna (0 a BOARD_SIZE-1)
     */
    int getColumn();

    /**
     * Verifica se esta posição é igual a outra posição.
     * 
     * @param other Objeto a ser comparado
     * @return {@code true} se as posições forem iguais, {@code false} caso contrário
     */
    boolean equals(Object other);

    /**
     * Verifica se esta posição é adjacente a outra posição (ou seja, vizinha).
     * 
     * @param other Posição a ser verificada
     * @return {@code true} se as posições forem adjacentes, {@code false} caso contrário
     */
    boolean isAdjacentTo(IPosition other);

    /**
     * Marca esta posição como ocupada por um navio.
     */
    void occupy();

    /**
     * Marca esta posição como atingida por um tiro.
     */
    void shoot();

    /**
     * Verifica se esta posição está ocupada por um navio.
     * 
     * @return {@code true} se estiver ocupada, {@code false} caso contrário
     */
    boolean isOccupied();

    /**
     * Verifica se esta posição já foi atingida por um tiro.
     * 
     * @return {@code true} se foi atingida, {@code false} caso contrário
     */
    boolean isHit();
}
