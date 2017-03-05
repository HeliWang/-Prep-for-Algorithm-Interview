/*
@Copyright:LintCode
@Author:   HeliWang
@Problem:  http://www.lintcode.com/problem/copy-books
@Language: Java
@Datetime: 17-01-29 05:40
*/

public class Solution {
    /**
     * @param pages: an array of integers
     * @param k: an integer
     * @return: an integer
     */
    
    public int copyBooks(int[] L, int k) {
        int maxBookAssignment = 0;
        int minBookAssignment = 0;
        for (int i = 0; i < L.length; i++) {
            maxBookAssignment += L[i]; //Math.max!!!!
            minBookAssignment = Math.max (L[i], minBookAssignment);
        }
        int start = minBookAssignment, end = maxBookAssignment;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int count = count (L, mid);
            if (count <= k) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (count(L, start) <= k) {
            return start;
        } else if (count(L, end) <= k)  {
            return end;
        } else {
            return 0;
        }
    }
    
    private int count (int[] L, int maxl) {
        int totalPeople = 1;
        int pagePerPep  = 0;
        for (int i = 0; i < L.length; i++) {
            pagePerPep += L[i];
            if (pagePerPep > maxl) {
                totalPeople ++;
                pagePerPep = L[i];
            }
        }
        return totalPeople;
    }
}