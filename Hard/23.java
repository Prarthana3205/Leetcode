// 23. Merge K Sorted Lists
// https://leetcode.com/problems/merge-k-sorted-lists/

// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.List;
import java.util.PriorityQueue;

// Definition for singly-linked list.
class ListNode
{
      int val;
      ListNode next;
      ListNode(int val) { this.val = val; }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        // Brute Force Approach O(nlogn)
        // List<Integer> ans=new ArrayList<>();
        // for(int i=0;i<lists.length;i++)
        // {
        //     ListNode curr=lists[i];
        //     while(curr!=null)
        //     {
        //         ans.add(curr.val);
        //         curr=curr.next;
        //     }
        // }

        // Collections.sort(ans);
        // ListNode head=null,temp=null;
        // for(int i:ans)
        // {
        //     ListNode node=new ListNode(i);
        //     if(head==null)
        //         head=temp=node;
        //     else
        //     {
        //         temp.next=node;
        //         temp=temp.next;
        //     }
        // }
        // return head;


        // Optimal Solution using MinHeap O(nlogn)
        PriorityQueue<Integer> minheap=new PriorityQueue<>();
        for(ListNode list:lists)
        {
            while(list!=null)
            {
                minheap.add(list.val);
                list=list.next;
            }
        }

        ListNode dummy=new ListNode(1);
        ListNode node=dummy;
        while(!minheap.isEmpty())
        {
            ListNode newnode=new ListNode(minheap.remove());
            node.next=newnode;
            node=node.next;
        }
        return dummy.next;
    }
}