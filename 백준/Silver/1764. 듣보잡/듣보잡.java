import java.util.*;
import java.io.*;
import java.util.stream.Stream;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    HashSet<String> didntHeard = new HashSet<>();
    List<String> list = new ArrayList<>();

    public void sol() throws Exception {
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            didntHeard.add(name);
        }

        for (int i = 0; i < m; i++) {
            String didntSee = br.readLine();
            if(didntHeard.contains(didntSee))
                list.add(didntSee);
        }

        Collections.sort(list);
        System.out.println(list.size());
        for (String name : list) {
            System.out.println(name);
        }
    }



    public static void main(String[] args) throws Exception {
        new Main().sol();
    }
}
