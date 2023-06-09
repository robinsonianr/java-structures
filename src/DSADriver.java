import com.robinson.algorithms.search.BinarySearchList;
import com.robinson.algorithms.search.LinearSearchList;
import com.robinson.algorithms.sorting.BubbleSort;
import com.robinson.algorithms.sorting.QuickSort;

import java.util.Arrays;

public class DSADriver {
    public static void main(String[] args) {
        int[] testCase = {5, 3, 2, 55, 2, 6};
        QuickSort.quickSort(testCase);

        System.out.println(Arrays.toString(testCase));
    }
}
