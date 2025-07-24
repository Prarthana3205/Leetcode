/* Question: Convert a given BST into a Special Max Heap with the condition
that all the values in the left subtree of a node should be less than all the values in the right subtree 
of the node.This condition is applied on all the nodes in the so converted Max Heap.
Approach:
1: BST insertion
2: Inorder traversal to get the values in sorted order
3: Build a Max Heap from the sorted values
4: Postorder traversal to print the Max Heap
 */

#include <stdio.h>
#include <stdlib.h>

struct node
{
    int data;
    struct node* left;
    struct node* right;
};

void insert(struct node** root,int x)
{
    struct node* temp=malloc(sizeof(struct node));
    if(!temp)
    {
        printf("Memory Allocation failed !");
        exit(0);
    }
    temp->data=x;
    temp->right=temp->left=NULL;
    
    if(!*root)
        *root=temp;
    else
    {
        struct node* curr=*root;
        struct node* prev=NULL;
        while(curr)
        {
            prev=curr;
            curr=(x<curr->data)?curr->left:curr->right;
        }
        if(x<prev->data) prev->left=temp;
        else prev->right=temp;
    }
}

void inorder(struct node* root,int* arr,int* ind)
{
    if(!root) return;
    inorder(root->left,arr,ind);
    arr[(*ind)++]=root->data;
    inorder(root->right,arr,ind);
}
void postorder(struct node* root)
{
    if(root)
    {
        postorder(root->left);
        postorder(root->right);
        printf("%d ",root->data);
    }
}

struct node* BuildHeap(int* arr,int start,int end)
{
    if(start>end) return NULL;
    struct node* root=malloc(sizeof(struct node));
    if(!root)
    {
        printf("Memory Allocation Failed");
        exit(0);
    }
    root->data=arr[end];
    int n=end-start;
    int mid=start+(n/2);
    root->left=BuildHeap(arr,start,mid-1);
    root->right=BuildHeap(arr,mid,end-1);
    
    return root;
}

void countNodes(struct node* root,int* count)
{
    if(!root) return;
    countNodes(root->left,count);
    (*count)++;
    countNodes(root->right,count);
}

void Heap(struct node* root)
{
    int count=0;
    countNodes(root,&count);
    
    int i=0;
    int* arr=malloc((count+1)*sizeof(int));
    inorder(root,arr,&i);
    
    struct node* hroot=BuildHeap(arr,0,count-1);
    postorder(hroot);
}
int main() {
    int ch,x;
    struct node* root=NULL;
    
    while(1)
    {
        printf("\n1.Insert\n2.Output\n3.Exit\n");
        scanf("%d",&ch);
        switch(ch)
        {
            case 1:
                printf("Value: ");
                scanf("%d",&x);
                insert(&root,x);
                break;
            
            case 2:
                Heap(root);
                break;
            
            case 3:
                exit(0);
                
            default:
                printf("Invalid choice");
                break;
        }
    }
    return 0;
}