public class Binary {
    public static void Searching(int Arr[], int Target) {
        int Start = 0;
        int End = Arr.length - 1;
        int Mid = 0;
        boolean bValue = false;

        while (Start <= End) {
            Mid = (Start + End) / 2;
            if (Arr[Mid] == Target) {
                System.out.println("Element is found at Index: " + Mid);
                bValue = true;
                break;
            } else if (Target > Arr[Mid]) {
                Start = Mid + 1;
            } else {
                End = Mid - 1;
            }
        }
        if (bValue == false) {
            System.out.println("Element is Not Found: ");
        }
    }

    public static void main(String Arg[]) {
        int Arr[] = {21, 25, 45, 89, 99};
        int iValue = 45;
        Searching(Arr, iValue);
    }
}
