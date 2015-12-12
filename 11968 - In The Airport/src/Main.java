import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by AhmedAmr on 10/12/15.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        String line[];
        int t = Integer.parseInt(in.readLine());
        for (int i = 0; i < t; i++) {
            line = in.readLine().split(" ");
            ArrayList<Long> drink = new ArrayList<>();
            ArrayList<Long> cake = new ArrayList<>();
            int items = Integer.parseInt(line[0]);
            int cakes = Integer.parseInt(line[1]);
            int drinks = Integer.parseInt(line[2]);
            line = in.readLine().split(" ");
            long sum = 0;
            double average = 0;
            for (int j = 0; j < cakes; j++) {
                long current = Integer.parseInt(line[j]);
                sum+=current;
                cake.add(current);
            }
            for (int j = cakes; j < cakes+drinks; j++) {
                long current = Integer.parseInt(line[j]);
                sum+=current;
                drink.add(current);
            }
            for (int j = cakes+drinks; j <items ; j++) {
                sum+=Integer.parseInt(line[j]);
            }
            average = (sum*1.0)/items;
            Collections.sort(cake);
            Collections.sort(drink);
            out.append("Case #");
            out.append(String.valueOf(i + 1));
//            System.out.print("Case #" + (i +1)+": ");
            out.append(": ");
            boolean isDone = false;
            for (int j = cakes-1 ; j >= 0 ; j--) {
                if(average >= cake.get(j)){
                    isDone = true;
                    if(j == cakes-1) {
//                        System.out.print(cake.get(j));
                        out.append(String.valueOf(cake.get(j)));
                    }else{
                        double diff1 = Math.abs(average - cake.get(j));
                        double diff2 = Math.abs(average - cake.get(j+1));
                        if(diff1 <= diff2){
                            out.append(String.valueOf(cake.get(j)));
                        }else{
                            out.append(String.valueOf(cake.get(j+1)));
                        }
                    }
                    break;
                }
            }
            if(!isDone){
                out.append(String.valueOf(cake.get(0)));
            }

            isDone = false;
            out.append(" ");
            for (int j = drinks-1 ; j >= 0 ; j--) {
                if(average >= drink.get(j)){
                    isDone = true;
                    if(j == drinks-1) {
//                        System.out.print(" "+drink.get(j));
                        out.append(String.valueOf(drink.get(j)));
                    }else{
                        double diff1 = Math.abs(average - drink.get(j));
                        double diff2 = Math.abs(average - drink.get(j+1));
                        if(diff1 <= diff2){
//                            System.out.print(" "+drink.get(j));
                            out.append(String.valueOf(drink.get(j)));
                        }else{
//                            System.out.print(" "+drink.get(j+1));
                            out.append(String.valueOf(drink.get(j+1)));
                        }

                    }
                    break;
                }
            }
            if(!isDone){
//                System.out.print(" "+drink.get(0));
                out.append(String.valueOf(drink.get(0)));
            }
            out.append("\n");
            out.flush();
        }
    }


}
