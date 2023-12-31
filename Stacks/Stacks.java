import java.util.*;

public class Stacks {
	static class StackArr {
		static ArrayList<Integer> arr = new ArrayList<>();
		
		public static boolean isEmpty() {
			return arr.size() == 0;
		}
		
		public static void push(int data) {
			arr.add(data);
		}
		
		public static int pop() {
			int top = arr.get(arr.size()-1);
			arr.remove(arr.size()-1);
			return top;
		}
		
		public static int peek() {
			return arr.get(arr.size()-1);
		}
	}
	
	static class Node {
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	static class StackLL {
		static Node head = null;
		
		public static boolean isEmpty() {
			return head == null;
		}
		
		public static void push(int data) {
			Node newNode = new Node(data);
			if(head == null) {
				head = newNode;
				return;
			}
			
			newNode.next = head;
			head = newNode;
		}
		
		public static int pop() {
			if(head == null) {
				return -1;
			}
			
			int top = head.data;
			head = head.next;
			return top;
		}
		
		public static int peek() {
			if(head == null) {
				return -1;
			}
			
			return head.data;
		}
	}
	
	public static void pushAtBottom(Stack<Integer> s, int data) {
		if(s.isEmpty()) {
			s.push(data);
			return;
		}
		
		int top = s.pop();
		pushAtBottom(s, data);
		s.push(top);
	}
	
	public static String reverseStr(String str) {
		Stack<Character> s = new Stack<>();
		
		for(int i=0; i<str.length(); i++) {
			s.push(str.charAt(i));
		}
		
		StringBuilder ans = new StringBuilder("");
		
		while(!s.isEmpty()) {
			ans.append(s.pop());
		}
		
		return ans.toString();
	}
	
	public static void reverseStack(Stack<Integer> s) {
		if(s.isEmpty()) {
			return;
		}
		
		int top = s.pop();
		reverseStack(s);
		pushAtBottom(s, top);
	}
	
	public static int[] nextGreater(int arr[]) {
		Stack<Integer> s = new Stack<>();
		int nxtGreater[] = new int[arr.length];
		
		for(int i=arr.length-1; i>=0; i--) {
			while(!s.isEmpty() && arr[s.peek()] <= arr[i]) {
				s.pop();
			}
			
			if(s.isEmpty()) {
				nxtGreater[i] = -1;
			} else {
				nxtGreater[i] = arr[s.peek()];
			}
			
			s.push(i);
		}
		
		return nxtGreater;
	}
	
	public static int[] stockSpan(int stocks[]) {
		int span[] = new int[stocks.length];
		Stack<Integer> s = new Stack<>();
		
		span[0] = 1;
		s.push(0);
		
		for(int i=1; i<span.length; i++) {
			while(!s.isEmpty() && stocks[s.peek()] <= stocks[i]) {
				s.pop();
			}
			
			if(s.isEmpty()) {
				span[i] = i+1;
			} else {
				span[i] = i-s.peek();
			}
			
			s.push(i);
		}
		
		return span;
	}
	
	public static boolean isValid(String str) {
		Stack<Character> s = new Stack<>();
		
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			
			if(ch == '(' || ch == '{' || ch == '[') {
				s.push(ch);
			} else {
				if(s.isEmpty()) {
					return false;
				}
				
				if((s.peek() == '(' && ch == ')')
						|| (s.peek() == '{' && ch == '}')
						|| (s.peek() == '[' && ch == ']')) {
					s.pop();
				} else {
					return false;
				}
			}
		}
		
		if(s.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isDuplicate(String str) {
		Stack<Character> s = new Stack<>();
		
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			
			if(ch == ')') {
				int count = 0;
				while(s.pop() != '(') {
					count++;
				}
				
				if(count == 0) {
					return true;
				}
			} else {
				s.push(ch);
			}
		}
		
		return false;
	}
	
	public static int maxArea(int arr[]) {
		int maxArea = 0;
		int nsl[] = new int[arr.length];
		int nsr[] = new int[arr.length];
		
		Stack<Integer> s = new Stack<>();
		for(int i=0; i<arr.length; i++) {
			while(!s.isEmpty() && arr[s.peek()] >= arr[i]) {
				s.pop();
			}
			
			if(s.isEmpty()) {
				nsl[i] = -1;
			} else {
				nsl[i] = s.peek();
			}
			s.push(i);
		}
		
		s = new Stack<>();
		for(int i=arr.length-1; i>=0; i--) {
			while(!s.isEmpty() && arr[s.peek()] >= arr[i]) {
				s.pop();
			}
			
			if(s.isEmpty()) {
				nsr[i] = arr.length;
			} else {
				nsr[i] = s.peek();
			}
			s.push(i);
		}
		
		for(int i=0; i<arr.length; i++) {
			int ht = arr[i];
			int wd = nsr[i] - nsl[i] - 1;
			
			int currArea = ht * wd;
			maxArea = Math.max(maxArea, currArea);
		}
		
		return maxArea;
	}
	
	public static void main(String args[]) {
//		StackLL s = new StackLL();
//		s.push(1);
//		s.push(2);
//		s.push(3);
//		
//		while(!s.isEmpty()) {
//			System.out.println(s.peek());
//			s.pop();
//		}
		
//		Stack<Integer> s = new Stack<>();
//		s.push(1);
//		s.push(2);
//		s.push(3);
//		
//		pushAtBottom(s, 4);
//		while(!s.isEmpty()) {
//			System.out.println(s.peek());
//			s.pop();
//		}
			
//		System.out.println(reverseStr("dishashah"));
		
//		Stack<Integer> s = new Stack<>();
//		s.push(1);
//		s.push(2);
//		s.push(3);
//		
//		reverseStack(s);
//		while(!s.isEmpty()) {
//			System.out.println(s.peek());
//			s.pop();
//		}
		
//		int arr[] = {6, 8, 1, 0, 3};
//		
//		int nxtGreater[] = nextGreater(arr);
//		for(int i=0; i<nxtGreater.length; i++) {
//			System.out.print(nxtGreater[i] + " ");
//		}
//		System.out.println();
		
//		int stocks[] = {6, 8, 1, 0, 11};
//		
//		int span[] = stockSpan(stocks);
//		for(int i=0; i<span.length; i++) {
//			System.out.print(span[i] + " ");
//		}
//		System.out.println();
		
//		String str = "{}()([])";
//		System.out.println(isValid(str));
		
//		String str = "(a+b)";
//		System.out.println(isDuplicate(str));
		
		int arr[] = {2, 1, 5, 6, 2, 3};
		System.out.println(maxArea(arr));
	}
}