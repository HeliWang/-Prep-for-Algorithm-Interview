/*
@Copyright:LintCode
@Author:   HeliWang
@Problem:  http://www.lintcode.com/problem/combination-sum-ii
@Language: Java
@Datetime: 17-02-18 23:10
*/

public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> result = new ArrayList<Integer>();
        if (candidates == null || candidates.length == 0) {
            return results;
        }
        Arrays.sort(candidates);
        helper(candidates, target, 0, result, results);
        return results;
    }
    
    
    void helper(int[] candidates, int target, int start, List<Integer> result, List<List<Integer>> results) {
        if (target == 0) {
            results.add(new ArrayList<Integer> (result));
        } else {
            for (int i = start; i < candidates.length; i++) {
                if (candidates[i] > target) continue;
                if (i > start && candidates[i] == candidates[i-1]) continue;
                result.add(candidates[i]);
                helper(candidates, target - candidates[i], i+1, result, results);
                result.remove(result.size() - 1);
            }
        }
    }
}