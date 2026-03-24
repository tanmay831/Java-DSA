public class Reverse {

    public static int Rev(int arr []){
      
        for(int i = 0; i < arr.length/2;i++){
           int temp = arr[i];
           arr[i] = arr[arr.length-i-1];
           arr[arr.length-i-1] = temp;
        }
        
        return  ;


        
    }
    public static void main(String args[]){
        int arr [] = {90,70,50,34,23};

       int result = Rev(arr);
       System.out.println(result);
    }
}
