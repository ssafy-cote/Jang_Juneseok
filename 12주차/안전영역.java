import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] map;
	static int maxHeight = Integer.MIN_VALUE;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				maxHeight = Math.max(maxHeight, map[i][j]);
			}
		}
		
		int answer = 1;
		for (int h = maxHeight - 1; h > 0; h--) {
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] <= h) visited[i][j] = true;
				}
			}
			
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j]) {
						bfs(i, j);
						cnt++;
					}
				}
			}
			answer = Math.max(answer, cnt);
		}
		System.out.println(answer);
	}

	public static void bfs(int y, int x) {
		Deque<Point> q = new ArrayDeque<>();
		visited[y][x] = true;
		q.add(new Point(y, x));
		int[][] d = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
		
		while (!q.isEmpty()) {
			Point p = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int tx = p.x + d[i][0];
				int ty = p.y + d[i][1];
				
				if (invalidRange(tx, ty) || visited[ty][tx]) continue;
				visited[ty][tx] = true;
				
				q.add(new Point(ty, tx));
			}
		}
	}
	
	public static boolean invalidRange(int x, int y) {
		return x < 0 || x >= N || y < 0 || y >= N;
	}
}

class Point {
	int x;
	int y;
	
	Point(int y, int x) {
		this.x = x;
		this.y = y;
	}
}
