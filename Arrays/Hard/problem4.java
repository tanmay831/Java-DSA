public class problem4 {
    static boolean Presntelement(int arr[]){
        int n = arr.length;
        int target = 3;
        for(int i = 0 ; i < n ; i++){
            if(arr[i]==target){
                return true;
            }
        }
        return false;

        
    }
    public static void main(String[] args) {
        int arr [] = {1,2,3,4,5};

        boolean result = Presntelement(arr);
        System.out.println(result);

    }
}
