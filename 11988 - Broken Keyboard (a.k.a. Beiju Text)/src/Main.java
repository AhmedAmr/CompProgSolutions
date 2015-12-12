import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        Deque<Character> deque = new ArrayDeque<>();
        Deque<Character> temp = new ArrayDeque<>();
        while(in.ready()){
            deque.clear();
            char[] line = in.readLine().toCharArray();
            boolean isFirst=false;
            for (char c : line) {
                if(c == '['){
                    isFirst = true;
                    if(!temp.isEmpty()){
                        while(!temp.isEmpty()) {
                            deque.addFirst(temp.removeLast());
                        }
                    }
                }else if(c == ']'){
                    isFirst = false;
                    if(!temp.isEmpty()){
                        while(!temp.isEmpty()) {
                            deque.addFirst(temp.removeLast());
                        }
                    }
                }else{
                    if(isFirst){
                        temp.add(c);
                    }else{
                        deque.addLast(c);
                    }
                }
            }
            if(!temp.isEmpty()){
                while(!temp.isEmpty()) {
                    deque.addFirst(temp.removeLast());
                }
            }
            for (char c : deque) {
                out.append(c);
            }
            out.append("\n");
            out.flush();
        }
        out.close();
    }
}
