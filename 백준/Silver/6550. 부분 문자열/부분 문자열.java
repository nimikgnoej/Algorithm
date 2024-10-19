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
        String str;

        while((str=br.readLine()) != null){
            String[] inputs = str.split(" ");
            char[] s = inputs[0].toCharArray();
            char[] t = inputs[1].toCharArray();
            boolean isSub = true;
            boolean found = false;
            int k=0;
            for (int i = 0; i < s.length;i++) {
                found = false;
                for (int j = k; j < t.length; j++) {
                    if(s[i] == t[j]){
                        k = j+1;
                        found = true;
                        break;
                    }
                }
                if(!found){
                    isSub = false;
                    break;
                }
            }
            if(isSub) System.out.println("Yes");
            else System.out.println("No");
        }
    }


    public static void main(String[] args) throws Exception {
        new Main().sol();
    }

}
