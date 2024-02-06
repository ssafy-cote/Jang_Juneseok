package 게임맵최단거리;

import java.util.ArrayDeque;
import java.util.Queue;

/*
 * 문제
 * 1.미로찾기 맵이 주어짐 -> M,N은 최대 100
 * 2. 최단 경로가 되는 이동 횟수 출력 => 골인은 항상 M,N위치
 * 3. 없으면 종료
 * 
 * 풀이
 * 1. 배열의 크기파악-> M,N위치 찾아내기
 * 2. 배열 순회해서 0의 갯수 파악하기 -finished
 * 3. dfs돌기 -> (depth, r, c)
 * 
 * dfs
 * 1. depth가 finished면 종료
 * 2. 좌표가 M,N에 도달하면 종료
 * 	2.1. 최소값 갱신
 * 3. 도착 위치가 경계를 벗어나거나 1, visited면 리턴
 * 4. for문 4방향 돌리기
 * 	4.1. visited 표시
 * 	4.2. dfs(depth 증가, r+dir[], c+dir[])
 * 	4.3. visited해제
 */
public class Main {
	int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	int finished = 0;
	int N;
	int M;
	Queue<int[]> que = new ArrayDeque<int[]>(); 
	boolean[][] visited;
    public int solution(int[][] maps) {
    	N = maps.length;
    	M = maps[0].length;
    	visited = new boolean[N][M];
    	visited[0][0] = true;
    	que.offer(new int[] {0,0,1});
    	int answer =0;
    	while(!que.isEmpty()) {
    		int[] point = que.poll();
    		int r = point[0];
    		int c = point[1];
    		answer = point[2];
    		if(r==N-1 && c== M-1) {	
    			return answer;
    		}
    		for(int i=0;i<4;i++) {
    			int nr = r + dir[i][0];
    			int nc = c + dir[i][1];
    			if(nr<0 || nc<0 || nr>=N || nc>=M || maps[nr][nc] == 0 || visited[nr][nc] == true) continue;
    			visited[nr][nc] = true;
    			que.add(new int[] {nr,nc,answer+1});
    		}
    	}
        return -1;
    }

    public static void main(String[] args) {
		
	}
}
