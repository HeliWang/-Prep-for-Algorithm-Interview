/*
@Copyright:LintCode
@Author:   HeliWang
@Problem:  http://www.lintcode.com/problem/strstr
@Language: Java
@Datetime: 17-01-18 23:25
*/

class Solution {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }
        if (target.length() == 0) {
            return 0;
        }
        for (int i = 0; i < source.length() - target.length() + 1; i++){
            for (int j = 0; j < target.length(); j++) {
                if (source.charAt(i + j) != target.charAt(j)) {
        		    break;
        		}
            		if (j == target.length() - 1) {
            		    return i;
            		}
            	}
        }
        return -1;
    }
}