    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.ArrayList;
    import java.util.Arrays;

    /**
     * Created by AhmedAmr on 12/11/15.
     */
    public class Main {
        static ArrayList<String[]> result = new ArrayList<>();
        static int ruleSize ;
        static String[] current;
        public static void main(String[] args) throws IOException {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            while(in.ready()) {
                ArrayList<String> line = readStrings(nextLine(in));
                int n = Integer.parseInt(line.get(0));
                String[] dict = new String[n];
                for (int i = 0; i < n; i++) {
                    dict[i] = readStrings(nextLine(in)).get(0);
                }
                int m = Integer.parseInt(readStrings(nextLine(in)).get(0));
                String[] rules = new String[m];
                for (int i = 0; i < m; i++) {
                    rules[i] = readStrings(nextLine(in)).get(0);
                }
                System.out.println("--");
                for (int i = 0; i < m; i++) {
                    ruleSize = rules[i].length();
                    current = new String[ruleSize];
                    solve(dict,rules[i].toCharArray(),0);
                }
                for (String[] strings : result) {
                    for (int i = 0; i < strings.length; i++) {
                        System.out.print(strings[i]);
                    }
                    System.out.println();
                }
                result= new ArrayList<>();
            }
        }

        private static void solve(String[] dict, char[] ruls , int ri) {
            //final case
            if(ri == ruleSize){
                result.add(Arrays.copyOf(current,current.length));
    //            current = new String[ruleSize];
                return;
            }
            if(ruls[ri]=='#'){
                //for each possible state form this state
                for (int i = 0; i < dict.length; i++) {
                    //do
                    current [ri] = dict[i];
                    //recurse
                    solve(dict,ruls,ri+1);
                }
            }else{
                //for each possible state form this state
                for (int i = 0; i < 10; i++) {
                    //do
                    current[ri]=String.valueOf(i);
                    // recurse
                    solve(dict,ruls,ri+1);
                }
            }
            return;

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
