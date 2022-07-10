package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class FindTreeParent {

    /**
     * 백준(11725) - 트리의 부모 찾기(https://www.acmicpc.net/problem/11725)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        List<List<Integer>> map = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            map.add(new ArrayList<>());
        }
        boolean[] visit = new boolean[N + 1];
        int[] arr = new int[N + 1];

        StringTokenizer st;
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(reader.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            map.get(n1).add(n2);
            map.get(n2).add(n1);
        }

        dfs(map, visit, arr, 1);

        for (int i = 2; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
    }

    private static void dfs(List<List<Integer>> map, boolean[] visit, int[] arr, int v) {
        visit[v] = true;

        for (int node : map.get(v)) {
            if (!visit[node]) {
                arr[node] = v;
                dfs(map, visit, arr, node);
            }
        }
    }
}
