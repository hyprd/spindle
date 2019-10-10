package week11;
/** 
  * Implementation of the quick sort sorting method.
  * @author Ethan Simmonds
  */
public class QuickSort extends Sorter{
    /** 
      *  Basic constructor to pass nums array. 
      *  @param nums the array to be passed to the constructor
      */
    public QuickSort(Integer[] nums){
        super(nums);
    }
    /**
      * Method to invoke quicksort. Overrides sortNums
      * from abstract class.
      */
    public void sortNums(){
        quicksort(0, nums.length);
    }
    /** 
      * Recursive method for quicksorting. 
      * @param high the highest element
      * @param low the lowest element
      */
    private void quicksort(int low, int high){
        if(high - low <= 1){
            return;
        }
        int part = partition(low, high);
        quicksort(low, part);
        quicksort(part + 1, high);
        //update();
    }  
    /** 
      * Method for partitioning elements.
      * @param low the lowest element
      * @param high the highest element
      * @return the value of 'hole'
      */
    private int partition (int low, int high){
        int pivot = nums[low];
        int hole = low;
        int left = low + 1;
        int right = high - 1;
        while(true){
            while(right > hole && nums[right] >= pivot){
                comparisons++;
                update();
                right--;
            }
            if (right == hole){
                break;
            }
            nums[hole] = nums[right];
            hole = right;
            while(left < hole && nums[left] < pivot){
                comparisons++;
                update();              
                left++;
            }
            if(left == hole){
                break;
            }
            nums[hole] = nums[left];
            hole = left;
        }
        nums[hole] = pivot;
        return hole;
    }
}
        


