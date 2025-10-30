# 3027. Find the Number of Ways to Place People II
# https://leetcode.com/problems/find-the-number-of-ways-to-place-people-ii

# Time limit exceeded (508/550 test cases)
# from typing import List
# class Solution:
#     def numberOfPairs(self, points: List[List[int]]) -> int:
#         n=len(points)
#         c=0
#         for i in range(n):
#             x1,y1=points[i] # Alice
#             for j in range(n):
#                 if(i!=j):
#                     x2,y2=points[j] # Bob
#                     if(x2>=x1 and y1>=y2): # left position condition
#                         valid=True
#                         for k in range(n):
#                             x,y=points[k]
#                             if(k!=i and k!=j):
#                                 if(x1<=x<=x2 and y1>=y>=y2):
#                                     valid=False
#                                     break
#                         if(valid):
#                             c+=1
#         return c



        