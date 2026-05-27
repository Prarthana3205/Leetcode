# 49. Group Anagrams
# https://leetcode.com/problems/group-anagrams
# Approach: Sort each word in the list and compare 

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        sorted_words=[]
        final=[]
        hashmap=[0]*len(strs)
        for word in strs:
            sorted_words.append("".join(sorted(word)))
        
        for i in range (0,len(strs)):
            sub=[]
            if(hashmap[i]==0):
                for j in range (i,len(strs)):
                    if(sorted_words[j]==sorted_words[i] and hashmap[j]==0):
                        sub.append(strs[j])
                        hashmap[j]=1
            if(len(sub)>0):
                final.append(sub)
        return final