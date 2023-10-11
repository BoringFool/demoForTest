package service;

import java.util.*;

public class TopStudents {
    public static void main(String[] args) {
        TopStudents topStudents = new TopStudents();
        String[] a = new String[]{"smart", "brilliant", "studious"};
        String[] b = new String[]{"not"};
        String[] c = new String[]{"this student is studious", "the student is smart"};
        int[] d = new int[]{1, 2};
        System.out.println(topStudents.topStudents(a, b, c, d, 2));
    }

    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        Map<String, Integer> words = new HashMap<>();
        for (String word : positive_feedback) {
            words.put(word, 3);
        }
        for (String word : negative_feedback) {
            words.put(word, -1);
        }
        int n = report.length;
        int[][] A = new int[n][2];//默认一个学生只有一个评价
        for (int i = 0; i < n; i++) {
            int score = 0;
            for (String word : report[i].split(" ")) {
                score += words.getOrDefault(word, 0);
            }
            A[i] = new int[]{-score, student_id[i]};
        }
        Arrays.sort(A, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        List<Integer> topK = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            topK.add(A[i][1]);
        }
        return topK;
    }


}
