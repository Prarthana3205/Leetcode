// 381. Insert Delete GetRandom O(1) duplicated allowed
// https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/description/

class RandomizedCollection {

    List<Integer> list;
    Map<Integer,Set<Integer>> map;
    Random rand;
    public RandomizedCollection() {
        list=new ArrayList<>();
        map=new HashMap<>();
        rand=new Random();
    }
    
    public boolean insert(int val) {
        boolean res=!map.containsKey(val);
        if(!map.containsKey(val))
            map.put(val,new HashSet<>());
        
        map.get(val).add(list.size());
        list.add(val);
        return res;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val))
            return false;
        
        int removeInd=map.get(val).iterator().next(); // Get any index of the value
        map.get(val).remove(removeInd);

        int lastInd=list.size()-1;
        int lastVal=list.get(lastInd); 

        if(removeInd!=lastInd)
        {
            list.set(removeInd,lastVal);
            map.get(lastVal).remove(lastInd);
            map.get(lastVal).add(removeInd);
        }

        list.remove(lastInd);

        if(map.get(val).isEmpty())
            map.remove(val);
        return true;   
    }
    
    public int getRandom() {
        int randInd=rand.nextInt(list.size());
        return list.get(randInd);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */