public class Backtracking {
	public static void getSubsets(String str, String ans, int i) {
		if(i == str.length()) {
			System.out.println(ans);
			return;
		}
		
		getSubsets(str, ans+str.charAt(i), i+1);
		getSubsets(str, ans, i+1);
	}
	
	public static void getPermutations(String str, String ans) {
		if(str.length() == 0) {
			System.out.println(ans);
			return;
		}
		
		for(int i=0; i<str.length(); i++) {
			char curr = str.charAt(i);
			String newStr = str.substring(0, i) + str.substring(i+1);
			getPermutations(newStr, ans+curr);
		}
	}
	
	public static void printBoard(char[][] board) {
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board.length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static boolean isSafe(char[][] board, int row, int col) {
		for(int i=row-1; i>=0; i--) {
			if(board[i][col] == 'Q') {
				return false;
			}
		}
		
		for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
			if(board[i][j] == 'Q') {
				return false;
			}
		}
		
		for(int i=row-1, j=col+1; i>=0 && j<board.length; i--, j++) {
			if(board[i][j] == 'Q') {
				return false;
			}
		}
		
		
		return true;
	}
	
	static int count = 0;
	
	public static boolean nQueens(char[][] board, int row) {
		//base case
		if(row == board.length) {
			//printBoard(board);
			//count++;
			return true;
		}
		
		for(int j=0; j<board.length; j++) {
			if(isSafe(board, row, j)) {
				board[row][j] = 'Q';
				if(nQueens(board, row+1)) {
					return true;
				}
				board[row][j] = 'x';
			}
		}
		
		return false;
	}
	
	public static int gridWays(int n, int m, int i, int j) {
		if(i == n-1 && j == m-1) {
			return 1;
		} else if(i == n || j == m) {
			return 0;
		}
		
		return gridWays(n, m, i+1, j) + gridWays(n, m, i, j+1);
	}
	
	public static boolean sudokuSolver(int[][] sudoku, int row, int col) {
		if(row == 9) {
			return true;
		}
		
		int nextRow = row;
		int nextCol = col+1;
		
		if(col+1 == 9) {
			nextRow = row+1;
			nextCol = 0;
		}
		
		if(sudoku[row][col] != 0) {
			return sudokuSolver(sudoku, nextRow, nextCol);
		}
		
		for(int i=1; i<=9; i++) {
			if(isSafe(sudoku, row, col, i)) {
				sudoku[row][col] = i;
				if(sudokuSolver(sudoku, nextRow, nextCol)) {
					return true;
				}
				sudoku[row][col] = 0;
			}
		}
		
		return false;
	}
	
	public static boolean isSafe(int[][] sudoku, int row, int col, int digit) {
		for(int i=0; i<9; i++) {
			if(sudoku[i][col] == digit) {
				return false;
			}
		}
		
		for(int j=0; j<9; j++) {
			if(sudoku[row][j] == digit) {
				return false;
			}
		}
		
		int sr = (row/3) * 3;
		int sc = (col/3) * 3;
		
		for(int i=sr; i<sr+3; i++) {
			for(int j=sc; j<sc+3; j++) {
				if(sudoku[i][j] == digit) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public static void printSudoku(int[][] sudoku) {
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				System.out.print(sudoku[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String args[]) {
		//getPermutations("abc", "");
//		int n = 2;
//		char board[][] = new char[n][n];
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<n; j++) {
//				board[i][j] = 'x';
//			}
//		}
		//nQueens(board, 0);
		//System.out.println(count);
//		System.out.println(nQueens(board, 0));
//		printBoard(board);
		
		//System.out.println(gridWays(3, 3, 0, 0));
		
		int sudoku[][] = {{0, 0, 0, 0, 0, 0, 2, 0, 0},
				{0, 8, 0, 0, 0, 7, 0, 9, 0},
				{6, 0, 2, 0, 0, 0, 5, 0, 0},
				{0, 7, 0, 0, 6, 0 ,0 ,0 ,0},
				{0, 0, 0 ,9, 0, 1, 0, 0, 0},
				{0, 0, 0, 0, 2, 0, 0, 4, 0},
				{0, 0, 5, 0, 0, 0, 6, 0, 3},
				{0, 9, 0, 4, 0, 0, 0, 7, 0},
				{0, 0, 6, 0, 0, 0, 0, 0, 0}};
		
		System.out.println(sudokuSolver(sudoku, 0, 0));
		printSudoku(sudoku);
	}
}