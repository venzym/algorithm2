package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Snail {

    /**
     * 백준 1913 달팽이(https://www.acmicpc.net/problem/1913)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        int[][] map = new int[N][N];

        int findNumber = Integer.parseInt(reader.readLine());
        StringBuilder sb = new StringBuilder();

        int num = N * N;

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int x = 0;
        int y = 0;
        int dir = 0;
        for (int i = 0; i <= N / 2; i++) {
            //꼭지점 변화
            x = i;
            y = i;
            dir = 0;

            map[x][y] = num--;

            //4회전
            while (dir < 4) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    //정사각형 나갔을 때 방향전환
                    dir++;
                } else if (map[nx][ny] != 0) {
                    //값이 있을 때 방향전환
                    dir++;
                } else {
                    map[nx][ny] = num--;
                    x = nx;
                    y = ny;
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == findNumber) {
                    sb.append((i + 1) + " " + (j + 1));
                }
                result.append(map[i][j] + " ");
            }
            result.append("\n");
        }
        System.out.print(result.toString());
        System.out.println(sb.toString());
    }
}
