import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            HashMap<String, ArrayList<Integer>> map = new HashMap<>();
            String[] saying = br.readLine().split(" "); // 울음소리 저장

            for (int c = 0; c < saying.length; c++) {
                if (!map.containsKey(saying[c])) map.put(saying[c], new ArrayList<>(List.of(c))); //키 파악
                else map.get(saying[c]).add(c); // 키 있다면 list에 저장
            }

            String str;
            while((str = br.readLine()) != null && !str.equals("what does the fox say?")) {
                String[] strArr = str.split(" ");
                String sound = strArr[strArr.length - 1];
                List<Integer> list = map.get(sound);
                for (Integer num : list) saying[num] = ""; // 울음 소리가 저장된 인덱스 찾아서 "" 만들기
            }

            for (String say : saying) {
                if (say != null && !say.equals("")) sb.append(say).append(" "); // null이 아니고 ""가 아니라면 울음 소리 저장
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}