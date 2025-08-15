/* Question: 1038. Binary Search Tree to Greater Sum Tree
https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree
*/

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */

//Time efficiency : O(n^2)
// void countnodes(struct TreeNode* root,int* count)
// {
//     if(!root) return;
//     countnodes(root->left,count);
//     (*count)++;
//     countnodes(root->right,count);
// }

// void inorder(int* arr,struct TreeNode* root,int* ind)
// {
//     if(!root) return;
//     inorder(arr,root->left,ind);
//     arr[(*ind)++]=root->val;
//     inorder(arr,root->right,ind);
// }

// void greater(int*arr,struct TreeNode* root,int count)
// {
//     if(!root) return;
//     greater(arr,root->left,count);
//     int sum=0;
//     for(int i=0;i<count;i++)
//     {
//         if(arr[i]>=root->val)
//             sum+=arr[i];
//     }
//     root->val=sum;
//     greater(arr,root->right,count);
// }

// struct TreeNode* bstToGst(struct TreeNode* root) {
//     int count=0;
//     countnodes(root,&count);
//     int* arr=malloc(count*sizeof(int));
//     int ind=0;
//     inorder(arr,root,&ind);
//     greater(arr,root,count);
//     return root;
// }


//Optmised approach
void reverseinorder(struct TreeNode* root,int* sum)
{
    if(!root) return;
    reverseinorder(root->right,sum);
    *sum+=root->val;
    root->val=*sum;
    reverseinorder(root->left,sum);
}

struct TreeNode* bstToGst(struct TreeNode* root) {
    int sum=0;
    reverseinorder(root,&sum);
    return root;
}