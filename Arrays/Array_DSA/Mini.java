public class Mini {
    static int Minimum(int arr[]) {
        int mn = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < mn) {
                mn = arr[i];
            }
        }
        return mn;
    }

    public static void main(String[] args) {
        int arr[] = {5, 2, 6, 3, 7};
        System.out.println(Minimum(arr));
    }
}
