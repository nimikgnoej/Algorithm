import java.util.*;
import java.io.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    List<Integer> visitors = new ArrayList<>();
    List<Integer> result = new ArrayList<>();
    int[] sum;
    int N,X;
    int max=0;
    int count = 0;

    public void sol() throws Exception {
        String[] NX = br.readLine().split(" ");
        N = Integer.parseInt(NX[0]);
        X = Integer.parseInt(NX[1]);
        sum = new int[N];
        String[] inputs = br.readLine().split(" ");
        for (String input : inputs)
            visitors.add(Integer.parseInt(input));

        sum(X);
        findMaxAndCount();
        if (max == 0) {
            sb.append("SAD");
        } else {
            sb.append(max).append("\n").append(count);
        }
        System.out.println(sb);
    }

    public void findMaxAndCount() {
        for (int i = 0; i < sum.length; i++) {
            if(max<sum[i])
                max=sum[i];
        }
        for (int i = 0; i < sum.length; i++) {
            if (max == sum[i]) {
                count++;
            }
        }
    }

    public void sum(int days) {
        sum[0] = visitors.get(0);
        for (int i = 1; i < days; i++) {
            sum[i] = sum[i-1] + visitors.get(i);
        }

        for (int i = days; i < N; i++) {
            sum[i] = sum[i - 1] - visitors.get(i - days) + visitors.get(i);
        }
    }


    public static void main(String[] args) throws Exception {
        new Main().sol();
    }
}
