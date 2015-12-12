import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by AhmedAmr on 12/12/15.
 */
public class Main {
    static Node startNode;
    static Node endNode;
    static ArrayList<Node> list ;
    static boolean visited[];
    static boolean result = false;
    static int MAX ;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> line = readInts(nextLine(in));
        while(line.get(0)!=0){
            int n = line.get(0);
            result = false;
            MAX = readInts(nextLine(in)).get(0);
            visited = new boolean[MAX];
            line = readInts(nextLine(in));
            startNode = new Node(line.get(0),line.get(1));
            line = readInts(nextLine(in));
            endNode = new Node(line.get(0),line.get(1));
            list = new ArrayList<>();
            for (int i = 0; i < MAX; i++) {
                line = readInts(nextLine(in));
                list.add(new Node(line.get(0), line.get(1)));
            }
            solve(n,startNode.y);
            if (result){
                System.out.println("YES");
            }else
            {
                System.out.println("NO");
            }
            line = readInts(nextLine(in));
        }
    }

    public static void solve(int leftSpaces , int sideToMatch){
        // invalid case
        if(leftSpaces<0)return;
        //end case
        if(leftSpaces==0){
            if(sideToMatch==endNode.x)result=true;
            return;
        }
        // for all possible states from this state
        for (int i = 0; i <MAX; i++) {
            if(!visited[i]){
                int otherSideToMatch = isMatched(list.get(i),sideToMatch);
                if(otherSideToMatch!=-1){
                    //do
                    visited[i] = true;

                    // recurse
                    solve(leftSpaces-1,otherSideToMatch);

                    //undo
                    visited[i]=false;
                }
            }
        }
        return;
    }
    //return -1 if no match
    //return the other side to match if matched
    public static int isMatched(Node node , int sideToMatch){
        if(node.x == sideToMatch)return node.y;
        if(node.y == sideToMatch)return node.x;
        return -1;
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
class Node{
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
