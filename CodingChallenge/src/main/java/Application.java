import java.util.*;

public class Application {
    static class FirstTwoCharComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            return a.substring(0,2).compareTo(b.substring(0,2));
        }
    }
    public static void main(String[] args) {
//        addBigNum(new int[] {1, 2, 3}, new int[] {4, 5, 7});
//        maxMirror(new int[] {1, 2, 3, 8, 9, 3, 2, 1});
//        System.out.println(maxMirror(new int[] {5, 9, 9, 6, 5, 4, 9, 9, 2}));
//        List<String> testList = new ArrayList<>();
//        testList.add("Bob");
//        testList.add("Bobby");
//        testList.add("Robert");
//        testList.add("Roberto");
//        testList.add("Alice");
//        testList.add("Alicia");
//        groupByFirstTwoCharacter(testList.toArray(new String[testList.size()]));
//        System.out.println(reverseDigit(54321));
        System.out.println(maxArea(new int[] {1,8,6,2,5,4,8,3,7}));
    }

    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right])
                    * (right - left));
            if (height[left] < height[right])
                left++;
            else
                right--;
        }

        return maxArea;
    }

    public static boolean isPerfect(int num) {
        int sum = 1;
        for (int i = 2; i * i <= num; i++) {
            if (sum > num) return false;
            if (num % i == 0)
                if (i * i != num) sum += i + (num / i);
                else sum += i;
        }
        return sum == num && num != 1;
    }

    public static int reverseDigit(int digit) {
        int ans = 0;
        while (digit != 0) {
            ans *= 10;
            ans += (digit % 10);
            digit /= 10;
        }
        return ans;
    }

    public static int getLongestChain() {
        int[] longestChain = {0, 0};
        int counter = 0;
        for (int i = 2; i <= 100000000; i++) {
            if (i % 4 == 0) continue;
            long x = i;
            while (x != 1) {
                if (x % 2 == 1) {
                    x = x * 3 + 1;
                    counter++;
                }
                else {
                    x /= 2;
                    counter++;
                }
            }
            if (counter > longestChain[1]) {
                longestChain[0] = i;
                longestChain[1] = counter;
            }
            counter = 0;
        }
        return longestChain[0];
    }

    public static Map<String, List<String>> groupByFirstTwoCharacter(String[] strArr) {
//        Arrays.sort(strArr, new FirstTwoCharComparator());
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strArr) {
            String s = str.length() <= 2 ? str : str.substring(0, 2);
            if (!map.containsKey(s)) {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(s, list);
            } else {
                map.get(s).add(str);
            }
        }
        return map;
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
