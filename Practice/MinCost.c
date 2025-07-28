/* Question: 1928. Minimum Cost to Reach Destination in Time
https://leetcode.com/problems/minimum-cost-to-reach-destination-in-time
1st condition : <=maxtime
2nd condition : minimum cost

Approach: Dijkstra's algorithm with a min-heap
min heap to obtain the minimum cost path

NOT SOLVED COMPLETELY

 */
#include <stdio.h>
#include <stdlib.h>

#define INF 100000
struct node
{
  int city;
  int time;
  int cost;
};

struct minheap
{
  struct node heap[1001];
  int size;
};

void swap(struct node* a,struct node* b)
{
    struct node temp=*a;
    *a=*b;
    *b=temp;
}

void push(struct minheap* h,struct node val)
{
    int i=h->size++;
    h->heap[i]=val;
    while(i>0)
    {
        int p=(i-1)/2;
        if(h->heap[p].cost<h->heap[i].cost) break;
        swap(&h->heap[p],&h->heap[i]);
        i=p;
    }
}

struct node pop(struct minheap* h)
{
    struct node res=h->heap[0];
    h->heap[0]=h->heap[--h->size];
    int i=0;
    while(i<h->size)
    {
        int c=i;
        int a=2*i+1;
        int b=2*i+2;
        
        if(a<h->size && h->heap[a].cost<h->heap[c].cost) c=a;
        if(b<h->size && h->heap[b].cost<h->heap[c].cost) c=b;
        
        if(c==i) break;
        swap(&h->heap[i],&h->heap[c]);
        i=c;
    }
    return res;
}

int minCost(int maxTime, int** edges, int edgesSize, int* edgesColSize, int* passingFees, int passingFeesSize) {
    int u,v,t,c;
    int n=passingFeesSize;
    int timeMap[n][n];
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<n;j++)
            timeMap[i][j]=INF;
    }
    
    for(int i=0;i<edgesSize;i++)
    {
        u=edges[i][0];
        v=edges[i][1];
        t=edges[i][2];
        if(t<timeMap[u][v])
            timeMap[u][v]=timeMap[v][u]=t;
    }
    
    int dp[n][maxTime+1];
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<=maxTime;j++)
            dp[i][j]=INF;
    }
    
    dp[0][0]=passingFees[0];
    struct node first;
    first.city=first.time=0;
    first.cost=passingFees[0];
    struct minheap h;
    h.size=0;
    push(&h,first);
    
    while(h.size>0)
    {
        struct node curr=pop(&h);
        u=curr.city;
        t=curr.time;
        c=curr.cost;
        
        if(u==n-1) return c;
        if(dp[u][t]<c) continue;
        for(int v=0;v<n;v++)
        {
            if(timeMap[u][v]!=INF)
            {
                int newTime=t+timeMap[u][v];
                if(newTime<=maxTime)
                {
                    int newCost=c+passingFees[v];
                    if(newCost<dp[v][newTime])
                    {
                        dp[v][newTime]=newCost;
                        struct node new;
                        new.city=v;
                        new.cost=newCost;
                        new.time=newTime;
                        push(&h,new);
                    }
                }
            }
        }
        
    }
    return -1;
    
}
int main() {
    int n;//Number of nodes n (will be numbered from 0 to n-1)
    int edgesSize;//Number of edges
    int maxTime;
    
    printf("Enter number of cities: ");
    scanf("%d",&n);
    
    printf("Enter number of edges: ");
    scanf("%d",&edgesSize);
    
    printf("Enter maxTime: ");
    scanf("%d",&maxTime);
    
    int** edges=malloc(edgesSize*sizeof(int*));
    int* edgesColSize=malloc(edgesSize*sizeof(int));
    
    for(int i=0;i<edgesSize;i++)
    {
        edges[i]=(int*)malloc(3*sizeof(int));
        printf("Enter from to time: ");
        scanf("%d %d %d",&edges[i][0],&edges[i][1],&edges[i][2]);
        edgesColSize[i]=3;
    }
    
    int* passingFees=malloc(n*sizeof(int));
    int passingFeesSize=n;
    for(int j=0;j<n;j++)
    {
        printf("Passing fees for %d: ",j);
        scanf("%d",&passingFees[j]);
    }
    int result=minCost(maxTime,edges,edgesSize,edgesColSize,passingFees,passingFeesSize);
    printf("%d",result);
        
    return 0;
}