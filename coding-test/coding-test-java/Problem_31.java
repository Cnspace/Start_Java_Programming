import java.util.*;
import java.util.stream.Collectors;

// 폰켓몬 (제출 완료)
// https://school.programmers.co.kr/learn/courses/30/lessons/1845
// n/2 중 가장 많은 폰켓몬 고르기
public class Problem_31 {

    public static void main(String[] args) {
        int[] input1 = {3,1,2,3};
        int[] input2 = {3,3,3,2,2,4};
        int[] input3 = {3,3,3,2,2,2};

        int result1 = solution(input1);
        int result2 = solution(input2);
        int result3 = solution(input3);

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }

    public static int solution(int[] nums) {
        Set<Integer> set = new HashSet(Arrays.stream(nums).boxed().toList());

        // 책에서의 Set 크기 구하기
        // Arrays.stream(nums).distinct().count()
        return Math.min(set.size(), nums.length / 2);
    }

    // 재풀이
    // 조건보다는 Math.min을 사용할 것
    public int solution1(int[] nums) {
        int answer = 0;
        Set<Integer> set = new HashSet<>(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        answer = set.size() > nums.length / 2 ? nums.length / 2 : set.size();
        return answer;
    }
}
