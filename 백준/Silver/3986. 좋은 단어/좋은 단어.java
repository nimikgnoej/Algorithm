import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int count = 0;

    public void sol() throws Exception {
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String str = br.readLine();
            goodWord(str);
        }
        sb.append(count);
        System.out.println(sb);
        br.close();
    }

    private static void goodWord(String str) {
        int aCnt=0;
        int bCnt=0;
        Stack<String> stack = new Stack<>();
        st = new StringTokenizer(str,"");
        String[] split = str.split("");
        int len = split.length;
        for(int i=0;i<len;i++) {
            String word = split[i];
            if(word.equals("A")){
                if (aCnt == 0) {
                    stack.push("A");
                    aCnt++;
                } else {
                    if(!stack.isEmpty()){
                        if (stack.peek().equals("A")) {
                            stack.pop();
                            aCnt-=1;
                        } else {
                            stack.push("A");
                            aCnt++;
                        }
                    }
                }
            } else if(word.equals("B")){
                if (bCnt == 0) {
                    stack.push("B");
                    bCnt++;
                } else {
                    if(!stack.isEmpty()){
                        if (stack.peek().equals("B")) {
                            stack.pop();
                            bCnt-=1;
                        } else {
                            stack.push("B");
                            bCnt++;
                        }
                    }
                }
            }
        }
        if (stack.empty()) {
            count++;
        }
    }


    public static void main(String[] args) throws Exception {
        new Main().sol();
    }
}
