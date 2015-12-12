import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by AhmedAmr on 12/11/15.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> line = readInts(nextLine(in));
        while(line.get(0)!=0){
            visited = new boolean[5];
            answer = false;
            solve(line,0,0);
            if(answer){
                System.out.println("Possible");
            }else{
                System.out.println("Impossible");
            }
            line =readInts(nextLine(in));
        }
    }

    static boolean [] visited;
    static boolean answer;

    private static void solve(ArrayList<Integer> nums, int sumSoFar, int i) {
        //final case
        if(i==5){
            if(sumSoFar==23){
                answer=true;
            }
            return;
        }
        // for all possible transitions , go to it
        for (int j = 0; j < 5; j++) {
            if(!visited[j]){
                //do visit
                visited[j]=true;

                if(i==0){
                    // recurse
                    solve(nums,nums.get(j),i+1);
                }else{
                    // recurse
                    solve(nums,sumSoFar+nums.get(j),i+1);
                    solve(nums,sumSoFar*nums.get(j),i+1);
                    solve(nums,sumSoFar-nums.get(j),i+1);
                }
                //undo
                visited[j]=false;
            }
        }
        return ;
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
