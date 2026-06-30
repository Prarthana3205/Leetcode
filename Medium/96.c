// 96. Unique Binary Search Trees
// https://leetcode.com/problems/unique-binary-search-trees

int build(int start,int end)
{
    if(start>end)
        return 1;

    int result=0;
    for(int root=start;root<=end;root++)
    {
        int lefts=build(start,root-1);
        int rights=build(root+1,end);
        result+=lefts*rights;
    }
    return result;
}

int numTrees(int n) {
    int res=build(1,n);
    return res;
}