import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public void sol() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        for (int i = 0; i < m; i++) {
            String[] inputs = br.readLine().split(" ");
            int from = Integer.parseInt(inputs[0])-1;
            int to = Integer.parseInt(inputs[1])-1;
            int temp=0;

            temp = arr[from];
            arr[from] = arr[to];
            arr[to] = temp;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        br.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().sol();
    }
}
