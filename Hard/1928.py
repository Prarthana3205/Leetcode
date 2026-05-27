# 1928. Minimum Cost to Reach Destination in Time
# https://leetcode.com/problems/minimum-cost-to-reach-destination-in-time
# 1st condition : <=maxtime
# 2nd condition : minimum cost

# Approach: Dijkstra's algorithm with a min-heap (min heap to obtain the minimum cost path)

import heapq
from collections import defaultdict
from typing import List
import math

class Solution:
    def minCost(self, maxTime: int, edges: List[List[int]], passingFees: List[int]) -> int:
        n=len(passingFees)
        graph=defaultdict(list) # initialisation graph
        for u,v,t in edges:
            graph[u].append((v,t))
            graph[v].append((u,t))
        
        heap=[(passingFees[0],0,0)] #cost, time, node
        best_time=[math.inf]*n
        best_time[0]=0

        while heap:
            c,t,node=heapq.heappop(heap)
            if(node==n-1):
                return c
            for newn,time in graph[node]:
                newcost=c+passingFees[newn]
                newtime=t+time
                if(newtime<=maxTime and newtime<best_time[newn]):
                    best_time[newn]=newtime
                    heapq.heappush(heap,(newcost,newtime,newn))
        return -1
        
        