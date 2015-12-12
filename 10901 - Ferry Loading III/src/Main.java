import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by AhmedAmr on 9/30/15.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine());
        Queue<Node> left = new LinkedList<>();
        Queue<Node> right = new LinkedList<>();
        for (int i = 0; i < t; i++) {
            left.clear();
            right.clear();
            String line[] = in.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int time = Integer.parseInt(line[1]);
            int size = Integer.parseInt(line[2]);
            Integer[] res=new Integer[size];
            for (int j = 0; j < size; j++) {
                line = in.readLine().split(" ");
                int value = Integer.parseInt(line[0]);
                Node node = new Node();
                node.v=value;
                node.order = j;
                if (line[1].equals("left")) {
                    left.add(node);
                } else {
                    right.add(node);
                }
            }
            run(n,time,left,right,res);
            for (Integer re : res) {
                out.append(String.valueOf(re));
                out.append("\n");
            }
            if(i<t-1){
                out.append("\n");
            }
            out.flush();
        }
    }

    public static void run(int  n , int t ,Queue<Node> left,Queue<Node> right,Integer[] results){
        int mc;
        if(!right.isEmpty()&&!left.isEmpty()) mc = Math.min(left.peek().v,right.peek().v);
        else if(!right.isEmpty()){
            mc = right.peek().v;
        }else if(!left.isEmpty()){
            mc = left.peek().v;
        }else return;
        int c;
        Queue<Integer>res ;
        while(!(left.isEmpty()&&right.isEmpty())){
            while(true){
                if(isAbleToLoad(mc,left)==1)break;
                if(isAbleToLoad(mc, right)==1)break;
                if(left.isEmpty() && right.isEmpty())return;
                mc++;
            }
             res = load(n,mc,left);
            if(!res.isEmpty()){
                c = res.size();
                for (int i = 0; i < c; i++) {
                    results[res.poll()]= mc+t ;
                }
            }
            mc+=t;
            while(true){
                if(isAbleToLoad(mc,left)==1)break;
                if(isAbleToLoad(mc,right)==1)break;
                if(left.isEmpty() && right.isEmpty())return;
                mc++;
            }
            res = load(n,mc,right);
            if(!res.isEmpty()){
                c = res.size();
                for (int i = 0; i < c; i++) {
                    results[res.poll()]= mc+t ;
                }
            }
            mc+=t;
        }
    }

    public static int isAbleToLoad(int mc ,Queue<Node> q ){
        if(q.isEmpty()) return -1;
        if(q.peek().v<=mc)return 1;
        return 0;
    }


    public static Queue<Integer> load(int n ,int mc, Queue<Node> q){
        Queue<Integer> res = new LinkedList<>();
        if(q.isEmpty()) return res;
        while(n!=0){
            if(q.isEmpty())break;
            if(q.peek().v<=mc){
                res.add(q.poll().order);
                n--;
            }else break;
        }
        return res;
    }

    public static class Node{
        int v ;
        int order;
    }
}
