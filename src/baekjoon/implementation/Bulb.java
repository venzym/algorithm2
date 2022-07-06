package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Bulb {

    /**
     * 백준 21918 전구(https://www.acmicpc.net/problem/21918)
     */
    public static void main(String[] args) throws IOException {
        //1 : 켜져 있는 상태
        //0 : 꺼져 있는 상태

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String input = reader.readLine();
        st = new StringTokenizer(input, " ");
        //전구의 개수 N, 입력되는 명령어의 개수 M 입력받음
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer> bulbs = new ArrayList<>();
        input = reader.readLine();
        st = new StringTokenizer(input, " ");

        //N개의 전구가 현재 어떤 상태 s인지 입력받음(0, 1)
        for (int i = 0; i < N; i++) {
            bulbs.add(Integer.parseInt(st.nextToken()));
        }

        //M + 2번째 줄까지 세 개의 정수 a, b, c가 들어온다.
        int a, b, c = 0;
        for (int i = 0; i < M; i++) {
            input = reader.readLine();
            st = new StringTokenizer(input, " ");
            //a는 a번째 명령어를 의미하고
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken()) - 1;
            c = Integer.parseInt(st.nextToken());

            if (a == 1) {
                //b, c는 a가 1인 경우는 각각 i, x를 의미하고
                //i 번째 전구의 상태를 x로 변경
                bulbs.set(b, c);
            } else {
                //a가 2, 3, 4 중 하나면 각각 l, r을 의미한다.
                if (a == 2) {
                    //2: l번째부터 r번째까지의 전구의 상태를 변경한다. (켜져있는 전구는 끄고, 꺼져있는 전구는 킨다.)
                    for (int j = b; j < c; j++) {
                        if (bulbs.get(j) == 0) {
                            bulbs.set(j, 1);
                        } else {
                            bulbs.set(j, 0);
                        }
                    }
                } else if (a == 3) {
                    //3: l번째부터 r번째까지의 전구를 끈다.
                    for (int j = b; j < c; j++) {
                        bulbs.set(j, 0);
                    }
                } else {
                    //4: l번째부터 r번째까지의 전구를 킨다.
                    for (int j = b; j < c; j++) {
                        bulbs.set(j, 1);
                    }
                }
            }
        }

        for (int i = 0; i < bulbs.size(); i++) {
            System.out.print(bulbs.get(i) + " ");
        }

    }
}
