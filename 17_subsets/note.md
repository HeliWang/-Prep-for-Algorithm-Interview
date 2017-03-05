```
@Copyright:LintCode
@Author:   HeliWang
@Problem:  http://www.lintcode.com/problem/subsets
@Language: Markdown
@Datetime: 17-01-19 02:30
```

class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
     
    /* Search Related Question: Start with {}
    add some numbers and remove some numbers DFS
    先画递归树！*/
    
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        //学习怎么创建新ArrayList!!
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return results;
        }
        //有序，先sort，有无皆可
        Arrays.sort(nums);
        dfsHelper(nums, 0, new ArrayList<Integer>(), results);
        return results;
    }
    
    /*
    nums,
    subset - forming a result
    startIndex - avoid repetition
    results - store all subsets as results
    
    How to analyze a recursion:
    递归的定义：把所有以subset开头的集合都丢到results
   （所有集合都以empty开头，所有字符串都以""开头）
    递归的拆解：怎么链接下一次，怎么擦屁股回复之前状态
    递归的出口: ..
    */
    private void dfsHelper(int[] nums,
                           int startIndex,
                           ArrayList<Integer> subset,
                           ArrayList<ArrayList<Integer>> results) {
        //首先要把empty这个subset扔到results里面
        //Clone, 一定要DEEP COPY!!! 否则丢的是reference
        results.add(new ArrayList<Integer>(subset));
        for (int i = startIndex; i < nums.length; i++){
            subset.add(nums[i]);
            dfsHelper(nums, i + 1, subset, results);
            subset.remove(subset.size() - 1); //擦屁股步骤
        }
    }
}