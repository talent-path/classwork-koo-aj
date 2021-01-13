import java.sql.SQLOutput;
import java.util.*;

public class App {
    public static void main(String[] args) {
        System.out.println("You are in a dessert and you have the choice to go North, South, West, or East to get out");
        System.out.print("Please choose one of the options ");
        Scanner sc = new Scanner(System.in);

        while (true) {
            String next = sc.nextLine().toLowerCase();
            if (next.equals("north")) {
                System.out.println("You have taken the northern path, welcome.");
                System.out.print("Do you want to go left or right ");
                String lr = sc.nextLine().toLowerCase();
                LeftOrRight(sc);
                break;
            } else if (next.equals("south")) {
                System.out.println("You have taken the southern path, welcome.");
                LeftOrRight(sc);
                break;
            } else if (next.equals("west")) {
                System.out.println("You have taken the western path, welcome.");
                LeftOrRight(sc);
                break;
            } else if (next.equals("east")) {
                System.out.println("You have taken the eastern path, welcome.");
                LeftOrRight(sc);
                break;
            } else {
                System.out.println("Choose again");
            }
        }
    }

    public static void LeftOrRight(Scanner sc) {
        while (true) {
            String lr = sc.nextLine().toLowerCase();
            if (lr.equals("left")) {
                System.out.println("You have come the left way, welcome.");
                break;
            } else if (lr.equals("right")) {
                System.out.println("You have come the right way, welcome.");
                break;
            } else {
                System.out.println("Try again please! Left or Right");
            }
        }
    }
}
