import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Created by AhmedAmr on 10/2/15.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine());
        in.readLine();//empty
        for (int i = 0; i < n; i++) {
            int pos = 0;
            int neg = 0;
            int size = Integer.parseInt(in.readLine())+1;
            UnionFind uf = new UnionFind(size);
            String line = in.readLine();
            while(true){
                if(line==null)break;
                if(line.isEmpty())break;
                String[] input = line.split(" ");
                if(input[0].equals("c")){
                    uf.union(Integer.parseInt(input[1]),Integer.parseInt(input[2]));
                }else{
                    if(uf.find(Integer.parseInt(input[1])) == uf.find(Integer.parseInt(input[2])))pos++;
                    else neg++;
                }
                line = in.readLine();
            }
            out.append(String.valueOf(pos));
            out.append(",");
            out.append(String.valueOf(neg));
            out.append("\n");
            if(i<n-1)out.append("\n");
            out.flush();
        }

    }

    public static class UnionFind {
        private int size;
        private int[] links;


        public UnionFind(int maxSize) {
            this.size = maxSize;
            links = new int[size];
            for (int i = 0; i < size; i++) {
                links[i] = i;
            }
        }

        public int find(int x) {
            if (x == links[x]) return x; // base case
            int root = find(links[x]);
            links[x] = root;
            return root;
        }

        public void union(int x, int y) {
            links[find(x)] = find(y);
        }


    }


}
