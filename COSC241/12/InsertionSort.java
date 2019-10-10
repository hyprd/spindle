package week12;

/**
 *  An insertion sort implementation which is able to be observed through its
 *  Sorter superclass.
 *
 * @author Iain Hewson
 */
public class InsertionSort extends Sorter {

    /**
     *  Create a new InsertionSort sorter with the given integers to sort.
     * 
     * @param nums the integers to sort.
     */
    public InsertionSort(Integer[] nums) {
        super(nums);
    }

    /**
     *  Sort the integers (which are stored in the parent Sorter class)
     *  using insertion sort.
     */
    public void sortNums() {
        for(i = 1; i < nums.length; i++){
            int k = nums[i];
            for(j = i - 1; j >= 0 && nums[j] > k; j--){
                nums[j + 1] = nums[j];
            }
            nums[j + 1] = k;
        }
        
    }

}
