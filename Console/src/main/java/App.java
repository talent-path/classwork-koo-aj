public class App {
    public static void main(String[] args) {
        int min1 = 5, max1 = 10;
        int num1 = Console.readInt("Please enter a number between " + min1 + " and " + max1 + ": ", min1, max1);
        double min2 = 5.75, max2 = 10.75;
        double num2 = Console.readDouble("Please enter a number between " + min2 + " and " + max2 + ": ", min2, max2);
        System.out.println(num1);
        System.out.println(num2);
    }
}
