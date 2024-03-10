import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static int cnt = 0;
    public void sol() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();
        int target = Integer.parseInt(br.readLine());

        String[] inputArr = input.split(" ");

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(inputArr[i]);
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] == target)
                cnt++;
        }
        System.out.println(cnt);
        br.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().sol();
    }
}
