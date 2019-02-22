package datastructure.array.program;

/**
 * Find a peak element in a given array.
 * @author saukedia1
 *
 */
public class PeakElementInArray {

    public static void main(String[] args) {
        int[] array = { 5, 4, 3, 9, 1 };
        System.out.println(findfirstPeakElement(array));
    }

    /**
     * Peak element in an array is an element whose neighbors are less than the element.</br>
     * We are going to use binary search to find an element whose neighbors are less than itself.</br>
     * 
     * @param array
     * @return
     */
    public static int findfirstPeakElement(int[] array) {
        int peakIndex = modifiedBinarySearch(array, 0, array.length - 1);
        if (peakIndex == -1)
            return -1;
        else
            return array[peakIndex];
    }

    private static int modifiedBinarySearch(int[] array, int low, int high) {
        if (high < low) {
            return -1;
        }
        int mid = (high + low) / 2;

        if ((mid == 0 || array[mid - 1] < array[mid]) && (mid == array.length - 1 || array[mid + 1] < array[mid])) {
            return mid;
        }
        if (mid > 0 && array[mid - 1] > array[mid])
            return modifiedBinarySearch(array, low, mid - 1);
        if (mid < high && array[mid + 1] > array[mid])
            return modifiedBinarySearch(array, mid + 1, high);
        return -1;
    }

}
