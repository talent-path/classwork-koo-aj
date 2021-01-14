import jdk.swing.interop.SwingInterOpUtils;

import java.text.DecimalFormat;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Welcome to a game of Tic Tac Toe");
        int player = 1;
        Scanner sc = new Scanner(System.in);
        int x = 0;
        int y = 0;
        int size = Console.readInt("How big should the Tic Tac Toe board be? ", 3, 10);
        TicTacToe ttt = new TicTacToe(size);
        int chosenPlayer = Console.readInt("Do you want to be player 1 or 2? ", 1, 2);
        if (chosenPlayer == player) {
            System.out.println("You are player " + player % 2 + ", put in the x and y coordinate");
            x = Console.readInt("First, type in the x coordinate. ", 0, ttt.getSqLength() - 1);
            y = Console.readInt("Second, type in the y coordinate. ", 0, ttt.getSqLength() - 1);
        } else {
            System.out.println("You are player " + 2 + ", put in the x and y coordinate");
            x = Console.readInt("First, type in the x coordinate. ", 0, ttt.getSqLength() - 1);
            y = Console.readInt("Second, type in the y coordinate. ", 0, ttt.getSqLength() - 1);
        }
        if (chosenPlayer != player) player++;
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
            }
            else {
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
        }
    }
}
