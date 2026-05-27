# 2097. Valid Arrangement of Pairs
# https://leetcode.com/problems/valid-arrangement-of-pairs/

from collections import defaultdict
from typing import List

class Solution:
    def validArrangement(self, pairs: List[List[int]]) -> List[List[int]]:
        
        # initialization
        adj=defaultdict(list)
        indeg=defaultdict(int)
        outdeg=defaultdict(int)
        nodes=set()
        
        for u,v in pairs:
            adj[u].append(v)
            outdeg[u]+=1
            indeg[v]+=1
            nodes.add(u)
            nodes.add(v)
        
        # determine start node (out=in+1), else if any node with out degree else no edges ([])
        start=None
        for n in nodes:
            if(outdeg[n]==indeg[n]+1):
                start=n
        
        if(start==None):
            for n in nodes:
                if(outdeg[n]>0):
                    start=n

        if(start==None):
            return []
        
        # HierHolzer Algo to find eulerian path
        path=[]
        stack=[start]

        while stack:
            u=stack[-1]
            if adj[u]:
                v=adj[u].pop()
                stack.append(v)
            else:
                path.append(stack.pop())

        path.reverse()

        # answer in pairs
        res=[]
        for i in range (len(path)-1):
            res.append([path[i],path[i+1]])
        return res

        
