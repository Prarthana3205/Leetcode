# Data Stream as Disjoint Intervals
# https://leetcode.com/problems/data-stream-as-disjoint-intervals

class SummaryRanges:

    def __init__(self):
        self.intervals=[]

    def addNum(self, value: int) -> None:
        new_start=value
        new_end=value
        result=[]

        for start,end in self.intervals:
            # is the new start and end BEFORE the current start and end ?
            if(new_end+1<start):
                result.append([new_start,new_end])
                new_start,new_end=start,end
            
            # is th new start and end AFTER the current end amd start ?
            elif(end+1<new_start):
                result.append([start,end])
            
            #overlapping
            else:
                new_start=min(new_start,start)
                new_end=max(new_end,end)
            
        result.append([new_start,new_end])
        self.intervals=result

    def getIntervals(self) -> List[List[int]]:
        return self.intervals
        

# Your SummaryRanges object will be instantiated and called as such:
# obj = SummaryRanges()
# obj.addNum(value)
# param_2 = obj.getIntervals()