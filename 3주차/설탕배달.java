import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int three = 0; //3킬로 개수

        while (true) {
            if (N % 5 == 0) { //설탕을 5킬로로 다 가져갈 수 있다면?
                System.out.println(three + N / 5);
                break;
            } else if (N < 0) { //3,5 킬로로 못 가져 간다면
                System.out.println(-1);
                break;
            }
            N -= 3; //5킬로로 다 못가져가면 3킬로 가져감
            three++; //3킬로 개수 증가
        }
    }
}

