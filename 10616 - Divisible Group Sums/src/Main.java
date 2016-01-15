import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by AhmedAmr on 1/15/16.
 */
public class Main {
    static int MAX ;
    static int D;
    static int M;
    static ArrayList<Integer> list = new ArrayList<>();
    static int[][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> line = readInts(nextLine(in));
        MAX = line.get(0);
        int q = line.get(1);
        int c = 1;
        while(MAX!=0&&q!=0){
            list = new ArrayList<>();
            for (int i = 0; i < MAX; i++) {
                list.add(readInts(nextLine(in)).get(0));
            }
            System.out.println("SET "+c+":");
            for (int i = 1; i <=q; i++) {
                line = readInts(nextLine(in));
                D = line.get(0);
                M = line.get(1);

                dp = new int[MAX+1][D+1][M+1];
                for (int j = 0; j <= MAX; j++) {
                    for (int k = 0; k <= D; k++) {
                        for (int l = 0; l <= M; l++) {
                            dp[j][k][l]=-1;
                        }
                    }
                }

                int res = solve(0,0,M);
                System.out.println("QUERY "+i+": "+res);
            }
            line = readInts(nextLine(in));
            MAX = line.get(0);
            q = line.get(1);
            c++;
        }
    }


    public static int solve(int i,int sumSoFar,int rem){
        //base case
            if(rem==0){
                if(sumSoFar%D==0)return 1;
                return 0;
            }
        // invalid
        if(i==MAX){
            return 0;
        }
        if(dp[i][sumSoFar][rem]!=-1)return dp[i][sumSoFar][rem];
        return dp[i][sumSoFar][rem] = solve(i+1,sumSoFar,rem)+solve(i+1,mod(sumSoFar+list.get(i),D),rem-1);

    }

    public static int mod(int i , int k){
        return (((i%k)+k)%k);
    }


    public static ArrayList<Integer> readInts(String line) {
        String[] arr = line.split(" ");
        ArrayList<Integer> res = new ArrayList<>();
        for (String s : arr) {
            if (!s.isEmpty()) res.add(Integer.parseInt(s));
        }
        return res;
    }



    public static String nextLine(BufferedReader in) throws IOException {
        String line = in.readLine();
        while (line.isEmpty()) {
            line = in.readLine();
        }
        return line;
    }

}
