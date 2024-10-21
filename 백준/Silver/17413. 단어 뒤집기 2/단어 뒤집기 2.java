import java.util.*;
import java.io.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void sol() throws Exception {
        String str = br.readLine();
        char[] arr = str.toCharArray();
        boolean toStack = true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                if(toStack){
                    while (!stack.empty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(arr[i]);
                }
            }
            if (arr[i] == '<') {
                toStack = false;
                while (!stack.empty()) {
                    sb.append(stack.pop());
                }
            } else if(arr[i]=='>'){
                sb.append(arr[i]);
                toStack = true;
            }

            if (!toStack) { // toStack이 false 면
                sb.append(arr[i]);
            } else {
                if(arr[i]=='>') continue;
                else if(arr[i]!=' ')
                    stack.push(arr[i]);
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);

    }

    public static void main(String[] args) throws Exception {
        new Main().sol();
    }
}
