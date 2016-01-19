import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by AhmedAmr on 1/19/16.
 */
public class Main {
    static int[] q ;
    static int[] p;
    static int MAX ;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> line = readInts(nextLine(in));
        int n = line.get(0);
        for (int i = 0; i < n; i++) {
            line = readInts(nextLine(in));
            int l = line.get(0);
            q = new int[1001];
            p = new int[1001];
            for (int j = 0; j < l; j++) {
                line = readInts(nextLine(in));
                q[j] = line.get(0);
                p[j] = line.get(1);
            }
            dp = new int[1001][1001];
            for (int[] ints : dp) {
                Arrays.fill(ints,-1);
            }
            MAX = l;
            System.out.println(solve(0,0));
        }
    }

    public static int solve(int i,int j) {
        if(j==MAX)return 0;

        if(dp[i][j]!=-1)return dp[i][j];

        int path1 = (sum(i,j)+10)*p[j]+solve(j+1,j+1);
        int path2 = Integer.MAX_VALUE;
        if(j+1!=MAX)
            path2= solve(i,j+1);

        return dp[i][j]=Math.min(path1, path2);

    }

    public static int sum(int i ,int j){
        int sum = 0;
        for (int k = i ; k <=j ; k++) {
            sum+=q[k];
        }
        return sum;
    }

    public static ArrayList<Integer> readInts(String line) {
        String[] arr = line.split(" ");
        ArrayList<Integer> res = new ArrayList<>();
        for (String s : arr) {
            if (!s.isEmpty()) res.add(Integer.parseInt(s));
        }
        return res;
    }

    public static ArrayList<String> readStrings(String line) {
        String[] arr = line.split(" ");
        ArrayList<String> res = new ArrayList<>();
        for (String s : arr) {
            if (!s.isEmpty()) res.add(s);
        }
        return res;
    }

    public static String nextReadyLine(BufferedReader in) throws IOException {
        if (!in.ready()) return null;
        String line = in.readLine();
        while (line.isEmpty()) {
            if (!in.ready())
                break;
            line = in.readLine();
        }
        return line;
    }

    public static String nextLine(BufferedReader in) throws IOException {
        String line = in.readLine();
        while (line.isEmpty()) {
            line = in.readLine();
        }
        return line;
    }

}
