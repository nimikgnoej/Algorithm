import java.util.*;
import java.io.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void sol() throws Exception {
        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        while (N-- > 0) {
            String[] file = br.readLine().split("\\.");
            String extension = file[1];

            if (!map.containsKey(extension)) {
                map.put(extension, 1);
            } else {
                int count = map.get(extension);
                map.remove(extension);
                map.put(extension, count + 1);
            }
        }

        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        for (String s : list) {
            sb.append(s).append(" ");
            sb.append(map.get(s)).append("\n");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().sol();
    }
}
