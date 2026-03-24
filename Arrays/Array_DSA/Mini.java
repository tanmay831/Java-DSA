public class Mini {
    static int Minimum(int arr[]){
        int mx =Integer.MAX_VALUE;


        for(int i = 0 ; i < arr.length;i++){
            if(arr[i]<mx){
                mx=arr[i];
            }
        }
        return mx ;

        int mx = Integer.m
    }
    public static void main(String[] args) {
        int arr [] = {5,2,6,3,7};

        System.out.println(Minimum(arr));
    }
}
