# 3025. Find the Number of Ways to Place People I
# https://leetcode.com/problems/find-the-number-of-ways-to-place-people-i

from typing import List
class Solution:
    def numberOfPairs(self, points: List[List[int]]) -> int:
        n=len(points)
        count=0
        for i in range (n):
            x1,y1=points[i] # A
            for j in range(n):
                if(i==j):
                    continue
                x2,y2=points[j] # B
                if(y2<=y1 and x1<=x2): # condition checking upper left 
                    valid=True
                    for k in range(n):
                        if(k==i or k==j):
                            continue
                        x,y=points[k]
                        if(x1<=x<=x2 and y1>=y>=y2):
                            valid=False
                            break
                    if(valid):
                        count+=1
        return count                       

                            

        