package com.chenyue.experiment.oj.doublepointer;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/7/23
 * @description
 * 快慢指针的应用：
 * 1. 判断链表是否有环
 *      快指针每次走两步，慢指针每次走一步，快慢指针能够相遇即说明有环。
 * 2. 寻找链表的中点
 *      快指针每次走两步，慢指针每次走一步，快指针走完链表，慢指针即达到链表中点。
 * 3. 寻找链表的倒数第k个节点
 *      快指针、慢指针每次走一步，快指针先走k步，然后快慢指针一起走，当快指针到达链表尾时，快指针到达第k个节点。
 * 4. 寻找环形链表的入环点
 *      快指针每次走两步，慢指针每次走一步，首先获得相遇节点，然后将快指针置为链表头，每次走一步，
 *      快慢指针再次相遇点，即为环入口。
 */
public class lc287 {
    public int findDuplicate(int[] nums) {
        int len = nums.length;
        if(len == 1) return nums[0];
        if(nums[0] == nums[1]) {
            return nums[0];
        }
        int fast = 0, slow = 0;
        while(true) {
            fast = nums[nums[fast]]; // two step
            slow = nums[slow]; // one step
            if(slow == fast) {
                fast = 0;
                while(nums[slow] != nums[fast]) {
                    fast = nums[fast];
                    slow = nums[slow];
                }
                return nums[slow];
            }
        }
    }
}
