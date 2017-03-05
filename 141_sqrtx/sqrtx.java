/*
@Copyright:LintCode
@Author:   HeliWang
@Problem:  http://www.lintcode.com/problem/sqrtx
@Language: Java
@Datetime: 17-01-29 00:19
*/

class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
       long start = 0, end = x; //!!!!!!!!!LONG!!!!!!!!
       while (start + 1 < end) {
           long mid = start + (end - start) / 2;
           if (mid * mid == x) {
               return (int)mid;
           } else if (mid * mid < x) {
               start = mid;
           } else {
               end = mid;
           }
       }
       if (start * start == x) {
           return (int)start;
       } else if (end * end == x){
           return (int)end;
       } else {
           return (int)start;
       }
    }
}