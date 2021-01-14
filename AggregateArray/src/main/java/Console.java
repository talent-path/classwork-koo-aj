import java.util.*;

public class Console {

    public static void print(String s) {
        System.out.print(s);
    }
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
    public static double readDouble(String str, double min, double max) {
        double num = readDouble(str);
        while (num <= min || num >= max) {
            if (num >= min && num <= max) {
                System.out.println("The number, " + num + " is between " + min + " and " + max + ".");
                return num;
            }
            else {
                System.out.println("Please try again. The number isn't within the min and max.");
                num = readDouble(str);
            }
        }
        return num;
    }
    public static double readDouble(String str) {
        Scanner sc = new Scanner(System.in);
        boolean validInput = false;
        double num = Double.NaN;
        while (!validInput) {
            print(str);
            String input = sc.nextLine();
            try {
                num = Double.parseDouble(input);
                validInput = true;
            } catch(NumberFormatException e) {
                //
            }
        }
        return num;
    }
}
