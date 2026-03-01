/**
 *
 */
package iscteiul.ista.battleship;

import java.util.Objects;

/**
 * Representa uma posição (célula) no tabuleiro do jogo Batalha Naval.
 * Cada posição é identificada por uma linha e uma coluna e pode conter
 * um navio (ocupada) e/ou ter sido atingida por um tiro.
 */
public class Position implements IPosition {
     /** Linha da posição no tabuleiro. */
    private int row;

     /** Coluna da posição no tabuleiro. */
    private int column;

     /** Indica se a posição está ocupada por parte de um navio. */
    private boolean isOccupied;

    /** Indica se a posição já foi atingida por um tiro. */
    private boolean isHit;

    /**
     * Cria uma nova posição no tabuleiro com as coordenadas indicadas.
     * A posição começa vazia e não atingida.
     *
     * @param row linha da posição
     * @param column coluna da posição
     */
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
        this.isOccupied = false;
        this.isHit = false;
    }

/**
     * Devolve a linha da posição.
     *
     * @return linha da posição
     */
    @Override
    public int getRow() {
        return row;
    }

    /**
     * Devolve a coluna da posição.
     *
     * @return coluna da posição
     */
    @Override
    public int getColumn() {
        return column;
    }

    /**
     * Gera o código hash da posição com base nos seus atributos.
     *
     * @return valor hash da posição
     */
    @Override
    public int hashCode() {
        return Objects.hash(column, isHit, isOccupied, row);
    }

   /**
     * Verifica se duas posições são iguais comparando linha e coluna.
     *
     * @param otherPosition objeto a comparar
     * @return true se as posições tiverem a mesma linha e coluna
     */
    @Override
    public boolean equals(Object otherPosition) {
        if (this == otherPosition)
            return true;
        if (otherPosition instanceof IPosition) {
            IPosition other = (IPosition) otherPosition;
            return (this.getRow() == other.getRow() && this.getColumn() == other.getColumn());
        } else {
            return false;
        }
    }

    /**
     * Verifica se esta posição é adjacente a outra posição.
     * Considera adjacência horizontal, vertical e diagonal.
     *
     * @param other posição a comparar
     * @return true se as posições forem adjacentes
     */
    @Override
    public boolean isAdjacentTo(IPosition other) {
        return (Math.abs(this.getRow() - other.getRow()) <= 1 && Math.abs(this.getColumn() - other.getColumn()) <= 1);
    }

    /**
     * Marca a posição como ocupada por um navio.
     */
    @Override
    public void occupy() {
        isOccupied = true;
    }

    /**
     * Marca a posição como atingida por um tiro.
     */
    @Override
    public void shoot() {
        isHit = true;
    }

    /**
     * Indica se a posição está ocupada por um navio.
     *
     * @return true se estiver ocupada
     */
    @Override
    public boolean isOccupied() {
        return isOccupied;
    }

    /**
     * Indica se a posição já foi atingida por um tiro.
     *
     * @return true se já tiver sido atingida
     */
    @Override
    public boolean isHit() {
        return isHit;
    }

    /**
     * Representação textual da posição.
     *
     * @return descrição da posição com linha e coluna
     */
    @Override
    public String toString() {
        return ("Linha = " + row + " Coluna = " + column);
    }

}
