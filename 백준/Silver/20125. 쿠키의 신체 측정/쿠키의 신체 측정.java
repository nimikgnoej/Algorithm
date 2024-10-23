import java.util.*;
import java.io.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int heartX = 0;
    int heartY = 0;
    int n;
    int leftArm, rightArm, leftLeg, rightLeg, waist;

    public void sol() throws Exception {
        n = Integer.parseInt(br.readLine());
        String[][] map = new String[n][n];

        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = inputs[j];
            }
        }
        findHeart(map);

        findLeftArm(map);
        findRightArm(map);
        findWaist(map);
        findLeftLeg(map);
        findRightLeg(map);
        System.out.println((heartX + 1) + " " + (heartY + 1));
        System.out.println(leftArm + " " + rightArm + " " + waist + " " + leftLeg + " " + rightLeg);
    }

    private void findRightLeg(String[][] map) {
        int x=heartX + waist + 1;
        int y=heartY + 1;
        while (true) {
            if(x>=n)
                break;
            if (!map[x][y].equals("*")) { // 몸이 아님
                break;
            }
            rightLeg++;
            x++;
        }
    }

    private void findLeftLeg(String[][] map) {
        int x=heartX + waist + 1;
        int y=heartY - 1;
        while (true) {
            if(x>=n)
                break;
            if (!map[x][y].equals("*")) { // 몸이 아님
                break;
            }
            leftLeg++;
            x++;
        }
    }

    private void findWaist(String[][] map) {
        int x=heartX;
        int y=heartY;
        while (true) {
            if (!map[x+1][y].equals("*")) { // 몸이 아님
                break;
            }
            waist++;
            x++;
        }
    }

    private void findLeftArm(String[][] map) {
        int x=heartX;
        int y=heartY-1;
        while (true) {
            if(y<0)
                break;
            if (!map[x][y].equals("*")) { // 몸이 아님
                break;
            }
            leftArm++;
            y--;
        }
    }
    private void findRightArm(String[][] map) {
        int x=heartX;
        int y=heartY+1;
        while (true) {
            if(y>=n)
                break;
            if (!map[x][y].equals("*")) { // 몸이 아님
                break;
            }
            rightArm++;
            y++;
        }
    }

    public void findHeart(String[][] map) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j].equals("*")) {
                    heartX = i+1;
                    heartY = j;
                    return;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().sol();
    }
}
