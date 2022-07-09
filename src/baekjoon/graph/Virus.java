package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Virus {

    /**
     * 백준(2606) - 바이러스(https://www.acmicpc.net/problem/2606)
     */
    private static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        int num = Integer.parseInt(reader.readLine());

        int[][] map = new int[N + 1][N + 1];
        boolean[] visit = new boolean[N + 1];

        StringTokenizer st;
        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(reader.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            map[n1][n2] = 1;
            map[n2][n1] = 1;
        }

        dfs(map, visit, 1);
        System.out.println(result);
    }

    private static void dfs(int[][] map, boolean[] visit, int v) {
        visit[v] = true;
        result++;

        for (int i = 1; i < map.length; i++) {
            if (!visit[i] && map[v][i] == 1) {
                dfs(map, visit, i);
            }
        }
    }
}
