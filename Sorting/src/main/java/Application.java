public class Application {

    public static void main(String[] args) {
        int[] arr = {10, 7, 9, 3, 2, 1, 8, 4, 5, 6};
        quickSort(arr, 0, arr.length - 1);
        for (int a : arr) {
            System.out.print(a);
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pIndex = partition(arr, low, high);
            quickSort(arr, low, pIndex - 1);
            quickSort(arr, pIndex + 1, high);
        }
    }

    public static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int j = low - 1;
        for (int i = low; i < high; i++) {
            if (arr[i] < pivot) {
                j++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        int temp = arr[j + 1];
        arr[j + 1] = arr[high];
        arr[high] = temp;
        return j + 1;
    }
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
