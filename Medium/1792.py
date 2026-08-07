#1792. Maximum Average Pass Ratio
#https://leetcode.com/problems/maximum-average-pass-ratio/

# in python heapq by default is min heap therefore to obtain max gain we introduce negative sign

from typing import List
import heapq

class Solution:
    def maxAverageRatio(self, classes: List[List[int]], extraStudents: int) -> float:
        def gain(p,t):
            return (((p+1)/(t+1))-(p/t))
        
        heap=[]
        for p,t in classes:
            g=gain(p,t)
            heap.append((-g,p,t)) # python by default is min heap , so we introduce -ve sign
        heapq.heapify(heap)

        for i in range (0,extraStudents):
            g,p,t=heapq.heappop(heap)
            p+=1
            t+=1
            heapq.heappush(heap,(-gain(p,t),p,t))

        sum=0
        while heap:
            g,p,t=heapq.heappop(heap)
            sum+=p/t
        return sum/len(classes)

        