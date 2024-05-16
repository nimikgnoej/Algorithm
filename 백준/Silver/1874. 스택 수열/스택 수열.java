import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
    public void sol() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        int start = 0;

        while (n-- > 0) {
            int num = Integer.parseInt(br.readLine());
            if (num > start) {
                for(int i=start+1;i<=num;i++) {
                    stack.push(i);
                    //bw.write("+"+"\n");
                    sb.append("+\n");
                }
                start = num;
            }
            else if (stack.peek() != num) {
                System.out.println("NO");
                System.exit(0);
            }

            stack.pop();
            //bw.write("-" + "\n");
            sb.append("-\n");
        }
        //bw.flush();
        //bw.close();

        System.out.println(sb);
        br.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().sol();
    }
}
