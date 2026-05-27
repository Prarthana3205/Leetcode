// 460. LFU Cache 
// https://leetcode.com/problems/lfu-cache/

struct DLL
{
    int key;
    int value;
    int freq;
    struct DLL* next;
    struct DLL* prev;
};

struct FreqList
{
    // freq = 1 : [head] 7 <-> 8 <-> 9 [tail]
    // freq = 2 : [head] 3 <-> 6 [tail]

    int freq;
    struct DLL* head;
    struct DLL* tail;
    struct FreqList* next;
    struct FreqList* prev;
};

struct KeyHash // hash -> DLL node
{
    UT_hash_handle hh;
    struct DLL* node;
    int key;
};

struct FreqHash // freq -> list
{
    UT_hash_handle hh;
    struct FreqList* list;
    int freq;
};

typedef struct {
    int capacity;
    int size;
    int minFreq; // to know which list of min freq to refer
    struct DLL* head;
    struct DLL* tail;
    struct KeyHash* KeyTable;
    struct FreqHash* FreqTable;
} LFUCache;

struct FreqList* createFreqList(int freq)
{
    struct FreqList* new=malloc(sizeof(struct FreqList));
    new->freq=freq;
    new->head=new->tail=NULL;
    new->next=new->prev=NULL;
    return new;
}

struct FreqList* getFreqList(LFUCache* obj,int freq)
{
    struct FreqHash* fh;
    HASH_FIND_INT(obj->FreqTable,&freq,fh);
    if(!fh)
    {
        fh=(struct FreqHash*)malloc(sizeof(struct FreqHash));
        fh->freq=freq;
        fh->list=createFreqList(freq);
        HASH_ADD_INT(obj->FreqTable,freq,fh);
    }
    return fh->list;
}

void removenode(struct FreqList* list,struct DLL* n)
{
    if(!n->prev) list->head=n->next; // is n head?
    else n->prev->next=n->next;

    if(!n->next) list->tail=n->prev; // is n tail?
    else n->next->prev=n->prev;

    n->next=n->prev=NULL;
}

void inserttohead(struct FreqList* newlist,struct DLL* n)
{
    n->next=newlist->head;
    if(newlist->head) newlist->head->prev=n;
    newlist->head=n;
    if(!newlist->tail) newlist->tail=n;
}

void increasefreq(LFUCache* obj,struct DLL* temp)
{
    int oldfreq=temp->freq;
    struct FreqList* oldlist=getFreqList(obj,oldfreq);
    removenode(oldlist,temp);

    // to handle
    // freq=1 : []
    // freq=2 : [A, B, C]
    // minFreq = 1   (but this is WRONG!)
    if(!oldlist->head && obj->minFreq==oldfreq) obj->minFreq+=1;
    temp->freq+=1;
    struct FreqList* newlist=getFreqList(obj,temp->freq);
    inserttohead(newlist,temp);
}

LFUCache* lFUCacheCreate(int capacity) {
    // Initialisation
    LFUCache* obj=(LFUCache*)malloc(sizeof(LFUCache));
    obj->capacity=capacity;
    obj->size=0;
    obj->minFreq=0;
    obj->head=obj->tail=NULL;
    obj->KeyTable=NULL;
    obj->FreqTable=NULL;
    return obj;
}

int lFUCacheGet(LFUCache* obj, int key) {
    if(obj->capacity==0) return -1;
    struct KeyHash* kh;
    HASH_FIND_INT(obj->KeyTable,&key,kh);
    if(!kh) return -1;
    increasefreq(obj,kh->node);
    return(kh->node->value);
}

void lFUCachePut(LFUCache* obj, int key, int value) {
    if(obj->capacity==0) return;
    struct KeyHash* kh;
    HASH_FIND_INT(obj->KeyTable,&key,kh);
    if(kh)
    {
        kh->node->value=value;
        increasefreq(obj,kh->node);
        return;
    }
    if(obj->size==obj->capacity) // finding out whether the cache is already full 
    {
        struct FreqHash* fh;
        HASH_FIND_INT(obj->FreqTable,&obj->minFreq,fh);
        struct DLL* evict=fh->list->tail;
        removenode(fh->list,evict);
        HASH_FIND_INT(obj->KeyTable,&evict->key,kh);
        HASH_DEL(obj->KeyTable,kh);
        free(evict);
        free(kh);
        obj->size--;
    }
    struct DLL* new=(struct DLL* )malloc(sizeof(struct DLL));
    new->key=key;
    new->value=value;
    new->freq=1;
    new->next=new->prev=NULL;

    struct FreqHash* fh2;
    struct FreqList* newlist=getFreqList(obj,1); //to avoid seg fault
    inserttohead(newlist,new);

    struct KeyHash* kh2=(struct KeyHash*)malloc(sizeof(struct KeyHash));
    kh2->node=new;
    kh2->key=key;
    HASH_ADD_INT(obj->KeyTable,key,kh2);

    obj->minFreq=1;
    obj->size++;
}

void lFUCacheFree(LFUCache* obj) {
    struct KeyHash* kh,*khtemp;
    HASH_ITER(hh,obj->KeyTable,kh,khtemp)
    {
        free(kh->node);
        HASH_DEL(obj->KeyTable,kh);
        free(kh);
    }

    struct FreqHash* fh,*fhtemp;
    HASH_ITER(hh,obj->FreqTable,fh,fhtemp)
    {
        free(fh->list);
        HASH_DEL(obj->FreqTable,fh);
        free(fh);
    }
    free(obj);  
}

/**
 * Your LFUCache struct will be instantiated and called as such:
 * LFUCache* obj = lFUCacheCreate(capacity);
 * int param_1 = lFUCacheGet(obj, key);
 
 * lFUCachePut(obj, key, value);
 
 * lFUCacheFree(obj);
*/
