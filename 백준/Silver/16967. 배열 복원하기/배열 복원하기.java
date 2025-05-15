import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int H = Integer.parseInt(input[0]);
        int W = Integer.parseInt(input[1]);
        int X = Integer.parseInt(input[2]);
        int Y = Integer.parseInt(input[3]);
        int[][] B = new int[H+X][W+Y];
        int[][] A = new int[H][W];

        for (int i = 0; i < H + X; i++) {
            String[] ins = br.readLine().split(" ");
            for (int j = 0; j < W + Y; j++) {
                B[i][j] = Integer.parseInt(ins[j]);
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                int tx = i;
                int ty = j;
                boolean check = false;
                if (i >= X && j >= Y) {
                    tx = i-X;
                    ty = j-Y;
                    check = true;
                }
                if(check){
                    A[i][j] = B[i][j] - B[tx][ty];
                    B[i][j] = B[i][j] - B[tx][ty];
                }
                else
                    A[i][j] = B[i][j];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                sb.append(A[i][j]);
                if(j!=W-1) sb.append(" ");
            }
            if(i!=H-1) sb.append("\n");
        }
        System.out.println(sb);
    }
}

