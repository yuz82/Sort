/*
 * 
原理
分而治之思想：

Divide：找到基准元素pivot，将数组A[p..r]划分为A[p..pivotpos-1]和A[pivotpos+1...q]，左边的元素都比基准小，右边的元素都比基准大;
Conquer：对俩个划分的数组进行递归排序；
Combine：因为基准的作用，使得俩个子数组就地有序，无需合并操作。
性能
快排的平均时间复杂度为O(NlogN），空间复杂度为O(logN)，但最坏情况下，时间复杂度为O(N^2)，空间复杂度为O(N)；且排序是不稳定的，但每次都能确定一个元素所在序列中的最终位置，复杂度与初始序列有关。

优化
当初始序列是非递减序列时，快排性能下降到最坏情况，主要因为基准每次都是从最左边取得，这时每次只能排好一个元素。 
所以快排的优化思路如下：

优化基准，不每次都从左边取，可以进行三路划分，分别取最左边，中间和最右边的中间值，再交换到最左边进行排序；或者进行随机取得待排序数组中的某一个元素，再交换到最左边，进行排序。
在规模较小情况下，采用直接插入排序
 */
package sort;

/**
 *
 * @author yuezhao
 */
public class QuickSort {
    int[] nums;
    int n;
    
    public QuickSort(int[] nums){
        this.nums = nums;
        n = nums.length;
        quick_sort();  //solution1
    }
    
    
    public void quick_sort(){
        quick_sort(0, n-1);
    }
    
    public void quick_sort(int low, int high){
        if(low >= high) { return; }
        //int pivot = partition1(low, high);   //solution 1
        int pivot = partition2(low, high);   //solution 2
        quick_sort(low, pivot-1);
        quick_sort(pivot+1, high);
    }
    
    /**
     * Solution 1
     */
    public int partition1(int low, int high){
        int pivot = nums[low], count = low;
        for(int i=low+1;i<=high;i++){
            if(nums[i] < pivot){
                count++;   //count pivot应在的位置
                if(count != i){
                    Swap s = new Swap(nums, count, i); //把比pivot大的数和最近的比pivot小的数交换        
                }
            }
        }
        Swap s = new Swap(nums, count, low);
        return count;
    }
    
    
    /**
     * Solution 2
     */
    public int partition2(int low, int high){
        int pivot = nums[low], index = low;
        while(low < high){
            while(low<high && nums[high]>=pivot) { high--; }   //先判断high，再判断low!!!        
            while(low<high && nums[low]<=pivot) { low++; }
            if(low < high) { Swap s = new Swap(nums, low, high); }
        }
        Swap s = new Swap(nums, index, low);
        return low;
    }
}
