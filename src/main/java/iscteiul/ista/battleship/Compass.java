package iscteiul.ista.battleship;

/**
 * Enumeração que representa as possíveis orientações (direções)
 * dos navios no tabuleiro do jogo.
 *
 * Cada direção está associada a um carácter:
 * <ul>
 *     <li>'n' - Norte</li>
 *     <li>'s' - Sul</li>
 *     <li>'e' - Este</li>
 *     <li>'o' - Oeste</li>
 *     <li>'u' - Desconhecida</li>
 * </ul>
 */
public enum Compass {

    NORTH('n'),
    SOUTH('s'),
    EAST('e'),
    WEST('o'),
    UNKNOWN('u');

    /**
     * Carácter associado à direção.
     */
    private final char c;

    /**
     * Construtor da enumeração Compass.
     *
     * @param c carácter representativo da direção
     */
    Compass(char c) {
        this.c = c;
    }

    /**
     * Devolve o carácter associado à direção.
     *
     * @return carácter representativo da direção
     */
    public char getDirection() {
        return c;
    }

    /**
     * Devolve a representação textual da direção.
     *
     * @return carácter da direção sob a forma de String
     */
    @Override
    public String toString() {
        return "" + c;
    }

    /**
     * Converte um carácter na respetiva direção Compass.
     *
     * @param ch carácter representativo da direção
     * @return direção correspondente ou UNKNOWN caso não exista correspondência
     */
    static Compass charToCompass(char ch) {
        Compass bearing;

        switch (ch) {
            case 'n':
                bearing = NORTH;
                break;
            case 's':
                bearing = SOUTH;
                break;
            case 'e':
                bearing = EAST;
                break;
            case 'o':
                bearing = WEST;
                break;
            default:
                bearing = UNKNOWN;
        }

        return bearing;
    }
}
