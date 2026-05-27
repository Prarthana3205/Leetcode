/* 
1557.  Minimum Number of Vertices to Reach All Nodes
https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes

Approach:
find nodes no incoming edges, those nodes are the starting points.
nodes with no incoming edges can be reached from any other node.
*/

#include <stdio.h>
#include <stdlib.h>

int* findSmallestSetOfVertices(int n, int** edges, int edgesSize, int* edgesColSize, int* returnSize) {
    int* count=calloc(n,sizeof(int));
    for(int i=0;i<edgesSize;i++)
    {
        int num=edges[i][1];
        count[num]+=1;
    }
    int* result=malloc(n*sizeof(int));
    int ind=0;
    for(int i=0;i<n;i++)
        if(!count[i]) result[ind++]=i;
    *returnSize=ind;
    return result;
}
int main() {
    int n;//Number of nodes n (will be numbered from 0 to n-1)
    int edgesSize;//Number of edges
    
    printf("Enter number of nodes: ");
    scanf("%d",&n);
    
    printf("Enter number of edges: ");
    scanf("%d",&edgesSize);
    
    int**edges=malloc(edgesSize*sizeof(int*));
    int*edgesColSize=malloc(edgesSize*sizeof(int));
    
    for(int i=0;i<edgesSize;i++)
    {
        edges[i]=(int*)malloc(2*sizeof(int));
        printf("Enter from and to: ");
        scanf("%d %d",&edges[i][0],&edges[i][1]);
        edgesColSize[i]=2;
    }
    int returnSize=0;
    int * result=findSmallestSetOfVertices(n,edges,edgesSize,edgesColSize,&returnSize) ;
    for(int j=0;j<returnSize;j++)
        printf("%d ",result[j]);
        
    return 0;
}