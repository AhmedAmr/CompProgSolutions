import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int n = Integer.parseInt(in.readLine().replace(" ",""));
        for (int i = 0; i < n; i++) {
            String line = in.readLine();
            boolean res= checkParentheses(line);
            if(res)
                out.append("Yes\n");
            else
                out.append("No\n");
            out.flush();
        }
    }

    public static String nextLine(BufferedReader in) throws IOException {
        if(!in.ready()) return null;
        String line = in.readLine();
        while(line.isEmpty()) {
            if(!in.ready())
                break;
            line = in.readLine();
        }
        return line;
    }

    public static boolean checkParentheses(String s){
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for (char c: arr) {
            if(c=='['||c=='('){
                stack.push(new Character(c));
            }else if(c==']'){
                if(stack.isEmpty()) return false;
                Character res = stack.peek();
                if(res == '[') stack.pop();
            }else if(c == ')'){
                if(stack.isEmpty()) return false;
                Character res = stack.pop();
                if(res != '(') return false;
            }
        }
        if(stack.isEmpty())
            return true;
        return false;
    }
}
