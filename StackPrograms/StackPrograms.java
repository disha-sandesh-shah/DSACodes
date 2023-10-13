import java.util.*;

public class StackPrograms {
//		static ArrayList<Integer> stack = new ArrayList<>();
//		
//		//isEmpty
//		public static boolean isEmpty() {
//			return stack.size() == 0;
//		}
//		
//		//push
//		public static void push(int data) {
//			stack.add(data);
//		}
//		
//		//pop
//		public static int pop() {
//			if(isEmpty()) {
//				return -1;
//			}
//			
//			int top = stack.get(stack.size()-1);
//			stack.remove(stack.size()-1);
//			return top;
//		}
//		
//		//peek
//		public static int peek() {
//			if(isEmpty()) {
//				return -1;
//			}
//			
//			return stack.get(stack.size()-1);
//		}
		
//		static class Node {
//			int data;
//			Node next;
//			
//			public Node(int data) {
//				this.data = data;
//				this.next = null;
//			}
//		}
//		
//		static class Stack {
//			public static Node head;
//			
//			//isEmpty
//			public static boolean isEmpty() {
//				return head == null;
//			}
//			
//			//push
//			public static void push(int data) {
//				Node newNode = new Node(data);
//				
//				if(isEmpty()) {
//					head = newNode;
//					return;
//				}
//				
//				newNode.next = head;
//				head = newNode;
//			}
// 			
//			
//			//pop
//			public static int pop() {
//				if(isEmpty()) {
//					return -1;
//				}
//				
//				int top = head.data;
//				head = head.next;
//				return top;
//			}
//			
//			//peek
//			public static int peek() {
//				if(isEmpty()) {
//					return -1;
//				}
//				
//				return head.data;
//			}
//		}
	
	public static void pushAtBottom(Stack<Integer> s, int data) {
		if(s.isEmpty()) {
			s.push(data);
			return;
		}
		
		int top = s.pop();
		pushAtBottom(s, data);
		s.push(top);
	}
	
	public static String reverseString(String str) {
		Stack<Character> s = new Stack<>();
		
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			s.push(ch);
		}
		
		StringBuilder sb = new StringBuilder();
		while(!s.isEmpty()) {
			char ch = s.pop();
			sb.append(ch);
		}
		
		return sb.toString();
	}
	
	public static void reverseStack(Stack<Integer> s) {
		if(s.isEmpty()) {
			return;
		}
		
		int top = s.pop();
		reverseStack(s);
		pushAtBottom(s, top);
	}
	
	public static boolean isValid(String str) {
		Stack<Character> s = new Stack<>();
		
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			
			//opening
			if(ch == '{' || ch == '[' || ch == '(') {
				s.push(ch);
			}
			
			//closing if-else
			else {
				if(s.isEmpty()) {
					return false;
				}
				
				if((s.peek() == '{' && ch == '}') ||
					(s.peek() == '[' && ch == ']') ||
					(s.peek() == '(' && ch == ')')) {
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
			
			//closing
			if(ch == ')') {
				int idx = 0;
				while(s.pop() != '(') {
					idx++;
				}
				if(idx < 1) {
					return true;
				}
			} else {//opening
				s.push(ch);
			}
		}
		
		return false;
	}
	
	public static int maxArea(int arr[]) {
		int maxArea = 0;
		int nsr[] = new int[arr.length];
		int nsl[] = new int[arr.length];
		
		//next smaller right
		Stack<Integer> s = new Stack<>();
		
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
		
		//next smaller left
        s = new Stack<>();
		
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
		
		//cal area (width = nsr[i]-nsl[i]-1)
		for(int i=0; i<arr.length; i++) {
			int height = arr[i];
			int width = nsr[i] - nsl[i] - 1;
			int currArea = height * width;
			maxArea = Math.max(maxArea, currArea);
		}
		
		return maxArea;
	}
	
	public static void main(String args[]) {
//		Stack<Integer> s = new Stack<>();
//		s.push(1);
//		s.push(2);
//		s.push(3);
//		//pushAtBottom(s, 4);
//		
//		reverseStack(s);
//		
//		while(!s.isEmpty()) {
//			System.out.println(s.peek());
//			s.pop();
//		}
		
		//System.out.println(reverseString("disha"));
		
//		int arr[] = {6, 8, 0, 1, 3};
//		
//		int nxtGreater[] = new int[arr.length];
//		
//		Stack<Integer> s = new Stack<>();
//		
//		for(int i=arr.length-1; i>=0; i--) {
//			//while
//			while(!s.isEmpty() && arr[s.peek()] <= arr[i]) {
//				s.pop();
//			}
//			
//			//if-else
//			if(s.isEmpty()) {
//				nxtGreater[i] = -1;
//			} else {
//				nxtGreater[i] = arr[s.peek()];
//			}
//			
//			//push
//			s.push(i);
//		}
//		
//		for(int i=0; i<arr.length; i++) {
//			System.out.print(nxtGreater[i] + " ");
//		}
//		System.out.println();
		
		//System.out.println(isDuplicate("(a*b)"));
		
		int arr[] = {2, 4};
		System.out.println(maxArea(arr));
	}
}