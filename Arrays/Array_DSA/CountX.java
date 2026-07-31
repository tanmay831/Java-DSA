public class CountX {
    public static int count(int arr[], int x) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                count++;
            }
        }
        return count;
    }

    public static void main(String args[]) {
        int arr[] = {1, 5, 3, 5, 6, 5};
        System.out.println(count(arr, 5));
    }
}
