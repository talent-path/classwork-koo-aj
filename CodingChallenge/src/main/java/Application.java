import java.util.*;

public class Application {
    static class FirstTwoCharComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            return a.substring(0,2).compareTo(b.substring(0,2));
        }
    }
    public static void main(String[] args) {
        letterCasePermutation("a1b2");
//        findCircleNum(new int[][] {{1,1,0,0}, {1,1,0,0}, {0,0,1,1}, {0,0,1,1}});
//        minAreaRect(new int[][] {{1,1}, {1,3}, {3,1}, {3,3}, {2,2}});
//        System.out.println(numPairsDivisibleBy60(new int[] {30,20,150,100,40}));
        System.out.println(findAllConcatenatedWordsInADict(new String[] {"cat","cats","catsdogcats",
                "dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"}));
    }

    public static List<String> findAllConcatenatedWordsInADict(String[] words) {
        HashSet<String> set = new HashSet<>();
        for (String word : words)
            set.add(word);
        List<String> list = new ArrayList<>();
        for (String word: words) {
            int start = 0;
            int count = 0;
            for (int i = 1; i <= word.length(); i++) {
//                System.out.println(word.substring(start, i));
                if (set.contains(word.substring(start, i)) || set.contains(word.substring(0, i))) {
                    start = i;
                    count++;
                    if (count == 2 && i == word.length()) {
                        list.add(word);
                    }
                }
            }
        }
        return list;
    }

    public static int numPairsDivisibleBy60(int[] time) {
        int remainders[] = new int[60];
        int count = 0;
        for (int t: time) {
            if (t % 60 == 0) { // check if a%60==0 && b%60==0
                count += remainders[0];
            } else { // check if a%60+b%60==60
                System.out.println(60 - t % 60);
                count += remainders[60 - t % 60];
            }
            remainders[t % 60]++; // remember to update the remainders
        }
        return count;
    }
    public static int minAreaRect(int[][] points) {
        int min = Integer.MAX_VALUE;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] p : points) {
            if (!map.containsKey(p[0])) {
                map.put(p[0], new HashSet<>());
            }
            map.get(p[0]).add(p[1]);
        }
        for (int[] p1 : points) {
            for (int[] p2 : points) {
                if (p1[0] == p2[0] || p1[1] == p2[1]) // if have the same x or y
                    continue;
                if (map.get(p1[0]).contains(p2[1]) && map.get(p2[0]).contains(p1[1])) // find other two points
                    min = Math.min(min, Math.abs(p1[0] - p2[0]) * Math.abs(p1[1] - p2[1]));
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
    public static void dfs(int[][] m, int[] visited, int i) {
        for (int j = 0; j < m.length; j++) {
            if (m[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(m, visited, j);
            }
        }
    }
    public static int findCircleNum(int[][] m) {
        int[] visited = new int[m.length];
        int count = 0;
        for (int i = 0; i < m.length; i++) {
            if (visited[i] == 0) {
                dfs(m, visited, i);
                count++;
            }
        }
        return count;
    }

    public static List<String> letterCasePermutation(String s) {
        List<String> list = new ArrayList<>();
        char[] c = s.toCharArray();
        backtrack(list, c, 0);
        return list;
    }

    public static void backtrack(List<String> list, char[] c, int i) {
        if (i == c.length)
            list.add(new String(c));
        else {
            if (Character.isLetter(c[i])) {
                c[i] = Character.toLowerCase(c[i]);
                backtrack(list, c, i + 1);
                c[i] = Character.toUpperCase(c[i]);
            }
            backtrack(list, c, i + 1);
        }
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
