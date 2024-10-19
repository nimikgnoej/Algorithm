import java.util.*;
import java.io.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void sol() throws Exception {
        String str;
        char[] password;
        while ((str = br.readLine()) != null) {
            boolean isAcc = true;
            if (str.equals("end")) {
                break;
            }
            password = str.toCharArray();

            if (!hasVowels(password)) {
                isAcc = false;
            }

            if(isThreeInARow(password))
                isAcc = false;

            if(sameChar(password))
                isAcc = false;

            if(isAcc)
                sb.append("<").append(str).append("> is acceptable.").append("\n");
            else sb.append("<").append(str).append("> is not acceptable.").append("\n");
        }
        System.out.println(sb);
    }

    public boolean sameChar(char[] password) {
        if(password.length<2)
            return false;
        boolean result = false;
        for (int i = 0; i < password.length-1; i++) {
            if (password[i] == password[i + 1]) {
                if (password[i] == 'e' || password[i] == 'o') {
                    result = false;
                }
                else {
                    return true;
                }
            }
        }
        return result;
    }

    public boolean isVowel(char c) {
        return c == 'a' ||
                c == 'e' ||
                c == 'i' ||
                c == 'o' ||
                c == 'u';
    }

    public boolean isThreeInARow(char[] password) {
        if(password.length<3)
            return false;
        boolean result = true;
        for (int i = 0; i < password.length-2; i++) {
            if(isVowel(password[i])){ // 모음이라면
                if(!isVowel(password[i+1])){
                    result = false;
                } else{
                    if (!isVowel(password[i + 2])) {
                        result = false;
                    }
                    else{
                        return true;
                    }
                }
            }
            else{ // 시작이 자음이라면
                if(isVowel(password[i+1])){ // 두번째는 모음이면
                    result =  false;
                } else {
                    if (isVowel(password[i + 2])) {
                        result =  false;
                    }
                    else{
                        return true;
                    }
                }
            }
        }
        return result;
    }

    public boolean hasVowels(char[] password) {
        boolean result = false;
        for (int i = 0; i < password.length; i++) {
            if (
                    password[i] == 'a' ||
                    password[i] == 'e' ||
                    password[i] == 'i' ||
                    password[i] == 'o' ||
                    password[i] == 'u'
            ) {
                return true;
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        new Main().sol();
    }
}
