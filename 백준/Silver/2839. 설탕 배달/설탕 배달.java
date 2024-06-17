import java.util.*;
import java.io.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[] sugar = new int[5001];

    public void sol() throws Exception {
        int num = Integer.parseInt(br.readLine());
        fill(sugar); // -1로 채움
        sugar[0] = 0;
        sugar[3] = 1;
        sugar[5] = 1;
        for (int i = 5; i <= num; i++) {
            if(sugar[i-3] != -1 && sugar[i-5] != -1)
                sugar[i] = min(sugar[i - 3] + 1, sugar[i - 5] + 1);
            else if(sugar[i-3] == -1)
                if(sugar[i-5] == -1)
                    continue;
                else
                    sugar[i] = sugar[i - 5] + 1;
            else if (sugar[i-5] == -1)
                sugar[i] = sugar[i-3] + 1;
        }

        sb.append(sugar[num]);
        System.out.println(sb);

        br.close();
    }

    public void fill(int[] sugar) {
        for (int i = 0; i <= 5000; i++) {
            sugar[i] = -1;
        }
    }

    public int min(int a, int b) {
        if(a>b)
            return b;
        else
            return a;
    }

    public static void main(String[] args) throws Exception {
        new Main().sol();
    }
}
