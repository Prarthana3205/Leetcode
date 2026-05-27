/*
1373. Maximum Sum BST in Binary Tree
https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/

Approach: Postorder traversal to check if the subtree is a BST
If it is, calculate the sum and update the maximum sum if needed.
*/

#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

struct TreeNode
{
    int val;
    struct TreeNode* left;
    struct TreeNode* right;
};

struct node
{
    int sum;
    int isBST;
    int min;
    int max;
};

struct TreeNode* create()
{
    int x;
    printf("Enter data (-1 to exit): ");
    scanf("%d",&x);
    if(x==-1)
        return NULL;
    struct TreeNode* temp=malloc(sizeof(struct TreeNode));
    if(!temp)
    {
        printf("Memory Allocation failed! ");
        exit(0);
    }
    temp->val=x;
    temp->right=temp->left=NULL;
    
    printf("Left child of %d: ",x);
    temp->left=create();
    
    printf("Right child of %d: ",x);
    temp->right=create();
    
    return temp;
    
}

struct node helper(struct TreeNode* root,int* maxsum)
{
    struct node curr;
    if(!root)
    {
        curr.sum=0;
        curr.isBST=1;
        curr.min=INT_MAX;
        curr.max=INT_MIN;
        return curr;
    }
    struct node leftinfo=helper(root->left,maxsum);
    struct node rightinfo=helper(root->right,maxsum);
    
    if(leftinfo.isBST && rightinfo.isBST && leftinfo.max<root->val && rightinfo.min>root->val)
    {
        int newsum=root->val+leftinfo.sum+rightinfo.sum;
        *maxsum=(*maxsum>newsum)?*maxsum:newsum;
        curr.sum=newsum;
        curr.isBST=1;
        curr.min=(root->val<leftinfo.min)?root->val:leftinfo.min;
        curr.max=(root->val>rightinfo.max)?root->val:rightinfo.max;
        return curr;
    }
    curr.sum=curr.isBST=curr.min=curr.max=0;
    return curr;
}

int maxSumBST(struct TreeNode* root)
{
    int maxsum=0;
    struct node res=helper(root,&maxsum);
    return maxsum;
}

int main() {
    
    struct TreeNode* root=create();
    
    int res=maxSumBST(root);
    printf("Result: %d",res);
    return 0;
}