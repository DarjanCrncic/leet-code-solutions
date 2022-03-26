package test;

public class MinimumOperationsToMakeArrayEqual {
	
	public static void main(String[] args) {
		MinimumOperationsToMakeArrayEqual sol = new MinimumOperationsToMakeArrayEqual();
		System.out.println(sol.minOperations(6));
	}
	
	public int minOperations(int n) {
        
		int sum = 0;
		
		for (int i = 0; i < n/2; i++) {
			sum += n - 2*i - 1;
		}
		
		return sum;
    }
}
