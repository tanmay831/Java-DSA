public class problem3 {
   static int Firstlargest(int arr []){
      int n  = arr.length;
      int mxs = Integer.MIN_VALUE;


      for(int i = 0; i < n ; i++){
        if(arr[i] > mxs){
            mxs = arr[i];
        }
      }return mxs;
      
    }
      static int Secondlargest(int arr[]){
        int mx = Firstlargest(arr);
        for(int i = 0; i < arr.length;i++){
            if(arr[i]==mx){
                arr[i] =  Integer.MIN_VALUE;
            }
            
        }  int secondmax = Firstlargest(arr);
        return secondmax; 

      }
    public static void main(String[] args) {
        int arr [] ={10, 20, 4, 45, 99};
        int result = Firstlargest(arr);
        int result2 = Secondlargest(arr);  
        System.out.println(result + " " +result2);
}
}