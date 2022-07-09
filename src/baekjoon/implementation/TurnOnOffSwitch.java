package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TurnOnOffSwitch {

    /**
     * 백준 1244 스위치 켜고 끄기(https://www.acmicpc.net/problem/1244)
     */
    public static void main(String[] args) throws IOException {
        //1: 스위치가 켜져 있음
        //0: 스위치가 꺼져 있음

        //남학생은 스위치 번호가 자기가 받은 수의 배수이면 -> 켜져 있으면 끄고, 꺼져 있으면 켠다
        //여학생은 자기와 같은 번호가 붙은 스위치를 중심으로 '좌우가 대칭'이면서 가장 많은 스위치를 포함하는 구간을 찾아 스위치의 상태를 모두 바꾼다.
        //여학생이 3을 받았다면, 3번 스위치를 중심으로 2번, 4번 스위치의 상태가 같고 1번, 5번 스위치의 상태가 같으므로 '모두 바꾼다'
        //본인은 무조건 바꾼다

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        int[] arr = new int[N + 1];

        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //학생수
        int studentCount = Integer.parseInt(reader.readLine());

        //학생수만큼 성별, 번호 입력
        for (int i = 0; i < studentCount; i++) {
            st = new StringTokenizer(reader.readLine());

            //성별
            int sex = Integer.parseInt(st.nextToken());
            //학생번호
            int studentNumber = Integer.parseInt(st.nextToken());
            int temp = studentNumber;

            if (sex == 1) {
                //남학생
                int increase = 2;
                while (temp <= N) {
                    changeArr(arr, temp);
                    temp = studentNumber * increase++;
                }
            } else {
                //여학생
                //본인 바꾸기
                changeArr(arr, studentNumber);
                //좌우대칭
                int left = studentNumber - 1;
                int right = studentNumber + 1;
                while (left > 0 && right <= N && (arr[left] == arr[right])) {
                    changeArr(arr, left);
                    changeArr(arr, right);
                    left--;
                    right++;
                }
            }
        }

        for (int i = 1; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            if (i % 20 == 0) {
                System.out.println();
            }
        }
    }

    private static void changeArr(int[] arr, int temp) {
        if (arr[temp] == 0) {
            arr[temp] = 1;
        } else {
            arr[temp] = 0;
        }
    }
}
