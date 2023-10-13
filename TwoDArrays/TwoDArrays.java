public class TwoDArrays {
	public static void spiralMatrix(int matrix[][]) {
		int startRow = 0;
		int startCol = 0;
		int endRow = matrix.length-1;
		int endCol = matrix[0].length-1;
		
		while(startRow <= endRow && startCol <= endCol) {
			for(int j=startCol; j<=endCol; j++) {
				System.out.print(matrix[startCol][j] + " ");
			}
			
			for(int i=startRow+1; i<=endRow; i++) {
				System.out.print(matrix[i][endCol] + " ");
			}
			
			for(int j=endCol-1; j>=startCol; j--) {
				if(startRow == endRow) {
					break;
				}
				System.out.print(matrix[endRow][j] + " ");
			}
			
			for(int i=endRow-1; i>=startRow+1; i--) {
				if(startCol == endCol) {
					break;
				}
				System.out.print(matrix[i][startCol] + " ");
			}
			
			startRow++;
			startCol++;
			endRow--;
			endCol--;
		}
	}
	
	public static int diagonalSum(int matrix[][]) {
//		int sum = 0;
//		for(int i=0; i<matrix.length; i++) {
//			for(int j=0; j<matrix[0].length; j++) {
//				if(i == j) {
//					sum += matrix[i][j];
//				} else if(i+j == matrix.length-1) {
//					sum += matrix[i][j];
//				}
//			}
//		}
		
		int sum = 0;
		
		for(int i=0; i<matrix.length; i++) {
			sum += matrix[i][i];
			
			if(i != matrix.length-i-1) {
				sum += matrix[i][matrix.length-1-i];
			}
		}
		
		return sum;
	}
	
	public static boolean staircaseSearch(int matrix[][], int key) {
		int row = 0;
		int col = matrix[0].length-1;
		
		while(row<matrix.length && col >= 0) {
			if(matrix[row][col] == key) {
				System.out.println("key found at (" + row + "," + col + ")");
				return true;
			}
			
			if(key < matrix[row][col]) {
				col--;
			} else {
				row++;
			}
		}
		
		System.out.println("key not found in the matrix");
		return false;
	}
	
	public static int numberOf7s(int matrix[][]) {
		int freq = 0;
		
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				if(matrix[i][j] == 7) {
					freq++;
				}
			}
		}
		
		return freq;
	}
	
	public static int sum(int matrix[][]) {
		int sum = 0;
		
		for(int j=0; j<matrix[0].length; j++) {
			sum += matrix[1][j];
		}
		
		return sum;
	}
	
	public static int[][] getTranspose(int matrix[][]) {
		int n = matrix.length;
		int m = matrix[0].length;
		
		int transpose[][] = new int[m][n];
		
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				transpose[j][i] = matrix[i][j];
			}
		}
		
		return transpose;
	}
	
	public static void printMatrix(int matrix[][]) {
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String args[]) {
		int matrix[][] = {{1, 2, 3},
						  {4, 5, 6}};
		
		//spiralMatrix(matrix);
		//System.out.println(diagonalSum(matrix));
		//staircaseSearch(matrix, 10);
		//System.out.println(numberOf7s(matrix));
		//System.out.println(sum(matrix));
		printMatrix(getTranspose(matrix));
	}
}