/* Question: 1382. Balance a Binary Search Tree
https://leetcode.com/problems/balance-a-binary-search-tree
*/

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */

void countnodes(struct TreeNode* root,int* count)
{
    if(!root) return;
    countnodes(root->left,count);
    (*count)++;
    countnodes(root->right,count);
}

void inorder(struct TreeNode* root,int* arr,int* ind)
{
    if(!root) return;
    inorder(root->left,arr,ind);
    arr[(*ind)++]=root->val;
    inorder(root->right,arr,ind);
}

struct TreeNode* construct(int* arr,int start,int end)
{
    if(start>end) return NULL;
    int n=end-start;
    int mid=start+(n/2);
    struct TreeNode* temp=malloc(sizeof(struct TreeNode));
    temp->left=temp->right=NULL;
    temp->val=arr[mid];
    temp->left=construct(arr,start,mid-1);
    temp->right=construct(arr,mid+1,end);
    return temp;
}

struct TreeNode* balanceBST(struct TreeNode* root) {
    int count=0,ind=0;
    countnodes(root,&count);
    int* arr=malloc((count+1)*sizeof(int));
    inorder(root,arr,&ind);
    struct TreeNode* r=construct(arr,0,count-1);
    return r;
}