import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by AhmedAmr on 12/14/15.
 */
public class Main {
    static boolean result = false;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> line = readStrings(nextLine(in));
        int n = Integer.parseInt(line.get(0));
        for (int i = 0; i < n; i++) {
            line = readStrings(nextLine(in));
            result = false;
            solve(line.get(0));
            if(result)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }

    public static void solve(String s){
        //end case
        if(s.length()==0){
            result = true;
            return;
        }
        int size  =s.length();
        //go to all possible states form here
        for (int j = 0; j <size; j++) {
            int next = nextPart(s.toCharArray(),j);
            if(next==-1){
                next = nextPart(s.toCharArray(),0);
                if(next==-1&&s.length()>1)result=true;
                return;
            }
            if(next-j!=1){
                // could be popped :D
                //do pop them
                String popped = s.substring(0,j).concat(s.substring(next,s.length()));
                solve(popped);
            }
            j=next-1;
        }
        return;
    }

    public static int nextPart(char[] s , int i){
        int length = s.length;
        for (int j = i+1; j <length; j++) {
            if(s[j]!=s[i])return j;
        }
        return -1;
    }

    public static ArrayList<String> readStrings(String line) {
        String[] arr = line.split(" ");
        ArrayList<String> res = new ArrayList<>();
        for (String s : arr) {
            if (!s.isEmpty()) res.add(s);
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
