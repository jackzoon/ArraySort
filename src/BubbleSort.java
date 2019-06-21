import java.util.Arrays;

/**
 * @author Halen
 * @version 1.0
 * @date 2019/6/10 19:22
 * 冒泡排序
 * 双层循环，时间复杂度为O(n^2)
 */
public class BubbleSort extends ArraySort{

    // 冒泡排序，平均时间复杂度O(n^2)，空间复杂度O(1)，稳定
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr,j,j+1);
                }
            }
        }
    }

    public static void bubbleSort_2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        boolean sorted = true;
        for (int i = 0; i < arr.length - 1; i++) {
            sorted = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    sorted = false;
                    swap(arr,j,j+1);
                }
            }
            if (sorted) {
                break;
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
            bubbleSort_2(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Good!" : "Fail!");
        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        bubbleSort(arr);
        printArray(arr);
    }

}
