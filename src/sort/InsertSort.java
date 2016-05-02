/**
 * 原理 
 * 依次选择一个待排序的数据，插入到前边已排好序的序列中。
 * 
 * 性能
 * 时间复杂度为O(N^2)，空间复杂度为O(1)。算法是稳定的，比较次数和交换次数都与初始序列有关。
 * 
 * 优化
 * 直接插入排序每次往前插入时，是按顺序依次往前找，可在这里进行优化，往前找合适的插入位置时采用二分查找的方式，即折半插入。 
 * 折半插入排序相对直接插入排序而言：平均性能更快，时间复杂度降至O(NlogN)，排序是稳定的，但排序的比较次数与初始序列无关，总是需要foor(log(i))+1次排序比较。
 * 
 * 使用场景 
 * 当数据基本有序时，采用插入排序可以明显减少数据交换和数据移动次数，进而提升排序效率。
 */
package sort;

/**
 *
 * @author yuezhao
 */
public class InsertSort {
    int[] nums;
    int n;
    
    public InsertSort(int[] nums){
        this.nums = nums;
        n = nums.length;
        //insert_sort();
        insert_sort_binary();
    }
    
    public void insert_sort(){
        for(int i=1;i<n;i++){
            if(nums[i] >= nums[i-1]){ continue; }
            int tmp = nums[i];
            int j;
            for(j=i-1;j>=0 && nums[j]>tmp;j--){
                nums[j+1] = nums[j];
            }
            nums[j+1] = tmp;
        }
    }
    
    public void insert_sort_binary(){
        for(int i=1;i<n;i++){
            if(nums[i] >= nums[i-1]) { continue; }
            int tmp = nums[i], low = 0, high = i-1, index = i;
            while(low+1 < high){
                int mid = low + (high - low)/2;
                if(nums[mid] < nums[i]) { low = mid; }
                else{ high = mid; }
            }
            if(nums[low] >= nums[i]) { index = low; }
            else if(nums[high] >= nums[i]){ index = high; }
            for(int j=i-1;j>=index;j--){
                nums[j+1] = nums[j];
            }
            nums[index] = tmp;
        }
    }
}
