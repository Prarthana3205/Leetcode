// 146. LRU Cache 
// https://leetcode.com/problems/lru-cache/
// VERY IMPORTANT PROBLEM !!!
// in c we have to implement our own hash map using uthash library that comes under #include <uthash.h>

struct DLL // Doubly linked list to track most recently (MRU) used and LRU
{
    int key;
    int value;
    struct DLL * prev;
    struct DLL * next;
};

struct HashNode
{
    int key;
    struct DLL * node;
    UT_hash_handle hh; // required by uthash function for hash map table 
};

typedef struct {
    int capacity; // Max number of nodes
    int size; // keeps current count of the nodes
    struct DLL * head; // MRU (most recently used)
    struct DLL * tail; // LRU (least recently used)
    struct HashNode * cache; // HashTable storing key and the pointer
} LRUCache;

void addtohead(LRUCache* obj, struct DLL* node)
{
    node->prev=NULL;
    node->next=obj->head;
    if(obj->head) obj->head->prev=node;
    obj->head=node;
    if(!obj->tail) obj->tail=node; // What if there is node is the first node
}

void movetohead(LRUCache* obj,struct DLL* node)
{
    if(obj->head==node) return;

    //Unlink the node from the DLL
    if(node->prev) node->prev->next=node->next;
    if(node->next) node->next->prev=node->prev;

    // If the node is tail , change tail
    if(obj->tail==node) obj->tail=node->prev;
    addtohead(obj,node);
}

struct DLL* removetail(LRUCache* obj)
{
    struct DLL* removed=obj->tail;
    if(!removed) return NULL;
    if(removed->prev) removed->prev->next=NULL;
    obj->tail=removed->prev;
    removed->prev=NULL;
    if(!obj->tail) obj->head=NULL;
    return removed;
}

// Create DLL node
struct DLL* createNode(int key,int value)
{
    struct DLL* node=(struct DLL*)malloc(sizeof(struct DLL));
    node->key=key;
    node->value=value;
    node->prev=node->next=NULL;
    return node;
}

LRUCache* lRUCacheCreate(int capacity) {
    // Initialisation
    LRUCache* obj=(LRUCache*)malloc(sizeof(LRUCache));
    obj->capacity=capacity;
    obj->size=0;
    obj->head=obj->tail=NULL;
    obj->cache=NULL;
    return obj;
}

int lRUCacheGet(LRUCache* obj, int key) {
    struct HashNode* temp;
    HASH_FIND_INT(obj->cache,&key,temp); // row found from hash table stored in temp
    if(!temp) return -1;
    movetohead(obj,temp->node); // need to change the order of DLL 
    // row found ,node needs to be head of DLL now
    return temp->node->value; 
}

void lRUCachePut(LRUCache* obj, int key, int value) {
    struct HashNode* find;
    HASH_FIND_INT(obj->cache,&key,find);
    if(find)
    {
        find->node->value=value;
        movetohead(obj,find->node);
    }
    else
    {
        struct DLL* newnode=createNode(key,value);
        addtohead(obj,newnode);
        struct HashNode* newhash=(struct HashNode* )malloc(sizeof(struct HashNode));
        newhash->key=key;
        newhash->node=newnode;
        HASH_ADD_INT(obj->cache,key,newhash);
        obj->size++;
        if(obj->size>obj->capacity) // Need to implement LRU policy (evict a node)
        {
            struct DLL* removed=removetail(obj);
            HASH_FIND_INT(obj->cache,&removed->key,find);
            if(find)
            {
                HASH_DEL(obj->cache,find);
                free(find);
            }
            free(removed);
            obj->size--;
        }
    }  
}

void lRUCacheFree(LRUCache* obj) {
    struct DLL* curr=obj->head;
    while(curr)
    {
        struct DLL* temp=curr;
        curr=curr->next;
        free(temp);
    }

    struct HashNode* start,* temp2;
    HASH_ITER(hh,obj->cache,start,temp2) 
    // HASH_ITER(hash_handle, head, current, temp for safe deletion)
    HASH_DEL(obj->cache,start);
    free(start);
    free(obj);   
}

/**
 * Your LRUCache struct will be instantiated and called as such:
 * LRUCache* obj = lRUCacheCreate(capacity);
 * int param_1 = lRUCacheGet(obj, key);
 
 * lRUCachePut(obj, key, value);
 
 * lRUCacheFree(obj);
*/