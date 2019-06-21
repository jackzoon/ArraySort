/**
 * @author Halen
 * @version 1.0
 * @date 2019/6/21 22:04
 * 插入排序
 * 时间复杂度：O(n^2)
 */
public class InsertionSort extends ArraySort{

    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 1) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    public static void main(String[] args) {
        int testTime = 5000;
        int maxSize= 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            insertionSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                printArray(arr1);
                printArray(arr2);
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Good!" : "Fail!");
        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        insertionSort(arr);
        printArray(arr);
    }

}
