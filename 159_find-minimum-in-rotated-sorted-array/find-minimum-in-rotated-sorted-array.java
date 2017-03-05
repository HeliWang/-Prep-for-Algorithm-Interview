/*
@Copyright:LintCode
@Author:   HeliWang
@Problem:  http://www.lintcode.com/problem/find-minimum-in-rotated-sorted-array
@Language: Java
@Datetime: 17-01-28 22:31
*/

public class Solution {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0, end = nums.length - 1;
        int target = nums[end];
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start; 
            if (nums [mid] > target) {
                start = mid;   
            } else {
                end = mid;
            }
        }
        if (nums[start] < nums[end]) {
            return nums[start];
        } else {
            return nums[end];
        }
    }
}