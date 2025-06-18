import java.util.*;

class Result {
    public static List<String> findSchedules(int workHours, int dayHours, String pattern) {
        List<String> schedules = new ArrayList<>();
        int missingHours = workHours - getSum(pattern);
        int remainingDays = countQuestionMarks(pattern);

        if (missingHours < 0 || missingHours > remainingDays * dayHours) {
            return schedules;
        }

        findSchedulesHelper(schedules, pattern, missingHours, dayHours, 0);
        Collections.sort(schedules);
        return schedules;
    }

    private static void findSchedulesHelper(List<String> schedules, String pattern, int missingHours, int dayHours, int index) {
        if (missingHours == 0 && index == pattern.length()) {
            schedules.add(pattern);
            return;
        }

        if (index >= pattern.length()) {
            return;
        }

        if (pattern.charAt(index) == '?') {
            for (int i = 0; i <= dayHours; i++) {
                if (missingHours - i >= 0) {
                    String newPattern = pattern.substring(0, index) + i + pattern.substring(index + 1);
                    findSchedulesHelper(schedules, newPattern, missingHours - i, dayHours, index + 1);
                }
            }
        } else {
            findSchedulesHelper(schedules, pattern, missingHours, dayHours, index + 1);
        }
    }

    private static int getSum(String pattern) {
        int sum = 0;
        for (char c : pattern.toCharArray()) {
            if (c != '?') {
                sum += Character.getNumericValue(c);
            }
        }
        return sum;
    }

    private static int countQuestionMarks(String pattern) {
        int count = 0;
        for (char c : pattern.toCharArray()) {
            if (c == '?') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // Test Case 1: Multiple Solutions
        int workHours = 30;
        int dayHours = 8;
        String pattern = "0?7?4?";
        List<String> schedules = findSchedules(workHours, dayHours, pattern);
        System.out.println("Test Case 1: " + schedules);

        // Test Case 2: No Solutions
        workHours = 40;
        dayHours = 8;
        pattern = "888888";
        schedules = findSchedules(workHours, dayHours, pattern);
        System.out.println("Test Case 2: " + schedules);

        // Test Case 3: Edge Case: Maximum Work Hours
        workHours = 40;
        dayHours = 8;
        pattern = "?????";
        schedules = findSchedules(workHours, dayHours, pattern);
        System.out.println("Test Case 3: " + schedules);

        // Test Case 4: Edge Case: Minimum Work Hours
        workHours = 0;
        dayHours = 8;
        pattern = "000000";
        schedules = findSchedules(workHours, dayHours, pattern);
        System.out.println("Test Case 4: " + schedules);

        // Test Case 5: Single Solution
        workHours = 56;
        dayHours = 8;
        pattern = "???8???";
        schedules = findSchedules(workHours, dayHours, pattern);
        System.out.println("Test Case 5: " + schedules);
    }
}