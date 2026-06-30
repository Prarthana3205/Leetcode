// 105. Construct Binary Tree from preorder and inorder traversal
// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */

struct TreeNode* create(int val)
{
    struct TreeNode* node=malloc(sizeof(struct TreeNode));
    node->left=node->right=NULL;
    node->val=val;
    return node;
}
struct TreeNode* build(int*preorder,int*inorder,int instart,int inend,int* preSize)
{
    if(instart>inend)
        return NULL;
    
    int rootval=preorder[(*preSize)++]; // root can be found from preorder traversal
    struct TreeNode* root=create(rootval);

    // values left of rootval in inorder traversal will lie in the leftsubtree
    // value right of the rootavl present in inorder traversal will lie in the right subtree
    int pos;
    for(pos=instart;pos<=inend;pos++) 
    {
        if(inorder[pos]==rootval)
            break;
    }
    root->left=build(preorder,inorder,instart,pos-1,preSize);
    root->right=build(preorder,inorder,pos+1,inend,preSize);
    return root;
}

struct TreeNode* buildTree(int* preorder, int preorderSize, int* inorder, int inorderSize) {
    int preSize=0;
    struct TreeNode* res=build(preorder,inorder,0,inorderSize-1,&preSize);
    return res;    
}