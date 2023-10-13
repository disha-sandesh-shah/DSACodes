import java.util.*;

public class GraphPrograms {
	static class Edge {
		int src;
		int dest;
		
		public Edge(int src, int dest) {
			this.src = src;
			this.dest = dest;
		}
	}
	
	public static void createGraph(ArrayList<Edge>[] graph) {
		for(int i=0; i<graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		
//		graph[0].add(new Edge(0, 2));
//		graph[1].add(new Edge(1, 0));
//		graph[2].add(new Edge(2, 3));
     	//graph[3].add(new Edge(3, 0));
		
		/*KOSARAJU ALGO*/
//		graph[0].add(new Edge(0, 2));
//		graph[0].add(new Edge(0, 3));
//		
//		graph[1].add(new Edge(1, 0));
//		
//		graph[2].add(new Edge(2, 1));
//		
//		graph[3].add(new Edge(3, 4));

		/*TARJAN'S ALGO TO FIND BRIDGE*/
//		graph[0].add(new Edge(0, 1));
//		graph[0].add(new Edge(0, 2));
//		graph[0].add(new Edge(0, 3));
//		
//		graph[1].add(new Edge(1, 0));
//		graph[1].add(new Edge(1, 2));
//		
//		graph[2].add(new Edge(2, 0));
//		graph[2].add(new Edge(2, 1));
//		
//		graph[3].add(new Edge(3, 0));
//		graph[3].add(new Edge(3, 4));
//		graph[3].add(new Edge(3, 5));
//		
//		graph[4].add(new Edge(4, 3));
//		graph[4].add(new Edge(4, 5));
//		
//		graph[5].add(new Edge(5, 4));
//		graph[5].add(new Edge(5, 3));
		
		/*TARJAN'S ALGO TO FIND ARTICULATION POINT*/
		graph[0].add(new Edge(0, 1));
     	graph[0].add(new Edge(0, 2));
		graph[0].add(new Edge(0, 3));
		
		graph[1].add(new Edge(1, 0));
		graph[1].add(new Edge(1, 2));
		
		graph[2].add(new Edge(2, 0));
		graph[2].add(new Edge(2, 1));
		
		graph[3].add(new Edge(3, 0));
		graph[3].add(new Edge(3, 4));
		
		graph[4].add(new Edge(4, 3));
	}
	
	public static void bfs(ArrayList<Edge>[] graph) {
		boolean vis[] = new boolean[graph.length];
		
		for(int i=0; i<graph.length; i++) {
			if(!vis[i]) {
				bfsUtil(graph, vis);
			}
		}
	}
	
	public static void bfsUtil(ArrayList<Edge>[] graph, boolean vis[]) {
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		
		while(!q.isEmpty()) {
			int curr = q.remove();
			
			if(!vis[curr]) {
				System.out.print(curr + " ");
				vis[curr] = true;
				for(int i=0; i<graph[curr].size(); i++) {
					Edge e = graph[curr].get(i);
					q.add(e.dest);
				}
			}
		}
	}
	
	public static void dfs(ArrayList<Edge>[] graph) {
		boolean vis[] = new boolean[graph.length];
		
		for(int i=0; i<graph.length; i++) {
			if(!vis[i]) {
				dfsUtil(graph, i, vis);
			}
		}
	}
	public static void dfsUtil(ArrayList<Edge>[] graph, int curr, boolean vis[]) {
		//visit
		System.out.print(curr + " ");
		vis[curr] = true;
		
		for(int i=0; i<graph[curr].size(); i++) {
			Edge e = graph[curr].get(i);
			if(!vis[e.dest]) {
				dfsUtil(graph, e.dest, vis);
			}
		}
	}
	
	public static void topSort(ArrayList<Edge>[] graph) {
		boolean vis[] = new boolean[graph.length];
		Stack<Integer> s = new Stack<>();
		
		for(int i=0; i<graph.length; i++) {
			if(!vis[i]) {
				topSortUtil(graph, i, vis, s);
			}
		}
		
		while(!s.isEmpty()) {
			System.out.print(s.pop() + " ");
		}
	}
	public static void topSortUtil(ArrayList<Edge>[] graph, int curr, boolean vis[], Stack<Integer> s) {
		//visit
		vis[curr] = true;
		
		for(int i=0; i<graph[curr].size(); i++) {
			Edge e = graph[curr].get(i);
			
			if(!vis[e.dest]) {
				topSortUtil(graph, e.dest, vis, s);
			}
		}
		
		s.add(curr);
	}
	
	public static boolean detectCycle(ArrayList<Edge>[] graph) {
		boolean vis[] = new boolean[graph.length];
		
		for(int i=0; i<graph.length; i++) {
			if(!vis[i]) {
				if(detectCycleUtil(graph, i, vis, -1)) {
					return true;
				}
			}
		}
		
		return false;
	}
	public static boolean detectCycleUtil(ArrayList<Edge>[] graph, int curr, boolean vis[], int par) {
		vis[curr] = true;
		
		for(int i=0; i<graph[curr].size(); i++) {
			Edge e = graph[curr].get(i);
			if(!vis[e.dest]) {
				if(detectCycleUtil(graph, e.dest, vis, curr)) {
					return true;
				}
			}
			if(vis[e.dest] && e.dest != par) {
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean isBipartite(ArrayList<Edge>[] graph) {
		int col[] = new int[graph.length];
		Queue<Integer> q = new LinkedList<>();
		for(int i=0; i<graph.length; i++) {
			col[i] = -1;
		}
		
		for(int i=0; i<graph.length; i++) {
			if(col[i] == -1) {
				if(isBipartiteUtil(graph, col, i, q)) {
					return true;
				}
			}
		}
		
		return false;
	}
	public static boolean isBipartiteUtil(ArrayList<Edge>[] graph, int col[], int curr, Queue<Integer> q) {
		q.add(curr);
		col[curr] = 0;
		
		while(!q.isEmpty()) {
			int c = q.remove();
			for(int i=0; i<graph[c].size(); i++) {
				Edge e = graph[c].get(i);
				if(col[e.dest] == -1) {
					int nextCol = col[c] == 0 ? 1 : 0;
					col[e.dest] = nextCol;
					q.add(e.dest);
				}
				
				if(col[e.dest] == col[c]) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public static boolean isCycle(ArrayList<Edge>[] graph) {
		boolean vis[] = new boolean[graph.length];
		boolean stack[] = new boolean[graph.length];
		
		for(int i=0; i<graph.length; i++) {
			if(!vis[i]) {
				if(isCycleUtil(graph, i, vis, stack)) {
					return true;
				}
			}
		}
		
		return false;
	}
	public static boolean isCycleUtil(ArrayList<Edge>[] graph, int curr, boolean vis[], boolean stack[]) {
		vis[curr] = true;
		stack[curr] = true;
		
		for(int i=0; i<graph[curr].size(); i++) {
			Edge e = graph[curr].get(i);
			
			if(stack[e.dest]) {
				return true;
			}
			
			if(!vis[e.dest] && isCycleUtil(graph, e.dest, vis, stack)) {
				return true;
			}
		}
		
		stack[curr] = false;
		return false;
	}
	
	public static void calcIndeg(ArrayList<Edge> graph[], int indeg[]) {
		for(int i=0; i<graph.length; i++) {
			for(int j=0; j<graph[i].size(); j++) {
				Edge e = graph[i].get(j);
				indeg[e.dest]++;
			}
		}
		
		for(int i=0; i<indeg.length; i++) {
			System.out.print(indeg[i] + " ");
		}
		System.out.println();
	}
	
	public static void topSortBfs(ArrayList<Edge> graph[]) {
		Queue<Integer> q = new LinkedList<>();
		int indeg[] = new int[graph.length];
		calcIndeg(graph, indeg);
		
		for(int i=0; i<indeg.length; i++) {
			if(indeg[i] == 0) {
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int curr = q.remove();
			System.out.print(curr + " ");
			
			for(int i=0; i<graph[curr].size(); i++) {
				Edge e = graph[curr].get(i);
				indeg[e.dest]--;
				
				if(indeg[e.dest] == 0) {
					q.add(e.dest);
				}
			}
		}
		
		System.out.println();
	}
	
	public static void printAllPaths(ArrayList<Edge> graph[], int src, int dest, String path) {
		if(src == dest) {
			System.out.println(path + src);
			return;
		}
		
		for(int i=0; i<graph[src].size(); i++) {
			Edge e = graph[src].get(i);
			printAllPaths(graph, e.dest, dest, path+src);
		}
	}
	
	public static void topSort(ArrayList<Edge> graph[], int curr, boolean vis[], Stack<Integer> s) {
		vis[curr] = true;
		
		for(int i=0; i<graph[curr].size(); i++) {
			Edge e = graph[curr].get(i);
			if(!vis[e.dest]) {
				topSort(graph, e.dest, vis, s);
			}
		}
		
		s.push(curr);
	}
	public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]) {
		vis[curr] = true;
		System.out.print(curr + " ");
		
		for(int i=0; i<graph[curr].size(); i++) {
			Edge e = graph[curr].get(i);
			if(!vis[e.dest]) {
				dfs(graph, e.dest, vis);
			}
		}
	}
	public static void kosaraju(ArrayList<Edge> graph[], int v) {
		//topSort
		Stack<Integer> s = new Stack<>();
		boolean vis[] = new boolean[v];
		for(int i=0; i<v; i++) {
			if(!vis[i]) {
				topSort(graph, i, vis, s);
			}
		}
		
		//transpose graph
		ArrayList<Edge> transpose[] = new ArrayList[v];
		for(int i=0; i<transpose.length; i++) {
			vis[i] = false;
			transpose[i] = new ArrayList<>();
		}
		
		for(int i=0; i<v; i++) {
			for(int j=0; j<graph[i].size(); j++) {
				Edge e = graph[i].get(j);
				transpose[e.dest].add(new Edge(e.dest, e.src));
			}
		}
		
		//dfs
		for(int i=0; i<v; i++) {
			if(!vis[i]) {
				System.out.print("SCC : ");
				dfs(transpose, i, vis);
				System.out.println();
			}
		}
	}
	
	public static void dfs(ArrayList<Edge> graph[], int curr, int par, boolean vis[], int dt[], int low[], int time) {
		vis[curr] = true;
		dt[curr] = low[curr] = ++time;
		
		for(int i=0; i<graph[curr].size(); i++) {
			Edge e = graph[curr].get(i);
			int neigh = e.dest;
			
			//case 1
			if(neigh == par) {
				continue;
			} else if(!vis[neigh]) {
				dfs(graph, neigh, curr, vis, dt, low, time);
				low[curr] = Math.min(low[curr], low[neigh]);
				if(dt[curr] < low[neigh]) {
					System.out.println("Bridge : " + curr + "-----" + neigh);
				}
			} else {
				low[curr] = Math.min(low[curr], dt[neigh]);
			}
			
		}
	}
	public static void tarjanBridge(ArrayList<Edge> graph[], int v) {
		int dt[] = new int[v];
		int low[] = new int[v];
		boolean vis[] = new boolean[v];
		int time = 0;
		
		for(int i=0; i<v; i++) {
			if(!vis[i]) {
				dfs(graph, i, -1, vis, dt, low, time);
			}
		}
	}
	
	public static void dfs2(ArrayList<Edge> graph[], int curr, int par, boolean vis[], int dt[], int low[], int time) {
		vis[curr] = true;
		dt[curr] = low[curr] = ++time;
		int children = 0;
		
		for(int i=0; i<graph[curr].size(); i++) {
			Edge e = graph[curr].get(i);
			int neigh = e.dest;
			
			//case 1
			if(neigh == par) {
				continue;
			} else if(vis[neigh]) {
				low[curr] = Math.min(low[curr], dt[neigh]);
			} else {
				dfs2(graph, neigh, curr, vis, dt, low, time);
				low[curr] = Math.min(low[curr], low[neigh]);
				if(par != -1 && dt[curr] <= low[neigh]) {
					System.out.println("AP : " + curr);
				}
				children++;
			}
		}
		
		if(par == -1 && children > 1) {
			System.out.println("AP : " + curr);
		}
	}
	public static void getAP(ArrayList<Edge>[] graph, int v) {
		int dt[] = new int[v];
		int low[] = new int[v];
		boolean vis[] = new boolean[v];
		int time = 0;
		
		for(int i=0; i<v; i++) {
			if(!vis[i]) {
				dfs2(graph, i, -1, vis, dt, low, time);
			}
		}
	}
	
	public static void main(String args[]) {
		int v = 5;
		
		ArrayList<Edge>[] graph = new ArrayList[v];
		createGraph(graph);
		//System.out.println(isBipartite(graph));
		//topSortBfs(graph);
		//printAllPaths(graph, 1, 3, "");
		getAP(graph, v);
		
	}
}