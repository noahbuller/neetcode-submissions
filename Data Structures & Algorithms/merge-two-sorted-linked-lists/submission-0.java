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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }else if(list2 == null){
            return list1;
        }
        ListNode dummyHead = minNode(list1, list2);
        ListNode curr = new ListNode();
        while(list1 != null && list2 != null){
            curr.next = minNode(list1, list2);
            curr = curr.next;
            if(curr.equals(list1)){
                list1 = list1.next;
            }else{
                list2 = list2.next;
            }
        }
        if(list1 == null && list2 != null){
            while(list2 != null){
                curr.next = list2;
                list2 = list2.next;
                curr = curr.next;
            }
        }else if(list2 == null && list1!= null){
            curr.next = list1;
            list1 = list1.next;
            curr = curr.next;
        }
        return dummyHead;
    }
    public ListNode minNode(ListNode a, ListNode b){
        return a.val > b.val ? b : a;
    }
}