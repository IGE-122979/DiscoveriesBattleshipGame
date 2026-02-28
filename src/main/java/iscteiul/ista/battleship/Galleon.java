package iscteiul.ista.battleship;

/**
 * Representa um galeão no jogo Battleship.
 * <p>
 * O galeão é um navio maior com tamanho fixo de 5 posições.
 * Sua orientação (bearing) pode ser Norte, Sul, Leste ou Oeste, e
 * suas posições são preenchidas de forma específica dependendo da orientação.
 * </p>
 */
public class Galleon extends Ship {

    /** Tamanho fixo do galeão */
    private static final Integer SIZE = 5;

    /** Nome do navio */
    private static final String NAME = "Galeao";

    /**
     * Construtor do galeão.
     * <p>
     * Inicializa as posições do navio de acordo com a orientação fornecida.
     * Lança exceção se a orientação for nula ou inválida.
     * </p>
     *
     * @param bearing Orientação do navio (NORTE, SUL, LESTE, OESTE)
     * @param pos     Posição inicial (esquerda/cima) do navio no tabuleiro
     * @throws NullPointerException     Se a orientação for {@code null}
     * @throws IllegalArgumentException Se a orientação for inválida
     */
    public Galleon(Compass bearing, IPosition pos) throws IllegalArgumentException {
        super(Galleon.NAME, bearing, pos);

        if (bearing == null)
            throw new NullPointerException("ERROR! invalid bearing for the galleon");

        switch (bearing) {
            case NORTH:
                fillNorth(pos);
                break;
            case EAST:
                fillEast(pos);
                break;
            case SOUTH:
                fillSouth(pos);
                break;
            case WEST:
                fillWest(pos);
                break;
            default:
                throw new IllegalArgumentException("ERROR! invalid bearing for the galleon");
        }
    }

    /**
     * Retorna o tamanho do galeão.
     *
     * @return Tamanho fixo do navio (5)
     */
    @Override
    public Integer getSize() {
        return Galleon.SIZE;
    }

    /**
     * Preenche as posições do galeão quando orientado para o Norte.
     *
     * @param pos Posição inicial do navio
     */
    private void fillNorth(IPosition pos) {
        for (int i = 0; i < 3; i++) {
            getPositions().add(new Position(pos.getRow(), pos.getColumn() + i));
        }
        getPositions().add(new Position(pos.getRow() + 1, pos.getColumn() + 1));
        getPositions().add(new Position(pos.getRow() + 2, pos.getColumn() + 1));
    }

    /**
     * Preenche as posições do galeão quando orientado para o Sul.
     *
     * @param pos Posição inicial do navio
     */
    private void fillSouth(IPosition pos) {
        for (int i = 0; i < 2; i++) {
            getPositions().add(new Position(pos.getRow() + i, pos.getColumn()));
        }
        for (int j = 2; j < 5; j++) {
            getPositions().add(new Position(pos.getRow() + 2, pos.getColumn() + j - 3));
        }
    }

    /**
     * Preenche as posições do galeão quando orientado para o Leste.
     *
     * @param pos Posição inicial do navio
     */
    private void fillEast(IPosition pos) {
        getPositions().add(new Position(pos.getRow(), pos.getColumn()));
        for (int i = 1; i < 4; i++) {
            getPositions().add(new Position(pos.getRow() + 1, pos.getColumn() + i - 3));
        }
        getPositions().add(new Position(pos.getRow() + 2, pos.getColumn()));
    }

    /**
     * Preenche as posições do galeão quando orientado para o Oeste.
     *
     * @param pos Posição inicial do navio
     */
    private void fillWest(IPosition pos) {
        getPositions().add(new Position(pos.getRow(), pos.getColumn()));
        for (int i = 1; i < 4; i++) {
            getPositions().add(new Position(pos.getRow() + 1, pos.getColumn() + i - 1));
        }
        getPositions().add(new Position(pos.getRow() + 2, pos.getColumn()));
    }

}
