/*
 * 
原理
堆的性质：

是一棵完全二叉树
每个节点的值都大于或等于其子节点的值，为最大堆；反之为最小堆。
堆排序思想：

将待排序的序列构造成一个最大堆，此时序列的最大值为根节点
依次将根节点与待排序序列的最后一个元素交换
再维护从根节点到该元素的前一个节点为最大堆，如此往复，最终得到一个递增序列
性能
时间复杂度为O(NlogN)，空间复杂度为O(1)，因为利用的排序空间仍然是初始的序列，并未开辟新空间。算法是不稳定的，与初始序列无关。

使用场景
想知道最大值或最小值时，比如优先级队列，作业调度等场景。
 */
package sort;

/**
 *
 * @author yuezhao
 */
public class HeapSort {
    int[] nums;
    int n;
    
    public HeapSort(int[] nums){
        this.nums = nums;
        n = nums.length;
        //heap_sort1();  //solution 1
        heap_sort2();  //solution 2
    }
    
    /**
     * Solution 1
     */
    public void heap_sort1(){
        buildingHeap();
        for(int i=n-1;i>0;i--){
            Swap s = new Swap(nums, 0, i);  //交换堆顶、堆底元素
            heapAdjust(0, i);
        }
    }
    /**
     * 建堆方法
     * n个节点的完全二叉树，最后一个节点是第n/2个节点的子树
     * 筛选从第n/2个节点为根的子树开始，使其成堆
     * 之后向前依次对各节点为根的子树筛选，使其成堆，直到根节点
     */
    public void buildingHeap(){
        for(int i=(n-1)/2;i>=0;i--){
            heapAdjust(i, n);
        }
    }
    /**
     * 调整小顶堆
     * 将堆顶元素输出后，将堆底元素推送至堆顶
     * 将根节点与其左右子树中较小的元素交换
     * 对被交换的左右子树进行调整，重复上一步，直到根节点
     */
    public void heapAdjust(int root, int len){
        int tmp = nums[root];
        int child = 2*root+1; //左孩子节点
        while(child < len){
            if(child+1<len && nums[child]<nums[child+1]){ //右孩子大于左孩子
                ++child;
            }
            if(nums[root] < nums[child]){
                nums[root] = nums[child];
                root = child;
                child = 2*root+1;
            }else{
                break;
            }
            nums[root] = tmp;
        }
    }
    
    
    
    /**
     * Solution 2
     */
    public void heap_sort2(){
        //先调整为最大堆，再依次与第一个交换，进行调整，最后构成最小堆
        for (int i = (n - 2) / 2; i >= 0; i--){   //n为总长度，最后一个为n-1,所以父节点为    (n-1-1)/2
            shiftDown(i,n-1);
        }
        for (int i = n - 1; i >= 0; i--){
            Swap s = new Swap(nums, 0, i);
            shiftDown(0,i-1);
        }
    }
    
    public void shiftDown(int start, int end){  
        //从start出发到end，调整为最大堆
        int dad = start;
        int son = dad * 2 + 1;
        while (son <= end){
            //先选取子节点中较大的
            if (son + 1 <= end && nums[son] < nums[son + 1]){
                son++;
            }
            //若子节点比父节点大，则交换，继续往子节点寻找；否则退出
            if (nums[dad] < nums[son]){
                Swap s = new Swap(nums, dad, son);
                dad = son;
                son = dad * 2 + 1;
            }
            else{
                break;
            }
        }
    }
    
}
