package test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class FindingTheUsersActiveMinutes {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(findingUsersActiveMinutes(new int[][] {{0,5},{1,2},{0,2},{0,5},{1,3}}, 5)));
	}
	
	public static int[] findingUsersActiveMinutes(int[][] logs, int k) {
		int[] result = new int[k];
		Map<Integer, HashSet<Integer>> userMinutes = new HashMap<>();
				
		for (int[] pair : logs) {
			if (!userMinutes.containsKey(pair[0])) {
				userMinutes.put(pair[0], new HashSet<>());
			}
			userMinutes.get(pair[0]).add(pair[1]);
		}
		
		for (Map.Entry<Integer, HashSet<Integer>> entry : userMinutes.entrySet()) {
			result[entry.getValue().size()-1]++;
		}
		
		return result;
        
    }
}
