import java.util.Stack;

/**
 * Jorge Vega
 * Problem Solving 3 Course
 * Prof. Nayda Santiago
 * Instr. Shiva Garg
 */

//The Time Complexity of 'rotate(int[][])' is: O(n^2)
//The Space Complexity 'rotate(int[][])' is:

public class TransposeMatrix {

	public static void main(String[] args) {
		//change to 'matrix' the name of the 2d array you want to rotate
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		int[][] matrix2 = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
		
		//Printing the original matrix
		System.out.println("Original: ");
		for(int i = 0; i < matrix.length; i++) {
			System.out.print("[");
			for(int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j]);
				if(j != matrix[0].length - 1) {
					System.out.print(", ");
				}
			}
			System.out.print("]");
		}
		
		rotate(matrix);
		
		//Printing the rotated matrix
		System.out.println();
		System.out.println("Rotated: ");
		for(int i = 0; i < matrix.length; i++) {
			System.out.print("[");
			for(int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j]);
				if(j != matrix[0].length - 1) {
					System.out.print(", ");
				}
			}
			System.out.print("]");
		}
	}

	//desired outcome for matrix1: [7,4,1],[8,5,2],[9,6,3]
	//desired outcome for matrix2: [15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]
	
	static void rotate(int[][] matrix) { //nxnx(4 bytes) for matrix
		
		Stack<Integer> stack = new Stack<Integer>(); //<>bytes for stack 
		
		//push all columns from each row into the stack
		for(int i = 0; i < matrix.length; i++) { //4 bytes for int i
			for(int j = 0; j < matrix[0].length; j++) { //4 bytes for int j
				stack.push(matrix[i][j]);
			}
		}
		
		//set the values for each row in the same column to what comes out of the stack
		for(int i = 0; i < matrix[0].length; i++) {
			for(int j = matrix.length - 1; j >= 0; j--) {
				matrix[j][i] = stack.pop();
			}
		}
	}

}
