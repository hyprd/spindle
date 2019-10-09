package week12;

/**
 *  A selection sort implementation which is able to be observed through
 *  its Sorter superclass.
 *
 * @author Iain Hewson
 */
public class SelectionSort extends Sorter {
    
    /**
     *  Create a new SelectionSort sorter with the given integers to sort.
     * 
     * @param nums the integers to sort.
     */
    public SelectionSort(Integer[] nums) {
        super(nums);
    }

    /**
     *  Sort the integers (which are stored in the parent Sorter class)
     *  using selection sort.
     */
    public void sortNums() {
        for(i = 0; i < nums.length; i++){
            j = findSmallest();
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
     
    }
    public void findSmallest(){
        int smallest = nums[i]; 
        
        for(j = i; j < nums.length; j++){
            if (nums[j] < smallest){
                smallest = j;
                
            }        
        }
        return smallest;
    }
 
}
