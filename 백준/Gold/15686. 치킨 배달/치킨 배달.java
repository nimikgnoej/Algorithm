import java.util.*;
import java.io.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public int[][] map;
    int n,m;
    int min = Integer.MAX_VALUE;
    List<int[]> chickenList = new ArrayList<>();
    List<int[]> houseList = new ArrayList<>();
    boolean[] selected;

    public void sol() throws Exception {
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        map = new int[n][n];


        for(int i=0;i<n;i++){
            String[] inputs = br.readLine().split(" ");
            for(int j=0;j<n;j++){
                map[i][j] = Integer.parseInt(inputs[j]);
                if(map[i][j]==2)
                    chickenList.add(new int[]{i, j});
                else if(map[i][j]==1)
                    houseList.add(new int[]{i, j});
            }
        }
        selected = new boolean[chickenList.size()];
        calculate(0, 0);
        sb.append(min);
        System.out.println(sb);

    }


    public void calculate(int count,int index){
        if (count == m) {
            int dist=0;
            for (int i = 0; i < houseList.size(); i++) {
                int max = 987654321;
                for (int j = 0; j < chickenList.size(); j++) {
                    if(selected[j]){
                        int res = Math.abs(houseList.get(i)[0] - chickenList.get(j)[0]) + Math.abs(houseList.get(i)[1] - chickenList.get(j)[1]);
                        max = Math.min(max, res);
                    }
                }
                dist += max;
            }
            min = Math.min(dist, min);
            return;
        }

        for (int i = index; i < chickenList.size(); i++) {
            if (!selected[i]) {
                selected[i] = true;
                calculate(count+1, i+1);
                selected[i] = false;
            }
        }
    }


    public static void main(String[] args) throws Exception {
        new Main().sol();
    }
}
