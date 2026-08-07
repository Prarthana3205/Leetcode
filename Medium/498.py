# 498. Diagonal Traverse
# https://leetcode.com/problems/diagonal-traverse/

# Obtain all diagonals and reverse alternate diagonals

from typing import List

class Solution:
    def findDiagonalOrder(self, mat: List[List[int]]) -> List[int]:
        rows=len(mat)
        cols=len(mat[0])
        d=rows+(cols-1) #Number of diagonals
        diagonals=[]
        
        for i in range(0,cols): # row diagonals
            r,c=0,i
            temp=[]
            while(c>=0 and r<rows):
                temp.append(mat[r][c])
                r+=1
                c-=1
            diagonals.append(temp)
        
        for i in range(1,rows):
            r,c=i,cols-1
            temp=[]
            while(c>=0 and r<rows):
                temp.append(mat[r][c])
                r+=1
                c-=1
            diagonals.append(temp)
        
        res=[]
        for i in range (0,d):
            if(i%2!=0):
                res.extend(diagonals[i])
            else:
                diagonals[i].reverse()
                res.extend(diagonals[i])
        return res
            
