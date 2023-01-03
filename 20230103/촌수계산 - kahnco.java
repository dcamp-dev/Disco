import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws IOException {
	    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
	    
	    int n = Integer.parseInt(r.readLine());
	    
	    List<Integer>[] graph = new ArrayList[n+1];
	    for (int i = 0; i <= n; i++) {
	        graph[i] = new ArrayList<>();
	    }
	    
	    StringTokenizer st = new StringTokenizer(r.readLine());
	    
	    int a = Integer.parseInt(st.nextToken());
	    int b = Integer.parseInt(st.nextToken());
	    
	    int m = Integer.parseInt(r.readLine());
	    
	    setGraph(graph, m, st, r);
	    
	    boolean[] visited = new boolean[n+1];
	    
	    int[] answer = {-1};
	    dfs(graph, visited, a, b, 0, answer);
	    System.out.println(answer[0]);
	}
	
	public static void setGraph(List<Integer>[] graph, int m, StringTokenizer st, BufferedReader r) throws IOException {
	    for (int i = 0; i < m; i++) {
	        st = new StringTokenizer(r.readLine());
	        
	        int from = Integer.parseInt(st.nextToken());
	        int to = Integer.parseInt(st.nextToken());
	        
	        graph[from].add(to);
	        graph[to].add(from);
	    }
	}
	
	public static void dfs(List<Integer>[] graph, boolean[] visited, int start, int target, int distance, int[] answer) {
	    if (start == target) {
	        if (answer[0] == -1 || distance < answer[0]) {
	            answer[0] = distance;
	        }
	        return;
	    }
	    
	    visited[start] = true;
	    for (int next : graph[start]) {
	        if (!visited[next]) {
	            dfs(graph, visited, next, target, distance + 1, answer);
	        }
	    }
	}
}
