import java.util.*;

public class GraphPrograms {
	static class Edge {
		int src;
		int dest;
		int wt;
		
		public Edge(int src, int dest, int wt) {
			this.src = src;
			this.dest = dest;
			this.wt = wt;
		}
	}
	
	public static void createGraph(ArrayList<Edge>[] graph, int flights[][]) {
		for(int i=0; i<graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		
//		graph[0].add(new Edge(0, 1, 1));
//		graph[0].add(new Edge(0, 2, 1));
//		
//		graph[1].add(new Edge(1, 0, 1));
//		graph[1].add(new Edge(1, 3, 1));
//		
//		graph[2].add(new Edge(2, 0, 1));
//		graph[2].add(new Edge(2, 4, 1));
//		
//		graph[3].add(new Edge(3, 1, 1));
//		graph[3].add(new Edge(3, 4, 1));
//		graph[3].add(new Edge(3, 5, 1));
//		
//		graph[4].add(new Edge(4, 2, 1));
//		graph[4].add(new Edge(4, 3, 1));
//		graph[4].add(new Edge(4, 5, 1));
//		
//		graph[5].add(new Edge(5, 3, 1));
//		graph[5].add(new Edge(5, 4, 1));
//		graph[5].add(new Edge(5, 6, 1));
//		
//		graph[6].add(new Edge(6, 5, 1));
		
		/* DIJKTRA'S ALGO*/
//		graph[0].add(new Edge(0, 1, 2));
//		graph[0].add(new Edge(0, 2, 4));
//		
//		graph[1].add(new Edge(1, 2, 1));
//		graph[1].add(new Edge(1, 3, 7));
//		
//		graph[2].add(new Edge(2, 4, 3));
//		
//		graph[3].add(new Edge(3, 5, 1));
//		
//		graph[4].add(new Edge(4, 3, 2));
//		graph[4].add(new Edge(4, 5, 5));
		
		/*BELLMAN FORD ALGO*/
//		graph[0].add(new Edge(0, 1, 2));
//		graph[0].add(new Edge(0, 2, 4));
//		
//		graph[1].add(new Edge(1, 2, -4));
//		
//		graph[2].add(new Edge(2, 3, 2));
//		
//		graph[3].add(new Edge(3, 4, 4));
//		
//		graph[4].add(new Edge(4, 1, -1));
		
		/*PRIM'S ALGO*/
//		graph[0].add(new Edge(0, 1, 10));
//		graph[0].add(new Edge(0, 2, 15));
//		graph[0].add(new Edge(0, 3, 30));
//		
//		graph[1].add(new Edge(1, 0, 10));
//		graph[1].add(new Edge(1, 3, 40));
//		
//		graph[1].add(new Edge(2, 0, 15));
//		graph[1].add(new Edge(2, 3, 50));
//		
//		graph[1].add(new Edge(3, 0, 30));
//		graph[1].add(new Edge(3, 1, 40));
//		graph[1].add(new Edge(3, 2, 50));
		
		/*Cheapest Flight with k stops*/
		for(int i=0; i<flights.length; i++) {
			int src = flights[i][0];
			int dest = flights[i][1];
			int wt = flights[i][2];
			
			Edge e = new Edge(src, dest, wt);
			graph[src].add(e);
		}
	}
	
	public static void bfs(ArrayList<Edge>[] graph) {
		Queue<Integer> q = new LinkedList<>();
		boolean vis[] = new boolean[graph.length];
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
	
	public static void dfs(ArrayList<Edge>[] graph, int curr, boolean vis[]) {
		//visit
		System.out.print(curr + " ");
		vis[curr] = true;
		
		for(int i=0; i<graph[curr].size(); i++) {
			Edge e = graph[curr].get(i);
			if(!vis[e.dest]) {
				dfs(graph, e.dest, vis);
			}
		}
	}
	
	public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean vis[]) {
		if(src == dest) {
			return true;
		}
		
		vis[src] = true;
		
		for(int i=0; i<graph[src].size(); i++) {
			Edge e = graph[src].get(i);
			//e.dest = dest of Edge/neighbour
			if(!vis[e.dest] && hasPath(graph, e.dest, dest, vis)) {
				return true;
			}
		}
		
		return false;
	}
	
	public static class Pair implements Comparable<Pair>{
		int n;
		int path;
		
		public Pair(int n, int path) {
			this.n = n;
			this.path = path;
		}
		
		@Override
		public int compareTo(Pair p2) {
			return this.path - p2.path;
		}
	}
	public static void dijkstras(ArrayList<Edge> graph[], int src) {
		int dist[] = new int[graph.length];
		for(int i=0; i<dist.length; i++) {
			if(i != src) {
				dist[i] = Integer.MAX_VALUE;
			}
		}
		
		boolean vis[] = new boolean[graph.length];
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(src, 0));
		
		while(!pq.isEmpty()) {
			Pair curr = pq.remove();
			
			if(!vis[curr.n]) {
				vis[curr.n] = true;
				
				for(int i=0; i<graph[curr.n].size(); i++) {
					Edge e = graph[curr.n].get(i);
					int u = e.src;
					int v = e.dest;
					int wt = e.wt;
					
					if(dist[u] + wt < dist[v]) {
						dist[v] = dist[u] + wt;
						pq.add(new Pair(v, dist[v]));
					}
				}
			}
		}
		
		for(int i=0; i<graph.length; i++) {
			System.out.print(dist[i] + " ");
		}
		System.out.println();
	}
	
	public static void bellmanFord(ArrayList<Edge> graph[], int src) {
		int dist[] = new int[graph.length];
		for(int i=0; i<dist.length; i++) {
			if(i != src) {
				dist[i] = Integer.MAX_VALUE;
			}
		}
		
		int V = graph.length;
		for(int i=0; i<V-1; i++) {
			for(int j=0; j<graph.length; j++) {
				for(int k=0; k<graph[j].size(); k++) {
					Edge e = graph[j].get(k);
					int u = e.src;
					int v = e.dest;
					int wt = e.wt;
					
					if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
						dist[v] = dist[u] + wt;
					}
				}
			}
		}
		
		for(int i=0; i<dist.length; i++) {
			System.out.print(dist[i] + " ");
		}
		System.out.println();
	}
	
	public static class Pair2 implements Comparable<Pair2>{
		int v;
		int cost;
		
		public Pair2(int v, int cost) {
			this.v = v;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Pair2 p2) {
			return this.cost - p2.cost;
		}
	}
	public static void prims(ArrayList<Edge> graph[]) {
		boolean vis[] = new boolean[graph.length];
		PriorityQueue<Pair2> pq = new PriorityQueue<>();
		pq.add(new Pair2(0, 0));
		int finalCost = 0;
		
		while(!pq.isEmpty()) {
			Pair2 curr = pq.remove();
			
			if(!vis[curr.v]) {
				//visit
				vis[curr.v] = true;
				finalCost += curr.cost;
				
				for(int i=0; i<graph[curr.v].size(); i++) {
					Edge e = graph[curr.v].get(i);
					pq.add(new Pair2(e.dest, e.wt));
				}
			}
		}
		
		System.out.println(finalCost);
	}
	
	static class Edge2 implements Comparable<Edge2>{
		int dest;
		int wt;
		
		public Edge2(int dest, int wt) {
			this.dest = dest;
			this.wt = wt;
		}
		
		@Override
		public int compareTo(Edge2 e2) {
			return this.wt - e2.wt;
		}
	}
	
	public static int connectCities(int cities[][]) {
		int finalCost = 0;
		PriorityQueue<Edge2> pq = new PriorityQueue<>();
		boolean vis[] = new boolean[cities.length];
		pq.add(new Edge2(0, 0));
		
		while(!pq.isEmpty()) {
			Edge2 curr = pq.remove();
			
			if(!vis[curr.dest]) {
				vis[curr.dest] = true;
				finalCost += curr.wt;
				
				for(int i=0; i<cities[curr.dest].length; i++) {
					if(cities[curr.dest][i] != 0) {
						pq.add(new Edge2(i, cities[curr.dest][i]));
					}
				}
			}
		}
		
		return finalCost;
	}
	
	static class Info {
		int v;
		int cost;
		int k;
		
		public Info(int v, int cost, int k) {
			this.v = v;
			this.cost = cost;
			this.k = k;
		}
	}
	public static int cheapestFlight(int n, int flights[][], int src, int dest, int k) {
		ArrayList<Edge> graph[] = new ArrayList[n];
		createGraph(graph, flights);
		
		int dist[] = new int[graph.length];
		for(int i=0; i<dist.length; i++) {
			if(i != src) {
				dist[i] = Integer.MAX_VALUE;
			}
		}
		
		Queue<Info> q = new LinkedList<>();
		q.add(new Info(src, 0 , 0));
		
		while(!q.isEmpty()) {
			Info curr = q.remove();
			if(curr.k > k) {
				break;
			}
			
			for(int i=0; i<graph[curr.v].size(); i++) {
				Edge e = graph[curr.v].get(i);
				int u = e.src;
				int v = e.dest;
				int wt = e.wt;
				
				if(curr.cost + wt < dist[v] && curr.k <= k) {
					dist[v] = curr.cost + wt;
					q.add(new Info(v, dist[v], curr.k+1));
				}
			}
		}
		
		if(dist[dest] == Integer.MAX_VALUE) {
			return -1;
		} else {
			return dist[dest];
		}
	}
	
	public static void main(String args[]) {
		int v = 4;
//   	ArrayList<Edge>[] graph = new ArrayList[v];
//		createGraph(graph);
		//dfs(graph, 0, new boolean[v]);
		//System.out.println(hasPath(graph, 1, 5, new boolean[v]));
		//bellmanFord(graph, 0);
		//prims(graph);
		
//		int cities[][] = {{0, 1, 2, 3, 4},
//				          {1, 0, 5, 0, 7},
//				          {2, 5, 0, 6, 0},
//				          {3, 0, 6, 0 ,0},
//				          {5, 7, 0, 0, 0}};
//		
//		System.out.println(connectCities(cities));
		
		int flights[][] = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}}; 
		System.out.println(cheapestFlight(v, flights, 0, 3, 1));
	}
}