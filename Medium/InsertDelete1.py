# Insert Delete GetRandom O(1)
# https://leetcode.com/problems/insert-delete-getrandom-o1/description/

# Approach - Using a combination of a list and a dictionary to achieve O(1) time complexity for insert, delete, and getRandom operations.
# For delete operation, we swap the element to be deleted with the last element in the list and then remove the last element.
# This ensures that we can delete an element in O(1) time as remove element from the array is O(n) but removing the last element is O(1).

class RandomizedSet:

    def __init__(self):
        self.arr=[] # array storing the elements
        self.pos={} # dictionary storing value:index
        

    def insert(self, val: int) -> bool:
        if val in self.pos:
            return False
        self.pos[val]=len(self.arr)
        self.arr.append(val)
        return True        

    def remove(self, val: int) -> bool:
        if val not in self.pos:
            return False

        ind=self.pos[val]
        last_val=self.arr[-1]
        self.arr[ind]=last_val
        self.pos[last_val]=ind

        self.arr.pop()
        del self.pos[val]
        return True        

    def getRandom(self) -> int:
        return random.choice(self.arr)

# Mistakes made
# Forgot to update the position of the last element when swapping during removal.


# Your RandomizedSet object will be instantiated and called as such:
# obj = RandomizedSet()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()