import java.time.Year;
import java.util.*;
import java.io.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void sol() throws Exception {
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        String game = inputs[1];
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < n; i++)
            set.add(br.readLine());

        if (game.equals("Y")) {
            sb.append(set.size());
        } else if (game.equals("F")) {
            sb.append((int)Math.floor(set.size() / 2));
        } else {
            sb.append((int)Math.floor(set.size() / 3));
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().sol();
    }
}
