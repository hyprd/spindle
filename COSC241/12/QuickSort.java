package week12;

/**
 *  A quick sort implementation which is able to be observed through its
 *  Sorter superclass.
 *
 * @author Iain Hewson
 */
public class QuickSort extends Sorter {

    /**
     *  Create a new QuickSort sorter with the given integers to sort.
     * 
     * @param nums the integers to sort.
     */
    public QuickSort(Integer[] nums) {
        super(nums);
    }

    /**
     *  Sort the integers (which are stored in the parent Sorter class)
     *  using quick sort.
     */
    public void sortNums() {
        
    }

    public void quickSort(int left, int right){
        if (left < right){
            int part = partition(left,right);
            quickSort(left, part);
            quickSort(part + 1, right);
        }
    }
    public void partition(int left, int right){
        int pivot = nums[left];
        int hole = left;
        i = left + 1;
        j= right;
        while(true){
            while(j  hole && hums[j] >= pivot){
                j--;
            }
            if (j == hole){
                return;
            }
            nums[hole] = nums[j];
            hole = j;
            while(i < hole && nums[i] < pivot){
                i++;
            }
            if (i = hole){
                return;
            }
        }

    }
}
