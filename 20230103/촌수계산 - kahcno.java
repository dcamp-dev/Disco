/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

import java.io.*;
import java.util.*;

public class Main
{
    static int answer = -1;
    
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
	    
	    if (a == b) {
	        System.out.println(0);
	        return;
	    }
	    
	    int m = Integer.parseInt(r.readLine());
	    
	    setGraph(graph, m, st, r);
	    
	    boolean[] visited = new boolean[n+1];
	    
	    dfs(graph, visited, a, b, 0);
	    System.out.println(answer);
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
	
	public static void dfs(List<Integer>[] graph, boolean[] visited, int start, int target, int distance) {
	    if (start == target) {
	        if (answer == -1 || distance < answer) {
	            answer = distance;
	        }
	        return;
	    }
	    
	    visited[start] = true;
	    for (int next : graph[start]) {
	        if (!visited[next]) {
	            dfs(graph, visited, next, target, distance + 1);
	        }
	    }
	}
}
