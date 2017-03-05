/*
@Copyright:LintCode
@Author:   HeliWang
@Problem:  http://www.lintcode.com/problem/first-bad-version
@Language: Java
@Datetime: 17-01-28 21:30
*/

/**
 * public class SVNRepo {
 *     public static boolean isBadVersion(int k);
 * }
 * you can use SVNRepo.isBadVersion(k) to judge whether 
 * the kth code version is bad or not.
*/
class Solution {
    /**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        // write your code here
        int start = 1, end = n;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (SVNRepo.isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (SVNRepo.isBadVersion(start)) {
            return start;
        } else if (SVNRepo.isBadVersion(end)) {
            return end;
        } else {
            return 0;
        }
        
    }
}
