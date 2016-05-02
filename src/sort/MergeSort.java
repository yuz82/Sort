/*
 * 
原理
分而治之思想：

Divide：将n个元素平均划分为各含n/2个元素的子序列；
Conquer：递归的解决俩个规模为n/2的子问题；
Combine：合并俩个已排序的子序列。
性能
时间复杂度总是为O(NlogN)，空间复杂度也总为为O(N)，算法与初始序列无关，排序是稳定的。

优化
优化思路：
在规模较小时，合并排序可采用直接插入；
在写法上，可以在生成辅助数组时，俩头小，中间大，这时不需要再在后边加俩个while循环进行判断，只需一次比完。
 */
package sort;
import java.util.*;

/**
 *
 * @author yuezhao
 */
public class MergeSort {
    int[] nums;
    int n;
    
    public MergeSort(int[] nums){
        this.nums = nums;
        n = nums.length;
        merge_sort();
    }
    
    public void merge_sort(){
        merge_sort(0, n-1);
    }
    
    public void merge_sort(int low, int high){
        if(low>=high) { return; }
        int mid = low + (high-low)/2;
        merge_sort(low, mid);
        merge_sort(mid+1, high);
        merge(low, mid, high);
    }
    
    public void merge(int low, int mid, int high){
        //int[] tmp = Arrays.copyOf(nums, n);
        int[] tmp = new int[n];
        for(int i=low;i<=high;i++) { tmp[i] = nums[i]; }
        int part1 = low, part2 = mid+1, count = low;
        while(part1<=mid && part2<=high){
            if(tmp[part1] < tmp[part2]){
                nums[count++] = tmp[part1++];
            }else{
                nums[count++] = tmp[part2++];
            }
        }
        while(part1<=mid){
            nums[count++] = tmp[part1++];
        }
        while(part2<=high){
            nums[count++] = tmp[part2++];
        }
    }
}
