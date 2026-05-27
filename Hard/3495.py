# 3495. Minimum Operations to Make Array Elements Zero

from typing import List
from math import ceil

'''
4^(k-1) to 4^k -1 takes k operations to reduce to 0
1 - 3     → 1 step
4 - 15    → 2 steps
16 - 63   → 3 steps
64 - 255  → 4 steps

so we make sure to count how many numbers fall in these ranges for each query and then finally 
divide by 2 as each operation can reduce 2 numbers by 1 step

therefore total steps for a query = sum of (count of numbers in range * steps required for that range)
i.e steps=(numbers within 4^(k-1) to 4^k -1 ) * k for all k
total operations for a query = ceil(total steps/2)
'''
class Solution:
    def minOperations(self, queries: List[List[int]]) -> int:

        powers=[1]
        while powers[-1]<=10**9:
            powers.append(powers[-1]*4) # finding powers of 4 for easy retrieval
        
        total=0
        for l,r in queries:
            steps=0
            for k in range(1,len(powers)):
                low=powers[k-1]
                high=powers[k]-1

                ''' range (a,b) and (c,d) and x must lie within both ranges
                x>=a and x>=c therefore we take max(a,c)
                similarly x<=b and x<=d therefore we take min(b,d)
                '''

                left=max(l,low)  # intersection of both ranges
                right=min(r,high)

                if(left<=right):
                    steps+=(right-left+1)*k
                
            total+=ceil(steps/2)

        return total


# TLE (591/646 test cases passed)
# class Solution:
#     def minOperations(self, queries: List[List[int]]) -> int:
#         total=0
#         for l,r in queries:
#             steps=0
#             for i in range(l,r+1):
#                 num=i
#                 while(num):
#                     num//=4
#                     steps+=1
#             total+=ceil(steps/2)
#         return total

