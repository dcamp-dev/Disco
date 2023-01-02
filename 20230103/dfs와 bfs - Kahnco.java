import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(r.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        
        List<Integer>[] list = new ArrayList[n+1];
        for (int i = 0; i <= n; i ++) {
            list[i] = new ArrayList<>();
        }
        
        setGraph(list, m, st, r);
        sortGraph(list);
    
        boolean[] visited = new boolean[n+1];
        dfs(v, list, visited, w);
        w.write("\n");
        
        visited = new boolean[n+1];
        bfs(v, list, visited, w);
        
        w.flush();
        w.close();
        r.close();
    }
    
    public static void setGraph(List<Integer>[] list, int m, StringTokenizer st, BufferedReader r) throws IOException {
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(r.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            list[start].add(end);
            list[end].add(start);
        }
    }
    
    public static void sortGraph(List<Integer>[] list) {
        for (int i = 1; i < list.length; i++) {
            Collections.sort(list[i]);
        }
    }
    
    public static void dfs(int v, List<Integer>[] list, boolean[] visited, BufferedWriter w) throws IOException {
        if (visited[v]) return;
        
        visited[v] = true;
        w.write(v + " ");
        for (int next : list[v]) {
            if (!visited[next]) dfs(next, list,visited, w);
        }
    }
    
    public static void bfs(int v, List<Integer>[] list, boolean[] visited, BufferedWriter w) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            w.write(current + " ");
            for (int next : list[current]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }
}
