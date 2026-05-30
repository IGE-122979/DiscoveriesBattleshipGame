package iscteiul.ista;

import iscteiul.ista.battleship.Fleet;
import iscteiul.ista.battleship.Tasks;

/**
 * Classe principal de entrada (Entry Point) para o jogo Battleship.
 * Esta classe contém o método main que orquestra o arranque do programa
 * e permite selecionar qual a tarefa (Task) a ser executada.
 * * @author britoeabreu
 * @author adrianolopes
 * @author miguelgoulao
 * @author [O Teu Nome Aqui]
 */
public class App 
{
    /**
     * Método principal que inicia a aplicação.
     * Atualmente configurado para executar a Task B por defeito.
     * Para testar outras funcionalidades, descomente a tarefa pretendida 
     * e comente as restantes.
     * * @param args Argumentos da linha de comandos (não utilizados).
     */
    public static void main( String[] args )
    {
        System.out.printf("\n*** Battleship Game ***\n");

        // Tasks.taskA(); // Teste de navios individuais
        Tasks.taskB();    // Teste de frotas e comandos básicos
        // Tasks.taskC(); // Teste de frotas com modo batota
        // Tasks.taskD(); // Fluxo de jogo completo
    }
}
