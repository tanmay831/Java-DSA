public class Palindrome {
    public static void Method1(String Str) {
        String Rev = "";
        for (int i = Str.length() - 1; i >= 0; i--) {
            Rev += Str.charAt(i);
        }

        if (Rev.equals(Str)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static void Method2(String Str) {
        int Start = 0;
        int End = Str.length() - 1;
        boolean bValue = true;

        while (Start < End) {
            if (Str.charAt(Start) != Str.charAt(End)) {
                bValue = false;
                break;
            }
            Start++;
            End--;
        }

        if (bValue == true) {
            System.out.println("String is palindrome: ");
        } else {
            System.out.println("String is not palindrome: ");
        }
    }

    public static void main(String Arg[]) {
        String str = "MadaM";
        Method1(str);
        Method2(str);
    }
}
