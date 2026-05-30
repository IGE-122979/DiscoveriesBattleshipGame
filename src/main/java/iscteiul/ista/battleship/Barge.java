/**
  * Representa um navio do tipo Barca no jogo Discoveries Battleship.
 *
 * A Barca é o menor navio da frota, ocupando apenas uma posição
 * no tabuleiro. Na versão moderna da Batalha Naval, corresponde
 * ao Submarino.
 */
package iscteiul.ista.battleship;

public class Barge extends Ship {
    /**
     * Tamanho fixo da Barca.
     */
    private static final Integer SIZE = 1;
      /**
     * Nome do navio.
     */
    private static final String NAME = "Barca";

    /**
     * Constrói uma nova Barca com uma determinada orientação
     * e posição inicial no tabuleiro.
     *
     * @param bearing - barge bearing
     * @param pos     - upper left position of the barge
     */
    public Barge(Compass bearing, IPosition pos) {
        super(Barge.NAME, bearing, pos);
        getPositions().add(new Position(pos.getRow(), pos.getColumn()));
    }
      /**
     * Devolve o tamanho da Barca.
     *
     * @return tamanho do navio (1)
     */
    @Override
    public Integer getSize() {
        return SIZE;
    }

}
