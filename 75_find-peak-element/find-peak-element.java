/*
@Copyright:LintCode
@Author:   HeliWang
@Problem:  http://www.lintcode.com/problem/find-peak-element
@Language: Java
@Datetime: 17-01-28 23:52
*/

class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here
        if (A == null || A.length == 0){
            return -1;
        }
        int start = 0, end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            //if (mid > 0 && mid < A.length - 1){
                if (A[mid - 1] < A[mid] && A[mid + 1] < A[mid]) {
                    return mid;
                } else if (A[mid - 1] < A[mid]) {
                    start = mid;
                } else {
                    end = mid;
                }
            /*} else {
                break;
            }*/
        }
        return -1;
    }
}
