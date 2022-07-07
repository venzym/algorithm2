package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Cow {

    /*
     * 백준 14467 소가 길을 건너간 이유 1(https://www.acmicpc.net/problem/14467)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> cow = new HashMap<>();

        int result = 0;

        //소의 위치를 N번 관찰
        int N = Integer.parseInt(reader.readLine());

        StringTokenizer st;
        int number = 0;
        int location = 0;
        //각 관찰은 소의 번호와 소의 위치 하나씩
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(reader.readLine());
            number = Integer.parseInt(st.nextToken());
            location = Integer.parseInt(st.nextToken());

            if (!cow.containsKey(number)) {
                cow.put(number, location);
            } else {
                int nowLocation = cow.get(number);
                if (nowLocation != location) {
                    //이전 위치와 현재 위치가 다를 때
                    if (nowLocation == 0) {
                        cow.put(number, 1);
                    } else {
                        cow.put(number, 0);
                    }
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}
