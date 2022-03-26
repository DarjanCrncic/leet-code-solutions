package test;

public class RotateImage {

	public static void main(String[] args) {
		rotate(new int[][]  {{1,2,3},{4,5,6},{7,8,9}});
	}
	
	public static void rotate(int[][] matrix) {
        int len = matrix[0].length-1;
        int rot = len/2;
        int temp;
        printMatrix(matrix);
        for (int i=0; i<=rot; i++) {
            for (int j=i; j<len-i; j++) {
                temp = matrix[j][len-i];
                matrix[j][len-i] = matrix[i][j];
                
                matrix[i][j] = matrix[len-j][i];
                matrix[len-j][i] = matrix[len-i][len-j];
                matrix[len-i][len-j] = temp;
            }
            printMatrix(matrix);
        }
    }
	
	public static void printMatrix(int[][] matrix) {
		System.out.println(System.lineSeparator() + "Printing matrix:" + System.lineSeparator());
		for(int i=0; i<matrix[0].length; i++) {
			StringBuilder str = new StringBuilder();
			for(int j=0; j<matrix[0].length; j++) {
				str.append(matrix[i][j] + " ");
			}
			System.out.println(str.toString());
		}
		System.out.println("----------------------------------------------------------------");
		System.out.println(System.lineSeparator());
	}
}
