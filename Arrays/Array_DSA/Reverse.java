public class Reverse {
    public static void Rev(int arr[]) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
    }

    public static void main(String args[]) {
        int arr[] = {90, 70, 50, 34, 23};
        Rev(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
