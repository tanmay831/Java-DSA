public class prefixsum {
    static int[] makeprefixsum(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i];
        }
        return arr;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        makeprefixsum(arr);
        for (int sum : arr) {
            System.out.print(sum + " ");
        }
    }
}
