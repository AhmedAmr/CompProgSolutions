import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by AhmedAmr on 9/29/15.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine());
        Queue<Integer>left = new LinkedList<>();
        Queue<Integer>right = new LinkedList<>();
        for (int i = 0; i < t; i++) {
            left.clear();
            right.clear();
            String line[] = in.readLine().split(" ");
            int l = Integer.parseInt(line[0]);
            int size = Integer.parseInt(line[1]);
            for (int j = 0; j < size; j++) {
                line = in.readLine().split(" ");
                int value = Integer.parseInt(line[0]);
                if(line[1].equals("left")){
                    left.add(value);
                }else{
                    right.add(value);
                }
            }
            out.append(String.valueOf(run(l*100,left,right)));
            out.append("\n");
            out.flush();
        }
    }

    public static int run(int l , Queue<Integer> left , Queue<Integer> right){
        int moves = 0;
        boolean isLoaded;
        boolean isLeft = true;
        while(true){
            if(isLeft){
                isLoaded = load(l,left);
                if(isLoaded){
                    moves++;
                    isLeft=false;
                }else{
                    isLoaded = load(l,right);
                    if(isLoaded){
                        moves+=2;
                    }else{
                        return moves;
                    }
                }
            }else{
                isLoaded = load(l,right);
                if(isLoaded){
                    moves++;
                    isLeft=true;
                }else{
                    isLoaded = load(l,left);
                    if(isLoaded){
                        moves+=2;
                    }else{
                        return moves;
                    }
                }
            }
        }

    }

    public static boolean load(int l , Queue<Integer> q){
        if(q.isEmpty()) return false;
        int sum = 0;
        while(!q.isEmpty()){
            if(q.peek()+sum<=l)sum+=q.poll();
            else break;
        }
        return true;
    }
}
