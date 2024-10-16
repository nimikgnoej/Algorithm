import java.util.*;
import java.io.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public void sol() throws Exception {
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int count = 0;
            Queue<Integer> q = new LinkedList<>();
            List<Integer> list = new ArrayList<>();
            String[] inputs = br.readLine().split(" ");
            int testCaseNum = Integer.parseInt(inputs[0]);
            for (int i = 1; i < 21; i++)
                q.add(Integer.parseInt(inputs[i]));

            while (!q.isEmpty()) {
                int x = q.poll();
                int res = hasBigger(list, x);
                if(res >= 0){ // 자기 앞에 키 큰 애가 있다면 발자국 계산
                    count += res;
                } else {
                    list.add(x);
                }
            }
            System.out.println(testCaseNum + " " + count);
        }

    }

    public int hasBigger(List<Integer> list, int x){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) > x){
                int size = list.size();
                list.add(x);
                Collections.sort(list);
                return size - i;
            }
        }
        return -1;
    }


    public static void main(String[] args) throws Exception {
        new Main().sol();
    }
}
