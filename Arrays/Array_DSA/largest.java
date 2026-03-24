public class largest {

    public static int largestValue(int arr[]){
        int largestValue = arr[0];

        for(int i = 0 ;  i < arr.length; i ++){
            if(arr[i]>largestValue){
                largestValue=arr[i];
            }
        }
        return largestValue;

    }
    public static void main(String args []){

        int arr [] = {90,80,105,34};

       int largests = largestValue(arr);

       System.out.println(largests);
       
    
    }
}
