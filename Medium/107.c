// 107. Binary Tree Level Order Traversal II
// https://leetcode.com/problems/binary-tree-level-order-traversal-ii

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
/**
 * Return an array of arrays of size *returnSize.
 * The sizes of the arrays are returned as *returnColumnSizes array.
 * Note: Both returned array and *columnSizes array must be malloced, assume caller calls free().
 */
int** levelOrderBottom(struct TreeNode* root, int* returnSize, int** returnColumnSizes) {
    if(root==NULL)
    {
        *returnSize=0;
        *returnColumnSizes=NULL;
        return NULL;
    }
    int** result=malloc(2000*sizeof(int*));
    *returnColumnSizes=malloc(2000*sizeof(int));
    struct TreeNode* queue[2000];
    int front=0,rear=0;
    int levels=0;
    queue[rear++]=root;

    while(front<rear)
    {
        int levelSize=rear-front;
        result[levels]=malloc(levelSize*sizeof(int));
        (*returnColumnSizes)[levels]=levelSize;

        for(int i=0;i<levelSize;i++) //BFS
        {
            struct TreeNode* node=queue[front++];
            result[levels][i]=node->val;
            if(node->left)
                queue[rear++]=node->left;
            if(node->right)
                queue[rear++]=node->right;
        }
        levels++;
    }
    *returnSize=levels;

    // reverse logic

    /* // why complicate ???
    int ind=levels-1;
    int** final=malloc(levels*sizeof(int*));
    for(int i=0;i<levels;i++)
    {
        int num=(*returnColumnSizes)[ind--];
        final[i]=malloc(num*sizeof(int));
        for(int j=0;j<num;j++)
            final[i][j]=result[levels-i-1][j];
    }

    for(int i=0;i<levels/2;i++)
    {
        int temp=(*returnColumnSizes)[i];
        (*returnColumnSizes)[i]=(*returnColumnSizes)[levels-i-1];
        (*returnColumnSizes)[levels-i-1]=temp;

    }
    return final; 
    */

    for(int i=0;i<levels/2;i++)
    {
        // reverse the result array
        int* temp=result[i];
        result[i]=result[levels-i-1];
        result[levels-i-1]=temp;

        // reverse the column sizes
        int temp2=(*returnColumnSizes)[i];
        (*returnColumnSizes)[i]=(*returnColumnSizes)[levels-i-1];
        (*returnColumnSizes)[levels-i-1]=temp2;
    }
    return result; 
}