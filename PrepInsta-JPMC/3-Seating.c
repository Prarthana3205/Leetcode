/*
https://prepinsta.com/jp-morgan-coding-questions/

Problem Statement:

Semester exams are going on for university students. Examiners noticed that a group of people are trying to cheat.
They marked students of that group as ‘1’ and students of another group ( who are not cheating ) as ‘0’ 
We can reduce cheating by not allowing students from group 1 to sit together, means no two students from group 1 can sit together.
Seatings are marked using above conditions. Your task is to give the seating placement of nth possibility Possibility order from 1 to 10 is given below

[1  10  100  101  1000  1001  1010  10000  10001  10010]

Sample input :
3 → number of test cases
4
6
9

Sample output :

101
1001
10001

Explanation :
4th possibility is 101 
6th possibility is 1001
9th possibility is 10001
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct Node
{
    char str[100];
};

char* seating(int n)
{
    struct Node queue[1000];
    int front=0,rear=0;

    char curr[100];
    int count=0;

    // We start with 1
    strcpy(queue[rear++].str,"1");

    while(1)
    {
        strcpy(curr,queue[front++].str);
        int len=strlen(curr);

        count++;
        if(count==n)
        {
            // this is necessary as we cant return a local variable
            char* result=malloc(100*sizeof(char));
            strcpy(result,curr);
            return(result);
        }
        
        // Add 0 (no condition required)
        strcpy(queue[rear].str,curr);
        queue[rear++].str[len]='0';
        queue[rear-1].str[len+1]='\0';

        // Checking whether we can add 1
        if(curr[len-1]=='0')
        {
            strcpy(queue[rear].str,curr);
            queue[rear++].str[len]='1';
            queue[rear-1].str[len+1]='\0';
        }
    }
}

int main()
{
    int n;
    scanf("%d",&n);
    int* num=malloc(n*sizeof(int));

    for(int i=0;i<n;i++)
        scanf("%d",&num[i]);

    for(int i=0;i<n;i++)
        printf("%s\n",seating(num[i]));
    
    return 0;
}

/*
A queue is required to maintain order
We can append 0 to both 0 and 1, but we can append 1 to only 0
*/