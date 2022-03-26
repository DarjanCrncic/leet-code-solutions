package test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MaximumFrequencyStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FreqStack stack = new FreqStack();
		stack.push(1);
		stack.push(0);
		stack.push(0);
		stack.push(1);
		stack.push(5);
		stack.push(4);
		stack.push(1);
		stack.push(5);
		stack.push(1);
		stack.push(6);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
	}
	
	static class FreqStack {

	    private List<Integer> stack;
	    Set<Integer> values;
    	Map<Integer, Integer> counts;
    	List<Integer> possibleValues;
    	int maxCount = 0;
	    
	    public FreqStack() {
	        stack = new LinkedList<>();
	        values = new HashSet<>();
	        counts = new HashMap<>();
	        possibleValues = new LinkedList<>();
	    }
	    
	    public void push(int val) {
	        stack.add(val);
    		if (counts.containsKey(val)) { 
    			int newCount = counts.get(val)+1;
    			counts.put(val, newCount);
    			if (newCount > maxCount) {
    				maxCount = newCount;
    				possibleValues.clear();
    				possibleValues.add(val);
    			}
    		} else {
    			values.add(val);
    			counts.put(val, 1);
    		}
	    }
	    
	    public int pop() {

	    	findMaxCount();
	    	findPossibleValues(maxCount);

	    	int numToRemove = -1;
	    	for (int i=stack.size()-1; i>=0; i--) {
	    		if (possibleValues.contains(stack.get(i))) {
	    			numToRemove = stack.get(i);
	    			stack.remove(i);
	    			decrementCount(numToRemove);
	    			break;
	    		}
	    	}
	        return numToRemove;
	    }
	    
	    private void findMaxCount() {
	    	maxCount = 0;
	    	for (int count : counts.values()) {
	    		maxCount = count > maxCount ? count : maxCount;
	    	}
	    }
	    
	    private void findPossibleValues(int maxCount) {
	    	possibleValues.clear();
	    	for (int key : values) {
	    		if (counts.get(key) == maxCount) {
	    			possibleValues.add(key);
	    		}
	    	}
	    }
	    
	    private void decrementCount(int numToRemove) {
	    	counts.put(numToRemove, counts.get(numToRemove) - 1);
	    }
	}
}
