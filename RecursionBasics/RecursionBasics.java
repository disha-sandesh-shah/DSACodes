import java.util.*;
class RecursionBasics {
	//Function to print numbers 1 to n in decreasing order
	public static void printDec(int n) {
		//base case
		if(n == 1) {
			System.out.println(n);
			return;
		}
		
		//work
		System.out.print(n + " ");
		printDec(n-1);
	}
	
	//Function to print numbers 1 to n in increasing order
	public static void printInc(int n) {
		//base case
		if(n == 1) {
			System.out.print(n + " ");
			return;
		}
		
		//work
		printInc(n-1);
		System.out.print(n + " ");
	}
	
	//Function to find factorial of n
	public static int factorial(int n) {
		//base case
		if(n == 0) {
			return 1;
		}
		
		//work
		return n * factorial(n-1);
	}
	
	//Function to find sum upto n
	public static int sumUptoN(int n) {
		//base case
		if(n == 1) {
			return 1;
		}
		
		//work
		return n + sumUptoN(n-1);
	}
	
	//Function to find nth fibonacci number(starting index = 0)
	public static int fib(int n) {
		//base case
		if(n == 0 || n == 1) {
			return n;
		}
		
		//work
		return fib(n-1) + fib(n-2);
	}
	
	//Function to find nth fibonacci number(starting index = 1)
	public static int fib2(int n) {
		//Base case
		if(n == 1 || n == 2) {
			return n-1;
		}
		
		//Work
		return fib2(n-1) + fib2(n-2);
	}
	
	//Function to find ways in which one can arrange 2x2 tiles in 2xn area
	public static int tilingProblem(int n) {
		//base case
		if(n == 0 || n == 1) {
			return 1;
		}
		
		//work
		return tilingProblem(n-1) + tilingProblem(n-2);
	}
	
	//Function to find whether the array is sorted or not
	public static boolean isSorted(int arr[], int i) {
		//base case
		if(i == arr.length-1) {
			return true;
		}
		
		//work
		if(arr[i] > arr[i+1]) {
			return false;
		}
		
		return isSorted(arr, i+1);
	}
	
	//Function to find first occurrence of key in an array
	public static int firstOccurence(int arr[], int i, int key) {
		//base case
		if(i == arr.length) {
			return -1;
		}
		
		//work
		if(arr[i] == key) {
			return i;
		}
		
		return firstOccurence(arr, i+1, key);
	}
	
	//Function to find first occurrence of key in an array
	public static int lastOccurence(int arr[], int i, int key) {
		//base case
		if(i == arr.length) {
			return -1;
		}
		
		//work
		int found = lastOccurence(arr, i+1, key);
		
		if(found == -1 && arr[i] == key) {
			return i;
		}
		
		return found;
	}
	
	//Function to find power of a to the n
	public static int power(int a, int n) {
		//base case
		if(n == 0) {
			return 1;
		}
		
		//work
		return a * power(a, n-1);
	}
	
	//Optimized power function
	public static int powerOpt(int a, int n) {
		//base case
		if(n == 0) {
			return 1;
		}
		
		//work
		int halfPower = powerOpt(a, n/2);
		int halfPowerSq = halfPower * halfPower;
		
		if(n % 2 != 0) {
			halfPowerSq = a * halfPowerSq;
		}
		
		return halfPowerSq;
	}
	
	//Function to remove duplicate characters in the string
	public static void removeDuplicates(String str, int i, boolean map[], StringBuilder newStr) {
		//base case
		if(i == str.length()) {
			System.out.println(newStr);
			return;
		}
		
		//work
		char currChar = str.charAt(i);
		if(map[currChar-'a'] == true) {
			removeDuplicates(str, i+1, map, newStr);
		} else {
			map[currChar-'a'] = true;
			removeDuplicates(str, i+1, map, newStr.append(currChar));
		}
	} 
	
	//Function to find ways of friends to remain single or in pair
	public static int friendsPairing(int n) {
		//base case
		if(n == 1 || n == 2) {
			return n;
		}
		
		//work
		return friendsPairing(n-1) + (n-1) * friendsPairing(n-2);
	}
	
	public static void printBinStrings(int n, int lastPlace, String newStr) {
		//base case
		if(n == 0) {
			System.out.println(newStr);
			return;
		}
		
		//work
		printBinStrings(n-1, 0, newStr + "0");
		
		if(lastPlace == 0) {
			printBinStrings(n-1, 1, newStr + "1");
		}
		
	}
	
	public static ArrayList<Integer> findOccurrences(int arr[], int key, int i, ArrayList<Integer> list) {
		//Base case
		if(i == arr.length) {
			return list;
		}
		
		//Work
		if(arr[i] == key) {
			list.add(i);
			//return findOccurrences(arr, key, i+1, list);
		}
		
		return findOccurrences(arr, key, i+1, list);
 	}
	
	public static String[] str = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eigth", "Nine"};
	
//	public static String getNumber(int num, String s) {
//		//Base case
//		if(num == 0) {
//			return s;
//		}
//		
//		//Work
//		int rem = num % 10;
//		s += str[rem];
//		return getNumber(num/10, s);
//		
//	}
	
	public static void main(String args[]) {
		//printDec(10);
		//printInc(10);
		//System.out.println(factorial(5));
		//System.out.println(sumUptoN(5));
		//System.out.println(fib(5));
		//System.out.println(tilingProblem(5));
		
		int arr[] = {1, 2, 5, 3, 4, 5, 5, 5};
		//System.out.println(isSorted(arr, 0));
		//System.out.println(firstOccurence(arr, 0, 5));
		//System.out.println(lastOccurence(arr, 0, 5));
		//System.out.println(power(2, 5));
		//System.out.println(powerOpt(2, 5));
		//removeDuplicates("dishashah", 0, new boolean[26], new StringBuilder());
		//System.out.println(friendsPairing(4));
		//printBinStrings(3, 0, new String());
		System.out.println(findOccurrences(arr, 5, 0, new ArrayList<>()));
		//System.out.println(getNumber(2019, ""));
	}
}