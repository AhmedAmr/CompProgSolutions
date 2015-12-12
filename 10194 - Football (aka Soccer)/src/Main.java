import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        Main m = new Main();
        BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        HashMap<String , Team> map = new HashMap<>();
        int n = Integer.parseInt(in.readLine());
        for (int i = 0; i < n; i++) {
            map.clear();
            String tourName = in.readLine();
            int t = Integer.parseInt(in.readLine());
            for (int j = 0; j < t; j++) {
                Team team = m.new Team();
                team.name = in.readLine();
                map.put(team.name , team);
            }
            int g =  Integer.parseInt(in.readLine());
            for (int j = 0; j <g; j++) {
                String[] match = in.readLine().split("#");
                Team a = map.get(match[0]);
                Team b = map.get(match[2]);
                String result[] = match[1].split("@");
                int scoreA = Integer.parseInt(result[0]);
                int scoreB = Integer.parseInt(result[1]);
                a.CalculateMatchResults(scoreA,scoreB);
                b.CalculateMatchResults(scoreB,scoreA);
            }
            ArrayList<Team> list = new ArrayList<>(map.values());
            Collections.sort(list);
            out.append(tourName);
            out.append("\n");
            out.flush();
            int k = 1;
            for (Team team : list) {
                out.append(String.valueOf(k));
                out.append(") ");
                team.print(out);
                k++;
            }
            if(i<n-1)
                System.out.println();
        }
        out.close();
    }

    class Team implements Comparable<Team>{
        String name;
        int points=0;
        int wins=0;
        int loses=0;
        int ties=0;
        int goalsScored=0;
        int goalsAgainst=0;

        public void CalculateMatchResults(int goalsScored , int goalsAgainst){
            this.goalsAgainst+=goalsAgainst;
            this.goalsScored += goalsScored;
            if(goalsScored > goalsAgainst){
                this.wins++;
                this.points+=3;
            }else if(goalsAgainst > goalsScored){
                this.loses++;
            }else{
                this.ties++;
                this.points+=1;
            }
        }
        public void print(PrintWriter out){
            //[a]) Team name [b]p, [c]g ([d]-[e]-[f]), [g]gd ([h]-[i])
            out.append(this.name);
            out.append(" ");
            out.append(String.valueOf(this.points));
            out.append("p, ");
            out.append(String.valueOf(this.wins+this.ties+this.loses));
            out.append("g (");
            out.append(String.valueOf(this.wins));
            out.append("-");
            out.append(String.valueOf(this.ties));
            out.append("-");
            out.append(String.valueOf(this.loses));
            out.append("), ");
            out.append(String.valueOf(this.goalsScored - this.goalsAgainst));
            out.append("gd (");
            out.append(String.valueOf(this.goalsScored));
            out.append("-");
            out.append(String.valueOf(this.goalsAgainst));
            out.append(")\n");
            out.flush();
        }


        @Override
        public int compareTo(Team o) {
            /*
            1. Most points earned.
            2. Most wins.
            3. Most goal difference (i.e. goals scored - goals against)
            4. Most goals scored.
            5. Less games played.
            6. Lexicographic order.
             */

            if(this.points > o.points)return -1;
            if(o.points > this.points) return 1;
            if(this.wins > o.wins)return -1;
            if(o.wins > this.wins) return 1;
            int diff1 = this.goalsScored - this.goalsAgainst;
            int diff2 = o.goalsScored - o.goalsAgainst;
            if(diff1 > diff2)return -1;
            if(diff2 > diff1) return 1;
            if(this.goalsScored > o.goalsScored)return -1;
            if(o.goalsScored > this.goalsScored) return 1;
            int games1 = this.wins+this.ties+this.loses;
            int games2 = o.wins+o.ties+o.loses;
            if(games1 > games2)return 1;
            if(games2 > games1) return -1;
            ArrayList<String> list = new ArrayList<>();
            list.add(this.name.toLowerCase());
            list.add(o.name.toLowerCase());
            Collections.sort(list);
            if(list.get(0).equals(this.name.toLowerCase())) return -1;
            return 1;
        }
    }

}
