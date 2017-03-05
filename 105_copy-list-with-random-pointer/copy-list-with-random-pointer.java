/*
@Copyright:LintCode
@Author:   HeliWang
@Problem:  http://www.lintcode.com/problem/copy-list-with-random-pointer
@Language: Java
@Datetime: 17-03-05 00:13
*/

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        while (head == null) {
            return null;
        }
        
        RandomListNode dummy = new RandomListNode(0);
        dummy.next = head;
        head = dummy;
        
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        
        while (head != null) {
            RandomListNode preNext = head.next;
            if (preNext != null) {
                if (!map.containsKey(preNext)) {
                    RandomListNode newNode = new RandomListNode(preNext.label);
                    newNode.next = preNext.next;
                    newNode.random = preNext.random;
                    map.put(preNext, newNode);
                }
                head.next = map.get(preNext);
            }

            RandomListNode preRamdom = head.random;
            if (preRamdom != null) {
                if (!map.containsKey(preRamdom)) {
                    RandomListNode newNode = new RandomListNode(preRamdom.label);
                    newNode.next = preRamdom.next;
                    newNode.random = preRamdom.random;
                    map.put(preRamdom, newNode);
                }
                head.random = map.get(preRamdom);
            }
            head = head.next;
        }
        
        return dummy.next;
    }
}