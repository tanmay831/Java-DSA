public class CountX {

    public static int occur(int arr [], int x ) {
        int count = 0;
        for(int i = 0; i < arr.length ; i++){
            if(arr[i]==x){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int arr [] = {5,5,3,6,};
        int x = 5;

       
        System.out.println(occur(arr, x));
    }
}
