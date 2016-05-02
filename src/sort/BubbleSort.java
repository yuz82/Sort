/**
 * 
 * 原理
 * 俩俩比较相邻记录的排序码，若发生逆序，则交换；有俩种方式进行冒泡，一种是先把小的冒泡到前边去，另一种是把大的元素冒泡到后边。
 * 
 * 性能
 * 时间复杂度为O(N^2)，空间复杂度为O(1)。排序是稳定的，排序比较次数与初始序列无关，但交换次数与初始序列有关。
 * 
 * 优化
 * 若初始序列就是排序好的，对于冒泡排序仍然还要比较O(N^2)次，但无交换次数。可根据这个进行优化，设置一个flag，
 * 当在一趟序列中没有发生交换，则该序列已排序好，但优化后排序的时间复杂度没有发生量级的改变。
 * 
 */
package sort;

/**
 *
 * @author yuezhao
 */
public class BubbleSort {
    int[] nums;
    int n;
    
    public BubbleSort(int[] nums){
        this.nums = nums;
        n = nums.length;
        bubble_sort();
    }
    
    public void bubble_sort(){
        for(int i=0;i<n;i++){
            boolean modified = false;
            for(int j=1;j<n;j++){
                if(nums[j-1]<=nums[j]) { continue; }
                Swap s = new Swap(nums, j-1, j);
                modified = true;
            }
            if(!modified) { break; }
        }
    }
    
//    public void Swap(int i, j){
//        int tmp = nums[i];
//        nums[i] = nums[i-1];
//        nums[i-1] = tmp;
//    }
}
