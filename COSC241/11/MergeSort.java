package week11;
/**
 * Java implementation of a merge sort algorithm.
 * @author Ethan Simmonds
 */
public class MergeSort extends Sorter {
    /**
     * Basic constructor. 
     * @param nums an array of elements, retrieved from an external file
     */
    public MergeSort(Integer[] nums) {
        super(nums);
    }

    /**
     * Call sort to sort numbers. 
     * Overrides sortNums in the Sorter abstract class.
     */
    public void sortNums() {
        mergeSort(0, nums.length);
    }

    /**
     * Recursively sort the elements in an array.
     * @param left the left section
     * @param right the right section
     */
    public void mergeSort(int left, int right) {
        if (right - left <= 1) {
            return;
        }
        int mid = (left + right)/2;
        j = mid;
        mergeSort(left, mid);
        mergeSort(mid, right);
        merge(left, mid, right);
        comparisons++;
        update();
    }

    /**
     * Merge the sorted results together.
     * @param left the left section
     * @param mid the middle position
     * @param right the right section
     */
    public void merge(int left, int mid, int right) {
        //update();
        Integer[] temp = new Integer[right - left];
        int leftPos = left;
        int rightPos = mid;
        i = 0;
        while (leftPos < mid && rightPos < right) {
            if (nums[leftPos] < nums[rightPos]) {
                j = leftPos;
                temp[i++] = nums[leftPos++];
            } else {
                temp[i++] = nums[rightPos++];
            }
        }
        while (leftPos < mid) {
            temp[i++] = nums[leftPos++];
        }
        while (rightPos < right) {
            temp[i++] = nums[rightPos++];
        }
        System.arraycopy(temp, 0, nums, left, right - left);
    }
}
