import java.util.Scanner;

public class User {
    public static void main (String args []){
        Scanner sc =  new Scanner(System.in);
        System.out.println("Enter the array : ");
        int n = sc.nextInt();
        int arr [] = new int[n];
        
        System.out.println("enter " + n + "array elements");
        for(int i = 0; i < arr.length;i++){
            arr[i] = sc.nextInt();
            System.out.print(arr[i]);
        }
        
     //  System.out.print(arr[i]);

    }

}
