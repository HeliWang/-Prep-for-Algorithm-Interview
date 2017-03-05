/*
@Copyright:LintCode
@Author:   HeliWang
@Problem:  http://www.lintcode.com/problem/word-break-ii
@Language: Java
@Datetime: 17-02-20 22:20
*/

public class Solution {
    /**
     * @param s a string
     * @param wordDict a set of words
     */
     // 最不优化版！
    public List<String> wordBreak(String s, Set<String> wordDict) {
        // Write your code here
        List<String> results = new ArrayList<String>();
        if (s == null || s.length() == 0 || wordDict.size() == 0) {
            return results;
        }
        // Prepare a dict as a substitution to wordDict.contains(substr);
        
        boolean[][] isWord = new boolean[s.length()][s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String word = s.substring(i, j + 1);
                isWord[i][j] = wordDict.contains(word);
            }
        }
        
        boolean[] possible = new boolean[s.length() + 1];
        possible[s.length()] = true;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (isWord[i][j] && possible[j + 1]) {
                    possible[i] = true;
                    break;
                }
            }
        }
        
        helper(s, wordDict, 0, "", results, isWord, possible);
        return results;
    }
    
    void helper(String s, Set<String> wordDict, int start, String result, List<String> results,  boolean[][] isWord, boolean[] possible) {
        if (start == s.length()) {
            results.add(result);
        } else if (!possible[start]) {
            return;
        } else  {
            for (int i = start; i < s.length(); i++) {
                String substr = s.substring(start, i+1);
                
                /*
                String substring(int beginIndex, int endIndex): Returns the substring starting from the given index(beginIndex) till the specified index(endIndex). For e.g. "Chaitanya".substring(2,5) would return "ait". It throws IndexOutOfBoundsException If the beginIndex is less than zero OR beginIndex > endIndex OR endIndex is greater than the length of String
                */
                //if (wordDict.contains(substr)) {
                if ( isWord[start][i] ) { //错误写法isWord(, ) 或者isWord[ , ]
                    int originalSize = result.length();
                    if (result.length() != 0) result += " ";
                    result += substr;
                    helper (s, wordDict, i+1, result, results, isWord, possible);
                    result = result.substring(0, originalSize);
                }
            }
        }
    }
}