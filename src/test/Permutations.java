package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

	public static void main(String[] args) {
		permute(new int[] { 1, 2, 3 });
	}

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> permutations = new ArrayList<>();
		int numberToInsert = nums[0];

		if (nums.length == 1) {
			List<Integer> temp = new ArrayList<>();
			temp.add(numberToInsert);
			permutations.add(temp);
			return permutations;
		}

		List<List<Integer>> prev = permute(Arrays.copyOfRange(nums, 1, nums.length));
		for (int i = 0; i < prev.size(); i++) {
			for (int j = 0; j < prev.get(i).size() + 1; j++) {
				List<Integer> current = new ArrayList<>(prev.get(i));
				current.add(j, numberToInsert);
				permutations.add(current);
			}
		}

		return permutations;
	}
}
