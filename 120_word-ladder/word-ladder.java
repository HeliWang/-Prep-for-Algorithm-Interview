/*
@Copyright:LintCode
@Author:   HeliWang
@Problem:  http://www.lintcode.com/problem/word-ladder
@Language: Java
@Datetime: 17-02-20 23:57
*/

public class Solution {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return a list of lists of string
      */
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here  
        if (start.equals(end)) {
            return 1;
        }
        
        Map<String, List<String>> routes = new HashMap<String, List<String>>();
        Map<String, Integer> routesLength = new HashMap<String, Integer>();
        int level = 1;
        dict.add(start);
        dict.add(end);
        for (String m : dict) {
            routes.put(m, new ArrayList<String>());
            routesLength.put(m, Integer.MAX_VALUE);
        }
        
        // BFS from end to start
        Queue<String> queue = new LinkedList<String>();
        Set<String> hash = new HashSet<>();
        queue.offer(end);
        hash.add(end);
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            level ++;
            for (int i = 0; i < queueSize; i++) {
                String node = queue.poll();
                List<String> neighbours = expand(node, dict);
                for (String m : neighbours) {
                    if (level <= routesLength.get(m)) {
                        if (hash.contains(m)) {
                            continue;
                        } else {
                            routesLength.put(m, level); //map是put不是set！
                            routes.get(m).add(node);
                            queue.offer(m);
                            hash.add(m);
                        }
                    }
                }
            }
        }
        return routesLength.get(start);
    }
    
    List<String> expand(String crt, Set<String> dict) {
        List<String> expansion = new ArrayList<String>();

        for (int i = 0; i < crt.length(); i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch != crt.charAt(i)) {
                    String expanded = crt.substring(0, i) + ch
                            + crt.substring(i + 1);
                    if (dict.contains(expanded)) {
                        expansion.add(expanded);
                    }
                }
            }
        }
        return expansion;
    }
}