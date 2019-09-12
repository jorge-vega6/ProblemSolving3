import java.util.Stack;

/**
 * Jorge Vega
 * Problem Solving 3 Course
 * Prof. Nayda Santiago
 * Instr. Shiva Garg
 */

public class TransposeMatrix {

	public static void main(String[] args) {
		//change to 'matrix' the name of the 2d array you want to rotate
		int[][] matrix1 = {{1,2,3},{4,5,6},{7,8,9}};
		int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
		
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
	
	static void rotateWithExtraMemory(int[][] matrix) { 
		
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
	
	public static void rotate(int[][] matrix){
	    for(int i = 0; i < matrix.length / 2; i++){ //this allows us to loop through the different 'circles' in the matrix. it's stopping condition is length/2 because that gives us the amount of rotatable circles in the given matrix 
	      for(int j = i; j < matrix.length - 1 - i; j++){ //this allows us to iterate through each set of values to rotate in a circle
	        int row = i;
	        int column = j;
	        int currentValue = matrix[row][column];
	        
	        //this do-while allows us to actually rotate the numbers within their set
	        do{	
	          //this portion calculates the future index of the current value
	          int oldRow = row;				
	          row = column;
	          column = matrix.length - 1 - oldRow;
	          
	          //this portion stores the value that is inside the future index and switches it for the current one
	          int oldValue = currentValue;
	          currentValue = matrix[row][column]; //this saves the element that is inside the new coordinates 
	          matrix[row][column] = oldValue; //this sets the new coordinate's element 

	        } while(!(row == i && column == j)); //this condition makes it stop rotating the numbers in the set, checking if we've come back to the original coordinates in which we started
	      }
	    }

}
}
