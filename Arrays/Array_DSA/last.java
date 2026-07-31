public class last {
    public static int lastIndex(int arr[], int x) {
        int lastIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                lastIndex = i;
            }
        }
        return lastIndex;
    }

    public static void main(String args[]) {
        int arr[] = {5, 6, 5, 3, 5};
        int result = lastIndex(arr, 5);
        System.out.println(result);
    }
}
