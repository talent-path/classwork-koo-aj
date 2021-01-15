public class Application {
    public static void main(String[] args) {
//        fizzBuzz(100);
//        System.out.println(canBalance(new int[] {1, 2, 3, 4, 1, 4, 3, 2, 1}));
        System.out.println(noTriples(new int[] {1, 1, 2, 1, 2, 1, 1, 2, 2, 2}));
    }

    public static boolean noTriples(int[] nums) {
        int counter = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i])
                counter++;
            else counter = 1;
            if (counter == 3) return false;
        }
        return true;
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

    public static boolean canBalance(int[] nums) {
        // return true if we can split the array
        if (nums.length == 0 || nums.length == 1) return false;
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 == 1) return false;
        int half = 0;
        for (int i = 0; i < nums.length; i++) {
            half += nums[i];
            if (half == sum / 2) return true;
            else if (half > sum / 2) return false;
        }
        return false;
    }
}
