/**
 *
 */
package iscteiul.ista.battleship;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Classe abstrata que representa um navio no jogo Batalha Naval.
 * Um navio possui uma categoria (tipo), uma orientação (bearing),
 * uma posição inicial e um conjunto de posições ocupadas no tabuleiro.
 * As subclasses concretas definem o tamanho e a forma de ocupação.
 */
public abstract class Ship implements IShip {

     /** Identificador para o tipo de navio Galeão. */
    private static final String GALEAO = "galeao";

     /** Identificador para o tipo de navio Fragata. */
    private static final String FRAGATA = "fragata";

    /** Identificador para o tipo de navio Nau. */
    private static final String NAU = "nau";

    /** Identificador para o tipo de navio Caravela. */
    private static final String CARAVELA = "caravela";

     /** Identificador para o tipo de navio Barca. */
    private static final String BARCA = "barca";

    /**
     * Método de fábrica que cria uma instância concreta de navio
     * com base no tipo indicado.
     *
     * @param shipKind tipo de navio a criar
     * @param bearing orientação do navio
     * @param pos posição inicial do navio
     * @return instância concreta de Ship correspondente ao tipo,
     *         ou null se o tipo não for reconhecido
     */
    static Ship buildShip(String shipKind, Compass bearing, Position pos) {
        Ship s;
        switch (shipKind) {
            case BARCA:
                s = new Barge(bearing, pos);
                break;
            case CARAVELA:
                s = new Caravel(bearing, pos);
                break;
            case NAU:
                s = new Carrack(bearing, pos);
                break;
            case FRAGATA:
                s = new Frigate(bearing, pos);
                break;
            case GALEAO:
                s = new Galleon(bearing, pos);
                break;
            default:
                s = null;
        }
        return s;
    }

    /** Categoria do navio. */
    private String category;

    /** Orientação do navio no tabuleiro. */
    private Compass bearing;

    /** Posição inicial do navio. */
    private IPosition pos;

    /** Lista de posições ocupadas pelo navio. */
    protected List<IPosition> positions;


    /**
     * Construtor do navio.
     *
     * @param category categoria do navio
     * @param bearing orientação do navio
     * @param pos posição inicial do navio
     */
    public Ship(String category, Compass bearing, IPosition pos) {
        assert bearing != null;
        assert pos != null;

        this.category = category;
        this.bearing = bearing;
        this.pos = pos;
        positions = new ArrayList<>();
    }

   /**
     * Devolve a categoria do navio.
     *
     * @return categoria do navio
     */
    @Override
    public String getCategory() {
        return category;
    }

    /**
     * Devolve a lista de posições ocupadas pelo navio.
     *
     * @return lista de posições ocupadas
     */
    public List<IPosition> getPositions() {
        return positions;
    }

    /**
     * Devolve a posição inicial do navio.
     *
     * @return posição inicial
     */
    @Override
    public IPosition getPosition() {
        return pos;
    }

   /**
     * Devolve a orientação do navio.
     *
     * @return orientação do navio
     */
    @Override
    public Compass getBearing() {
        return bearing;
    }

    /**
     * Verifica se o navio ainda não foi completamente afundado.
     *
     * @return true se pelo menos uma posição não tiver sido atingida
     */
    @Override
    public boolean stillFloating() {
        for (int i = 0; i < getSize(); i++)
            if (!getPositions().get(i).isHit())
                return true;
        return false;
    }

   /**
     * Devolve a linha mais acima ocupada pelo navio.
     *
     * @return menor valor de linha entre as posições do navio
     */
    @Override
    public int getTopMostPos() {
        int top = getPositions().get(0).getRow();
        for (int i = 1; i < getSize(); i++)
            if (getPositions().get(i).getRow() < top)
                top = getPositions().get(i).getRow();
        return top;
    }

    /**
     * Devolve a linha mais abaixo ocupada pelo navio.
     *
     * @return maior valor de linha entre as posições do navio
     */
    @Override
    public int getBottomMostPos() {
        int bottom = getPositions().get(0).getRow();
        for (int i = 1; i < getSize(); i++)
            if (getPositions().get(i).getRow() > bottom)
                bottom = getPositions().get(i).getRow();
        return bottom;
    }

     /**
     * Devolve a coluna mais à esquerda ocupada pelo navio.
     *
     * @return menor valor de coluna entre as posições do navio
     */
    @Override
    public int getLeftMostPos() {
        int left = getPositions().get(0).getColumn();
        for (int i = 1; i < getSize(); i++)
            if (getPositions().get(i).getColumn() < left)
                left = getPositions().get(i).getColumn();
        return left;
    }

   /**
     * Devolve a coluna mais à direita ocupada pelo navio.
     *
     * @return maior valor de coluna entre as posições do navio
     */
    @Override
    public int getRightMostPos() {
        int right = getPositions().get(0).getColumn();
        for (int i = 1; i < getSize(); i++)
            if (getPositions().get(i).getColumn() > right)
                right = getPositions().get(i).getColumn();
        return right;
    }

    /**
     * Verifica se o navio ocupa uma determinada posição.
     *
     * @param pos posição a verificar
     * @return true se o navio ocupar essa posição
     */
    @Override
    public boolean occupies(IPosition pos) {
        assert pos != null;

        for (int i = 0; i < getSize(); i++)
            if (getPositions().get(i).equals(pos))
                return true;
        return false;
    }

   /**
     * Verifica se este navio está demasiado próximo de outro navio.
     *
     * @param other outro navio
     * @return true se existir proximidade proibida
     */
    @Override
    public boolean tooCloseTo(IShip other) {
        assert other != null;

        Iterator<IPosition> otherPos = other.getPositions().iterator();
        while (otherPos.hasNext())
            if (tooCloseTo(otherPos.next()))
                return true;

        return false;
    }

     /**
     * Verifica se este navio está demasiado próximo de uma posição.
     *
     * @param pos posição a verificar
     * @return true se alguma posição do navio for adjacente
     */
    @Override
    public boolean tooCloseTo(IPosition pos) {
        for (int i = 0; i < this.getSize(); i++)
            if (getPositions().get(i).isAdjacentTo(pos))
                return true;
        return false;
    }


    /**
     * Regista um tiro numa posição do navio, se coincidir.
     *
     * @param pos posição atingida
     */
    @Override
    public void shoot(IPosition pos) {
        assert pos != null;

        for (IPosition position : getPositions()) {
            if (position.equals(pos))
                position.shoot();
        }
    }


    /**
     * Representação textual do navio.
     *
     * @return descrição do navio com categoria, orientação e posição inicial
     */
    @Override
    public String toString() {
        return "[" + category + " " + bearing + " " + pos + "]";
    }

}
