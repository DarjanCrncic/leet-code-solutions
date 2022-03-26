package test;

public class BinarySearch {

	public static void main(String[] args) {

		search(new int[] { -1, 0, 3, 5, 9, 12 }, 2);
	}

	public static int search(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		int middle = (end - start) / 2;
		int retVal = -1;

		if (nums[middle] == target) {
			return middle;
		}
		if (nums[end] == target) {
			return end;
		}
		if (nums[start] == target) {
			return start;
		}

		while (start < end - 1) {
			if (target == nums[middle]) {
				retVal = middle;
				break;
			} else if (target > nums[middle]) {
				start = middle;
				middle = (end + start) / 2;
			} else {
				end = middle;
				middle = (end + start) / 2;
			}
		}
		return retVal;
	}
}
