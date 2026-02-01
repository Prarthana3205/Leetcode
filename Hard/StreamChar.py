# Stream of Characters - Suffix Trie Implementation
# https://leetcode.com/problems/stream-of-characters/

'''
An example if the words were [abc, axy, xyz, ayz], the trie would look like this 
also according to the question we need to find suffix so we will reverse the words while inserting in the trie
    
trie = {
  'c': {
        'b': {
              'a': {'#': True}
        }
  },
  'y': {
        'x': {
              'a': {'#': True}
        }
  },
  'z': {
        'y': {
              'x': {'#': True},
              'a': {'#': True}
        }
  }
}
'''

class StreamChecker:

    def __init__(self, words: List[str]):
        self.trie={}
        self.maxlen=0

        for word in words:
            self.maxlen=max(self.maxlen,len(word))
            node=self.trie
            for ch in reversed(word):
                if ch not in node:
                    node[ch]={}
                node=node[ch]
            node['#']=True
        
        self.stream=[]

        

    def query(self, letter: str) -> bool:

        self.stream.insert(0,letter)
        if(len(self.stream)>self.maxlen):
            self.stream.pop()
        
        node=self.trie
        for ch in self.stream:
            if ch not in node:
                return False
            node=node[ch]
            if '#' in node:
                return True
        
        return False




# Your StreamChecker object will be instantiated and called as such:
# obj = StreamChecker(words)
# param_1 = obj.query(letter)
