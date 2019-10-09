package week11;
/** 
  * Class to handle Insertion Sort.
  * @author Ethan Simmonds
  */
public class InsertionSort extends Sorter{
     /**
      * Create a new InsertionSort sorter with the given integers to sort.
      * 
      * @param nums the integers to sort.
      *
      */
    public InsertionSort(Integer[] nums){
        super(nums);
    }
    
    /** 
     * Sort the numbers. Overrides sortNums.
     */
    
    public void sortNums(){
        for(int u = 0; u < nums.length; u++){
            searchAndInsert(nums, u, nums[u]);
        }
        
    }
    /**
     * Supporter class to search and insert keys.
     * @param nums the array of values to be passed
     * @param index an index value
     * @param val the value
     */
    public void searchAndInsert(Integer[] nums, int index, int val){
        index--;
        while(index >= 0 && nums[index] > val){
            nums[index + 1] = nums[index];
            index--;
        }
        comparisons++;
        update();
        nums[index + 1] = val;
        
    }
}
