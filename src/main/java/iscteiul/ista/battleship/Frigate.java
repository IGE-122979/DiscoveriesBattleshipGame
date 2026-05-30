package iscteiul.ista.battleship;

/**
 * Representa uma fragata no jogo Battleship.
 * <p>
 * A fragata é um tipo de navio com tamanho fixo de 4 posições.
 * Sua orientação (bearing) pode ser Norte, Sul, Leste ou Oeste.
 * </p>
 */
public class Frigate extends Ship {

    /** Tamanho fixo da fragata */
    private static final Integer SIZE = 4;

    /** Nome do navio */
    private static final String NAME = "Fragata";

    /**
     * Construtor da fragata.
     * <p>
     * Inicializa as posições do navio de acordo com a orientação fornecida.
     * </p>
     *
     * @param bearing Orientação do navio (NORTE, SUL, LESTE, OESTE)
     * @param pos     Posição inicial (esquerda/cima) do navio no tabuleiro
     * @throws IllegalArgumentException Se a orientação fornecida não for válida
     */
    public Frigate(Compass bearing, IPosition pos) throws IllegalArgumentException {
        super(Frigate.NAME, bearing, pos);
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
                throw new IllegalArgumentException("ERROR! invalid bearing for the frigate");
        }
    }

    /**
     * Retorna o tamanho da fragata.
     *
     * @return Tamanho fixo do navio (4)
     */
    @Override
    public Integer getSize() {
        return Frigate.SIZE;
    }

}
