import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by AhmedAmr on 12/27/15.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while(in.ready()) {
            ArrayList<Integer> line = readInts(nextLine(in));
            int n = line.get(0);
            int m = line.get(1);
            line = readInts(nextLine(in));
            int start = 1;
            int end = 1000000000;
            int mid = (int) Math.floor((start+end)/2);
            int res = 0;
            while(start<end){
                if(can(line,mid,m)){
                    //could exist a lower capacity to choose
                        res = mid;
                    end = mid;
                }else{
                    if(start==mid)break;
                    start = mid;
                }
                mid = (int) Math.floor((start+end)/2);
            }
            System.out.println(res);

        }
    }

    public static boolean can(ArrayList<Integer>list,int capacity,int k){
        int containers = 1;
        int rem = capacity;
        for (Integer current : list) {
            if(current>capacity)return false;
            if(current<rem){
                rem-=current;
            }else if(current==rem){
                rem=capacity;
                containers++;
            }else{
                containers++;
                rem = capacity-current;
            }
        }
        if(rem==capacity)containers--;
        if(containers>k){
            return false;
        }
        return true;
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
