import java.util.Random;
import java.util.Scanner;

public class RNG {
    static Random rng = new Random();
    public static int randInt( int incMin, int incMax ) {
        int rand = incMin + rng.nextInt(incMax - incMin + 1);
        return rand;
    }

    public static double randDouble( double min, double max ) {
        double rand = min + rng.nextDouble() * (max - min);
        return rand;
    }

    public static boolean coinFlip (boolean bool) {
        return rng.nextBoolean();
    }

    public static int playRPS() {
        int compRNG = randInt(0, 2);
        Scanner sc = new Scanner(System.in);
        while (true) {

        }
    }


}
