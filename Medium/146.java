// 146. LRU Cache
// https://leetcode.com/problems/lru-cache/

// Maintain a HashMap for easy lookup and DLL for MRU and LRU

import java.util.HashMap;

class LRUCache {

    class Node // Doubly linked list to maintain MRU(head) LRU(tail)
    {
        int key;
        int value;

        Node prev;
        Node next;

        Node(int key,int value)
        {
            this.key=key;
            this.value=value;
        }
    }

    int capacity;
    HashMap<Integer,Node> map;
    Node head,tail;

    public LRUCache(int capacity) { // Initialisation of all the data structures
        this.capacity=capacity;
        map=new HashMap<>();

        // dummy head and tail nodes to avoid edge cases
        head=new Node(0,0);
        tail=new Node(0,0);

        // head <-> tail
        head.next=tail; 
        tail.prev=head;
    }

    void remove(Node n)
    {
        n.prev.next=n.next;
        n.next.prev=n.prev;
    }

    void insert(Node node)
    {
        node.prev=head;
        node.next=head.next;
        head.next.prev=node;
        head.next=node;
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
            return -1;

        Node newnode=map.get(key);
        remove(newnode);
        insert(newnode);
        return newnode.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key))
        {
            Node n=map.get(key);
            n.value=value;

            // becomes most recently used node
            remove(n);
            insert(n);
        }
        else
        {
            if(map.size()==capacity)
            {
                Node rem=tail.prev;
                remove(rem);
                map.remove(rem.key);
            }
            Node n=new Node(key,value);
            map.put(key,n);
            insert(n);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */