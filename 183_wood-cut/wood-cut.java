/*
@Copyright:LintCode
@Author:   HeliWang
@Problem:  http://www.lintcode.com/problem/wood-cut
@Language: Java
@Datetime: 17-01-29 05:12
*/

public class Solution {
    /** 
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
    public int woodCut(int[] L, int k) {
        int maxWoodLength = 0;
        for (int i = 0; i < L.length; i++) {
            maxWoodLength = Math.max (L[i], maxWoodLength); //Math.max!!!!
        }
        int start = 1, end = maxWoodLength;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int count = count (L, mid);
            if (count < k) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (count(L, end) >= k) {
            return end;
        } else if (count(L, start) >= k)  {
            return start;
        } else {
            return 0;
        }
    }
    
    private int count (int[] L, int maxl) {
        int totalSmallPieces = 0;
        for (int i = 0; i < L.length; i++) {
            totalSmallPieces += (L[i] / maxl);
        }
        return totalSmallPieces;
    }
}