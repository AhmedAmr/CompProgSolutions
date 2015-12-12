import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine().replace(" ",""));
        for (int i = 0; i < n; i++) {
            in.readLine();
            ArrayList<Node> list = new ArrayList<>();
            for (int j = 1; j < 4; j++) {
                String line[] = in.readLine().split(" ");
                int size = line.length;
                for (int k = 1; k < size; k++) {
                    if(!line[k].isEmpty())
                        list.add(new Node(j, Integer.parseInt(line[k])));
                }
            }

            list = reduce(list);
            ArrayList<Integer> list1 = getProblems(list,1);
            ArrayList<Integer> list2 = getProblems(list,2);
            ArrayList<Integer> list3 = getProblems(list,3);
            ArrayList<Integer> sizes = new ArrayList<>();
            int s1 = list1.size();
            sizes.add(s1);
            int s2 = list2.size();
            sizes.add(s2);
            int s3 = list3.size();
            sizes.add(s3);
            int max = Collections.max(sizes);
            out.append("Case #");
            out.append(String.valueOf(i+1));
            out.append(":\n");
            out.flush();
            if(s1 == max){
                out.append("1 ");
                out.append(String.valueOf(s1));
                for (int j = 0; j < s1; j++) {
                    out.append(" ");
                    out.append(String.valueOf(list1.get(j)));
                }
                out.append("\n");
                out.flush();
            }
            if(s2 == max){
                out.append("2 ");
                out.append(String.valueOf(s2));
                for (int j = 0; j < s2; j++) {
                    out.append(" ");
                    out.append(String.valueOf(list2.get(j)));
                }
                out.append("\n");
                out.flush();
            }
            if(s3 == max){
                out.append("3 ");
                out.append(String.valueOf(s3));
                for (int j = 0; j < s3; j++) {
                    out.append(" ");
                    out.append(String.valueOf(list3.get(j)));
                }
                out.append("\n");
                out.flush();
            }
        }
        out.close();
    }

    public static ArrayList<Integer> getProblems(ArrayList<Node>list , int id){
        ArrayList<Integer> res  = new ArrayList<>();
        if(list.isEmpty()) return res;
        for (Node node : list) {
            if(node.friendNum == id)
                res.add(node.problemNum);
        }
        Collections.sort(res);
        return res;
    }

    public static ArrayList<Node> reduce(ArrayList<Node> list){
        if(list.isEmpty())return list;
        Collections.sort(list);
        Node last = list.get(0);
        boolean isDuplicated  = false;
        ArrayList<Node> result = new ArrayList<>();
        int size = list.size();
        for (int i = 1; i <size ; i++) {
            Node temp = list.get(i);
            if(temp.problemNum==last.problemNum){
                if(!isDuplicated)
                    isDuplicated=true;
            }else{
                if(!isDuplicated)
                    result.add(last);
                last = temp;
                isDuplicated = false;
            }
        }
        if(!isDuplicated &&size>0)
            result.add(list.get(size-1));
        Collections.sort(result);
        return result;
    }


    public static class Node implements Comparable<Node>{
        int friendNum ;
        int problemNum;

        public Node(int friendNum , int problemNum){
            this.friendNum= friendNum;
            this.problemNum=problemNum;
        }

        @Override
        public int compareTo(Node o) {
            if(this.problemNum < o.problemNum) return -1;
            if(this.problemNum > o.problemNum) return 1;
            if(this.friendNum < o.friendNum) return -1;
            if(this.friendNum > o.friendNum) return 1;
            return 0;

        }

    }

}
