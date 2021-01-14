public class Application {
    public static void main(String[] args) {
//        System.out.println(middleOfThree(2, 2, 3));
//        System.out.println(middleOfThree(1, 1, 2));
//        System.out.println(middleOfThree(2, 1, 3));
//        System.out.println(middleOfThree(2, 3, 1));
//        System.out.println(middleOfThree(3, 1, 2));
//        System.out.println(middleOfThree(3, 2, 1));
//        System.out.println(maxNum(3,4,5));
        fizzBuzz(100);

    }

    public static void fizzBuzz(int n) {
        for (int i = 0; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) System.out.println("FizzBuzz");
            else if (i % 3 == 0) System.out.println("Fizz");
            else if (i % 5 == 0) System.out.println("Buzz");
            else System.out.println(i);
        }
    }
    public static int maxNum(int a, int b, int c) {
        // checking a
        if (a > b && a > c) return a;
        else if (b > a && b > c) return b;
        return c;
    }

    public static int middleOfThree(int a, int b, int c) {
        // checking a
        if ((b >= a && c <= a) || (c >= a && b <= a))
            return a;
        // checking b
        else if ((a >= b && c <= b) || (c >= b && a <= b))
            return b;
        else
            return c;
    }
}
