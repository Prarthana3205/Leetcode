// 847. Shortest Path Visiting All Nodes
// https://leetcode.com/problems/shortest-path-visiting-all-nodes/

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

struct node
{
    int node;
    int mask;
    int dist;
};

int shortestPathLength(int** graph, int graphSize, int* graphColSize) 
{
    int finalMask=(1<<graphSize)-1;
    bool visited[graphSize][1<<graphSize];
    int k=1<<graphSize;
    for(int i=0;i<graphSize;i++)
    {
        for(int j=0;j<k;k++)
            visited[i][j]=false;
    }
    
    struct node queue[10000];
    int front,rear;
    front=rear=0;
    
    //Initialise BFS
    for(int i=0;i<graphSize;i++)
    {
        visited[i][1<<i]=true;
        struct node init;
        init.node=i;
        init.mask=1<<i;
        init.dist=0;
        queue[rear++]=init;
    }
    while(front<rear)
    {
        struct node curr=queue[front++];
        if(curr.mask==finalMask) return curr.dist;
        for(int i=0;i<graphColSize[curr.node];i++)
        {
            int neighbour=graph[curr.node][i];
            int newMask=curr.mask|(1<<neighbour);
            if(!visited[neighbour][newMask])
            {
                visited[neighbour][newMask]=true;
                struct node new;
                new.node=neighbour;
                new.mask=newMask;
                new.dist=1+curr.dist;
                queue[rear++]=new;
            }
        }
    }
    return 0;
    
}
int main() {
    int n;
    printf("Enter number of nodes: ");
    scanf("%d",&n);
    
    int** graph=malloc(n*sizeof(int*));
    int* graphColSize=malloc(n*sizeof(int));
    for(int i=0;i<n;i++)
    {
        printf("Enter number of neighbours for node %d: ",i);
        scanf("%d",&graphColSize[i]);
        graph[i]=malloc(graphColSize[i]*sizeof(int));
        for(int j=0;j<graphColSize[i];j++)
        {
            printf("Enter neighbour: ");
            scanf("%d",&graph[i][j]);
        }
    }
    int res=shortestPathLength(graph,n,graphColSize); 
    printf("Result: %d",res);
    return 0;
}
