import java.util.Arrays;

public class MergeSort {
    static int[] unsorted = {80, 62, 45, 12, 52, 61, 76, 22, 95, 7, 2, 16, 8, 85, 17, 38, 25, 48, 60, 96};

    public int[] merge(int[] left, int[] right) {
        int result[] = new int[left.length + right.length];
        int lidx = 0, ridx = 0, res_idx = 0;

        while (lidx < left.length || ridx < right.length) {
            if (lidx < left.length && ridx < right.length) {
                if (left[lidx] <= right[ridx]) {
                    result[res_idx] = left[lidx];
                    lidx++;
                } else {
                    result[res_idx] = right[ridx];
                    ridx++;
                }
            } else if (lidx < left.length) {
                result[res_idx] = left[lidx];
                lidx++;
            } else if (ridx < right.length) {
                result[res_idx] = right[ridx];
                ridx++;
            }
            
            res_idx++;
        }
        return result;
    }

    public int[] sort(int[] list) {
        if (list.length <= 1)
            return list;

        int left[] = Arrays.copyOfRange(list, 0, list.length / 2);
        int right[] = Arrays.copyOfRange(list, list.length / 2, list.length);

        left = sort(left);
        right = sort(right);
        return merge(left, right);
    }

    public static void main(String[] args) {
        MergeSort sorter = new MergeSort();
        System.out.println(Arrays.toString(sorter.sort(unsorted)));
        return;
    }
}
