import java.util.*;

public class DynamicProgramming {
	public static int fib(int n, int f[]) {
		if(n == 0 || n == 1) {
			return n;
		}
		
		if(f[n] != 0) {
			return f[n];
		}
		f[n] = fib(n-1, f) + fib(n-2, f);
		return f[n];
	}
	
	public static int fibTab(int n) {
		int dp[] = new int[n+1];
		dp[0] = 0;
		dp[1] = 1;
		
		for(int i=2; i<=n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		return dp[n];
	}
	
	public static int countWays(int n, int ways[]) {
		if(n == 0) {
			return 1;
		}
		if(n < 0) {
			return 0;
		}
		
		if(ways[n] != -1) {
			return ways[n];
		}
		
		ways[n] = countWays(n-1, ways) + countWays(n-2, ways);
		return ways[n];
	}
	
	public static int countWaysTab(int n) {
		int dp[] = new int[n+1];
		dp[0] = 1;
		
		for(int i=1; i<=n; i++) {
			if(i == 1) {
				dp[i] = dp[i-1];
			} else {
				dp[i] = dp[i-1] + dp[i-2];
			}
		}
		
		return dp[n];
	}
	
	public static int knapsack(int val[], int wt[], int W, int n) {
		if(n == 0 || W == 0) {
			return 0;
		}
		
		//valid
		if(wt[n-1] <= W) {
			int ans1 = val[n-1] + knapsack(val, wt, W-wt[n-1], n-1);
			int ans2 = knapsack(val, wt, W, n-1);
			
			return Math.max(ans1, ans2);
		} else {
			return knapsack(val, wt, W, n-1);
		}
	}
	
	public static int knapsackMem(int val[], int wt[], int W, int n, int dp[][]) {
		if(n == 0 || W == 0) {
			return 0;
		}
		
		if(dp[n][W] != -1) {
			return dp[n][W];
		}
		
		//valid
		if(wt[n-1] <= W) {
			int ans1 = val[n-1] + knapsack(val, wt, W-wt[n-1], n-1);
			int ans2 = knapsack(val, wt, W, n-1);
			
			dp[n][W] = Math.max(ans1, ans2);
			return dp[n][W];
		} else {
			dp[n][W] = knapsack(val, wt, W, n-1);
			return dp[n][W];
		}
	}
	
	public static int knapsackTab(int val[], int wt[], int W) {
		int dp[][] = new int[val.length+1][W+1];
		
		for(int i=1; i<dp.length; i++) {
			for(int j=0; j<dp[0].length; j++) {
				int v = val[i-1];
				int w = wt[i-1];
				
				if(w <= j) {
					int ans1 = v + dp[i-1][j-w];
					int ans2 = dp[i-1][j];
					dp[i][j] = Math.max(ans1, ans2);
				} else {
					dp[i][j] = dp[i-1][j];
 				}
			}
		}
		
		return dp[val.length][W];
	}
	
	public static boolean targetSumSubset(int arr[], int sum) {
		boolean dp[][] = new boolean[arr.length+1][sum+1];
		for(int i=0; i<dp.length; i++) {
			dp[i][0] = true;
		}
		
		for(int i=1; i<dp.length; i++) {
			for(int j=1; j<dp[0].length; j++) {
				int v = arr[i-1];
				if(v <= j && dp[i-1][j-v] == true) {
					dp[i][j] = true;
				} else if(dp[i-1][j] == true) {
					dp[i][j] = true;
				}
			}
		}
		
		return dp[arr.length][sum];
		
	}
	
	public static int unboundedKnapsack(int val[], int wt[], int W) {
		int dp[][] = new int[val.length+1][W+1];
		
		for(int i=1; i<dp.length; i++) {
			for(int j=1; j<dp[0].length; j++) {
				int v = val[i-1];
				int w = wt[i-1];
				
				if(w <= j) {
					int ans1 = v + dp[i][j-w];
					int ans2 = dp[i-1][j];
					dp[i][j] = Math.max(ans1, ans2);
				} else {
					dp[i][j] = dp[i-1][j];
 				}
			}
		}
		
		return dp[val.length][W];
	}
	
	public static int coinChange(int coins[], int change) {
		int n = coins.length;
		int dp[][] = new int[n+1][change+1];
		
		for(int i=0; i<dp.length; i++) {
			dp[i][0] = 1;
		}
		
		for(int j=0; j<dp[0].length; j++) {
			dp[0][j] = 0;
		}
		
		for(int i=1; i<dp.length; i++) {
			for(int j=1; j<dp[0].length; j++) {
				if(coins[i-1] <= j) { //valid
					dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j];
				} else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		
		return dp[n][change];
	}
	
	public static int rodCutting(int prices[], int length[], int totRod) {
		int n = prices.length;
		int dp[][] = new int[n+1][totRod+1];
		
		for(int i=0; i<dp.length; i++) {
			dp[i][0] = 0;
		}
		
		for(int j=0; j<dp[0].length; j++) {
			dp[0][j] = 0;
		}
		
		for(int i=1; i<dp.length; i++) {
			for(int j=1; j<dp[0].length; j++) {
				if(length[i-1] <= j) {
					dp[i][j] = Math.max(prices[i-1] + dp[i][j-length[i-1]], dp[i-1][j]);
				} else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		
		return dp[n][totRod];
	}
	
	public static int lcs(String str1, String str2, int n, int m) {
		if(n == 0 || m == 0) {
			return 0;
		}
		
		if(str1.charAt(n-1) == str2.charAt(m-1)) {
			return lcs(str1, str2, n-1, m-1) + 1;
		} else {
			int ans1 = lcs(str1, str2, n-1, m);
			int ans2 = lcs(str1, str2, n, m-1);
			
			return Math.max(ans1, ans2);
		}
	}
	
	public static int lcs2(String str1, String str2, int n, int m, int dp[][]) {
		if(n == 0 || m == 0) {
			return 0;
		}
		
		if(dp[n][m] != -1) {
			return dp[n][m];
	    }
		
		if(str1.charAt(n-1) == str2.charAt(m-1)) {
			return dp[n][m] = lcs2(str1, str2, n-1, m-1, dp) + 1;
		} else {
			int ans1 = lcs2(str1, str2, n-1, m, dp);
			int ans2 = lcs2(str1, str2, n, m-1, dp);
			
			return dp[n][m] = Math.max(ans1, ans2);
		}
	}
	
	public static int lcsTab(String str1, String str2) {
		int dp[][] = new int[str1.length()+1][str2.length()+1];
		
		for(int i=0; i<dp.length; i++) {
			dp[i][0] = 0;
		}
		
		for(int j=0; j<dp[0].length; j++) {
			dp[0][j] = 0;
		}
		
		for(int i=1; i<dp.length; i++) {
			for(int j=1; j<dp[0].length; j++) {
				if(str1.charAt(i-1) == str2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
				} else {
					int ans1 = dp[i-1][j];
					int ans2 = dp[i][j-1];
					dp[i][j] = Math.max(ans1, ans2);
				}
			}
		}
		
		return dp[str1.length()][str2.length()];
	}
	
	public static int longestCommonSubstring(String str1, String str2) {
		int n = str1.length();
		int m = str2.length();
		int ans = 0;
		int dp[][] = new int[n+1][m+1];
		
		for(int i=0; i<dp.length; i++) {
			dp[i][0] = 0;
		}
		
		for(int j=0; j<dp[0].length; j++) {
			dp[0][j] = 0;
		}
		
		for(int i=1; i<dp.length; i++) {
			for(int j=1; j<dp[0].length; j++) {
				if(str1.charAt(i-1) == str2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
					ans = Math.max(ans, dp[i][j]);
				} else {
					dp[i][j] = 0;
				}
			}
		}
		
		return ans;
	}
	
	public static int lis(int arr1[]) {
		HashSet<Integer> set = new HashSet<>();
		
		for(int i=0; i<arr1.length; i++) {
			set.add(arr1[i]);
		}
		
		int arr2[] = new int[set.size()];
		int i=0;
		for(int num : set) {
			arr2[i] = num;
			i++;
		}
		
		Arrays.sort(arr2);
		
		return lcs(arr1, arr2);
	}
	
	public static int lcs(int arr1[], int arr2[]) {
		int n = arr1.length; 
		int m = arr2.length;
		int dp[][] = new int[n+1][m+1];
		
		for(int i=0; i<dp.length; i++) {
			dp[i][0] = 0;
		}
		
		for(int j=0; j<dp[0].length; j++) {
			dp[0][j] = 0;
		}
		
		for(int i=1; i<dp.length; i++) {
			for(int j=1; j<dp[0].length; j++) {
				if(arr1[i-1] == arr2[j-1]) {
					dp[i][j] = dp[i-1][j-1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
				}
			}
		}
		
		return dp[n][m];
	}
	
	public static int editDistance(String word1, String word2) {
		int n = word1.length();
		int m = word2.length();
		int dp[][] = new int[n+1][m+1];
		
		for(int i=0; i<dp.length; i++) {
			dp[i][0] = i;
		}
		
		for(int j=0; j<dp[0].length; j++) {
			dp[0][j] = j;
		}
		
		for(int i=1; i<dp.length; i++) {
			for(int j=1; j<dp[0].length; j++) {
				if(word1.charAt(i-1) == word2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1];
				} else {
//					int add = dp[i][j-1] + 1;
//					int del = dp[i-1][j] + 1;
//					int rep = dp[i-1][j-1] + 1;
//					dp[i][j] = Math.min(add, Math.min(del, rep));
					 
					
					dp[i][j] = Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1])) + 1;
				}
			}
		}
		
		return dp[n][m];
	}
	
	public static int stringConversion(String str1, String str2) {
		int n = str1.length();
		int m = str2.length();
		
		int lcsLen = lcsTab(str1, str2);
		int del = n - lcsLen;
		int add = m - lcsLen;
		int operations = del + add;
		
		return operations;
	}
	
	public static int catalanRec(int n) {
		if(n == 0 || n == 1) {
			return 1;
		}
		
		int ans = 0;
		for(int i=0; i<n; i++) {
			ans += catalanRec(i) * catalanRec(n-i-1); 
		}
		
		return ans;
	}
	
	public static int catalanMem(int n, int dp[]) {
		if(n == 0 || n == 1) {
			return 1;
		}
		
		if(dp[n] != 0) {
			return dp[n];
		}
		
		int ans = 0;
		for(int i=0; i<n; i++) {
			ans += catalanMem(i, dp) * catalanMem(n-i-1, dp);
		}
		
		return dp[n] = ans;
	}
	
	public static int catalanTab(int n) {
		int dp[] = new int[n+1];
		dp[0] = 1;
		dp[1] = 1;
		
		for(int i=2; i<dp.length; i++) {
			for(int j=0; j<i; j++) {
				dp[i] += dp[j] * dp[i-j-1]; 
			}
		}
		
		return dp[n];
	}
	
	public static int countBSTs(int n) {
		int dp[] = new int[n+1];
		dp[0] = dp[1] = 1;
		
		for(int i=2; i<dp.length; i++) {
			for(int j=0; j<i; j++) {
				int left = dp[j];
				int right = dp[i-j-1];
				dp[i] += left * right;
			}
		}
		
		return dp[n];
	}
	
	public static int mountainRanges(int n) {
		int dp[] = new int[n+1];
		dp[0] = dp[1] = 1;
		
		for(int i=2; i<dp.length; i++) {
			for(int j=0; j<i; j++) {
				int inside = dp[j];
				int outside = dp[i-j-1];
				dp[i] += inside * outside;
			}
		}
		
		return dp[n];
	}
	
	public static void main(String args[]) {
//		int n = 5;
//		int f[] = new int[n+1];
//		System.out.println(fib(n, f));
//		System.out.println(fibTab(n));
		
//		int ways[] = new int[n+1];
//		Arrays.fill(ways, -1);
//		
//		System.out.println(countWays(n, ways));
//		System.out.println(countWaysTab(n));
		
//		int val[] = {15, 14, 10, 45, 30};
//		int wt[] = {2, 5, 1, 3, 4};
//		int W = 7;
//		System.out.println(unboundedKnapsack(val, wt, W));
//		int dp[][] = new int[val.length+1][W+1];
//		for(int i=0; i<dp.length; i++) {
//			for(int j=0; j<dp[0].length; j++) {
//				dp[i][j] = -1;
//			}
//		}
//		System.out.println(knapsackTab(val, wt, W));
		
//		int arr[] = {4, 2, 7, 3, 1};
//		int sum = 20;
//		System.out.println(targetSumSubset(arr, sum));
		
//		String str1 = "abcde";
//		String str2 = "ace";
//		int n = str1.length();
//		int m = str2.length();
//		
//		int dp[][] = new int[n+1][m+1];
//		for(int i=0; i<dp.length; i++) {
//			for(int j=0; j<dp[0].length; j++) {
//				dp[i][j] = -1;
//			}
//		}
//		
//		System.out.println(lcsTab(str1, str2));
		
//		int prices[] = {1, 5, 8, 9, 10, 17, 17 ,20};
//		int length[] = {1, 2, 3, 4, 5, 6, 7, 8};
//		int totRod = 8;
//		
//		System.out.println(rodCutting(prices, length, totRod));
		
//		int coins[] = {2, 3, 5, 6};
//		int change = 10;
//		System.out.println(coinChange(coins, change));
		
//		String str1 = "ABCDE";
//		String str2 = "ABGCE";
//		System.out.println(longestCommonSubstring(str1, str2));
		
//		int arr[] = {50, 3, 10, 7, 40, 80};
//		System.out.println(lis(arr));
		
//		String word1 = "intention";
//		String word2 = "execution";
//		System.out.println(editDistance(word1, word2));
		
//		String str1 = "pear";
//		String str2 = "sea";
//		System.out.println(stringConversion(str1, str2));
//		System.out.println(catalanRec(5));
		
		int n = 6;
//		int dp[] = new int[n+1];
//		System.out.println(catalanMem(n, dp));
//		System.out.println(catalanTab(n));
//		System.out.println(countBSTs(n));
		System.out.println(mountainRanges(n));
	}
}