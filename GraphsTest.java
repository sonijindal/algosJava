package practice;

import java.util.Iterator;
import java.util.LinkedList;

public class GraphsTest {
	private int V;
	private LinkedList<Integer> adj[];	

	public GraphsTest(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i) {
			adj[i] = new LinkedList<Integer>();
		}
	}

	public void addEdge(int node, int val) {
		adj[node].add(val);
	}

	public int BFS(int start) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		boolean visited[] = new boolean[V];
		visited[start] = true;
		while(!queue.isEmpty()) {
			int node = queue.poll();
			System.out.println(node+" ");
			Iterator<Integer> it = adj[node].iterator();
			while (it.hasNext()) {
				int n = it.next();

				if (visited[n] == false) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}
		return 0;
	}
	public int DFS(int start) {
		boolean visited[] = new boolean[V];
		DFSUtil(start, visited);
		return 0;
	}
	
	public void DFSUtil(int n, boolean[] visited) {
		visited[n] = true;
		System.out.println(n+" ");
		Iterator<Integer> it = adj[n].iterator();
		while (it.hasNext()) {
			int node = it.next();
			if (visited[node] != true) {
				DFSUtil(node, visited);
			}
		}
	}
}
