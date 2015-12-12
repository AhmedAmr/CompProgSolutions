import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * Created by AhmedAmr on 9/26/15.
 */
public class Main {

//
//    public static void main(String[] args) throws IOException {
//        BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter out = new PrintWriter(System.out);
//
//        Deque<Pack> deq = new ArrayDeque<>();
//
//        String line = in.readLine();
//        while(!line.equals("#")){
//            String[] cards = line.split(" ");
//            for (String card : cards) {
//                deq.add(new Pack(card));
//            }
//            line = in.readLine();
//            cards = line.split(" ");
//            for (String card : cards) {
//                deq.add(new Pack(card));
//            }
//
//
//
//
//            line = in.readLine();
//        }
//
//
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
        String line[] = in.readLine().split(" ");
        Deque<Pack> deq = new ArrayDeque<>();
        Stack<Pack> stack =new Stack<>();
        for (String s : line) {
            deq.add(new Pack(s));
        }
        line = in.readLine().split(" ");
        for (String s : line) {
            deq.add(new Pack(s));


        }

        Deque<Pack> q = new ArrayDeque<>();
        for (Pack pack : deq) {
            q.add(pack);
            System.out.println("BEFORE:\n" + q);
            mainRun(q);
            System.out.println("AFTER:\n"+q);

        }
//        System.out.println(q);
    }

    public static void mainRun(Deque<Pack> q) {
        int res = run(q);
        Stack<Pack> s = new Stack<>();
        while (res != -1) {
            if (res == 0) {
                Pack p = q.poll();
                s.add(p);
            }
            res = run(q);
            if(res == 1) {
                while (!s.isEmpty()) {
                    q.addFirst(s.pop());
                }
            }
        }
        while (!s.isEmpty()) {
            q.addFirst(s.pop());
        }
    }







    public static int run(Deque<Pack> q){
        if(q.size()==1 ){
            return -1;
        }
        Pack current = q.poll();
        Stack<Pack> temp = new Stack<>();
        int i = 0;
        boolean nextTo = false;
        boolean third = false;
        while(!q.isEmpty()&& i < 2){
            if(i==0){
                if(q.peek().compareTo(current) == 0)nextTo=true;
            }
            temp.add(q.poll());
            if(i == 1 && !q.isEmpty()){
                if(q.peek().compareTo(current) == 0) third = true;
            }
            i++;
        }
        Pack p ;
        if(nextTo){
            while(temp.size()>1){
                q.addFirst(temp.pop());
            }
            p = temp.pop();
            p.cards +=current.cards;
            q.addFirst(p);
            return 1;
        }
        if(third){
            p = q.poll();
            p.cards +=current.cards;
            while(!temp.isEmpty()){
                q.addFirst(temp.pop());
            }
            q.addFirst(p);
            return 1;
        }
        while(!temp.isEmpty()){
            q.addFirst(temp.pop());
        }
        q.addFirst(current);
        return 0;

    }


    static class Pack implements Comparable<Pack>{
        char suit;
        char value;
        int cards;


        public Pack(String card){
            char[] arr = card.toCharArray();
            this.suit = arr[1];
            this.value = arr[0];
            cards = 1;
        }


        @Override
        public String toString() {
            return this.value+String.valueOf(this.suit)+" ";
        }

        @Override
        public int compareTo(Pack o) {
            if ((this.value == o.value) || (this.suit == o.suit))
                return 0;
            return 1;
        }
    }
}
