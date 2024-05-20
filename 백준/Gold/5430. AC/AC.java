import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static boolean reverse = false;
    StringTokenizer st;
    public void sol() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<Integer> dq = new ArrayDeque<>();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            reverse = false;
            String[] command = br.readLine().split("");
            int commandLength = command.length;

            int length = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), "[],");
//            String[] arr = br.readLine().split(",");
//
//            arr[0]=arr[0].replace("[","");
//            arr[length-1]=arr[length-1].replace("]","");

            for(int i = 0; i < length; i++)
                dq.add(Integer.parseInt(st.nextToken()));

            AC(commandLength, command, dq);
        }
        System.out.println(sb);
        br.close();
    }

    private static void print(Deque<Integer> dq) {
        sb.append("[");
        if (dq.size() > 0) {
            if (reverse == false) { // 정상이라면 앞에서부터 출력
                sb.append(dq.poll());
                while (!dq.isEmpty()) {
                    sb.append(",").append(dq.poll());
                }
            } else {
                sb.append(dq.pollLast());
                while (!dq.isEmpty()) {
                    sb.append(",").append(dq.pollLast());
                }
            }
        }
        sb.append("]").append("\n");
    }

    public static void AC(int commandLength, String[] command, Deque<Integer> dq) {
        for (int i = 0; i < commandLength; i++) {
            if(command[i].equals("R")) // 뒤집음
                reverse = !reverse;

            else if (command[i].equals("D")) {
                if (reverse == false) { // 정상 상태
                    if (dq.pollFirst() == null) { //비어있는 덱에 대해서 D 연산
                        sb.append("error\n");
                        return;
                    }
                } else { // 뒤집어진 상태
                    if (dq.pollLast() == null) { //비어있는 덱에 대해서 D 연산
                        sb.append("error\n");
                        return;
                    }
                }
            }
        }
        print(dq);
    }

    public static void main(String[] args) throws Exception {
        new Main().sol();
    }
}
