package iscteiul.ista.battleship;

/**
 * Representa um navio do tipo Nau no jogo Discoveries Battleship.
 *
 * A Nau ocupa três posições consecutivas no tabuleiro,
 * podendo ser colocada na vertical (NORTH ou SOUTH)
 * ou na horizontal (EAST ou WEST).
 *
 * Na correspondência com a Batalha Naval moderna,
 * equivale ao navio de 3 canhões.
 */
public class Carrack extends Ship {

    /**
     * Tamanho fixo da Nau.
     */
    private static final Integer SIZE = 3;

    /**
     * Nome do navio.
     */
    private static final String NAME = "Nau";

    /**
     * Constrói uma nova Nau com uma determinada orientação
     * e posição inicial no tabuleiro.
     *
     * As posições ocupadas pelo navio são calculadas automaticamente
     * com base na orientação fornecida.
     *
     * @param bearing orientação do navio (NORTH, SOUTH, EAST ou WEST)
     * @param pos posição inicial (canto superior esquerdo) do navio
     *
     * @throws IllegalArgumentException se a orientação for inválida
     */
    public Carrack(Compass bearing, IPosition pos)
            throws IllegalArgumentException {

        super(Carrack.NAME, bearing, pos);

        switch (bearing) {
            case NORTH:
            case SOUTH:
                for (int r = 0; r < SIZE; r++)
                    getPositions().add(new Position(pos.getRow() + r, pos.getColumn()));
                break;

            case EAST:
            case WEST:
                for (int c = 0; c < SIZE; c++)
                    getPositions().add(new Position(pos.getRow(), pos.getColumn() + c));
                break;

            default:
                throw new IllegalArgumentException("ERROR! invalid bearing for the carrack");
        }
    }

    /**
     * Devolve o tamanho da Nau.
     *
     * @see battleship.Ship#getSize()
     */
    @Override
    public Integer getSize() {
        return Carrack.SIZE;
    }
}
