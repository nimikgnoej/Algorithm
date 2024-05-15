import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public void sol() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<Integer>();

        while (n-- > 0) {
            String[] command = br.readLine().split(" ");
            String commandType = command[0];
            if(commandType.equals("push")) {
                int target = Integer.parseInt(command[1]);
                stack.push(target);
            } else if(commandType.equals("pop")) {
                if(stack.isEmpty())
                    bw.write("-1"+"\n");
                else
                    bw.write(stack.pop()+"\n");
            } else if(commandType.equals("size")) {
                bw.write(stack.size()+"\n");
            } else if(commandType.equals("empty")) {
                if(stack.isEmpty())
                    bw.write("1"+"\n");
                else
                    bw.write("0"+"\n");
            } else if(commandType.equals("top")) {
                if(stack.isEmpty())
                    bw.write("-1"+"\n");
                else
                    bw.write(stack.peek()+"\n");
            }
        }
        bw.flush();

        bw.close();
        br.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().sol();
    }
}
