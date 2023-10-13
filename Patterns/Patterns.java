public class Patterns {
	public static void printStarPattern(int n) {
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public static void printInvertedStar(int n) {
		for(int i=1; i<=n; i++) {
			for(int j=n; j>=i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public static void halfPyramid(int n) {
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print(j);
			}
			System.out.println();
		}
	}
	
	public static void printChar(int n) {
		char ch = 'A';
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print(ch);
				ch++;
			}
			System.out.println();
		}
	}
	
	public static void hollowRectangle(int m, int n) {
		for(int i=1; i<=m; i++) {
			for(int j=1; j<=n; j++) {
				if(i==1 || i==m || j==1 || j==n) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	
	public static void rotatedPyramid(int n) {
		for(int i=1; i<=n; i++) {
			for(int j=n-1; j>=i; j--) {
				System.out.print(" ");
			}
			
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
	}
	
	public static void numberPyramid(int n) {
		for(int i=n; i>=1; i--) {
			for(int j=1; j<=i; j++) {
				System.out.print(j);
			}
			System.out.println();
		}
	}
	
	public static void floydsTriangle(int n) {
		int num = 1;
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print(num + " ");
				num++;
			}
			System.out.println();
		}
	}
	
	public static void zeroOneTriangle(int n) {
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=i; j++) {
				if((i+j)%2 == 0) {
					System.out.print("1");
				} else {
					System.out.print("0");
				}
			}
			System.out.println();
		}
	}
	
	public static void butterflyPattern(int n) {
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			
			for(int j=1; j<=(n-i)*2; j++) {
				System.out.print(" ");
			}
			
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
		
		for(int i=n-1; i>=1; i--) {
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			
			for(int j=1; j<=(n-i)*2; j++) {
				System.out.print(" ");
			}
			
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
	}
	
	public static void solidRhombus(int n) {
		for(int i=1; i<=n; i++) {
			for(int j=n-1; j>=i; j--) {
				System.out.print(" ");
			}
			
			for(int j=1; j<=n; j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
	}
	
	public static void hollowRhombus(int n) {
		for(int i=1; i<=n; i++) {
			for(int j=n-1; j>=i; j--) {
				System.out.print(" ");
			}
			
			for(int j=1; j<=n; j++) {
				if(i==1 || i==n || j==1 || j==n) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			
			System.out.println();
		}
	}
	
	public static void diamond(int n) {
		for(int i=1; i<=n; i++) {
			for(int j=n-1; j>=i; j--) {
				System.out.print(" ");
			}
			
			for(int j=1; j<=(2*i-1); j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
		
		for(int i=n-1; i>=1; i--) {
			for(int j=n-1; j>=i; j--) {
				System.out.print(" ");
			}
			
			for(int j=1; j<=(2*i-1); j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
	}
	
	public static void numberPyramid2(int n) {
		for(int i=1; i<=n; i++) {
			for(int j=n-1; j>=i; j--) {
				System.out.print(" ");
			}
			
			for(int j=1; j<=i; j++) {
				System.out.print(i + " ");
			}
			
			System.out.println();
		}
	}
	
	public static void palindromicNumbers(int n) {
		for(int i=1; i<=n; i++) {
			for(int j=n-1; j>=i; j--) {
				System.out.print(" ");
			}
			
			for(int j=i; j>=1; j--) {
				System.out.print(j);
			}
			
			for(int j=2; j<=i; j++) {
				System.out.print(j);
			}
			
			System.out.println();
		}
	}
	
	public static void main(String args[]) {
//		printStarPattern(4);
//		printInvertedStar(4);
//		halfPyramid(4);
//		printChar(4);
//		hollowRectangle(4, 5);
//		rotatedPyramid(4);
//		numberPyramid(4);
//		floydsTriangle(5);
//		zeroOneTriangle(5);
//		butterflyPattern(4);
//		solidRhombus(4);
//		hollowRhombus(5);
//		diamond(4);
//		numberPyramid2(5);
		palindromicNumbers(5);
	}
}