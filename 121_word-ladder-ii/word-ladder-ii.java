/*
@Copyright:LintCode
@Author:   HeliWang
@Problem:  http://www.lintcode.com/problem/word-ladder-ii
@Language: Java
@Datetime: 17-02-21 00:52
*/

public class Solution {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return a list of lists of string
      */
      Map<String, List<String>> routes;
      
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        // write your code here  
        List<List<String>> results = new ArrayList<>();
        
        if (end.equals(start)) {
            return results;
        }
        
        routes = new HashMap<String, List<String>>();
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
               // System.out.println ("For node - " + node);
                for (String m : neighbours) {
                  //  System.out.println ("Find " + m);

                    if (level < routesLength.get(m)) {
                         routes.put(m, new ArrayList<String>());
                    }
                    if (level <= routesLength.get(m)) {
                            routesLength.put(m, level); //map是put不是set！
                            if (!routes.get(m).contains(node)) {
                                 routes.get(m).add(node);
                                 queue.offer(m);
                            }
                    }
                }
            }
        }
        List<String> result = new ArrayList<String>();
        result.add(start);
        helper(start, end, dict, result, results);
        // DFS from start to end
        return results;
        //return routesLength.get(start) == Integer.MAX_VALUE ? 0 : routesLength.get(start);
    }
    
    void helper(String start, String end, Set<String> dict,
                List<String> result, List<List<String>> results) {
        if (start.equals(end)) { //Java.lang.Object.equals() 
            results.add(new ArrayList <String> (result));
        } else {
           // System.out.println("For " + start);

            for (String m : routes.get(start)) {
                //System.out.print(" " + m);
                result.add(m);
                helper (m, end, dict, result, results);
                result.remove(result.size() - 1);
            }
        }
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