package test;

import java.util.Arrays;

public class MinimizeMaximumPairSumInArray {
	public static void main(String[] args) {
		MinimizeMaximumPairSumInArray sol = new MinimizeMaximumPairSumInArray();
		System.out.println(sol.minPairSum(new int[]{2, 3, 3, 5}));
	}
	
	public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int maxSum = 0;
        int currentSum;
        
        for (int i = 0; i<nums.length/2; i++) {
        	currentSum = nums[i] + nums[nums.length-i-1];
        	if (currentSum > maxSum) {
        		maxSum = currentSum;
        	}
        }
        
        return maxSum;
	}
}

