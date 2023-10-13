public class Sorting {
	public static void selectionSort(int arr[]) {
		for(int i=0; i<arr.length-1; i++) {
			int idx = i;
			for(int j=i+1; j<arr.length; j++) {
				if(arr[idx] > arr[j]) {
					idx = j;
				}
			}
			
			int temp = arr[idx];
			arr[idx] = arr[i];
			arr[i] = temp;
		}
	}
	
	public static void bubbleSort(int arr[]) {
		for(int i=0; i<arr.length-1; i++) {
			for(int j=0; j<arr.length-1-i; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	
	public static void insertionSort(int arr[]) {
		for(int i=1; i<arr.length; i++) {
			int key = arr[i];
			int prev = i-1;
			
			while(prev >= 0 && arr[prev] > key) {
				arr[prev+1] = arr[prev];
				prev--;
			}
			
			arr[prev+1] = key;
		}
	}
	
	public static void selectionSortDec(int arr[]) {
		for(int i=0; i<arr.length-1; i++) {
			int idx = i;
			for(int j=i+1; j<arr.length; j++) {
				if(arr[idx] < arr[j]) {
					idx = j;
				}
			}
			
			int temp = arr[idx];
			arr[idx] = arr[i];
			arr[i] = temp;
		}
	}
	
	public static void bubbleSortDec(int arr[]) {
		for(int i=0; i<arr.length-1; i++) {
			for(int j=0; j<arr.length-1-i; j++) {
				if(arr[j] < arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	
	public static void insertionSortDec(int arr[]) {
		for(int i=1; i<arr.length; i++) {
			int key = arr[i];
			int prev = i-1;
			
			while(prev >= 0 && arr[prev] < key) {
				arr[prev+1] = arr[prev];
				prev--;
			}
			
			arr[prev+1] = key;
		}
	}
	
	public static void countingSort(int arr[]) {
		int range = Integer.MIN_VALUE;
		for(int i=0; i<arr.length; i++) {
			range = Math.max(range, arr[i]);
		}
		
		int count[] = new int[range+1];
		
		for(int i=0; i<arr.length; i++) {
			count[arr[i]]++;
		}
		
		int j = 0;
		for(int i=0; i<count.length; i++) {
			while(count[i] > 0) {
				arr[j] = i;
				count[i]--;
				j++;
			}
		}
	}
	
	public static void printArr(int arr[]) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String args[]) {
		int arr[] = {1, 3, 5, 3, 6, 7};
		
		//bubbleSortDec(arr);
		//selectionSortDec(arr);
		//insertionSortDec(arr);
		countingSort(arr);
		printArr(arr);
	}
}