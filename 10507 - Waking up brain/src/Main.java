
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by AhmedAmr on 10/3/15.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int size;
        int n;
        char[] arr;
        int years;
        HashSet<Character> active = new HashSet<>();
        HashSet<Character> notActive = new HashSet<>();
        AdjListGraph graph = new AdjListGraph();
        ArrayList<Character> nodes;
        HashSet<Character> list=new HashSet<>();
        char[] connection;
        while(in.ready()) {
             size = Integer.parseInt(in.readLine().replace(" ",""));
             n = Integer.parseInt(in.readLine().replace(" ", ""));
             arr = in.readLine().toCharArray();
            if(n==0){
               if(size==3){
                out.append("WAKE UP IN, 0, YEARS\n");
               }else{
                out.append("THIS BRAIN NEVER WAKES UP\n");
               }
                out.flush();
            }else {
                active.clear();
                notActive.clear();
                for (int i = 0; i < 3; i++) {
                    active.add(arr[i]);
                }
                graph.clear();
                for (int i = 0; i < n; i++) {
                     connection = in.readLine().toCharArray();
                    graph.addNode(connection[0], connection[1]);
                    graph.addNode(connection[1], connection[0]);
                    if (!active.contains(connection[0])) notActive.add(connection[0]);
                    if (!active.contains(connection[1])) notActive.add(connection[1]);
                }

                boolean state = false;
                if (graph.graph.size() < size) {
                    out.append("THIS BRAIN NEVER WAKES UP\n");
                    out.flush();
                    state = true;
                } else {
                    nodes = graph.getNodesThathaveLessThanEdges(3);
                    for (Character node : nodes) {
                        if (!active.contains(node)) {
                            out.append("THIS BRAIN NEVER WAKES UP\n");
                            out.flush();
                            state = true;
                            break;
                        }
                    }
                }
                if (!state) {
                    years = 0;
                    while (!notActive.isEmpty()) {
                        list.clear();
                        for (Character character : notActive) {
                            nodes = graph.getNeighbours(character);
                            int count = 0;
                            for (Character characterGraphNode : nodes) {
                                if (active.contains(characterGraphNode)) count++;
                                if (count >= 3) {
                                    list.add(character);
                                    break;
                                }
                            }
                        }
                        years++;
                        notActive.removeAll(list);
                        active.addAll(list);
                    }
                    out.append("WAKE UP IN, ");
                    out.append(String.valueOf(years));
                    out.append(", YEARS\n");
                    out.flush();
                }
            }
            if(!in.ready())return;
            in.readLine();
        }


    }

    public static class AdjListGraph {
        HashMap<Character,ArrayList<Character>> graph;

        public AdjListGraph(){
            this.graph = new HashMap<>();
        }

        public boolean contatins(char node){
            return graph.containsKey(node);
        }



        public ArrayList getNodesThathaveLessThanEdges(int n){
            ArrayList list = new ArrayList<>();
            for (char t : graph.keySet()) {
                if(this.getNeighbours(t).size()<n){
                    list.add(t);
                }
            }
            return list;
        }

        public void addNode(char currentNode,char neighbour){
            Character node = new Character(neighbour);
            ArrayList<Character> list;
            if(this.graph.containsKey(currentNode)){
                list = this.graph.get(currentNode);
            }else{
                list = new ArrayList<>();
            }
            list.add(node);
            this.graph.put(currentNode,list);
        }

        public ArrayList<Character> getNeighbours(char node){
            return graph.get(node);
        }
        public void clear(){
            this.graph.clear();
        }


    }



}
