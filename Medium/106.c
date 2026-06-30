// 106. Construct binary tree from inorder and postorder traversal
// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */

// Very similar to the previous q, here the root values are obtained from postorder node backwards
struct TreeNode* create(int val)
{
    struct TreeNode* node=malloc(sizeof(struct TreeNode));
    node->left=node->right=NULL;
    node->val=val;
    return node;
}
struct TreeNode* build(int* inorder,int* postorder,int instart,int inend,int* postSize)
{
    if(instart>inend)
        return NULL;

    int rootval=postorder[(*postSize)--];
    struct TreeNode* root=create(rootval);
    int pos;
    for(pos=instart;pos<=inend;pos++)
    {
        if(inorder[pos]==rootval)
            break;
    }
    root->right=build(inorder,postorder,pos+1,inend,postSize);
    root->left=build(inorder,postorder,instart,pos-1,postSize);
    return root;
}
struct TreeNode* buildTree(int* inorder, int inorderSize, int* postorder, int postorderSize) {
    int postSize=postorderSize-1;
    struct TreeNode* res=build(inorder,postorder,0,inorderSize-1,&postSize);
    return res;
}