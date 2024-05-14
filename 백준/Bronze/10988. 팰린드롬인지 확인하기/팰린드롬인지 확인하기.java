import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public void sol() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int len = str.length();

        if (len % 2 == 0) {
            for(int i = 0; i < len/2; i++) {
                if(str.charAt(i) != str.charAt(len-1-i)) { //다르면
                    System.out.println("0");
                    return;
                }
            }
            System.out.println("1");
        } else {
            for(int i = 0; i < len/2 - 1; i++) {
                if(str.charAt(i) != str.charAt(len-1-i)) { //다르면
                    System.out.println("0");
                    return;
                }
            }
            System.out.println("1");
        }
        br.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().sol();
    }
}
