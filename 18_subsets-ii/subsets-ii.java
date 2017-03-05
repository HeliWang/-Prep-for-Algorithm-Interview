/*
@Copyright:LintCode
@Author:   HeliWang
@Problem:  http://www.lintcode.com/problem/subsets-ii
@Language: Java
@Datetime: 17-02-18 22:25
*/

class Solution {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        if (nums == null  || nums.length == 0) {
            return results;
        }
        Arrays.sort(nums);
        ArrayList<Integer> subset = new ArrayList<>();
        helper(nums, 0, subset, results);
        return results;
    }
    
    // 注意deep copy问题！！！
    // Traverse 更容易想，对于找combination， Divide Conquer的Conquer往往会糊涂
    // 所以用Traverse，把return value变成void, 但一定要deep copy！
    void helper(int[] nums,
                int start,
                ArrayList<Integer> result,
                ArrayList<ArrayList<Integer>> results) {
        results.add(new ArrayList<Integer>(result));
        for (int i = start; i < nums.length; i++) {
            if (i > 0 && i > start && nums[i] == nums[i-1]) continue;
            result.add(nums[i]);
            helper(nums, i + 1, result, results);
            result.remove(result.size() - 1);
        }
    }
}