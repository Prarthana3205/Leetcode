// 2. Add two numbers
// https://leetcode.com/problems/add-two-numbers/


 //Definition for singly-linked list.
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
 
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int s=0,c=0;
        ListNode prev=null;
        ListNode head=null;
        while(l1!=null || l2!=null || c!=0)
        {
            if(l1!=null)
            {
                s+=l1.val;
                l1=l1.next;
            }
            if(l2!=null)
            {
                s+=l2.val;
                l2=l2.next;
            }

            ListNode node=new ListNode(s%10);
            if(prev==null)
                head=node; 
            else
                prev.next=node;
            prev=node;

            c=s/10;
            s=c;
        }
        return head;        
    }
}