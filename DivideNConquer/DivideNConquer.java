public class DivideNConquer {
	public static void quickSort(int arr[], int si, int ei) {
		//base case
		if(ei >= si) {
			return;
		}
		
		//work
		int pIdx = partition(arr, si, ei);
		
		quickSort(arr, si, pIdx-1);
		quickSort(arr, pIdx+1, ei);
	}
	
	public static int partition(int arr[], int si, int ei) {
		int pivot = arr[ei];
		int i = si-1;
		
		for(int j=si; j<ei; j++) {
			if(arr[j] <= pivot) {
				i++;
				//swap
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		
		i++;
		int temp = pivot;
		arr[ei] = arr[i];
		arr[i] = temp;
		
		return i;
	}
	
	public static void mergeSort(int arr[], int si, int ei) {
		//base case
		if(si >= ei) {
			return;
		}
		
		//work
		int mid = si + (ei-si)/2;
		
		mergeSort(arr, si, mid);
		mergeSort(arr, mid+1, ei);
		
		merge(arr, si, mid, ei);
	}
	
	public static void merge(int arr[], int si, int mid, int ei) {
		int temp[] = new int[ei-si+1];
		int i = si;
		int j = mid+1;
		int k = 0;
		
		while(i <= mid && j <= ei) {
			if(arr[i] < arr[j]) {
				temp[k] = arr[i];
				i++;
			} else {
				temp[k] = arr[j];
				j++;
			}
			k++;
		}
		
		while(i <= mid) {
			temp[k++] = arr[i++];
		}
		
		while(j <= ei) {
			temp[k++] = arr[j++];
		}
		
		for(k=0, i=si; k < temp.length; k++, i++) {
			arr[i] = temp[k];
		}
	}
	
	public static int search(int arr[], int key) {
		int si = 0;
		int ei = arr.length-1;
		
		while(si <= ei) {
			int mid = si + (ei-si)/2;
			if(arr[mid] == key) {
				return mid;
			}
			
			if(arr[si] <= arr[mid]) { //On L1
				if(arr[si] <= key && key <= arr[mid]) { // Left of L1
					ei = mid - 1;
				} else { // Right of L1
					si = mid + 1;
				}
			} else { // On L2
				if(arr[mid] <= key && key <= arr[ei]) { // Right of L2
					si = mid + 1;
				} else { // Left of L2
					ei = mid - 1;
				}
			}
		}
		
		return -1;
	}
	
	public static int recSearch(int arr[], int key, int si, int ei) {
		//Base case
		if(si > si) {
			return -1;
		}
		
		//Work
		int mid = si + (ei-si)/2;
		
		if(arr[mid] == key) {
			return mid;
		}
		
		if(arr[si] <= arr[mid]) {
			if(arr[si] <= key && key <= arr[mid]) {
				return recSearch(arr, key, si, mid-1);
			} else {
				return recSearch(arr, key, mid+1, ei);
			}
		} else {
			if(arr[mid] <= key && key <= arr[ei]) {
				return recSearch(arr, key, mid+1, ei);
			} else {
				return recSearch(arr, key, si, mid-1);
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
		int arr[] = {6, 3, 9, 8, 2, 5};
		quickSort(arr, 0, arr.length-1);
		printArr(arr);
		//System.out.println(recSearch(arr, 3, 0, arr.length-1));
	}
}