// 1716. Calculate Money in Leetcode Bank

int totalMoney(int n) {
    int i=0,c=0,sum=0,start=1,j=1;
    while(i++<n)
    {
        sum+=j++;
        c+=1;
        if(c==7)
        {
            j=++start;
            c=0;
        }
    }
    return sum;

}