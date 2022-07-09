package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DfsBfs {

    /**
     * 백준 1260 DFS와 BFS(https://www.acmicpc.net/problem/1260)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        int[][] map = new int[N + 1][N + 1];
        boolean[] visit = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(reader.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            map[n1][n2] = 1;
            map[n2][n1] = 1;
        }

        dfs(map, visit, V);
        System.out.println();

        Arrays.fill(visit, false);
        bfs(map, visit, V);
    }

    private static void bfs(int[][] map, boolean[] visit, int v) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visit[v] = true;

        while (!q.isEmpty()) {
            v = q.poll();
            System.out.print(v + " ");

            for (int i = 1; i < map.length; i++) {
                if (!visit[i] && map[v][i] == 1) {
                    //(1, 2), (1, 3), (1, 4)
                    visit[i] = true;
                    q.add(i);
                }
            }
        }
    }

    private static void dfs(int[][] map, boolean[] visit, int v) {
        visit[v] = true;
        System.out.print(v + " ");

        for (int i = 1; i < map.length; i++) {
            if (!visit[i] && map[v][i] == 1) {
                //(1, 2) -> (2, 4) -> (4, 3)
                dfs(map, visit, i);
            }
        }
    }
}
