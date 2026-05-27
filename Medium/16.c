/*
    16. 3Sum Closest
    https://leetcode.com/problems/3sum-closest
 */
 
int compare(const void* a,const void* b)
{
    return( *(int*)a-*(int*)b);
}

int threeSumClosest(int* nums, int numsSize, int target) {
    int minsum=INT_MAX,mindif=INT_MAX;
    qsort(nums,numsSize,sizeof(int),compare);
    for(int i=0;i<numsSize-1;i++)
    {
        int start=i+1,end=numsSize-1,sum=0;
        while(start<end)
        {
            sum=nums[i]+nums[start]+nums[end];
            if(abs(sum-target)<=mindif)
            {
                mindif=abs(sum-target);
                minsum=sum;
            }
            if(sum<target) start++;
            else if(sum>target) end--;
            else return minsum;
        }
    }
    return minsum;
}