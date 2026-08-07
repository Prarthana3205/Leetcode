// 460. LFU Cache 
// https://leetcode.com/problems/lfu-cache/

import java.util.HashMap;

class LFUCache {

    // Node data structure 
    class Node
    {
        int key;
        int value;
        int freq;
        Node next;
        Node prev;

        Node(int key,int value)
        {
            this.key=key;
            this.value=value;
            this.freq=1;
        }
    }

    // Doubly linked list
    class DLL
    {
        Node head;
        Node tail;
        int size;

        DLL()
        {
            this.size=0;

            // Dummy head and tail pointers
            head=new Node(-1,-1);
            tail=new Node(-1,-1);

            head.next=tail;
            tail.prev=head;
            head.prev=tail.next=null;
        }

        // Methods under DLL are remove ,removeLast and add node
        void remove(Node n)
        {
            n.prev.next=n.next;
            n.next.prev=n.prev;
            size--;
        }

        void add(Node n)
        {
            n.next=head.next;
            head.next.prev=n;
            n.prev=head;
            head.next=n;
            size++;
        }

        Node removeLast()
        {
            Node n=tail.prev;
            remove(n);
            return n;
        }
    }

    HashMap<Integer,Node> cache;
    HashMap<Integer,DLL> freqmap; // each frequency has its corresponding DLL
     
    int minfreq;
    int capacity;

    void update(Node n)
    {
        // Need to remove the node from the existing DLL 
        // Increment the frequency and add the node to the new DLL

        int oldfreq=n.freq;
        DLL oldlist=freqmap.get(oldfreq);

        oldlist.remove(n);

        if(oldfreq==minfreq && oldlist.size==0)
            minfreq++;

        n.freq++;
        DLL newlist=freqmap.getOrDefault(n.freq,new DLL());
        newlist.add(n);

        freqmap.put(n.freq,newlist);
    }

    public LFUCache(int capacity) {
        this.capacity=capacity;
        this.minfreq=0;

        cache=new HashMap<>();
        freqmap=new HashMap<>();
    }
    
    public int get(int key) {
        if(!cache.containsKey(key))
            return -1;
        
        Node n=cache.get(key);
        update(n);
        return n.value;        
    }
    
    public void put(int key, int value) {
        if(capacity==0)
            return;
            
        if(cache.containsKey(key))
        {
            Node n=cache.get(key);
            n.value=value;
            update(n);
        }
        else
        {
            Node newnode=new Node(key,value);

            if(cache.size()==capacity)
            {
                DLL removelist=freqmap.get(minfreq);
                Node n=removelist.removeLast();
                cache.remove(n.key);
            }
            DLL newlist=freqmap.getOrDefault(1,new DLL());
            minfreq=1;
            newlist.add(newnode);
            cache.put(key,newnode);
            freqmap.put(1,newlist);
        }        
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */