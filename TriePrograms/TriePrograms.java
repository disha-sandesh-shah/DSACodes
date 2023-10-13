public class TriePrograms {
	static class Node {
		Node[] children = new Node[26];
		boolean eow = false;
		int freq;
		
		public Node() {
			for(int i=0; i<26; i++) {
				children[i] = null;
			}
			freq = 1;
		}
	}
	
	public static Node root = new Node();
	
	public static void insert(String word) {
		Node curr = root;
		
		for(int i=0; i<word.length(); i++) {
			int idx = word.charAt(i)-'a'; 
			if(curr.children[idx] == null) {
				curr.children[idx] = new Node();
			} else {
				curr.children[idx].freq++;
			}
			
			curr = curr.children[idx];
		}
		
		curr.eow = true;
	}
	
	public static boolean search(String key) {
		Node curr = root;
		
		for(int i=0; i<key.length(); i++) {
			int idx = key.charAt(i)-'a'; 
			if(curr.children[idx] == null) {
				return false;
			}
			
			curr = curr.children[idx];
		}
		
		return curr.eow == true;
	}
	
	public static boolean startWith(String prefix) {
		Node curr = root;
		
		for(int i=0; i<prefix.length(); i++) {
			int idx = prefix.charAt(i)-'a'; 
			if(curr.children[idx] == null) {
				return false;
			}
			
			curr = curr.children[idx];
		}
		
		return true;
	}
	
	public static void findPrefix(Node root, String ans) {
		if(root == null) {
			return;
		}
		
		if(root.freq == 1) {
			System.out.println(ans);
			return;
		}
		
		for(int i=0; i<root.children.length; i++) {
			if(root.children[i] != null) {
				findPrefix(root.children[i], ans+(char)(i+'a'));
			}
		}
	}
	
	
	public static boolean wordBreak(String key) {
		if(key.length() == 0) {
			return true;
		}
		
		for(int i=1; i<=key.length(); i++) {
			if(search(key.substring(0, i)) && wordBreak(key.substring(i))) {
				return true;
			}
		}
		
		return false;
	}
	
	public static int countNodes(Node root) {
		if(root == null) {
			return 0;
		}
		
		int count = 0;
		for(int i=0; i<26; i++) {
			if(root.children[i] != null) {
				count += countNodes(root.children[i]);
			}
		}
		
		return count+1;
	}
	
	public static String ans = "";
	
	public static void findLargest(Node root, StringBuilder temp) {
		if(root == null) {
			return;
		}
		
		for(int i=0; i<26; i++) {
			if(root.children[i] != null && root.children[i].eow == true) {
				char ch = (char)('a'+i);
				temp.append(ch);
				if(temp.length() > ans.length()) {
					ans = temp.toString();
				}
				
				findLargest(root.children[i], temp);
				temp = temp.deleteCharAt(temp.length()-1);
			}
		}
	}
	
	public static void main(String args[]) {
	    String words[] = {"ab", "ac", "ad"};
		root.freq = -1;
		for(int i=0; i<words.length; i++) {
			insert(words[i]);
		}
//		
//		String key = "ilovesamsung";
//		
//		//System.out.println(startWith("z"));
//		//findPrefix(root, "");
//		System.out.println(wordBreak(key));
		
//		String word = "apple";
//		
//		for(int i=0; i<word.length(); i++) {
//			String suffix = word.substring(i);
//			insert(suffix);
//		}
//		
//		int count = countNodes(root);
//		
//		System.out.println(count);
		
		findLargest(root, new StringBuilder(""));
		System.out.println(ans);
		
	}
}