public class Aggregate {

    /**
     * Finds the minimum value inside the integer array.
     * @param arr
     * @return min
     */
    public static int min (int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int i : arr)
            if (i < min)
                min = i;
        return min;
    }

    /**
     * Finds the maximum value inside the integer array.
     * @param arr
     * @return max
     */
    public static int max (int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i : arr)
            if (i > max)
                max = i;
        return max;
    }

    /**
     * Finds the sum of all the numbers in the integer array.
     * @param arr
     * @return sum
     */
    public static int sum (int[] arr) {
        int sum = 0;
        for (int i : arr)
            sum += i;
        return sum;
    }

    /**
     * Finds the average of all the numbers in the integer array.
     * @param arr
     * @return average
     */
    public static double avg (int[] arr) {
        return sum(arr) / (double)arr.length;
    }

    /**
     * Finds the standard deviation of the numbers in the integer array.
     * @param arr
     * @return standard deviation
     */
    public static double standardDeviation (int[] arr) {
        double avg = avg(arr);
        double stdev = 0.0;
        for (int i : arr)
            stdev += Math.pow((i - avg), 2);
        return Math.sqrt((stdev / arr.length));
    }

    static int[] allFoundFibs = new int[10000];
    public static int fibonacci(int n) {
        if (n <= 1) return n;
        if (allFoundFibs[n] == 0) allFoundFibs[n] = fibonacci(n - 1) + fibonacci(n - 2);
        return allFoundFibs[n];
    }
}
