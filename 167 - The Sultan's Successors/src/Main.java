import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by AhmedAmr on 11/18/15.
 */
public class Main {
    static boolean visitd[][] = new boolean[8][8];
    static int MAX_SUM = 0;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> line = readInts(nextLine(in));
        int l = line.get(0);
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < 8; j++) {
                list.add(readInts(nextLine(in)));
            }
            solve(0, 0, 0);
            String result = String.valueOf(MAX_SUM);
            int s = 5-result.length();
            for (int j = 0; j < s; j++) {
                System.out.print(" ");
            }
            System.out.print(result);
            System.out.println();
            MAX_SUM=0;
            visitd = new boolean[8][8];
            list = new ArrayList<>();
        }

    }



    public static void solve(int r,int c,int sum){
        if(r==8){
            if(sum>MAX_SUM)MAX_SUM=sum;
            return;
        }
        for (int i = 0; i < 8; i++) {
            if(isAcceptedPosition(r,i)){
                //place queen
                visitd[r][i]=true;

                // recurse
                solve(r+1,0,sum+list.get(r).get(i));

                // remove queen
                visitd[r][i]=false;
            }
        }
        return;
    }

    public static boolean isAcceptedPosition(int r,int c){
        if(r<0||c<0||r>7||c>7) return false;
        for (int i = r; i >=0 ; i--) {
            if(visitd[i][c])return false;
        }
        for (int i = c; i >=0 ; i--) {
            if(visitd[r][i])return false;
        }
        int temp = r-1;
//        boolean res = true;
        int right = c;
        int left = c;
        while(temp>=0){
            right++;
            left--;
            if(right<8){
                if(visitd[temp][right])return false;
            }
            if(left> -1){
                if(visitd[temp][left])return false;
            }
            temp--;
        }
        return true;
    }

    public static ArrayList<Integer> readInts(String line){
        String[] arr =  line.split(" ");
        ArrayList<Integer> res = new ArrayList<>();
        for (String s : arr) {
            if(!s.isEmpty()) res.add(Integer.parseInt(s));
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
