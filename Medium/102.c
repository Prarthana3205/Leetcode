// 102. Binary Tree Level Order Traversal
// https://leetcode.com/problems/binary-tree-level-order-traversal

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
int** levelOrder(struct TreeNode* root, int* returnSize, int** returnColumnSizes) {
    if(root==NULL)
    {
        *returnSize=0;
        *returnColumnSizes=NULL;
        return NULL;
    }
    int** result=malloc(2000*sizeof(int*));
    *returnColumnSizes=malloc(2000*sizeof(int));
    struct TreeNode* queue[5000];
    int levels=0;
    int front=0,rear=0;

    queue[rear++]=root;
    while(front<rear)
    {
        int levelSize=rear-front;
        (*returnColumnSizes)[levels]=levelSize;
        result[levels]=malloc(levelSize*sizeof(int));

        for(int i=0;i<levelSize;i++)
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
    return result;
}