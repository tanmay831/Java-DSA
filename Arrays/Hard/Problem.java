public class Problem {
    static int Maximum(int arr[]) {
        int mx = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > mx) mx = num;
        }
        return mx;
    }

    static int Minimum(int arr[]) {
        int mn = Integer.MAX_VALUE;
        for (int num : arr) {
            if (num < mn) mn = num;
        }
        return mn;
    }

    public static void main(String[] args) {
        int arr[] = {3, 7, 9, 2, 1};
        System.out.println(Maximum(arr) + " " + Minimum(arr));
    }
}
