public class sort {

    static boolean isSorted(int arr []){
        boolean check = true;
        for(int i =  1 ; i < arr.length;i++){
            if(arr[i]<arr[i - 1]){
                check = false;
            }
        }
        return check;

    }
    public static void main(String args[]){
     int arr [] = {1,2,3,4};

     System.out.println(isSorted(arr));

    }
}
