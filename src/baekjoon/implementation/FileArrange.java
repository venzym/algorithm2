package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class FileArrange {

    /**
     * 백준(20291) - 파일 정리(https://www.acmicpc.net/problem/20291)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        TreeMap<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String str = reader.readLine();
            String input = str.substring(str.indexOf(".") + 1);
            map.put(input, map.getOrDefault(input, 0) + 1);
        }

        for (String key : map.keySet()) {
            System.out.print(key);
            System.out.println(" " + map.get(key));
        }

    }
}
