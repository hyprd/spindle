package week11;
/** 
  * Class to handle Selection Sort.
  * @author Ethan Simmonds
  */
public class SelectionSort extends Sorter {
    /**
      * Create a new SelectionSort sorter with the given integers to sort.
      * 
      * @param nums the integers to sort.
      *
      */
    public SelectionSort(Integer[] nums) {
        super(nums);
    }
    
    /** 
      * Sort the numbers. Overrides sortNums.
      */
    public void sortNums() {
        i = 0;

        while (i < nums.length) {
            j = minPosition(i, nums.length);
            swap(i, j);
            i++;
        }
    }
    /** 
      * Support class to find the current minimum position.
      * @param a position in array
      * @param b another position in the array 
      * @return index the index value
      */

    public int minPosition(int a, int b) {
        int index = i;
        int value = nums[i];

        for (int u = i + 1; u < nums.length; u++) {
            if (nums[u] < value) {
                index = u;
                value = nums[u];
            }

            comparisons++;
            update();
        }
        return index;
    }
    
    /** 
      * Swap elements in the array to their proper 
      * (or atleast until reupdating) location.
      * @param a element in the array
      * @param b another element in the array
      */
    public void swap(int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
}
