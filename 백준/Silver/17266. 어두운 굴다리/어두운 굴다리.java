import java.util.*;
import java.io.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String[] lights = br.readLine().split(" ");

        int left=1;
        int right=N;
        int h=0;
        while (left <= right) {
            int mid = (left+right)/2;
            if (check(mid,lights)) {
                h=mid;
                right = mid-1;
            } else left = mid+1;
        }

        System.out.println(h);
    }

    public static boolean check(int mid,String[] lights) {
        int prev=0;
        for (int i = 0; i < lights.length; i++) {
            if(Integer.parseInt(lights[i])-mid <= prev) prev = Integer.parseInt(lights[i])+mid;
            else return false;
        }
        return N-prev <= 0;
    }
}