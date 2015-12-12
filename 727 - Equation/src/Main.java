import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by AhmedAmr on 9/28/15.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        Queue<String>q = new LinkedList<>();
        int n = Integer.parseInt(in.readLine());
        in.readLine();
        for (int i = 0; i < n; i++) {
            q.clear();
            String line = in.readLine();
            while(line != null){
                if(line.isEmpty())break;
                q.add(line);
                line = in.readLine();
            }
            infixToPostfix(q,out);
            if(i<n-1){
                out.append("\n");
            }
            out.flush();
        }
    }

    public static void infixToPostfix(Collection<String> arr,PrintWriter sb){
        Stack<String> stack = new Stack<>();
        for (String s : arr) {
            int value = getOperandValue(s);
            if(value == -1) sb.append(s);
            else{
                if(value == 4){
                    while(true){
                        if(getOperandValue(stack.peek())!=3)
                            sb.append(stack.pop());
                        else break;
                    }
//                    if(!stack.isEmpty())
                        stack.pop();
                }else if(!stack.isEmpty()&&value!=3){
                    if(getOperandValue(stack.peek())!=3) {
                        while (!stack.isEmpty()) {
                            if(compareOperands(stack.peek(), s) <= 0)
                                sb.append(stack.pop());
                            else break;
                        }
                    }
                }
                if(value !=4) stack.push(s);
            }

        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb.append("\n");
    }


    public static int compareOperands(String s1,String s2){
        int v1 = getOperandValue(s1);
        int v2 = getOperandValue(s2);
        if(v1>v2) return 1;
        if(v2>v1) return -1;
        return 0;
    }

    public static int getOperandValue(String s){
        if(s==null)return -2;
        if(s.equals("*") || s.equals("/")){
            return 1;
        }else if(s.equals("+")||s.equals("-")) {
            return 2;
        }else if(s.equals("(")){
            return 3;
        }else if(s.equals(")")){
            return 4;
        }
        return -1;
    }




}
