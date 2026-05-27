/*
1008. Construct Binary Search Tree from Preorder Traversal
https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal
Approach: left tree < root value (bound) < right tree
 */
#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

 struct TreeNode
 {
     int val;
     struct TreeNode *left;
     struct TreeNode *right;
 };
 
struct TreeNode* helper(int*preorder,int* ind,int size,int bound)
{
    if((*ind)==size ||preorder[*ind]>bound) return NULL;
    struct TreeNode* temp=malloc(sizeof(struct TreeNode));
    temp->val=preorder[(*ind)++];
    temp->left=temp->right=NULL;
    
    temp->left=helper(preorder,ind,size,temp->val);
    temp->right=helper(preorder,ind,size,bound);
    return temp;
}

struct TreeNode* bstFromPreorder(int* preorder, int preorderSize) {
    int ind=0;
    struct TreeNode* res=helper(preorder,&ind,preorderSize,INT_MAX);
    return res;
}

void Preorder(struct TreeNode* root)
{
    if(!root) return;
    printf("%d ",root->val);
    Preorder(root->left);
    Preorder(root->right);
}

int main() {
    int n;
    printf("Enter number of nodes: ");
    scanf("%d",&n);
    int* arr=malloc(n*sizeof(int));
    for(int i=0;i<n;i++)
    {
        printf("Enter value: ");
        scanf("%d",&arr[i]);
    }
    struct TreeNode* res=bstFromPreorder(arr,n);
    Preorder(res);
    return 0;
}