import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R;
    static int C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int mapLength = (int)Math.pow(2, N); //맵 전체 길이

        segment(mapLength, 0, 0, 0);
    }

    //사각형 분할
    public static void segment(int n, int sum, int tr, int tc) {
        int r = n / 2; // 분할된 사각형 길이
        int size = r * r; //분할된 사각형 넓이
        int cnt = 0; //사분면 수

        if (n == 2) {
            z(tr, tc, sum, 0);
            return;
        }

        for (int i = tr; i < tr + n; i += r) {
            for (int j = tc; j < tc + n; j += r, cnt++) {
                if (i <= R && R < i + r && j <= C && C < j + r) {
                    segment(r, cnt * size + sum, i, j);
                    return;
                }
            }
        }
    }

    //z돌기
    public static void z(int curR, int curC, int num, int flag) {
        if (curR == R && curC == C) { //최종 위치 확인
            System.out.println(num);
            return;
        }

        if (flag == 0) { //오른쪽
            z(curR, curC + 1, num + 1, 1);
        } else if (flag == 1) { //좌하
            z(curR + 1, curC - 1, num + 1, 0);
        }
    }
}
