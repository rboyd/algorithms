import java.util.Arrays;

public class InsertionSort {
    static int[] unsorted = {80, 62, 45, 12, 52, 61, 76, 22, 95, 7, 2, 16, 8, 85, 17, 38, 25, 48, 60, 96};

    /* Like selection sort, insertion sort is O(n^2) in the common
    implementation. It has the quality of being more efficient for
    partially-sorted inputs. It also outperforms more complex
    algorithms for very small inputs.

    Other notable properties of selection sort:
    - It is stable (the swap operation stops when the keys are equal)
    - It is online (the input can stream in)
    - It is in-place

    Implemented with a more advanced data structure (e.g. a heap), the
    times for search and insertion operations can be greatly reduced.
    */
    public int[] sort(int[] list) {
        for (int i = 1; i < list.length; i++) {
            int j = i;
            int current = list[i];
            for (; j > 0 && list[j-1] > current; j--) {
                list[j] = list[j-1];
            }
            list[j] = current;
        }
        return list;
    }

    public static void main(String[] args) {
        InsertionSort sorter = new InsertionSort();
        System.out.println(Arrays.toString(sorter.sort(unsorted)));
        return;
    }
}
