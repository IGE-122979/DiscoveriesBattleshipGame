package iscteiul.ista.battleship;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa uma partida do jogo Battleship.
 * <p>
 * Esta classe mantém o estado do jogo, incluindo a frota, os tiros disparados,
 * e estatísticas sobre tiros inválidos, repetidos, acertos e navios afundados.
 * </p>
 * 
 * @author fba
 */
public class Game implements IGame {

    /** Frota de navios do jogo */
    private IFleet fleet;

    /** Lista de posições onde tiros foram disparados */
    private List<IPosition> shots;

    /** Contador de tiros inválidos (fora do tabuleiro) */
    private Integer countInvalidShots;

    /** Contador de tiros repetidos (mesma posição já atirada) */
    private Integer countRepeatedShots;

    /** Contador de tiros que acertaram algum navio */
    private Integer countHits;

    /** Contador de navios afundados */
    private Integer countSinks;

    /**
     * Construtor do jogo.
     * <p>
     * Inicializa os contadores e associa uma frota ao jogo.
     * </p>
     * 
     * @param fleet Frota de navios utilizada no jogo
     */
    public Game(IFleet fleet) {
        shots = new ArrayList<>();
        countInvalidShots = 0;
        countRepeatedShots = 0;
        countHits = 0;
        countSinks = 0;
        this.fleet = fleet;
    }

    /**
     * Dispara um tiro em uma posição específica.
     * <p>
     * Atualiza os contadores de tiros inválidos, repetidos, acertos e afundamentos.
     * Retorna o navio afundado, caso algum tenha sido afundado pelo tiro.
     * </p>
     * 
     * @param pos Posição do tiro
     * @return Navio afundado se houver, ou {@code null} caso contrário
     */
    @Override
    public IShip fire(IPosition pos) {
        if (!validShot(pos))
            countInvalidShots++;
        else { // tiro válido
            if (repeatedShot(pos))
                countRepeatedShots++;
            else {
                shots.add(pos);
                IShip s = fleet.shipAt(pos);
                if (s != null) {
                    s.shoot(pos);
                    countHits++;
                    if (!s.stillFloating()) {
                        countSinks++;
                        return s;
                    }
                }
            }
        }
        return null;
    }

    /**
     * Retorna a lista de todos os tiros disparados.
     * 
     * @return Lista de posições dos tiros
     */
    @Override
    public List<IPosition> getShots() {
        return shots;
    }

    /**
     * Retorna o número de tiros repetidos.
     * 
     * @return Quantidade de tiros repetidos
     */
    @Override
    public int getRepeatedShots() {
        return this.countRepeatedShots;
    }

    /**
     * Retorna o número de tiros inválidos.
     * 
     * @return Quantidade de tiros inválidos
     */
    @Override
    public int getInvalidShots() {
        return this.countInvalidShots;
    }

    /**
     * Retorna o número de tiros que acertaram algum navio.
     * 
     * @return Quantidade de acertos
     */
    @Override
    public int getHits() {
        return this.countHits;
    }

    /**
     * Retorna o número de navios afundados.
     * 
     * @return Quantidade de navios afundados
     */
    @Override
    public int getSunkShips() {
        return this.countSinks;
    }

    /**
     * Retorna o número de navios restantes (ainda flutuando) na frota.
     * 
     * @return Quantidade de navios ainda flutuando
     */
    @Override
    public int getRemainingShips() {
        List<IShip> floatingShips = fleet.getFloatingShips();
        return floatingShips.size();
    }

    /**
     * Verifica se um tiro está dentro dos limites do tabuleiro.
     * 
     * @param pos Posição do tiro
     * @return {@code true} se o tiro é válido, {@code false} caso contrário
     */
    private boolean validShot(IPosition pos) {
        return (pos.getRow() >= 0 && pos.getRow() < Fleet.BOARD_SIZE &&
                pos.getColumn() >= 0 && pos.getColumn() < Fleet.BOARD_SIZE);
    }

    /**
     * Verifica se um tiro já foi disparado anteriormente.
     * 
     * @param pos Posição do tiro
     * @return {@code true} se o tiro já foi disparado, {@code false} caso contrário
     */
    private boolean repeatedShot(IPosition pos) {
        for (int i = 0; i < shots.size(); i++)
            if (shots.get(i).equals(pos))
                return true;
        return false;
    }

    /**
     * Imprime o tabuleiro com um conjunto de posições marcado por um caractere específico.
     * 
     * @param positions Lista de posições a serem marcadas
     * @param marker    Caractere utilizado para marcar as posições
     */
    public void printBoard(List<IPosition> positions, Character marker) {
        char[][] map = new char[Fleet.BOARD_SIZE][Fleet.BOARD_SIZE];

        for (int r = 0; r < Fleet.BOARD_SIZE; r++)
            for (int c = 0; c < Fleet.BOARD_SIZE; c++)
                map[r][c] = '.';

        for (IPosition pos : positions)
            map[pos.getRow()][pos.getColumn()] = marker;

        for (int row = 0; row < Fleet.BOARD_SIZE; row++) {
            for (int col = 0; col < Fleet.BOARD_SIZE; col++)
                System.out.print(map[row][col]);
            System.out.println();
        }
    }

    /**
     * Imprime o tabuleiro mostrando todos os tiros válidos disparados.
     */
    public void printValidShots() {
        printBoard(getShots(), 'X');
    }

    /**
     * Imprime o tabuleiro mostrando todas as posições ocupadas pelos navios da frota.
     */
    public void printFleet() {
        List<IPosition> shipPositions = new ArrayList<IPosition>();

        for (IShip s : fleet.getShips())
            shipPositions.addAll(s.getPositions());

        printBoard(shipPositions, '#');
    }
}
