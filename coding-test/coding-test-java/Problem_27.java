import util.PrintUtil;

import java.util.*;

// 다단계 칫솔 판매
// 다단계 회사 수익 분배 문제 풀이
public class Problem_27 {

    public static void main(String[] args) {
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller1 = {"young", "john", "tod", "emily", "mary"};
        int[] amount1 = {12, 4, 2, 5, 10};

        String[] seller2 = {"sam", "emily", "jaimie", "edward"};
        int[] amount2 = {2, 3, 5, 4};

        int[] result1 = solution(enroll, referral, seller1, amount1);
        int[] result2 = solution(enroll, referral, seller2, amount2);

        PrintUtil.printIntegerArray(result1);
        PrintUtil.printIntegerArray(result2);
    }

    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, String> parents = new HashMap<>();
        Map<String, Integer> answer = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
            String parent = referral[i];
            if (parent.equals("-")) {
                parent = null;
            }
            parents.put(enroll[i], parent);
            answer.put(enroll[i], 0);
        }


        for (int i = 0; i < seller.length; i++) {
            int realPrice = amount[i] * 90;
            int upperPrice = amount[i] * 10;
            answer.put(seller[i], answer.get(seller[i]) + realPrice);
            String parent = parents.get(seller[i]);
            while (parent != null && upperPrice > 0) {
                //upperPrice - upperPrice / 10 -> upperPrice / 90 으로 변경할 경우 값이 12이면 두 값이 달라진다. 11 -> 10
                answer.put(parent, answer.get(parent) + upperPrice - upperPrice / 10);
                parent = parents.get(parent);
                upperPrice = upperPrice / 10;
                // upperPrice /= 10;
            }
        }

        return Arrays.stream(enroll).mapToInt(answer::get).toArray();
    }
}
