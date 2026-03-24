public class Max {

    static int Maximum(int arr[]){
        int mx = Integer.MIN_VALUE;// if you want to find the maximum number in the array then you use the interger.min_value
        
        for(int i = 0; i < arr.length;i++){
            if(arr[i] > mx){
                mx = arr[i];
            }
        }
       return mx;
       
    
    }
    static int FindSecond(int arr[]){
        int mx = Maximum(arr);
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i]==mx){
                arr[i]=Integer.MIN_VALUE;
            }
        }
        int Secondmax = Maximum(arr);
        return Secondmax ;
    }
    public static void main(String[] args) {
        int arr [] = {5,1,2,6,3,7};

        System.out.println(Maximum(arr));
        System.out.println(FindSecond(arr));
    }
}
