public class Sort {
    public static void Sorting(int Arr[]) {
        for (int i = 0; i < Arr.length - 1; i++) {
            for (int j = 0; j < Arr.length - 1 - i; j++) {
                if (Arr[j] > Arr[j + 1]) {
                    int Temp = Arr[j];
                    Arr[j] = Arr[j + 1];
                    Arr[j + 1] = Temp;
                }
            }
        }

        for (int X : Arr) System.out.print(X + " ");
        System.out.println();
    }

    public static void main(String Arg[]) {
        int Arr[] = {2, 4, 8, 3, 9, 5};
        Sorting(Arr);
    }
}
