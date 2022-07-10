package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class EffectiveHacking {

    /**
     * 백준(1325) - 효율적인 해킹(https://www.acmicpc.net/problem/1325)
     */
    private static int max = 0;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        //한 번의 해킹으로 여러대의 컴퓨터를 해킹
        //한 번에 가장 많은 컴퓨터를 해킹할 수 있는 컴퓨터의 번호
        //-> 각 노드를 시작점으로 그래프를 돌려보기
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> map = new ArrayList<>();
        boolean[] visit = new boolean[N + 1];
        arr = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            map.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(reader.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            map.get(n1).add(n2);
        }

        for (int i = 1; i <= N; i++) {
            visit = new boolean[N + 1];
//            dfs(map, visit, i, i);
            bfs(map, visit, i);
        }

        for (int i = 1; i <= N; i++) {
            max = Math.max(max, arr[i]);
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == max) {
                System.out.print(i + " ");
            }
        }
    }

    private static void bfs(List<List<Integer>> map, boolean[] visit, int v) {
        Queue<Integer> q = new LinkedList<>();
        visit[v] = true;
        q.add(v);

        while (!q.isEmpty()) {
            int qn = q.poll();

            for (int node : map.get(qn)) {
                if (!visit[node]) {
                    visit[node] = true;
                    q.add(node);
                    arr[node]++;
                }
            }
        }
    }

    private static void dfs(List<List<Integer>> map, boolean[] visit, int v, int index) {
        for (int node : map.get(index)) {
            if (!visit[node]) {
                //해당 노드에 도달하는 경우 시작 노드에 + 1씩 해주기
                visit[node] = true;
                dfs(map, visit, v, node);
                arr[v]++;
            }
        }
    }
}
