import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by AhmedAmr on 11/19/15.
 */
public class Main {
    static boolean visitd[][] = new boolean[8][8];
    static Integer[] current = new Integer[8];
    static ArrayList<Integer[]> res=new ArrayList<>();
    static int INIT_ROW ;
    static int INIT_COL ;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> line = readInts(nextLine(in));
        Comparator<Integer[]> comparator = new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                int size =o1.length;
                for (int i = 0; i <size; i++) {
                    if(o1[i]<o2[i])return -1;
                    if(o1[i]>o2[i])return 1;
                }
                return 0;
            }
        };
        int l  = line.get(0);
        for (int i = 0; i < l; i++) {
            line = readInts(nextLine(in));
            visitd = new boolean[8][8];
            current = new Integer[8];
            res = new ArrayList<>();
            INIT_ROW = line.get(0)-1;
            INIT_COL = line.get(1)-1;
            visitd[INIT_ROW][INIT_COL]=true;
            solve(0, 0);
            Collections.sort(res,comparator);
            System.out.println("SOLN       COLUMN");
            System.out.println(" #      1 2 3 4 5 6 7 8\n");
            for (int j = 0; j < res.size(); j++) {
                if(j<9)
                    System.out.print(" "+(j+1)+"     ");
                else
                    System.out.print((j+1)+"     ");
                Integer[] arr = res.get(j);
                for (int k = 0; k <arr.length; k++) {
                System.out.print(" "+(arr[k]+1));
                }
                System.out.println();
            }
            if(i<l-1){
                System.out.println();
            }
        }

    }

    public static void solve(int r,int c){
        if(r==INIT_ROW){
            current[INIT_COL] = INIT_ROW;
            solve(r+1,0);
            return;
        }
        if(r==8){
            res.add(Arrays.copyOf(current,current.length));
            return;
        }
        for (int i = 0; i < 8; i++) {
            if(isAcceptedPosition(r,i)){
                //place queen
                visitd[r][i]=true;
                current[i]=r;

                // recurse
                solve(r+1,0);

                // remove queen
                visitd[r][i]=false;
            }
//            else if(r==INIT_ROW && i == INIT_COL){
//                current[INIT_COL]=INIT_ROW;
//                solve(r+1,0);
//            }
        }
        return;
    }

    public static boolean isAcceptedPosition(int r,int c){
            if (r < 0 || c < 0 || r > 7 || c > 7) return false;
            for (int i = 0; i <8; i++) {
                if (visitd[i][c]) return false;
            }
            for (int i = 0; i <8; i++) {
                if (visitd[r][i]) return false;
            }
            int temp = r - 1;
//        boolean res = true;
            int right = c;
            int left = c;
            while (temp >= 0) {
                right++;
                left--;
                if (right < 8) {
                    if (visitd[temp][right]) return false;
                }
                if (left > -1) {
                    if (visitd[temp][left]) return false;
                }
                temp--;
            }

        temp = r + 1;
//        boolean res = true;
        right = c;
        left = c;
        while (temp <8) {
            right++;
            left--;
            if (right < 8) {
                if (visitd[temp][right]) return false;
            }
            if (left > -1) {
                if (visitd[temp][left]) return false;
            }
            temp++;
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
