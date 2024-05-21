import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public void sol() throws Exception {
        while(true) {
            String str = br.readLine();
            if(str.equals("."))
                break;
            func(str);
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '\n') {
            sb.deleteCharAt(sb.length() - 1);
        }
        System.out.println(sb);
        br.close();
    }

    private static void func(String str) throws IOException {
        Stack<String> stack = new Stack<>();
        st = new StringTokenizer(str," ()[]",true);


        while(st.hasMoreTokens()) {
            String target = st.nextToken();
            if (target.equals("(") || target.equals("[")) { // 여는 괄호이면 스택에 push
                stack.push(target);
            } else if(target.equals(")")){ // 닫는 소괄호이면 top이 여는 소괄호일때 pop
                if(!stack.empty() && stack.peek().equals("("))
                    stack.pop();
                else{
                    sb.append("no\n");
                    return;
                }
            } else if(target.equals("]")){ // 닫는 대괄호이면 top이 여는 대괄호일때 pop
                if(!stack.empty() && stack.peek().equals("["))
                    stack.pop();
                else{
                    sb.append("no\n");
                    return;
                }
            }
        }
        if(stack.empty())
            sb.append("yes\n");
        else
            sb.append("no\n");
    }


    public static void main(String[] args) throws Exception {
        new Main().sol();
    }
}
