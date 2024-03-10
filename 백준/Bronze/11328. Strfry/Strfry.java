import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public void sol() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            int[] alpha = new int[26];
            String[] strings = br.readLine().split(" ");
            char[] str1 = strings[0].toCharArray();
            char[] str2 = strings[1].toCharArray();
            for (char c : str1)
                alpha[c - 97]++;
            for (char c : str2)
                alpha[c - 97]--;

            boolean flag = true;
            for (int k : alpha)
                if(k!=0)
                    flag = false;

            if (flag == true)
                System.out.println("Possible");
            else
                System.out.println("Impossible");

        }
        br.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().sol();
    }
}
