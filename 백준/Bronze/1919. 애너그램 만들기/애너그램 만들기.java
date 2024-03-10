import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public void sol() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] alpha1 = new int[26];
        int[] alpha2 = new int[26];
        int count = 0;

        char[] str1 = br.readLine().toCharArray();
        char[] str2 = br.readLine().toCharArray();
        for (char c : str1)
            alpha1[c - 97]++;
        for (char c : str2)
            alpha2[c - 97]++;

        for (int i = 0; i < 26; i++) {
            if(alpha1[i]!=alpha2[i]){
                if(alpha1[i]>=alpha2[i])
                    count = count + (alpha1[i] - alpha2[i]);
                else
                    count = count + (alpha2[i] - alpha1[i]);
            }
        }
        System.out.println(count);
        br.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().sol();
    }
}
