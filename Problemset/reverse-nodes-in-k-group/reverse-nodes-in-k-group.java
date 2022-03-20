
// @Title: K 个一组翻转链表 (Reverse Nodes in k-Group)
// @Author: luffyyy@vip.qq.com
// @Date: 2022-03-20 19:25:36
// @Runtime: 0 ms
// @Memory: 40.4 MB

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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = head;
        ListNode end = getKGroupEnd(start, k);
        if (end == null) {
            return head;
        }
        head = end;
        reverse(start, end);
        ListNode nextHead = start.next;
        while (nextHead != null) {
            end = getKGroupEnd(nextHead, k);
            if (end == null) {
                return head;
            }
            reverse(nextHead,end);
            start.next = end;
            start = nextHead;
            nextHead = nextHead.next;
        }
        return head;
    }

    /**
    * 反转从 start 到 end 的一段链表
    */
    public void reverse(ListNode start, ListNode end) {
        end = end.next;
        ListNode pre = null;
        ListNode cur = start;
        ListNode next = null;
        while (cur != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        start.next = end;
    }

    /**
    * 获取从 start 开始，第 k 个节点，若不够 k 个，返回 null
    */
    public ListNode getKGroupEnd(ListNode start, int k) {
        while (--k != 0 && start != null) {
            start = start.next;
        }
        return start;
    }
}
