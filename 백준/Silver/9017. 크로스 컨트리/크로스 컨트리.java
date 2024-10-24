import java.util.*;
import java.io.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void sol() throws Exception {
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            List<String> list = new ArrayList<>();
            HashMap<Integer, List<Integer>> map = new HashMap<>();
            int n = Integer.parseInt(br.readLine());
            String[] inputs = br.readLine().split(" ");
            int[] memberCount = new int[max(inputs)];
            for (int i = 0; i < n; i++) { // 각 팀에 몇명 있는지
                memberCount[Integer.parseInt(inputs[i])-1]++;
            }

            for (int i = 0; i < n; i++) {
                if (memberCount[Integer.parseInt(inputs[i]) - 1] == 6) { // 점수낼 조건에 만족
                    list.add(inputs[i]);
                }
            }

            for (int i = 0; i < list.size(); i++) {
                int team = Integer.parseInt(list.get(i));
                if (!map.containsKey(team)) {
                    map.put(team, new ArrayList<>());
                    map.get(team).add(i + 1);
                } else {
                    map.get(team).add(i+1);
                }
            }

            compare(map);
        }
        System.out.println(sb);
    }

    public void compare(HashMap<Integer, List<Integer>> map) {
        HashMap<Integer, Integer> nmap = new HashMap<>();
        for (Integer i : map.keySet()) {
            for (int x = 0; x < 4; x++) {
                nmap.put(i, nmap.getOrDefault(i, 0) + map.get(i).get(x));
            }
        }

        int min = Integer.MAX_VALUE;
        int resTeam = 201;
        for (int k : nmap.keySet()) {
            int val = nmap.get(k);
            if (min > val) {
                min = val;
                resTeam = k;
            } else if (min == val) { // 동점인 팀
                if (map.get(resTeam).get(4) > map.get(k).get(4)) {
                    resTeam = k;
                }
            }
        }
        sb.append(resTeam + "\n");
    }

    public int max(String[] inputs) {
        int max = 0;
        for (int i = 0; i < inputs.length; i++) {
            if(Integer.parseInt(inputs[i]) > max)
                max = Integer.parseInt(inputs[i]);
        }
        return max;
    }

    public static void main(String[] args) throws Exception {
        new Main().sol();
    }
}
