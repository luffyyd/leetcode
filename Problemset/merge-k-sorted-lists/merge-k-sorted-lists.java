
// @Title: 合并K个升序链表 (Merge k Sorted Lists)
// @Author: luffyyy@vip.qq.com
// @Date: 2022-03-22 19:50:24
// @Runtime: 4 ms
// @Memory: 43.2 MB

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
   public static class ListNodeComparator implements Comparator<ListNode>{
        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val-o2.val;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new ListNodeComparator());
        for (ListNode node : lists) {
            if (node != null){
                heap.add(node);
            }
        }
        if (heap.isEmpty()){
            return null;
        }
        ListNode head = heap.poll();
        ListNode pre = head;
         if (head.next!=null){
            heap.add(head.next);
        }
        while(!heap.isEmpty()){
            ListNode cur = heap.poll();
            pre.next = cur;
            pre = cur;
            if(cur.next!=null){
                heap.add(cur.next);
            }
        }
        return head;
    }
}
