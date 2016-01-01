import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by AhmedAmr on 12/31/15.
 */
public class Main {
    static int M;
    static int C;
    static ArrayList<ArrayList<Integer>>input;
    static int mem[][];

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> line = readInts(nextLine(in));
        int n = line.get(0);
        for (int j = 0; j < n; j++) {
            line = readInts(nextLine(in));
            M = line.get(0);
            C = line.get(1);
            input = new ArrayList<>();
            mem = new int[201][21];
            for (int[] ints : mem) {
                Arrays.fill(ints,-1);
            }


            for (int i = 0; i < C; i++) {
                line = readInts(nextLine(in));
                line.remove(0);
                input.add(new ArrayList<>(line));
            }
            //uncomment bellow to using Top Down DP
//            int res = solve_TOP_DOWN(M, 0);
            int res = solve_BOTTOM_UP();
            if (res<0) System.out.println("no solution");
            else System.out.println(res);
        }
    }


    //Solving By Recursive Backtracking
    // will give time limit exceeded as it's 20^20 operations
    /*
        To solve it we need to add memomization step (Top Down DP)
        Accepted Top Down Solution
     */

    public static int solve_TOP_DOWN(int rem,int g){
        //invalid cases
        if(rem<0)return Integer.MIN_VALUE;

        if(mem[rem][g]!=-1){
            return mem[rem][g];
        }

        //base case
        if(g==C){
            return M-rem;
        }


        //for all states that can be reached from this state .. go to it
        ArrayList<Integer> current = input.get(g);
        int size = current.size();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {

            int item = current.get(i);

            int res = solve_TOP_DOWN(rem - item, g + 1);
            max = Math.max(res,max);

        }
        return mem[rem][g] = max;
    }


    static int cur = 0;
    static int prev = 1;
    static boolean memo[][] ;


    /*
        Another way to solve it using Bottom-up DP using space saving trick to only use 2 colms to reduce the space.
     */
    public static int solve_BOTTOM_UP(){
        cur = 0;
        prev =1;
        memo = new boolean[201][2];
        //init
        ArrayList<Integer> current = input.get(0);
        for (Integer integer : current) {
            int idx = M-integer;
            if(idx>=0)
                memo[idx][cur]=true;
        }
        for (int k = 1; k < C; k++) {

            int temp = cur;
            cur = prev;
            prev = temp;

             current = input.get(k);
            boolean isChanged = false;
            for (boolean[] booleans : memo) {
                booleans[cur]=false;
            }
            for (int i = 0; i < 201; i++) {
                if (memo[i][prev]) {
                    for (Integer item : current) {
                        int value = i - item;
                        if (value >= 0) {
                            memo[value][cur] = true;
                            isChanged = true;
                        }
                    }
                }
            }
            if(!isChanged)return -1;
        }
        for (int i = 0; i < 201; i++) {
                if(memo[i][cur]){
                    return M-i;
                }
        }
        return -1;
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
