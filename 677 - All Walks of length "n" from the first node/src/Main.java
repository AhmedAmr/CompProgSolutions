import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by AhmedAmr on 12/13/15.
 */
public class Main {
    static int[] currentPath;
    static int currentIndex=0;
    static int SIZE ;
    static boolean[][] paths ;
    static ArrayList<int[]>results = new ArrayList<>();
    static boolean[][] input;
    static boolean [] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> line = readInts(nextLine(in));
        while(in.ready()){
            if(line.get(0)!=-9999) {
                results = new ArrayList<>();
                currentIndex = 0;
                SIZE = line.get(0);
                int n = line.get(1);
                input = new boolean[SIZE][SIZE];
                visited=new boolean[SIZE];
                for (int i = 0; i < SIZE; i++) {
                    line = readInts(nextLine(in));
                    fill(i, line);
                }
                paths = multiply(input, n);
                currentPath = new int[n + 1];
                solve(0, n);
                print(n);
            }else{
                System.out.println();
            }
            if(!in.ready())break;
            line = readInts(nextLine(in));
        }
    }

    public static void print(int n){
        if(results.size()==0){
            System.out.println("no walk of length "+n);
        }else{
            for (int[] result : results) {
                System.out.print("(");
                for (int i = 0; i < n+1; i++) {
                    if(i!=0){
                        System.out.print(",");
                    }
                    System.out.print((result[i]+1));
                }
                System.out.print(")\n");
            }
        }
    }

    public static void fill(int i , ArrayList<Integer> list){
        int j = 0;
        for (Integer integer : list) {
            input[i][j]=integer==0?false:true;
            j++;
        }
    }


    public static void solve(int nodeNum , int n){
        //end case
        if(n==0){
            //this node must be valid node
            if(paths[0][nodeNum]){
            currentPath[currentIndex]=nodeNum;
                results.add(Arrays.copyOf(currentPath,currentPath.length));
            }
            return;
        }
        //for each possible path from this node .. visit it
        for (int i = 0; i < SIZE; i++) {
            if(input[nodeNum][i]&&!visited[i]){
                //visit
                currentPath[currentIndex]=nodeNum;
                currentIndex++;
                visited[nodeNum]=true;

                //recurse
                solve(i,n-1);

                //undo
                currentIndex--;
                visited[nodeNum]=false;
            }
        }
        return;
    }

    public static boolean[][] multiply(boolean[][] leftArr,int n){
        //end case
        if (n==1)return leftArr;

        boolean[][] res = new boolean[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                boolean element = leftArr[i][0]&&input[0][j];
                for (int k = 1; k < SIZE; k++) {
                    element=element||(leftArr[i][k]&&input[k][j]);
                }
                res[i][j]=element;
            }
        }
        return multiply(res,n-1);
    }

    public static String nextLine(BufferedReader in) throws IOException {
        String line = in.readLine();
        while (line.isEmpty()) {
            line = in.readLine();
        }
        return line;
    }

    public static ArrayList<Integer> readInts(String line){
        String[] arr =  line.split(" ");
        ArrayList<Integer> res = new ArrayList<>();
        for (String s : arr) {
            if(!s.isEmpty()) res.add(Integer.parseInt(s));
        }
        return res;
    }

}
