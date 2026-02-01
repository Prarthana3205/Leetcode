// Kth Largest Element in a Stream
// https://leetcode.com/problems/kth-largest-element-in-a-stream

typedef struct {
    int* minheap; // the array
    int size;
    int capacity;
} KthLargest;

void swap(int* a,int* b)
{
    int t=*a;
    *a=*b;
    *b=t;
}

void heapifyup(KthLargest* obj,int ind)
{
    while(ind>0)
    {
        int parent=(ind-1)/2;
        if(obj->minheap[parent]<=obj->minheap[ind])
            return; //satisfies minheap condition 
        swap(&obj->minheap[parent],&obj->minheap[ind]);
        ind=parent;
    }
}

void heapifydown(KthLargest* obj,int ind)
{
    while(1)
    {
        int left= ind*2 +1;
        int right= ind*2 +2;
        int smallest= ind;

        if(left<obj->size && obj->minheap[left]<obj->minheap[smallest])
            smallest=left;
        if(right<obj->size && obj->minheap[right]<obj->minheap[smallest])
            smallest=right;
        if(smallest==ind) break;
        swap(&obj->minheap[smallest],&obj->minheap[ind]);
        ind=smallest;
    }
}

int kthLargestAdd(KthLargest* obj, int val) {
    if(obj->size<obj->capacity) //currently we are keeping size as index
    {
        obj->minheap[obj->size++]=val;
        heapifyup(obj,obj->size-1);
    }
    else if(val>obj->minheap[0])
    {
        obj->minheap[0]=val; // storing only the k largest elements
        heapifydown(obj,0); // so we are ignoring elements smaller than the Kth Largest element stored at index 0 of the heap
    }
    return obj->minheap[0];   
}

KthLargest* kthLargestCreate(int k, int* nums, int numsSize) {
    KthLargest* obj=(KthLargest*)malloc(sizeof(KthLargest));
    obj->size=0;
    obj->capacity=k;
    obj->minheap=(int*)malloc(k*sizeof(int));
    for(int i=0;i<numsSize;i++)
        kthLargestAdd(obj,nums[i]);
    return obj;
}

void kthLargestFree(KthLargest* obj) {
    free(obj->minheap);
    free(obj);
}

/**
 * Your KthLargest struct will be instantiated and called as such:
 * KthLargest* obj = kthLargestCreate(k, nums, numsSize);
 * int param_1 = kthLargestAdd(obj, val);
 
 * kthLargestFree(obj);
*/