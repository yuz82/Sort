/**
 * Sort Methods
 * 
 * References:
 * https://segmentfault.com/a/1190000003718280
 * https://segmentfault.com/a/1190000004994003
 */
package sort;

/**
 *
 * @author yuezhao
 */
public class Sort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Test cases
        int[] nums1 = { 7,6,5,4,3,2,1 };
        int[] nums2 = { 3,2,1,4,1 };
        int[] nums3 = { 7,2,4,6,1,5,3 };
        
        //sort methods
        //InsertSort is = new InsertSort(nums2);
        //BubbleSort bs = new BubbleSort(nums2);
        //SelectionSort ss = new SelectionSort(nums2);
        //QuickSort qs = new QuickSort(nums2);
        //MergeSort ms = new MergeSort(nums2);
        HeapSort hs = new HeapSort(nums3);
        
        //output
        for(int i : nums3){
            System.out.print(i + " ");
        }
        System.out.println("");
    }
    
}
