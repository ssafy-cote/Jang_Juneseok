import java.util.*;

//메모리: 76.4 MB, 시간: 0.05 ms
class Solution {
    public int solution(String name) {
        int len = name.length();
        String s = "A".repeat(len);
        int minChangePrice = 0;
        int minMovePrice = len - 1;
        int answer = 0;
        
        for (int i = 0; i < len; i++) {
            minChangePrice += calcChangeCharPrice(name.charAt(i));
            
            //연속된 A index확인
            int endAIdx = i + 1;
            while (endAIdx < len && name.charAt(endAIdx) == 'A') {
                endAIdx++;
            }
            
            minMovePrice = Math.min(minMovePrice, calcChangePosPrice(i, endAIdx, len));
        }
        answer = minChangePrice + minMovePrice;

        return answer;
    }
    
    //최소 교체 비용 찾기
    public int calcChangeCharPrice(char after) {
        return Math.min(after - 'A', 'Z' - after + 1);
    }
    
    //최소 이동 비용 찾기
    public int calcChangePosPrice(int start, int end, int len) {
       
        //0에서 start(오) 갔다가 end(왼)로 넘어가는거
        int rPrice = (start * 2) + len - end;
        //0에서 end(왼) 갔다가 start(오)로 넘어가는거
        int lPrice = (len - end) * 2 + start;
        return Math.min(rPrice, lPrice);
    }
}
