import java.util.Arrays;

/**
 * @author coolestyue
 * 要努力呀.
 */
public class TestHeap {
    public static void main(String[] args) {
        TestHeap t = new TestHeap();
        //[0,1,1,2,4,4,1,3,3,2]
        //6
        t.getLeastNumbers(new int[]{0, 1, 1, 2, 4, 4, 1, 3, 3, 2}, 6);
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        //构建大顶堆(顶部最大),比他小的就往里放,比他大的不管.
        int[] heap = Arrays.copyOfRange(arr, 0, k);
        if (k == 0 || arr.length == 0 || k > arr.length) return heap;
        buildMaxHeap(heap);
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < heap[0]) {
                heap[0] = arr[i];
                maxHeap(arr, 0);
            }
        }
        return heap;
    }

    public void buildMaxHeap(int[] arr) {
        int j = arr.length / 2 - 1;
        for (int i = j; i >= 0; i--) {
            maxHeap(arr, i);
        }
    }

    public void maxHeap(int[] arr, int index) {
        int maxIndex = index;
        int left = 2 * index + 1;
        int right = left + 1;
        if (left < arr.length && arr[left] > arr[maxIndex]) {
            maxIndex = left;
        }
        if (right < arr.length && arr[right] > arr[maxIndex]) {
            maxIndex = right;
        }
        if (index != maxIndex) {
            int temp = arr[index];
            arr[index] = arr[maxIndex];
            arr[maxIndex] = temp;
            maxHeap(arr, maxIndex);
        }
    }
}
