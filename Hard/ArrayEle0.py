# 3495. Minimum Operations to Make Array Elements Zero
from typing import List
from math import ceil

# TLE (591/646 test cases passed)
class Solution:
    def minOperations(self, queries: List[List[int]]) -> int:
        total=0
        for l,r in queries:
            steps=0
            for i in range(l,r+1):
                num=i
                while(num):
                    num//=4
                    steps+=1
            total+=ceil(steps/2)
        return total

