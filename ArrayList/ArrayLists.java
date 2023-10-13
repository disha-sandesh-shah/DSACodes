import java.util.*;

public class ArrayLists {
	public static int getMax(ArrayList<Integer> list) {
		int max = Integer.MIN_VALUE;
		
		for(int i=0; i<list.size(); i++) {
			max = Math.max(max, list.get(i));
		}
		
		return max;
	}
	
	public static void reverse(ArrayList<Integer> list) {
		for(int i=list.size()-1; i>=0; i--) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
	}
	 
	public static void swap(ArrayList<Integer> list, int idx1, int idx2) {
		int temp = list.get(idx1);
		list.set(idx1, list.get(idx2));
		list.set(idx2, temp);
	}
	
	public static int storedWater(ArrayList<Integer> list) {
		int maxWater = 0;
		int lp = 0;
		int rp = list.size()-1;
		
		while(lp < rp) {
			int height = Math.min(list.get(lp), list.get(rp));
			int width = rp - lp;
			int currWater = height * width;
			maxWater = Math.max(maxWater, currWater);
			
			if(list.get(lp) < list.get(rp)) {
				lp++;
			} else {
				rp--;
			}
		}
		
		return maxWater;
	}
	
	public static boolean pairSum1(ArrayList<Integer> list, int target) {
		int lp = 0;
		int rp = list.size()-1;
		
		while(lp != rp) {
			if(list.get(lp) + list.get(rp) == target) {
				return true;
			}
			
			if(list.get(lp) + list.get(rp) < target) {
				lp++;
			} else {
				rp--;
			}
		}
		
		return false;
	}
	
	public static boolean pairSum2(ArrayList<Integer> list, int target) {
		int bp = -1;
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i) > list.get(i+1)) {
				bp = i;
				break;
			}
		}
		
		int lp = bp + 1;
		int rp = bp;
		int n = list.size();
		
		while(lp != rp) {
			if(list.get(lp) + list.get(rp) == target) {
				return true;
			}
			
			if(list.get(lp) + list.get(rp) < target) {
				lp = (lp + 1) % n;
			} else {
				rp = (n + rp - 1) % n;
			}
		}
		
		return false;
	}
	
	/****************************PRACTICE****************************/
	
	public static boolean isMonotonic(ArrayList<Integer> arr) {
		boolean isDec = true;
		boolean isInc = true;
		
		for(int i=0; i<arr.size()-1; i++) {
			if(arr.get(i) < arr.get(i+1)) {
				isDec = false;
			}
			
			if(arr.get(i) > arr.get(i+1)) {
				isInc = false;
			}
		}
		
		return isInc || isDec;
		
	}
	
	public static ArrayList<Integer> getLonely(ArrayList<Integer> list) {
		ArrayList<Integer> lonely = new ArrayList<>();
		
		for(int i=0; i<list.size(); i++) {
			boolean isLonely = true;
			
			for(int j=0; j<list.size(); j++) {
				if(j != i) {
					if((list.get(i) == list.get(j)) || (list.get(j) == list.get(i)+1) || (list.get(j) == list.get(i)-1)) {
						isLonely = false;
					} 
				}
			}
			
			if(isLonely == true) {
				lonely.add(list.get(i));
			}
		}
		
		return lonely;
	}
	
	public static void main(String args[]) {
		ArrayList<Integer> list = new ArrayList<>();
		
		list.add(1);
		list.add(3);
		list.add(5);
		list.add(3);		
		
		//System.out.println(getMax(list));
		//reverse(list);
		//swap(list, 1, 3);
		//System.out.println(list);
		//Collections.sort(list, Collections.reverseOrder());
		//System.out.println(list);
		//System.out.println(storedWater(list));
		//System.out.println(pairSum1(list, 16));
		//System.out.println(pairSum2(list, 40));
		System.out.println(getLonely(list));
		//System.out.println(isMonotonic(list));
		
		}
}