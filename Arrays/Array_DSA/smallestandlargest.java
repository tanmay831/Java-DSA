public class smallestandlargest {

     public static int [] smallandlargest(int arr []){
        
        int [] ans = {arr [0] , arr[arr.length-1]};
        return ans ;
    } 

    public static void main (String args []){
        int arr [] = {5,6,7,8};
         
        System.out.println(smallandlargest(arr));
        System.out.println("smallest : "+ arr[0]);
        System.out.println("largest :"+ arr[arr.length-1]);
    }
}
