import java.util.*;
import java.io.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    List<Integer> budgets = new ArrayList<>();

    public void sol() throws Exception {
        int region = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");
        int totalBudget = Integer.parseInt(br.readLine());

        for (String input : inputs)
            budgets.add(Integer.parseInt(input));
        Collections.sort(budgets);
        int left = 0;
        int right = budgets.get(budgets.size() - 1); // 150

        while (left <= right) {
            int mid = (left + right) / 2;
            int temp=0;
            for (int i = 0; i < region; i++) {
                if(budgets.get(i) > mid) temp += mid;
                else temp += budgets.get(i);
            }

            if (temp > totalBudget) {
                right = mid - 1;
            } else if(temp <= totalBudget){
                left = mid + 1;
            }
        }
        System.out.println(right);
    }


    public static void main(String[] args) throws Exception {
        new Main().sol();
    }
}
