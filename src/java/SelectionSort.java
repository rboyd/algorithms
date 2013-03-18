import java.util.Arrays;

public class SelectionSort {
    static int[] unsorted = {80, 62, 45, 12, 52, 61, 76, 22, 95, 7, 2, 16, 8, 85, 17, 38, 25, 48, 60, 96};

    /* Selection sort is O(n^2) and operates by advancing two pointers
       through the input list. The first pointer starts at the
       left-most item while the second pointer starts at its right
       neighbor.

       The second pointer advances to the end of the list, with a
       comparison at every step. If the value at the second pointer is
       less than the value at the first pointer, they are swapped. (In
       practice the minimum is identified and the swap occurs after
       the end is reached).

       When the second pointer arrives at the end of the list, the
       first pointer is advanced and the second pointer is reset to
       its right neighbor.

       The invariants are that all items to the left of the pointers
       are in order, and the value at the first pointer is the lowest
       value encountered on the current iteration.

       Selection sort is less performant than other sorting algorithms
       but is notable for being simple and for its memory efficiency
       by virtue of sorting in-place.
    */
    public int[] sort(int[] list) {
        int min;
        for (int i = 0; i < list.length-1; i++) {
            min = i;
            for (int j = i+1; j < list.length; j++) {
                if (list[j] < list[min]) {
                    min = j;
                }
            }

            if (min != i) {
                int tmp = list[i];
                list[i] = list[min];
                list[min] = tmp;
            }
        }
        return list;
    };

    public static void main(String[] args) {
        SelectionSort sorter = new SelectionSort();
        System.out.println(Arrays.toString(sorter.sort(unsorted)));
        return;
    }
}
