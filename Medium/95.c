// 95. Unique Binary Search Trees II
// https://leetcode.com/problems/unique-binary-search-trees-ii/

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
/**
 * Note: The returned array must be malloced, assume caller calls free().
 */

// Draw to understand
struct TreeNode* create(int root)
{
    struct TreeNode* node=malloc(sizeof(struct TreeNode));
    node->left=node->right=NULL;
    node->val=root;
    return node;
}
struct TreeNode** build(int start,int end,int* returnSize)
{
    struct TreeNode** result=(struct TreeNode**)malloc(2000* sizeof(struct TreeNode*));
    *returnSize=0;
    if(start>end)
    {
        result[0]=NULL;
        *returnSize=1;
        return result;
    }

    for(int root=start;root<=end;root++)
    {
        int leftsize,rightsize;
        struct TreeNode** leftt=build(start,root-1,&leftsize);
        struct TreeNode** rightt=build(root+1,end,&rightsize);
        for(int i=0;i<leftsize;i++)
        {
            for(int j=0;j<rightsize;j++)
            {
                struct TreeNode* r=create(root);
                r->left=leftt[i];
                r->right=rightt[j];
                result[(*returnSize)++]=r;
            }
        }
    }
    return result;
}
struct TreeNode** generateTrees(int n, int* returnSize){
    if(n==0)
    {
        *returnSize=0;
        return NULL;
    }
    struct TreeNode** res=build(1,n,returnSize);
    return res;
}