package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Did_not_submit_homework {

    //백준 5597 - 과제 안내신 분..?(https://www.acmicpc.net/problem/5597)
    public static void main(String[] args) throws IOException {
        boolean[] map = new boolean[31];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 28; i++) {
            map[Integer.parseInt(reader.readLine())] = true;
        }

        for (int i = 1; i <= 30; i++) {
            if (!map[i]) {
                System.out.println(i);
            }
        }
    }
}
