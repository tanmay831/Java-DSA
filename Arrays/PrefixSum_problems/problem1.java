import java.util.Scanner;

public class problem1 {
    static int[] makeprefixsum(int arr[]) {
        int n = arr.length;
        int[] pre = new int[n];
        pre[0] = arr[0];

        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] + arr[i];
        }
        return pre;
    }

    static void PrintArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER THE ARRAY ");
        int n = sc.nextInt();
        int arr[] = new int[n];

        System.out.println("ENTER " + n + " ELEMENT");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("INPUT THE ARRAY");
        PrintArray(arr);
        int[] pref = makeprefixsum(arr);
        PrintArray(pref);
    }
}
