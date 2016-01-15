import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by AhmedAmr on 1/15/16.
 */
public class Main {
    static int MAX ;
    static int TOTAL=0;
    static ArrayList<Integer> list = new ArrayList<>();
    static int[][]dp;
    public static void main(String[] args) throws IOException {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            TOTAL=0;
            list = new ArrayList<>();
            MAX = s.nextInt();
            for (int j = 0; j < MAX; j++) {
                int current = s.nextInt();
                TOTAL += current;
                list.add(current);
            }
            dp = new int[MAX][TOTAL];
            for (int j = 0; j < MAX; j++) {
                for (int k = 0; k < TOTAL; k++) {
                    dp[j][k] = -1;
                }
            }
            System.out.println(solve(0, 0));
        }
    }

    public static int solve(int i,int sumSoFar){
        //base case
        if(i==MAX){
            int part2 = Math.abs(TOTAL-sumSoFar);
            return Math.abs(part2-sumSoFar);
        }
        if(dp[i][sumSoFar]!=-1)return dp[i][sumSoFar];
        return dp[i][sumSoFar]=Math.min(solve(i+1,sumSoFar),solve(i+1,sumSoFar+list.get(i)));
    }

}
