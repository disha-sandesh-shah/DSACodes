import java.util.*;

public class Arrays {
	
	//Linear Search
	public static int linearSearch(int arr[], int key) {
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == key) {
				return i;
			}
		}
		return -1;
	}
	
	//Find largest in an Array
	public static int findLargest(int arr[]) {
		int largest = Integer.MIN_VALUE;
		
		for(int i=0; i<arr.length; i++) {
			largest = Math.max(largest, arr[i]);
			//if(arr[i] > largest) {
			//	largest = arr[i];
			//}
		}
		
		return largest;
	}
	
	//Binary Search
	public static int binarySearch(int arr[], int key) {
		int start = 0;
		int end = arr.length-1;
		
		while(start <= end) {
			int mid = start + (end-start)/2;
			
			if(arr[mid] == key) {
				return mid;
			}
			if(arr[mid] < key) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		
		return -1;
	}
	
	//Reverse An Array
	public static void reverse(int arr[]) {
		int first = 0;
		int last = arr.length-1;
		
		while(first < last) {
			int temp  = arr[first];
			arr[first] = arr[last];
			arr[last] = temp;
			
			first++;
			last--;
		}
	}
	
	//Print Array
	public static void printArray(int arr[]) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	//Print All Pairs(All pairs = n*(n-1)/2)
	public static void printPairs(int arr[]) {
		for(int i=0; i<arr.length; i++) {
			for(int j=i+1; j<arr.length; j++) {
				System.out.print("[" + arr[i] + "," + arr[j] + "]");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	//Print all Subarrays(All subarrays = n*(n+1)/2)
	public static void printSubarrays(int arr[]) {
		for(int i=0; i<arr.length; i++) {
			for(int j=i; j<arr.length; j++) {
				for(int k=i; k<=j; k++) {
					System.out.print(arr[k] + " ");
				}
				System.out.println();
			}
			System.out.println();
		}
	}
	
	//maximum Subarray Sum(Brute Force)
	public static int maxSubarraySum(int arr[]) {
		int maxSum = 0;
		for(int i=0; i<arr.length; i++) {
			for(int j=i; j<arr.length; j++) {
				int sum = 0;
				for(int k=i; k<=j; k++) {
					sum += arr[k];
				}
				maxSum = Math.max(maxSum, sum);
			}
		}
		
		return maxSum;
	}
	
	//Maximum Subarray Sum(Better)
	public static int maxSubarraySum2(int arr[]) { // prefix sum
		int currSum = 0;
		int maxSum = Integer.MIN_VALUE;
		
		int prefix[] = new int[arr.length];
		prefix[0] = arr[0];
		
		for(int i=1; i<prefix.length; i++) {
			prefix[i] = arr[i] + prefix[i-1];
		}
		
		for(int i=0; i<arr.length; i++) {
			for(int j=i; j<arr.length; j++) {
				currSum = i==0 ? prefix[j] : prefix[j] - prefix[i-1];
				maxSum = Math.max(maxSum, currSum);
			}
		}
		
		return maxSum;
	}
	
	//Maximum Subarray Sum(Optimized)
	public static int maxSubarraySum3(int arr[]) { // Kadane's Algo
		int currSum = 0;
		int maxSum = Integer.MIN_VALUE;
		
		for(int i=0; i<arr.length; i++) {
			currSum += arr[i];
			
			currSum = Math.max(currSum, 0);
			
			maxSum = Math.max(currSum, maxSum);
		}
		
		return maxSum;
	}
	
	//Trapping Rainwater
	public static int trappedRainwater(int arr[]) {
		//finding leftmax boundary
		int leftMax[] = new int[arr.length];
		leftMax[0] = arr[0];
		
		for(int i=1; i<arr.length; i++) {
			leftMax[i] = Math.max(arr[i], leftMax[i-1]);
		}
		
		//finding rightmax boundary
		int rightMax[] = new int[arr.length];
		rightMax[arr.length-1] = arr[arr.length-1];
		
		for(int i=arr.length-2; i>=0; i--) {
			rightMax[i] = Math.max(arr[i], rightMax[i+1]);
		}
		
		//loop
		int trappedWater = 0;
		
		for(int i=0; i<arr.length; i++) {
			//waterlevel = min(rightmax, leftmax)
			int waterLevel = Math.min(rightMax[i], leftMax[i]);
			
			//trappedWater = waterlevel - arr[i]
			trappedWater += waterLevel - arr[i];
		}
		
		return trappedWater;
	}
	
	//Best Time to Buy and Sell Stocks
	public static int buyAndSellStocks(int arr[]) {
		int maxProfit = 0;
		int buyPrice = Integer.MAX_VALUE;
		
		for(int i=0; i<arr.length; i++) {
			if(buyPrice < arr[i]) {
				int profit = arr[i] - buyPrice;
				maxProfit = Math.max(maxProfit, profit);
			} else {
				buyPrice = arr[i];
			}
		}
		
		return maxProfit;
	}
	
	/**************************PRACTICE**************************/
	
	public static boolean isTwice(int arr[]) {
		for(int i=0; i<arr.length; i++) {
			for(int j=i+1; j<arr.length; j++) {
				if(arr[i] == arr[j]) {
					return true;
				}
			} 
		}
		
		return false;
	}
	
	public static boolean isTwice2(int arr[]) {
		HashSet<Integer> set = new HashSet<>();
		
		for(int i=0; i<arr.length; i++) {
			if(set.contains(arr[i])) {
				return true;
			} else {
				set.add(arr[i]);
			}
		}
		
		return false;
	}
	
	public static int search(int nums[], int target) {
		int si = 0;
        int ei = nums.length-1;

        while(si <= ei) {
            int mid = si + (ei-si)/2;

            //target at mid
            if(nums[mid] == target) {
                return mid;
            }

            //case 1 : target on L1
            if(nums[si] <= nums[mid]) {
                //case a : left of mid
                if(nums[si] <= target && target <= nums[mid]) {
                    ei = mid-1;
                } else { //case b : right of mid
                    si = mid+1;
                }
            } else { //case 2 : target on L2
                //case c : right of mid
                if(nums[mid] <= target && target <= nums[ei]) {
                    si = mid+1;
                } else { //case d : left of mid
                    ei = mid-1;
                }
            }
        }

        return -1;
	}
	
	public static void main(String args[]) {
		int arr[] = {6, 7, 8, 1, 2, 3, 4, 5};
		
		//System.out.println(linearSearch(arr, 8));
		//System.out.println(findLargest(arr));
		//System.out.println(binarySearch(arr, 5));
		//printArray(arr);
		//reverse(arr);
		//printArray(arr);
		//printPairs(arr);
		//printSubarrays(arr);
		//System.out.println(maxSubarraySum3(arr));
		//System.out.println(trappedRainwater(arr));
		//System.out.println(buyAndSellStocks(arr));
		
		//System.out.println(isTwice2(arr));
		System.out.println(search(arr, 3));
	}
}