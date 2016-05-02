/**
 * 原理
 * 每次从未排序的序列中找到最小值，记录并最后存放到已排序序列的末尾
 * 
 * 性能
 * 时间复杂度为O(N^2)，空间复杂度为O(1)，排序是不稳定的（把最小值交换到已排序的末尾导致的），
 * 每次都能确定一个元素所在的最终位置，比较次数与初始序列无关。
 */
package sort;

/**
 *
 * @author yuezhao
 */
public class SelectionSort {
    int[] nums;
    int n;
    
    public SelectionSort(int[] nums){
        this.nums = nums;
        n = nums.length;
        selection_sort();
    }
    
    public void selection_sort(){
        for(int i=0;i<n-1;i++){  //只要判断n－1次
            int min = i;
            for(int j=i+1;j<n;j++){
                if(nums[j] < nums[min])
                min = j;
            }
            if(min != i){
                Swap s = new Swap(nums, i, min);
            }
        }
    }
}
