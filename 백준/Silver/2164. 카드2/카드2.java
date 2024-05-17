import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public void sol() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Deque<Integer> dq = new ArrayDeque<>();
        int num = Integer.parseInt(br.readLine());
        while(num-- > 0)
            dq.push(num+1);

        while (dq.size() > 1) {
            dq.pop();
            dq.addLast(dq.pop());
        }
        sb.append(dq.pop());

        System.out.println(sb);
        br.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().sol();
    }
}
