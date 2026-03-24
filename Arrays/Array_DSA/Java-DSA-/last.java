


public class last {

    public static int last(int arr []){
     
    int lastIndex = -1;
    int x = 5;
    for(int i = 0; i < arr.length;i++){
        if(arr[i]>x){
            lastIndex =  i;
        }
    }


    return lastIndex;

}
    public static void main (String args []){
        int arr [] ={ 5,6,5,3,5};
        
        int result = last(arr);
        System.out.println(result);
    }
}
