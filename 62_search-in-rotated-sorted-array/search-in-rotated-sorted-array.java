/*
@Copyright:LintCode
@Author:   HeliWang
@Problem:  http://www.lintcode.com/problem/search-in-rotated-sorted-array
@Language: Java
@Datetime: 17-01-29 00:05
*/

public class Solution {
    /** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        };
        int start = findMin(nums);
        int end = nums.length - 1;
        
        int result1 = binarySearch(nums, start, end, target);
        
        if (result1 != -1) return result1;
        // Maybe in another part
        start = 0;
        end = findMin(nums);
        
        int result2 = binarySearch(nums, start, end, target);
        if (result2 != -1) {
            return result2; 
        } else {
            return -1;   
        }
    }
    
    public int binarySearch (int[] nums, int start, int end, int target) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2; // avoid end and start both too large
            if (nums[mid] == target) {
                end = mid; 
            }
            if (nums[mid] < target) {
                start = mid;
            } else if (nums[mid] > target) {
                end = mid;
            }
        }
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        
        return -1;
    }
    
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
            return start;
        } else {
            return end;
        }
    }
}
