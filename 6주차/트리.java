import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<List<Integer>> nodes;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();;
        int T = 1;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if (n + m == 0) {
                break;
            }

            nodes = new ArrayList<>();
            visited = new boolean[n + 1];

            //리스트 초기화
            for (int i = 0; i <= n; i++) {
                nodes.add(new ArrayList<>());
            }

            //간선 초기화
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                nodes.get(a).add(b);
                nodes.get(b).add(a);
            }

            //트리 체크
            int answer = 0;
            for (int i = 1; i <= n; i++) {
                if (visited[i]) continue;
                if (!dfs(-1, i)) ++answer; //true : Cycle O, false: Cycle X
            }

            if (answer > 1) {
                sb.append("Case ").append(T).append(": ").append("A forest of ").append(answer).append(" trees.");
            } else if (answer == 1) {
                sb.append("Case ").append(T).append(": ").append("There is one tree.");
            } else if (answer == 0) {
                sb.append("Case ").append(T).append(": ").append("No trees.");
            }
            sb.append("\n");
            T++;
        }
        System.out.println(sb);
    }

    public static boolean dfs(int parent, int child) {
        if (visited[child]) { //부모를 방문하지 않았는디 이미 방문처리가 되었다면 사이클 O
            return true;
        }

        visited[child] = true;
        boolean isCycle = false;
        for (int ch : nodes.get(child)) {
            if (parent == ch) continue; //자신의 부모는 방문하지 않음
            isCycle |= dfs(child, ch);
        }
        return isCycle;
    }
}

