// 295. Find Median from Data Stream
// https://leetcode.com/problems/find-median-from-data-stream/

// BRAINROT Q
import java.util.PriorityQueue;

class MedianFinder {

    PriorityQueue<Integer> minheap; 
    PriorityQueue<Integer> maxheap;

    public MedianFinder() {
        minheap=new PriorityQueue<>(
        (a,b)->a-b
    ); // Second Half

    maxheap=new PriorityQueue<>(
        (a,b)->b-a
    ); // First Half 
    }
    
    public void addNum(int num) {
        maxheap.offer(num);
        minheap.offer(maxheap.poll()); // To ensure maxheap stores elemnts less than all the elements in 2nd half

        // To balance
        if(minheap.size()>maxheap.size()+1)
            maxheap.offer(minheap.poll());
    }
    
    public double findMedian() {
        if(maxheap.size()==minheap.size())
            return ((double)maxheap.peek()+(double)minheap.peek())/2.0;
        else
            return minheap.peek();        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */