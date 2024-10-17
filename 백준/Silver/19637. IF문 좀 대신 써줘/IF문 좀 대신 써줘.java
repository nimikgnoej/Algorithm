import java.util.*;
import java.io.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void sol() throws Exception {
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        HashMap<Integer, String> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] chingho = br.readLine().split(" ");
            if(!map.containsKey(Integer.parseInt(chingho[1]))){
                map.put(Integer.parseInt(chingho[1]), chingho[0]);
                list.add(Integer.parseInt(chingho[1]));
            }
        }

        for (int i = 0; i < m; i++) {
            int power = Integer.parseInt(br.readLine());
            int result = binarySearch(list, 0, list.size() - 1, power);
            String res = map.get(result);
            sb.append(res).append("\n");
        }

        System.out.println(sb);
    }

    public int binarySearch(List<Integer> list, int start, int end, int power) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (power < list.get(mid))
                end = mid - 1;
            else if(power > list.get(mid))
                start = mid + 1;
            else
                return list.get(mid);
        }
        return list.get(start);
    }


    public static void main(String[] args) throws Exception {
        new Main().sol();
    }
}
