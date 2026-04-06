/*
https://prepinsta.com/jp-morgan-coding-questions/

Problem Statement:

Ashish was copying from Rahit in the exam. So, Rahit told him to change the answers a little bit so that the examiner cannot find the fraud.
But silly Ashish in the way started to change all the answers that were needed. He shuffled the letters in each word in a way where the maximum number of letters were misplaced.
For a given word, find the maximum difference that Ashish can generate between his answer and Rahit’s answer.

Suppose Rahit wrote “car” for an answer, Ashish can write “acr” with difference 2, or “arc” with differnece 3.

Note That: The letters are all in lowercase.

Input Format:
First line containing an integer n, number of words.
Then, n numbers of lines as the query words.

Output:
N number of lines with an integer each denoting possible maximum difference.

Sample Input:            Sample Output

4

abababa                      6
bbj                          2
kj                           2
kk                           0
*/

# include <stdio.h>
# include <stdlib.h>
# include <string.h>

int maxdiff(char* str)
{
    int freq[26]={0};
    int max=0;
    int len=strlen(str);

    for(int i=0;i<len;i++)
    {
        freq[str[i]-'a']++;
        max=freq[str[i]-'a']>max?freq[str[i]-'a']:max;
    }

    int final=len<(2*(len-max))?len:(2*(len-max));
    // len - max is just to find the number of possible positions the maximum freq character can shift
    return final;
}

int main()
{
    int n;
    scanf("%d",&n);

    char** input=malloc(n*sizeof(char*));
    for(int i=0;i<n;i++)
    {
        input[i]=malloc(1000*sizeof(char));
        scanf("%s",input[i]);
    }

    for(int i=0;i<n;i++)
    {
        printf("%d\n",maxdiff(input[i]));
    }

    return 0;
}

/*
We need to find the rearrangement such that maximum number of characters of the string are shifted not the number of permutation
And in one swap two characters positions change (that is why we multiply by 2)
If a string has distinct characters then the maximum position change will be n (therefore cannot cross n)
*/