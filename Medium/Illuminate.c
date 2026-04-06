/*
Q: Minimum Lamps to Remove to Avoid Overlapping Illumination

You are given an array positions[] representing the positions (in meters) of street lamps placed along a straight street.
Each street lamp illuminates 10 meters to the left and 10 meters to the right, inclusive.
Two lamps are said to overlap if they illuminate at least one common point on the street.
Task is to determine the minimum number of lamps that must be removed so that no two remaining lamps have overlapping illumination

*/

#include <stdio.h>
#include <stdlib.h>

int compare(const void* a,const void* b)
{
    return(*(int*)a-*(int*)b);
}

int main()
{
    int* arr,*res;
    int n,ind=0;
    printf("Number of Elements: ");
    scanf("%d",&n);

    if(n==0)
    {
        return 0;
    }

    arr=(int*)malloc(n*sizeof(int));
    res=(int*)malloc(n*sizeof(int));

    for(int i=0;i<n;i++)
    {
        printf("Enter Element: ");
        scanf("%d",&arr[i]);
    }
    
    qsort(arr,n,sizeof(int),compare);

    res[ind++]=arr[0];
    int last_inarr=arr[0];


    for(int i=1;i<n;i++)
    {
        if(arr[i]-last_inarr>=20)
        {
            res[ind++]=arr[i];
            last_inarr=arr[i];
        }
    }

    printf("Lamps to be removed: %d\n",n-ind);
    printf("Remaining Lamps: ");
    for(int i=0;i<ind;i++)
        printf("%d ",res[i]);
    printf("\n");

    free(arr);
    free(res);
    return 0;
}

