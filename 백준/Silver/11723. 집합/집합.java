import java.util.*;
import java.io.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public HashSet<Integer> set = new HashSet<>();

    public void sol() throws Exception {
        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            String[] inputs = br.readLine().split(" ");
            String operation = inputs[0];
            int number = 0;
            if(inputs.length>=2)
                number = Integer.parseInt(inputs[1]);

            if(operation.equals("add")){
                set.add(number);
            } else if (operation.equals("remove")) {
                set.remove(number);
            } else if (operation.equals("check")) {
                if(set.contains(number))
                    sb.append("1"+"\n");
                else
                    sb.append("0"+"\n");
            } else if (operation.equals("toggle")) {
                if(set.contains(number))
                    set.remove(number);
                else
                    set.add(number);
            } else if (operation.equals("all")) {
                set = new HashSet<>();
                for (int i = 1; i <= 20; i++) {
                    set.add(i);
                }
            } else if (operation.equals("empty")) {
                set = new HashSet<>();
            }
        }
        System.out.println(sb);
    }


    public static void main(String[] args) throws Exception {
        new Main().sol();
    }
}
