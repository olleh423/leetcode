package problems;
import java.util.*;

class RandomizedSet {
	
	public static void main(String[] args) {
		
		RandomizedSet rs = new RandomizedSet();
		
		/*
		["RandomizedSet","remove","remove","insert","getRandom","remove","insert"]
				[[],[0],[0],[0],[],[0],[0]]
	*	**/
		
		System.out.println(rs.remove(0));
		System.out.println(rs.remove(0));
		System.out.println(rs.insert(0));
		System.out.println(rs.getRandom());
		System.out.println(rs.remove(0));
		System.out.println(rs.insert(0));
	
	}
    
    private Map<Integer, Integer> indexMap;
    private List<Integer> data;
    private int size;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        
        this.indexMap = new HashMap<>();
        this.data = new ArrayList<>();
        this.size = 0;
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        
        if(indexMap.containsKey(val))
            return false;
        
        indexMap.put(val, size);
        data.add(val);
        size++;
        
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        
        if(!indexMap.containsKey(val))
            return false;
        
        if(indexMap.size() == 1) {
        	indexMap.remove(val);
        	data.clear();
        	size = 0;
        	return true;
        }
        
        size--;
        int index = indexMap.get(val);
        indexMap.remove(val);
        
        int lastElement = data.get(size);
        data.set(index, lastElement);
        data.remove(size);
        indexMap.put(lastElement, index);
        
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        
        int random = (int) Math.random() % size;
        return data.get(random);
    }
}