import java.util.*;

/**
 * Console Class will make it easier for us to print to the console and make sure that whatever we
 * input from the console is a valid integer.
 */
public class Console {

    /**
     * Easier way to print to the console of the given String.
     * @param s this will be what we print out.
     */
    public static void print(String s) {
        System.out.print(s);
    }

    /**
     * This method allows us to set a min and max of the given input. If
     * it isn't within those constraints it will ask to give the input again.
     * @param str String that gives us what to input
     * @param min the min
     * @param max the max
     * @return the correct input that is an integer
     */
    public static int readInt(String str, int min, int max) {
        int num = readInt(str);
        while (num <= min || num >= max) {
            if (num >= min && num <= max) {
                return num;
            }
            else {
                System.out.println("Please try again. The number isn't within " + min + " and " + max + ".");
                num = readInt(str);
            }
        }
        return num;
    }

    /**
     * Reads the int from the given System.in. Makes sure that it is an integer.
     * @param str Given comment.
     * @return returns an integer
     */
    public static int readInt(String str) {
        Scanner sc = new Scanner(System.in);
        boolean validInput = false;
        int num = Integer.MIN_VALUE;
        while (!validInput) {
            print(str);
            String input = sc.nextLine();
            try {
                num = Integer.parseInt(input);
                validInput = true;
            } catch(NumberFormatException e) {
                //
            }
        }
        return num;
    }
}
