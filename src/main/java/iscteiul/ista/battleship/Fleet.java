package iscteiul.ista.battleship;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa uma frota de navios no jogo Battleship.
 * <p>
 * Esta classe mantém uma lista de navios, permite adicionar navios,
 * consultar navios por categoria ou posição e imprimir o estado da frota.
 * </p>
 */
public class Fleet implements IFleet {

    /**
     * Imprime todos os navios fornecidos na lista.
     *
     * @param ships Lista de navios a serem impressos
     */
    static void printShips(List<IShip> ships) {
        for (IShip ship : ships)
            System.out.println(ship);
    }

    // -----------------------------------------------------

    /** Lista de navios da frota */
    private List<IShip> ships;

    /**
     * Construtor da frota. Inicializa a lista de navios.
     */
    public Fleet() {
        ships = new ArrayList<>();
    }

    /**
     * Retorna todos os navios da frota.
     *
     * @return Lista de navios
     */
    @Override
    public List<IShip> getShips() {
        return ships;
    }

    /**
     * Adiciona um navio à frota se houver espaço, se estiver dentro do tabuleiro
     * e se não houver risco de colisão com outros navios.
     *
     * @param s Navio a ser adicionado
     * @return {@code true} se o navio foi adicionado, {@code false} caso contrário
     */
    @Override
    public boolean addShip(IShip s) {
        boolean result = false;
        if ((ships.size() <= FLEET_SIZE) && (isInsideBoard(s)) && (!colisionRisk(s))) {
            ships.add(s);
            result = true;
        }
        return result;
    }

    /**
     * Retorna todos os navios que pertencem a uma determinada categoria.
     *
     * @param category Categoria de navios (ex: "Galeao", "Fragata")
     * @return Lista de navios da categoria especificada
     */
    @Override
    public List<IShip> getShipsLike(String category) {
        List<IShip> shipsLike = new ArrayList<>();
        for (IShip s : ships)
            if (s.getCategory().equals(category))
                shipsLike.add(s);

        return shipsLike;
    }

    /**
     * Retorna todos os navios que ainda estão flutuando (não foram totalmente afundados).
     *
     * @return Lista de navios ainda flutuantes
     */
    @Override
    public List<IShip> getFloatingShips() {
        List<IShip> floatingShips = new ArrayList<>();
        for (IShip s : ships)
            if (s.stillFloating())
                floatingShips.add(s);

        return floatingShips;
    }

    /**
     * Retorna o navio que ocupa uma determinada posição.
     *
     * @param pos Posição a ser verificada
     * @return Navio que ocupa a posição ou {@code null} se não houver navio
     */
    @Override
    public IShip shipAt(IPosition pos) {
        for (int i = 0; i < ships.size(); i++)
            if (ships.get(i).occupies(pos))
                return ships.get(i);
        return null;
    }

    /**
     * Verifica se um navio está totalmente dentro dos limites do tabuleiro.
     *
     * @param s Navio a ser verificado
     * @return {@code true} se o navio está dentro do tabuleiro, {@code false} caso contrário
     */
    private boolean isInsideBoard(IShip s) {
        return (s.getLeftMostPos() >= 0 && s.getRightMostPos() <= BOARD_SIZE - 1 &&
                s.getTopMostPos() >= 0 && s.getBottomMostPos() <= BOARD_SIZE - 1);
    }

    /**
     * Verifica se um navio está em risco de colisão com outros navios da frota.
     *
     * @param s Navio a ser verificado
     * @return {@code true} se houver risco de colisão, {@code false} caso contrário
     */
    private boolean colisionRisk(IShip s) {
        for (int i = 0; i < ships.size(); i++) {
            if (ships.get(i).tooCloseTo(s))
                return true;
        }
        return false;
    }

    /**
     * Exibe o estado completo da frota, incluindo todos os navios, navios flutuantes
     * e navios por categoria.
     */
    public void printStatus() {
        printAllShips();
        printFloatingShips();
        printShipsByCategory("Galeao");
        printShipsByCategory("Fragata");
        printShipsByCategory("Nau");
        printShipsByCategory("Caravela");
        printShipsByCategory("Barca");
    }

    /**
     * Imprime todos os navios de uma categoria específica.
     *
     * @param category Categoria de navios
     */
    public void printShipsByCategory(String category) {
        assert category != null;

        printShips(getShipsLike(category));
    }

    /**
     * Imprime todos os navios que ainda estão flutuando.
     */
    public void printFloatingShips() {
        printShips(getFloatingShips());
    }

    /**
     * Imprime todos os navios da frota.
     */
    void printAllShips() {
        printShips(ships);
    }

}
