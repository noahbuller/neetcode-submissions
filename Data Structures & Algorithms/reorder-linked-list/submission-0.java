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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //now slow points to the middle of the list
        //we need to reverse the list from slow onwards
        ListNode second = slow.next;
        slow.next = null;
        ListNode reverseHead = reverseList(second);
        while(head != null && reverseHead != null ){
            ListNode normalTemp = head.next;
            ListNode reverseTemp = reverseHead.next;
            head.next = reverseHead;
            reverseHead.next = normalTemp;
            reverseHead = reverseTemp;
            head = normalTemp;
        }
    }
    /** [2,8,4,6]

    head = 2
    reverseHead = 8
    normalTemp = 4
    reverseTemp = 6
    **/

    public ListNode reverseList(ListNode head){
        ListNode prev = null;   
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
