package iscteiul.ista.battleship;

/**
 * Representa um navio do tipo Caravela no jogo Discoveries Battleship.
 *
 * A Caravela ocupa duas posições consecutivas no tabuleiro,
 * podendo ser colocada na horizontal (EAST/WEST) ou na vertical
 * (NORTH/SOUTH).
 *
 * Na correspondência com a Batalha Naval moderna, equivale
 * ao navio de 2 canhões.
 */
public class Caravel extends Ship {

    /**
     * Tamanho fixo da Caravela.
     */
    private static final Integer SIZE = 2;

    /**
     * Nome do navio.
     */
    private static final String NAME = "Caravela";

    /**
     * Constrói uma nova Caravela com uma determinada orientação
     * e posição inicial no tabuleiro.
     *
     * Consoante a orientação (bearing), as posições ocupadas
     * pelo navio são calculadas automaticamente.
     *
     * @param bearing orientação do navio (NORTH, SOUTH, EAST ou WEST)
     * @param pos posição inicial (canto superior esquerdo) do navio
     *
     * @throws NullPointerException se a orientação for nula
     * @throws IllegalArgumentException se a orientação for inválida
     */
    public Caravel(Compass bearing, IPosition pos)
            throws NullPointerException, IllegalArgumentException {

        super(Caravel.NAME, bearing, pos);

        if (bearing == null)
            throw new NullPointerException("ERROR! invalid bearing for the caravel");

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
                throw new IllegalArgumentException("ERROR! invalid bearing for the caravel");
        }
    }

    /**
     * Devolve o tamanho da Caravela.
     *
     * @return tamanho do navio (2)
     */
    @Override
    public Integer getSize() {
        return SIZE;
    }
}
