public class Application {
    public static void main(String[] args) {
//        addBigNum(new int[] {1, 2, 3}, new int[] {4, 5, 7});
//        maxMirror(new int[] {1, 2, 3, 8, 9, 3, 2, 1});
        System.out.println(maxMirror(new int[] {5, 9, 9, 6, 5, 4, 9, 9, 2}));
    }

    public static int maxMirror(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = nums.length - 1; j >= 0 && i + count < nums.length; j--) {
                if (nums[i + count] == nums[j]) count++;
                else {
                    max = Math.max(count, max);
                    count = 0;
                }
            }
            max = Math.max(count, max);
        }
        return max;
    }

    public static int[] addBigNum(int[] left, int[] right) {
        int[] ans;
        if (left.length > right.length)
            ans = new int[left.length + 1];
        else
            ans = new int[right.length + 1];
        int carry = 0;
        int sum = 0;
        for (int i = 0; i < right.length; i++) {
            int x = right[i];
            int y = left[i];
            sum = x + y + carry;
            carry = sum / 10;
            ans[i] = sum % 10;
        }
        if (carry > 0) ans[ans.length - 1] = carry;
        return ans;
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
