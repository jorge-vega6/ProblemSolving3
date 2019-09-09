import java.util.ArrayList;

/**
 * Jorge Vega
 * Problem Solving 3 Course
 * Prof. Nayda Santiago
 * Instr. Shiva Garg
 */

class BuildingOutline {
  public static void main(String[] args) {
		int[][] grid = {{2,0,4},{3,8,5},{1,5,7}};
		int[][] grid2 = {{3,4,5,7}, {9,27,36,1}, {1,4,5,6}, {3,50,1,3}};
		System.out.println(maxOutline(grid));
	}
	
	public static int maxOutline(int[][] grid) {
		
		int maxSum = 0;
		
		//rows: ArrayList to house the max values of the corresponding rows in the grid
		//cols: ArrayList to house the max values of the corresponding rows in the grid
		ArrayList<Integer> rows = new ArrayList<Integer>();
		ArrayList<Integer> cols = new ArrayList<Integer>();
		
		for(int i = 0; i < grid.length; i++) {
			rows.add(0);
		}
		
		for(int i = 0; i < grid[0].length; i++) {
			cols.add(0);
		}		
		
		//filling each ArrayList with its respective max values 
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] > rows.get(i)) {
					rows.set(i, grid[i][j]);
				}
				if (grid[i][j] > cols.get(j)) {
					cols.set(j, grid[i][j]);
				}
			}
		}
		
		//this gets the max value of the current element's column and row to then choose the lowest one and add to maxSum the amount the element needs to reach it
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				int leastMax = rows.get(i);
				if (cols.get(j) < leastMax) leastMax = cols.get(j);
				if (grid[i][j] < leastMax) {
					maxSum += leastMax - grid[i][j];
				}
				
			}
		}
		
		return maxSum;  
	}
}