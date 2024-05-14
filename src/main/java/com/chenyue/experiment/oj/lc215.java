package com.chenyue.experiment.oj;

/**
 * @author chenyue7@foxmail.com
 * @date 16/4/2024
 * @description
 */
public class lc215 {
    public static void main(String[] args) {
        lc215 lc215 = new lc215();
        int[] nums = new int[]{3,2,3,1,2,4,5,5,6};
        lc215.findKthLargest(nums, 4);
        System.out.println(lc215.ans);
    }

    int ans = 0;
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        quickselect(nums, 0, len - 1,  len - k);
        return ans;
    }

    public void quickselect(int[] nums, int l, int r, int k) {
        if(l > r) { return;}
        int pivot = nums[l];
        // 优化pivot的选取
       /* int left = nums[l];
        int mid  = nums[(l + r) / 2];
        int right = nums[r];
        if(left < mid  && mid < right) {
            pivot = mid;
        }else if(mid < left && left < right) {
            pivot = left;
        }else {
            pivot = right;
        }*/
        int i = l, j = r;
        while(i < j) {
            while(i < j && nums[j] >= pivot){j--;};
            while(i < j && nums[i] <= pivot){i++;};
            int tmp = nums[j];
            nums[j] = nums[i];
            nums[i] = tmp;
        }
        int temp = nums[j];
        nums[j] = pivot;
        nums[l] = temp;
        if(j < k) {
            quickselect(nums, j + 1, r, k);
        }else if(j > k){
            quickselect(nums, l, j - 1, k);
        }else{
            ans = pivot;
        }
    }
}
