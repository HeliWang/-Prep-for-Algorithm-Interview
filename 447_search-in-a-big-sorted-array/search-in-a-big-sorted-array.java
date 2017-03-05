/*
@Copyright:LintCode
@Author:   HeliWang
@Problem:  http://www.lintcode.com/problem/search-in-a-big-sorted-array
@Language: Java
@Datetime: 17-01-29 04:37
*/

/**
 * Definition of ArrayReader:
 * 
 * class ArrayReader {
 *      // get the number at index, return -1 if index is less than zero.
 *      public int get(int index);
 * }
 */
public class Solution {
    /**
     * @param reader: An instance of ArrayReader.
     * @param target: An integer
     * @return : An integer which is the index of the target number
     */
    public int searchBigSortedArray(ArrayReader reader, int target) {
        // write your code here
        int start = 0;
        int end   = 1;
        while (reader.get(end) < target) {
            start = end;
            end *= 2;
        }
        return binarySearch(reader, target, start, end);
    }
    
    public int binarySearch(ArrayReader reader, int target, int start, int end) {

        while (start + 1 < end) {
            int mid = start + (end - start) / 2; // avoid end and start both too large
            if (reader.get(mid) == target) {
                end = mid; 
                //!!! not return target, because may not the last position
            }
            if (reader.get(mid) < target) {
                start = mid;
            } else if (reader.get(mid) > target) {
                end = mid;
            }
        }
        if (reader.get(start) == target) {
            return start;
        }
        if (reader.get(end) == target) {
            return end;
        }
        return -1;
    }
}