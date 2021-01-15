import java.util.Arrays;

/**
 * The TicTacToe class will allow the player to make his/her move.
 */
public class TicTacToe {
    char[][] gameDis;
    int[] rows;
    int[] cols;
    int size;
    int diag;
    int antiDiag;
    int totalMoves;

    /**
     * This is the constructor of the class so it
     * @param n n x n dimension
     */
    public TicTacToe(int n) {
        this.size = n;
        rows = new int[n];
        cols = new int[n];
        gameDis = new char[n][n];
        for (int i = 0; i < gameDis.length; i++) {
            for (int j = 0; j < gameDis[i].length; j++) {
                gameDis[i][j] = '+';
            }
        }
        totalMoves = 0;
        diag = 0;
        antiDiag = 0;
    }

    /**
     * This performs the main action of tic tac toe. This method
     * gives us insight on whether the game was won, lost, or tied.
     * @param row row of tic tac toe game
     * @param col col of tic tac to game
     * @param player which player 1 or 2
     * @return returns the correct int that gives us details on whether the game
     * has been won, lost, tied, or still playing.
     */
    public int move(int row, int col, int player) {
        int p = player == 1 ? 1 : -1;
        if (p == 1) {
            // player 1
            if (gameDis[row][col] != 'X' && gameDis[row][col] != 'O')
                gameDis[row][col] = 'X';
            else if (gameDis[row][col] == 'X'){
                System.out.println();
                System.out.println("This slot is already taken by player 1.");
                System.out.println("Try again.");
                System.out.println();
                return -2;
            }
            else {
                System.out.println();
                System.out.println("This slot is already taken by player 2.");
                System.out.println("Try again.");
                System.out.println();
                return -2;
            }
        }
        else {
            // player 2
            if (gameDis[row][col] != 'X' && gameDis[row][col] != 'O')
                gameDis[row][col] = 'O';
            else if (gameDis[row][col] == '0') {
                System.out.println();
                System.out.println("This slot is already taken by player 2.");
                System.out.println("Try again.");
                System.out.println();
                return -2;
            }
            else {
                System.out.println();
                System.out.println("This slot is already taken by player 1.");
                System.out.println("Try again.");
                System.out.println();
                return -2;
            }
        }
        rows[row] += p;
        cols[col] += p;
        if(row == col)
            diag += p;
        if(row + col == size - 1)
            antiDiag += p;
        if(Math.abs(rows[row]) == size ||
                Math.abs(cols[col]) == size ||
                Math.abs(diag) == size ||
                Math.abs(antiDiag) == size) {
            display();
            if (player == 0) player = 2;
            System.out.println("Player " + player + " wins!");
            return player;
        }
        display();
        totalMoves++;

        // More efficient way to find if the graph was filled.
        if (totalMoves != size * size) return 0;

        // Less efficient method.
//        for (int i = 0 ; i < gameDis.length; i++)
//            for (int j = 0; j < gameDis[i].length; j++)
//                if (gameDis[i][j] == '+') return 0;
        return -1;
    }

    /**
     * Get the length of the tic tac toe board
     * @return length of the tic tac toe board
     */
    public int getSqLength() {
        return gameDis.length;
    }

    /**
     * This will display the tic tac toe board on Console.
     */
    public void display() {
        System.out.println(Arrays.deepToString(gameDis).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
        System.out.println();
    }
}
