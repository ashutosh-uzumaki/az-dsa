package trees;

import java.util.*;
import java.io.*;

public class TreeDiameterAsGraph {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(reader.readLine());
        @SuppressWarnings("unchecked")
        List<Integer>[] adj = new ArrayList[size + 1];

        for (int i = 1; i <= size; i++) {
            adj[i] = new ArrayList<>();
        }
        int[] depth = new int[size + 1];
        for (int i = 0; i < size - 1; i++) {
            String[] nodes = reader.readLine().split(" ");
            int u = Integer.parseInt(nodes[0]);
            int v = Integer.parseInt(nodes[1]);
            adj[u].add(v);
            adj[v].add(u);
        }

        dfsIterative(1, adj, depth);
        int maxChild = 1;
        for (int i = 2; i <= size; i++) {
            if (depth[i] > depth[maxChild]) {
                maxChild = i;
            }
        }
        Arrays.fill(depth, 0);
        dfsIterative(maxChild, adj, depth);
        maxChild = 1;
        for (int i = 2; i <= size; i++) {
            if (depth[i] > depth[maxChild]) {
                maxChild = i;
            }
        }

        System.out.println(depth[maxChild]);
    }

    public static void dfsIterative(int start, List<Integer>[] adj, int[] depth) {
        boolean[] visited = new boolean[depth.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        visited[start] = true;
        while (!stack.isEmpty()) {
            int node = stack.pop();
            for (Integer nbr : adj[node]) {
                if (!visited[nbr]) {
                    stack.push(nbr);
                    visited[nbr] = true;
                    depth[nbr] = depth[node] + 1;
                }
            }
        }
    }
}
