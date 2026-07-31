import java.util.Scanner;

public class Main {
    public static String solve(String input) {
        String cleaned = input.replaceAll("[^0-9]+", " ").trim();
        if (cleaned.isEmpty()) return "0";
        String[] parts = cleaned.split("\\s+");
        int n = parts.length;
        if (n < 3) return "0";
        int[] height = new int[n];
        for (int i = 0; i < n; i++) height[i] = Integer.parseInt(parts[i]);

        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;
        long trappedWater = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) leftMax = height[left];
                else trappedWater += (leftMax - height[left]);
                left++;
            } else {
                if (height[right] >= rightMax) rightMax = height[right];
                else trappedWater += (rightMax - height[right]);
                right--;
            }
        }
        return String.valueOf(trappedWater);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (sc.hasNextLine()) {
            sb.append(sc.nextLine()).append(" ");
        }
        System.out.println(solve(sb.toString().trim()));
    }
}
