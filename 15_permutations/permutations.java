/*
@Copyright:LintCode
@Author:   HeliWang
@Problem:  http://www.lintcode.com/problem/permutations
@Language: Java
@Datetime: 17-02-20 16:42
*/

class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (nums == null) return results; 
        if (nums.length == 0) { results.add(new ArrayList<Integer>()); return results;}
        helper (nums, new ArrayList<Integer>(), results);
        return results;
    }
    
    void helper (int[] nums, List<Integer> result, List<List <Integer>> results) {
        if (result.size() == nums.length) {
            results.add(new ArrayList<Integer>(result));
        } else {
            for (int m : nums) {
                if (!result.contains(m)) {
                    result.add(m);
                    helper(nums, result, results);
                    result.remove(result.size()-1);
                }
            }
        }
    }
}
