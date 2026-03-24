import java.util.Scanner;

public class Main {
    public static String solve(String input) {
        // Replace anything that is NOT a digit with a space to make parsing bulletproof
        String cleaned = input.replaceAll("[^0-9]+", " ").trim();
        
        // If the input was empty or contained no numbers
        if (cleaned.isEmpty()) {
            return "0";
        }
        
        String[] parts = cleaned.split("\\s+");
        int n = parts.length;
        
        // A minimum of 3 bars is required to trap any water
        if (n < 3) {
            return "0";
        }
        
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = Integer.parseInt(parts[i]);
        }
        
        // Two Pointer Approach for O(1) space and O(n) time
        int left = 0;
        int right = n - 1;
        int leftMax = 0;
        int rightMax = 0;
        
        // Use long to prevent integer overflow on massive test cases
        long trappedWater = 0; 
        
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    trappedWater += (leftMax - height[left]);
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    trappedWater += (rightMax - height[right]);
                }
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
        String result = solve(sb.toString().trim());
        System.out.println(result);
    }
}