package sort;

/**
 * @author zy
 * @Date 16:29 2021/10/23
 * @Description
 */
public class QuickSort {


    public static void main(String[] args) {
        int[] arrs = new int[]{0, 1};
        int[] arrs2 = new int[]{1, 0};
        System.out.println(partition(arrs, 0, 1));
        System.out.println(partition(arrs2, 0, 1));
    }

    private static int partition(int[] arrs, int left, int right) {

        int target = arrs[left];
        int i = left;
        int j = right + 1;
        // 1, 0
        // 0, 1
        while (true) {
            while (arrs[++i] <= target) {
                if (i == right) break;
            }
            while (arrs[--j] >= target) {
                if (left == j) break;
            }
            if (i >= j) break;
            swap(arrs, i, j);
        }
        swap(arrs, left, j);
        return j;
    }


    private static void swap(int[] arrs, int source, int target) {
        int temp = arrs[source];
        arrs[source] = arrs[target];
        arrs[target] = target;
    }

}
