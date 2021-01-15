import jdk.swing.interop.SwingInterOpUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class App {
    /**
     * Runs the main code.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Welcome to a game of Tic Tac Toe");
        int games = Console.readInt("How many games do you want to play with the CPU? It came be up to 10 games. ", 1, 10);
        System.out.println("The board can be a 3 x 3 all the way up to 10 x 10.");
        int size = Console.readInt("How big do you want the Tic Tac Toe board to be? ", 3, 10);
        int wins = 0;
        int losses = 0;
        int ties = 0;
        int counter = 0;

        // This while loop allows the user to play x amount of games
        for (int i = 0; i < games; i++) {
            System.out.println();
            int player = 1;
            int x = 0;
            int y = 0;
            TicTacToe ttt = new TicTacToe(size);
            System.out.println("Player 1 'X' and Player 2 is 'O'");
            int chosenPlayer = RNG.coinFlip();
            if (chosenPlayer == player) {
                System.out.println("Player 1 (You) will go first.");
                System.out.println("You are player " + player % 2 + ", put in the x and y coordinate");
                x = Console.readInt("First, type in the x coordinate. ", 0, ttt.getSqLength() - 1);
                y = Console.readInt("Second, type in the y coordinate. ", 0, ttt.getSqLength() - 1);
            } else {
                System.out.println("Player 1 (CPU) will go first.");
            }
            int move = ttt.move(x, y, (player++) % 2);
            while (move == 0 || move == -2) {
                if (chosenPlayer == 1) {
                    if (player % 2 == 0) {
                        System.out.println("Player " + 2 + ", has made there move.");
                        x = RNG.randInt(0, ttt.getSqLength() - 1);
                        y = RNG.randInt(0, ttt.getSqLength() - 1);
                    } else {
                        System.out.println("You are player " + 1 + ", put in the x and y coordinate");
                        x = Console.readInt("First, type in the x coordinate. ", 0, ttt.getSqLength() - 1);
                        y = Console.readInt("Second, type in the y coordinate. ", 0, ttt.getSqLength() - 1);
                    }
                } else {
                    if (player % 2 != 0) {
                        System.out.println("Player " + 1 + ", has made there move.");
                        x = RNG.randInt(0, ttt.getSqLength() - 1);
                        y = RNG.randInt(0, ttt.getSqLength() - 1);
                    } else {
                        System.out.println("You are player " + 2 + ", put in the x and y coordinate");
                        x = Console.readInt("First, type in the x coordinate. ", 0, ttt.getSqLength() - 1);
                        y = Console.readInt("Second, type in the y coordinate. ", 0, ttt.getSqLength() - 1);
                    }
                }
                move = ttt.move(x, y, (player++) % 2);
                if (move == -2) player++;
            } // end of while loop

            if (move == -1) {
                System.out.println("This game was tied!");
                ties++;
            } else if (move == 1) {
                if (chosenPlayer == move) wins++;
                else losses++;
            } else {
                if (chosenPlayer == move) wins++;
                else losses++;
            }
            counter++;
            System.out.println("Game " + counter + ": You: " + wins +  ", CPU: " + losses + ", Ties: " + ties);
        } // end of for loop
        report(wins, losses, ties, games);
    }

    /**
     * Reports the results.
     * @param wins
     * @param losses
     * @param ties
     * @param games
     */
    public static void report(int wins, int losses, int ties, int games) {
        System.out.println("Results:");
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Ties: " + ties);
        double winPercentage = (double)(2 * wins + ties) / (double)(2 * games) * 100;
        System.out.println("Your win percentage is: " + round(winPercentage, 2) + "%");
    }
    /**
     * This returns a double that rounds to the x amount of places
     * @param value double that we are trying to round
     * @param places round to the given integer
     * @return will return the value that is rounded to x places.
     */
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
