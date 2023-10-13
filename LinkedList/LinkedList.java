public class LinkedList {
	public static class Node {
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		} 
	}
	
	public static Node head;
	public static Node tail;
	public static int size;
	
	public void addFirst(int data) {
		Node newNode = new Node(data);
		size++;
		
		if(head == null) {
			head = tail = newNode;
			return;
		}
		
		newNode.next = head;
		head = newNode;
	}
	
	public void addLast(int data) {
		Node newNode = new Node(data);
		size++;
		
		if(head == null) {
			head = tail = null;
			return;
		}
		
		tail.next = newNode;
		tail = newNode;
	}
	
	public void print() {
		Node temp = head;
		
		while(temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.println("null");
	}
	
	public void add(int idx, int data) {
		if(idx == 0) {
			addFirst(data);
			return;
		}
		
		Node prev = head;
		int i = 0;
		
		while(i < idx-1) {
			prev = prev.next;
			i++;
		}
		
		Node newNode = new Node(data);
		size++;
		newNode.next = prev.next;
		prev.next = newNode;
	}
	
	public int removeFirst() {
		if(head == null) {
			System.out.println("LL is Empty");
			return Integer.MIN_VALUE;
		} else if(head.next == null) {
			int val = head.data;
			head = tail = null;
			size = 0;
			return val;
		}
		
		int val = head.data;
		head = head.next;
		size--;
		return val;
	}
	
	public int removeLast() {
		if(head == null) {
			System.out.println("LL is Empty");
			return Integer.MIN_VALUE;
		} else if(head.next == null) {
			int val = head.data;
			head = tail = null;
			size = 0;
			return val;
		}
		
		Node prev = head;
		int i = 0;
		while(i < size-2) {
			i++;
			prev = prev.next;
		}
		
		int val = tail.data;
		prev.next = null;
		tail = prev;
		return val;
	}
	
	public int remove(int idx) {
		if(idx == 0) {
			return removeFirst();
		}
		
		Node prev = head;
		int i = 0;
		
		while(i < idx-1) {
			i++;
			prev = prev.next;
		}
		
		int val = prev.next.data;
		prev.next = prev.next.next;
		size--;
		return val;
	}
	
	public int itrSearch(int key) {
		Node temp = head;
		int i = 0;
		
		
		while(temp != null) {
			if(temp.data == key) {
				return i;
			}
			
			i++;
			temp = temp.next;
		}
		
		return -1;
	}
	
	public int recSearch(int key) {
		return helper(head, key);
	}
	
	public int helper(Node head, int key) {
		if(head == null) {
			return -1;
		}
		
		if(head.data == key) {
			return 0;
		}
		
		int idx = helper(head.next, key);
		if(idx == -1) {
			return -1;
		}
		
		return idx+1;
	}
	
	public void removeNthFromEnd(int idx) {
		if(idx == size) {
			removeFirst();
		}
		
		Node prev = head;
		int i = 1;
		
		while(i < size-idx) {
			i++;
			prev = prev.next;
		}
		
		prev.next = prev.next.next;
		size--;
	}
	
	public Node findMid(Node head) {
		Node slow = head;
		Node fast = head;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
	}
	
	public boolean isPalindrome() {
		if(head == null || head.next == null) {
			return true;
		}
		
		Node midNode = findMid(head);
		
		Node prev = null;
		Node curr = midNode;
		Node next;
		
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		Node right = prev;
		Node left = head;
		
		while(right != null) {
			if(left.data != right.data) {
				return false;
			}
			
			left = left.next;
			right = right.next;
		}
		
		return true;
	}
	
	public boolean isCycle() {
		Node slow = head;
		Node fast = head;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow == fast) {
				return true;
			}
		}
		
		return false;
	}
	
	public void removeCycle() {
		//detect cycle
		Node slow = head;
		Node fast = head;
		boolean cycle = false;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next;
			
			if(slow == fast) {
				cycle = true;
				break;
			}
		}
		
		if(cycle == false) {
			return;
		}
		
		slow = head;
		Node prev = null;
		
		while(slow != fast) {
			prev = fast;
			slow = slow.next;
			fast = fast.next;
		}
		
		prev.next = null;
	}
	
	
	private Node getMid(Node head) {
		Node slow = head;
		Node fast = head.next;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow; //mid
	}
	
	private Node merge(Node head1, Node head2) {
		Node mergedLL = new Node(-1);
		Node temp = mergedLL;
		
		while(head1 != null && head2 != null) {
			if(head1.data <= head2.data) {
				temp.next = head1;
				head1 = head1.next;
				temp = temp.next;
			} else {
				temp.next = head2;
				head2 = head2.next;
				temp = temp.next;
			}
		} 
		
		while(head1 != null) {
			temp.next = head1;
			head1 = head1.next;
			temp = temp.next;
		}
		
		while(head2 != null) {
			temp.next = head2;
			head2 = head2.next;
			temp = temp.next;
		}
		
		return mergedLL.next;
	}
	
	public Node mergeSort(Node head) {
		if(head == null || head.next == null) {
			return head;
		}
		
		//get midNode
		Node mid = getMid(head);
		
		//left and right mergeSort
		Node rightHead = mid.next;
		mid.next = null;
		
		Node left = mergeSort(head);
		Node right = mergeSort(rightHead);
		
		//merge
		return merge(left, right);
		
	}
	
	public void zigZag() {
		Node mid = getMid(head);
		
		Node curr = mid.next;
		mid.next = null;
		Node prev = null;
		Node next;
		
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
//		prev.next = null;
		
		Node rightHead = prev;
		Node leftHead = head;
		Node nextL, nextR;
		
		while(leftHead != null && rightHead != null) {
			nextL = leftHead.next;
			leftHead.next = rightHead;
			nextR = rightHead.next;
			rightHead.next = nextL;
			
			rightHead = nextR;
			leftHead = nextL;
		}
	}
	
	public void deleteNAfterM(int m, int n) {
		Node curr = head;
		Node prev = null;
		int i = 0;
		int j;
		
		while(curr != null) {
			while(i < m) {
				i++;
				prev = curr;
				curr = curr.next;
			}
			j = 0;
			while(j < n) {
				j++;
				curr = curr.next;
			}
			prev.next = curr;
			i = 0;
		}
	}
	
	public void swap(int key1, int key2) {
		Node temp1 = head;
		Node temp2 = head;
		Node prev1 = null;
		Node prev2 = null;
		
		while(temp1 != null) {
			if(temp1.data != key1) {
				prev1 = temp1;
				temp1 = temp1.next;
			} else {
				break;
			}
		}
		
		while(temp2 != null) {
			if(temp2.data != key2) {
				prev2 = temp2;
				temp2 = temp2.next;
			} else {
				break;
			}
		}
		
		Node temp = temp2.next;
		prev1.next = temp2;
		temp2.next = temp1.next;
		prev2.next = temp1;
		temp1.next = temp;
	}
	
	
	public static void main(String args[]) {
		LinkedList ll = new LinkedList();
//		ll.print();
		//System.out.println(ll.checkPalindrome());
		ll.addFirst(5);
		ll.addFirst(3);
		ll.addFirst(2);
		ll.addFirst(1);
//		ll.add(2, 5);
		
//		ll.print();
		ll.swap(2, 5);
		ll.print();
		//System.out.println(ll.recSearch(10));
		//ll.removeNthFromEnd(3);
		//ll.print();
		//System.out.println(ll.isPalindrome());
		//System.out.println(ll.isCycle());
		//ll.removeCycle();
		//System.out.println(ll.isCycle());
		
		//ll.print();
		//ll.head = ll.mergeSort(ll.head);
		//ll.print();
		
//		ll.print();
//		ll.zigZag();
//		ll.print();
		
//		ll.deleteNAfterM(2, 2);
//		ll.print();
	}
}