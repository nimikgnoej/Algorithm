import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int count = 0;

    public void sol() throws Exception {
        Stack<String> stack = new Stack<>();
        String[] split = br.readLine().split("");

        for(int i = 0; i < split.length; i++) {
            if(split[i].equals("(")) {
                stack.push(split[i]);
            } else {
                if(split[i-1].equals("(")){ // lazer
                    stack.pop();
                    count += stack.size();
                } else {
                    stack.pop();
                    count+=1;
                }
            }
        }
        sb.append(count);
        System.out.println(sb);
        br.close();
    }




    public static void main(String[] args) throws Exception {
        new Main().sol();
    }
}
