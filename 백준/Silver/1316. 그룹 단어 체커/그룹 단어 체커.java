import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public void sol() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = 0;

        int n = Integer.parseInt(br.readLine());
        for(int i = 1; i <= n; i++) {
            boolean[] alpha = new boolean[26];
            String str = br.readLine();
            for(int j = 0; j < str.length(); j++) {
                if(j == str.length() - 1) {
                    if(!alpha[str.charAt(j) - 'a']) {
                        alpha[str.charAt(j) - 'a'] = true;
                    } else {
                        cnt--;
                        break;
                    }
                } else{
                    if (str.charAt(j + 1) != str.charAt(j)) {//지금과 다음 알파벳이 같으면
                        if (!alpha[str.charAt(j) - 'a']) // false라면 넣고 true 라면 거부
                            alpha[str.charAt(j) - 'a'] = true;
                        else {
                            cnt--;
                            break;
                        }
                    }
                }
            }
            cnt++;
        }
        System.out.println(cnt);

        br.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().sol();
    }
}
