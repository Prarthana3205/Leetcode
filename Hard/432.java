/*
432. All O`one Data Structure
https://leetcode.com/problems/all-oone-data-structure/description/

We require one HashMap to store the key and its corresponding bucket 
and a doubly linked list of buckets to store the keys with same frequency. 
Each bucket will have a HashSet of keys with same frequency.
*/

import java.util.HashMap;
import java.util.HashSet;
class AllOne {
    class Bucket
    {
        int freq;
        HashSet<String> keys;
        Bucket next;
        Bucket prev;
        Bucket(int freq)
        {
            this.freq=freq;
            keys=new HashSet<>();
        }
    }

    void insert(Bucket prevb,Bucket newb)
    {
        newb.next=prevb.next;
        newb.next.prev=newb;
        newb.prev=prevb;
        prevb.next=newb;
    }
    
    void remove(Bucket newb)
    {
        newb.prev.next=newb.next;
        newb.next.prev=newb.prev;
        newb.prev=newb.next=null;
    }

    HashMap<String,Bucket> map;
    Bucket head;
    Bucket tail;

    public AllOne() { // Initialization
        map=new HashMap<>();
        head=new Bucket(-1);
        tail=new Bucket(-1);
        head.next=tail;
        tail.prev=head;
        head.prev=tail.next=null;
    }
    
    public void inc(String key) {
        // Case 1: key does not exist (add the key to the bucket with frequency 1) 
        if(!map.containsKey(key))
        {
            // Check if bucket exists else create a new one
            Bucket b=head.next;
            if(b.freq==1)
            {
                b.keys.add(key);
                map.put(key,b);
            }
            else
            {
                Bucket newb=new Bucket(1);
                insert(head,newb);
                newb.keys.add(key);
                map.put(key,newb);
            }
        }
        // Case 2: key exists
        // remove the key from the current bucket and add it to the next bucket (create a new bucket if it does not exist)
        else
        {
            Bucket oldb=map.get(key);
            Bucket newbucket=oldb.next;
            int oldfreq=oldb.freq;
            if(newbucket==tail || newbucket.freq!=oldfreq+1) // if next bucket where key needs to be added exist or not
            {
                newbucket=new Bucket(oldfreq+1);
                insert(oldb,newbucket);
            }
            oldb.keys.remove(key);
            newbucket.keys.add(key);

            if(oldb.keys.isEmpty())
                remove(oldb);
            
            map.put(key,newbucket);
        }        
    }
    
    public void dec(String key) {
        Bucket current=map.get(key); // current will not be null as per the q
        int newfreq=current.freq-1;
        Bucket prevbucket=current.prev;

        if(newfreq==0)
        {
            current.keys.remove(key);
            if(current.keys.isEmpty())
                remove(current);
            map.remove(key);
            return;
        }

        if(prevbucket==head || prevbucket.freq!=newfreq) // checking if bucket where the key needs to added exists or not
        {
            Bucket newbucket=new Bucket(newfreq);
            insert(prevbucket,newbucket);
            newbucket.keys.add(key);
            map.put(key,newbucket);
        }
        else
        {
            prevbucket.keys.add(key);
            map.put(key,prevbucket);
        }

        current.keys.remove(key);
        if(current.keys.isEmpty())
            remove(current);  
    }
    
    public String getMaxKey() {
        if(head.next==tail)
            return "";
        return tail.prev.keys.iterator().next();
        
    }
    
    public String getMinKey() {
        if(head.next==tail)
            return "";
        return head.next.keys.iterator().next();
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */

/* 
// Extremely complicated solution I came up with (5/25 test cases passed)
import java.util.HashMap;
class AllOne {

    // DLL
    class Node
    {
        String str;
        int freq;
        Node prev;
        Node next;
        Node(String str,int freq)
        {
            this.freq=freq;
            this.str=str;
        }
    }

    class DLL
    {
        Node head;
        Node tail;
        DLL()
        {
            // dummy head and tail nodes
            this.head=new Node("",-1);
            this.tail=new Node("",-1);

            // head <-> tail
            head.next=tail;
            tail.prev=head;
        }

        void insertnode(Node n)
        {
            n.prev=head;
            head.next.prev=n;
            n.next=head.next;
            head.next=n;
        }

        void removenode(Node n)
        {
            n.prev.next=n.next;
            n.next.prev=n.prev;
            n.prev=n.next=null;
        }
    }

    HashMap<String,Node> map;
    HashMap<Integer,DLL> freqmap;
    int minfreq=0,maxfreq=0;

    public AllOne() {
        map=new HashMap<>();
        freqmap=new HashMap<>();
    }
    
    public void inc(String key) {
        Node n=map.getOrDefault(key,new Node(key,1));
        
        if(map.containsKey(key))
        {
            int oldfreq=n.freq;
            DLL oldDLL=freqmap.get(oldfreq);
            oldDLL.removenode(n); // Remove the node from old DLL
            if(oldDLL.head.next==oldDLL.tail)
            {
                freqmap.remove(oldfreq);
                if(oldfreq==minfreq)
                    minfreq++;  
            }       

            DLL newDLL=freqmap.getOrDefault(++n.freq,new DLL());
            newDLL.insertnode(n); 
            freqmap.put(n.freq,newDLL);
        }

        else
        {
            map.put(key,n);
            minfreq=1;
            DLL freqDLL=freqmap.getOrDefault(1,new DLL());
            freqDLL.insertnode(n);
            freqmap.put(1,freqDLL);   
        } 
        maxfreq=Math.max(maxfreq,n.freq);
    }
    
    public void dec(String key) {
        Node n=map.get(key);
        int oldfreq=n.freq;
        DLL oldDLL=freqmap.get(oldfreq);
        oldDLL.removenode(n);

        if(oldfreq==1)
        {
            map.remove(key);
            if(oldDLL.head.next==oldDLL.tail)
                freqmap.remove(oldfreq);

            if(map.isEmpty())
                minfreq=maxfreq=0;

            else
            {
                minfreq++;
                while (!freqmap.containsKey(minfreq)) 
                    minfreq++;
            }
            return;
        }

        n.freq--;
        if (oldDLL.head.next==oldDLL.tail) 
            freqmap.remove(oldfreq);

        if (oldfreq == maxfreq)
        {
            maxfreq--;
            while (maxfreq > 0 && !freqmap.containsKey(maxfreq))
                maxfreq--;

        }

        DLL newDLL=freqmap.getOrDefault(n.freq,new DLL());
        newDLL.insertnode(n);
        freqmap.put(n.freq,newDLL);
        minfreq=Math.min(minfreq,n.freq);
    }
    
    public String getMaxKey() {
        if(maxfreq==0)
            return "";
        DLL newDLL=freqmap.get(maxfreq);
        return newDLL.head.next.str;
    }
    
    public String getMinKey() {
        if(minfreq==0)
            return "";
        DLL newDLL=freqmap.get(minfreq);
        return newDLL.head.next.str; 
    }
}
*/

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */